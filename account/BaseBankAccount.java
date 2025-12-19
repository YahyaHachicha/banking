package banking.account;

/**
 * This class models a base account implementing basics in a Bank Account.
 */
public class BaseBankAccount {
    // TODO:
    /**
     * Creates a new base bank account for the given customer.
     *
     * @param accountNumber the account number
     * @param owner the owner of the account
     * @param pin the pin for the account
     */
    public BaseBankAccount(int accountNumber, Customer owner, int pin){
        // TODO:
    }

    /**
     * This method validates if a pin is valid for this account.
     * @param pin the pin that should be validated
     * @return true, iff the pin fits to this account, false otherwise
     */
    public final boolean validatePin(int pin) {
        // TODO:
        return false;
    }

    /**
     * Returns the customer that owns this account.
     *
     * @return the owner of this account
     */
    public Customer getOwner() {
        // TODO:
        return null;
    }

    /**
     * Returns the account number of this account.
     *
     * @return the account number of this account
     */
    public final int getAccountNumber() {
        // TODO:
        return 0;
    }

    /**
     * Returns the current balance of this account.
     * @return the current balance of this account
     */
    public final double getBalance() {
        // TODO:
        return 0;
    }

    /**
     * This method removes money from this account.
     * This is only valid for positive numbers and if money <= balance.
     * @param money a positive amount of money
     */
    public void withdrawMoney(double money) {
        // TODO:
    }

    /**
     * This method adds money to this account.
     * This is only valid for positive numbers.
     * @param money -  a positive amount of money
     */
    public final void depositMoney(double money) {
        // TODO:
    }
}