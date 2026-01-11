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
    private String bankName, receiverBank, senderBank;
    private int maxAccounts, maxCustomers, BIC, receiverBIC, senderBIC;
    private TransactionTransferSystem tts;
    private Date endDate;
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
        // TODO:
        this.bankName = bankName;
        this.maxCustomers = maxCustomers;
        this.maxAccounts = maxAccounts;
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
        return false;
    }

    @Override
    public final String toString() {
        // TODO:
        String info = "BankName: " + getInstitutionName() +"/n" + "BIC: " + getBIC() + "/n " + "Customers: /n";
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
        return this.bankName;
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
        Transaction[] transactions = new Transaction[this.maxAccounts];
        int index = 0;
        while (index < this.maxAccounts) {
            if (executeTransaction(transactions[index])) {
                index ++;
            }
        }
        if (index == this.maxAccounts) {
            return transactions;
        }
        return null;
    }

    @Override
    public boolean withdraw(int accountNumber, double money) {
        // TODO:
        return this.baseBank.withdraw(accountNumber,  money);
    }
}
