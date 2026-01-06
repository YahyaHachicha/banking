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
    private String bankName;
    private int maxAccounts, maxCustomers, BIC;
    private TransactionTransferSystem tts;

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
        return null;
    }

    @Override
    public String getInstitutionName() {
        // TODO:
        return null;
    }

    @Override
    public int registerCustomer(Customer customer) {
        // TODO:
        return 0;
    }

    @Override
    public int createCheckingBankAccount(int customerID, int pin) {
        // TODO:
        return 0;
    }

    @Override
    public int createSavingsBankAccount(CheckingAccount checkingAccount, int pin) {
        // TODO:
        return 0;
    }

    @Override
    public BankAccount getBankAccount(int accountNumber) {
        // TODO:
        return null;
    }

    @Override
    public double getBalance(int accountNumber) {
        // TODO:
        return 0;
    }

    @Override
    public boolean validatePin(int accountNumber, int pin) {
        // TODO:
        return false;
    }

    @Override
    public Transaction[] getTransactionHistory(int accountNumber) {
        // TODO:
        return null;
    }

    @Override
    public boolean withdraw(int accountNumber, double money) {
        // TODO:
        return false;
    }
}
