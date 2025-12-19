package banking.bank;

import banking.account.Customer;
import banking.account.BankAccount;
import banking.account.CheckingAccount;
import banking.account.SavingsAccount;
import banking.transfer.TransactionTransferSystem;

/**
 * This class implements a base functionalities of a Bank.
 * @see Bank
 *
 */
public class BaseBank implements Bank {
    /** Stores the name of the bank */
    private String bankName;
    /** Stores all accounts of this bank */
    BankAccount[] accounts;
    /** Stores all customers of this bank */
    Customer[] customers;
    /** Stores the current number of accounts */
    private int accountCount = 0;
    /** Stores the current number of customers */
    private int customerCount = 0;
    /** Stores the transfer system between banks */
    public TransactionTransferSystem transferSystem;
    /** Stores transactions */
    private TransactionBuffer transactionBuffer;

    /**
     * Constructor for creation of new banks.
     * The number of customers and accounts is limited
     * to the given values.
     *
     * @param bankName     the name of the bank
     * @param maxCustomers the max. number of customers
     * @param maxAccounts  the max. number of accounts
     */
    public BaseBank(String bankName, int maxCustomers, int maxAccounts) {
        // TODO:

        // create a banking.transaction.TransactionBuffer which stores max. 100 transactions
        this.transactionBuffer = new TransactionBuffer(100);
    }

    /**
     * No need for documentation here! This method is defined and
     * documented in the given interface. The documentation is inherited
     * automatically from the interface. If you want to add additional
     * documentation to an implemented method, you can use {&#64;inheritDoc}
     * (see below).
     * <br />
     * <br />
     * {@inheritDoc}
     */
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
    public boolean withdraw(int accountNumber, double money) {
        // TODO:
        return false;
    }

    /**
     * This method provides a BankAccount for a given account number
     *
     * @param accountNumber the account number
     * @return a banking.accounts.BankAccount with the provided account number OR null if three is no matching account.
     */
    @Override
    public BankAccount getBankAccount(int accountNumber) {
        // TODO:
        return null;
    }

    /**
     * Method to check if a given amount of money can be withdrawn from a given account.
     *
     * @param account the account to check
     * @param money   the amount of money to check
     * @return true if the amount of money can be withdrawn, else if not
     */
    boolean canWithdrawal(BankAccount account, double money) {
        // TODO:
        return false;
    }

    @Override
    public Transaction[] getTransactionHistory(int accountNumber) {
        Transaction[] allTransactions = this.transactionBuffer.getTransactions();
        Transaction[] accountTransactions = new Transaction[allTransactions.length];
        int index = 0;

        for(Transaction t : allTransactions) {
            if(t != null && t.affectsAccountNumber(accountNumber)){
                accountTransactions[index] = t;
                index++;
            }
        }

        Transaction[] slice = new Transaction[index];
        System.arraycopy(accountTransactions, 0, slice, 0, index);
        return slice;
    }
}