package banking.bank;

import banking.account.BankAccount;
import banking.account.CheckingAccount;
import banking.account.Customer;
import banking.transfer.TransactionTransferSystem;

import java.util.Arrays;
import java.util.Date;

/**
 * This class implements a simple fully functional SWIFT Bank.
 * @see SWIFTBank
 *
 */
public class BICBank implements SWIFTBank {
    // TODO:
    private int BIC;
    private TransactionTransferSystem tts;
    private BaseBank baseBank;
    private BankAccount bankAccount;

    /**
     * Constructor for creation of new banks.
     * The number of customers and accounts is limited
     * to the given values.
     *
     * @param bankName     the name of the bank
     * @param maxCustomers the max. number of customers
     * @param maxAccounts  the max. number of accounts
     */
    public BICBank(String bankName, int maxCustomers, int maxAccounts) {
		
        this.baseBank = new BaseBank(bankName, maxCustomers, maxAccounts);
		
    }

    /**
     * Returns the bank code of this bank.
     *
     * @return the bank code
     */
    public int getBIC() {
        // TODO:
        return this.BIC;
    }

    /**
     * Sets the bank code of this bank.
     *
     */
    public void setBIC(int bankCode, TransactionTransferSystem tts){
        // TODO:
        if (tts == null || bankCode < 0 ) {
            return;
        }
        this.BIC = bankCode;
        this.tts = tts;
    }

    @Override
    public boolean executeTransaction(Transaction transaction) {
        // TODO:
                // 1. Null- & Enddatum-Check
        if (transaction == null || transaction.getFinishDate() != null)
            return false;

        BankAccount sender = getBankAccount(transaction.getFromAccountNumber());
        BankAccount receiver = getBankAccount(transaction.getToAccountNumber());

        // 2. Interne Überweisung, wenn beide Konten gleich sind
        if (sender != null && receiver != null) {

            boolean success = transferWithinBank(transaction.getFromAccountNumber(), transaction.getRecipientLastName(), transaction.getToAccountNumber(), transaction.getAmount());

            if (success) {
                transaction.setFinishDate(transaction.getStartDate());
                baseBank.getTransactionHistory(transaction.getToAccountNumber());
            }
            return success;
        }

        // 3. Externe Überweisung

        // Wir müssen Senderkonto überprüfen
        if (sender == null)
            return false;

        // Sparkonto darf nicht senden
        if (sender.getAccountType() == BankAccount.AccountType.Savings)
            return false;

        // Deckung prüfen, d.h., wenn der gesendete Beitrag größer als der Balance im Konto ist, dann ist die Ueberweisung unmöglich
        if (sender.getBalance() < transaction.getAmount())
            return false;

        // Geld abheben
        if (!withdraw(transaction.getFromAccountNumber(),
                transaction.getAmount()))
            return false;

        // Über SWIFT senden
        boolean success = tts.submitTransaction(transaction);

        if (!success) {
            deposit(transaction.getFromAccountNumber(), transaction.getAmount());
            return false;
        }

        // Erfolg
        transaction.setFinishDate(transaction.getStartDate());
        baseBank.getTransactionHistory(transaction.getToAccountNumber());
        return true;
    }

    @Override
    public final String toString() {
        // TODO:
        String info = "BankName: " + baseBank.getInstitutionName() +"/n" + "BIC: " + getBIC() + "/n " + "Customers: /n";
        for (Customer customer : baseBank.customers) {
            if (customer != null) {
                info = " " + info + customer + "/n";
            }
        }
        info = info + "Accounts: /n";
        for (BankAccount account : baseBank.accounts) {
            if (account != null) {
                info = " " + info + account + "/n";
            }
        }

        return info;
    }

    @Override
    public String getInstitutionName() {
        // TODO:
        return this.baseBank.getInstitutionName();
    }

    @Override
    public int registerCustomer(Customer customer) {
        // TODO:
        return this.baseBank.registerCustomer(customer);
    }

    @Override
    public int createCheckingBankAccount(int customerID, int pin) {
        // TODO:
        return this.baseBank.createCheckingBankAccount(customerID, pin);
    }

    @Override
    public int createSavingsBankAccount(CheckingAccount checkingAccount, int pin) {
        // TODO:
        return this.baseBank.createSavingsBankAccount(checkingAccount, pin);
    }

    @Override
    public BankAccount getBankAccount(int accountNumber) {
        // TODO:
        return this.baseBank.getBankAccount(accountNumber);
    }

    @Override
    public double getBalance(int accountNumber) {
        // TODO:
        return this.bankAccount.getBalance();
    }

    @Override
    public boolean validatePin(int accountNumber, int pin) {
        // TODO:
        return this.baseBank.validatePin(accountNumber, pin);
    }

    @Override
    public Transaction[] getTransactionHistory(int accountNumber) {
        // TODO:
        Transaction[] transactions = new Transaction[this.baseBank.accounts.length];
        int index = 0;
        while (index < this.baseBank.accounts.length) {
            if (executeTransaction(transactions[index])) {
                index ++;
            }
        }
        if (index == this.baseBank.accounts.length) {
            return transactions;
        }
        return null;
    }

    @Override
    public boolean withdraw(int accountNumber, double money) {
        // TODO:
        return this.baseBank.withdraw(accountNumber, money);
    }
}
