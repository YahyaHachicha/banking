package banking.account;

/**
 * This class models a check account implementing banking.accounts.BankAccount.
 *
 * @see BaseBankAccount
 *
 */
public class CheckingAccount implements BankAccount {
    // TODO:
    private BaseBankAccount baseAccount;

    /**
     * Creates a new checking bank account for the given customer.
     *
     * @param accountNumber the account number
     * @param owner the owner of the account
     * @param pin the pin for the account
     */
    public CheckingAccount(int accountNumber, Customer owner, int pin) {
        // TODO:
        this.baseAccount = new BaseBankAccount(accountNumber, owner, pin);

    }

    /**
     * This method returns the BankAccount variant type.
     * @return AccountTyp of this BankAccount.
     */
    @Override
    public final AccountType getAccountType() {
        // TODO:
        return AccountType.Checking;
    }

    /**
     * Closes the banking account by withdrawing the money for checking accounts
     * or for savings accounts, depositing the money back to the checking account.
     */
    @Override
    public final void closeAccount() {
        //TODO:
        double balance = baseAccount.getBalance();
        if (balance > 0) {
            baseAccount.withdrawMoney(balance);
        }
    }

    /**
     * This method validates if a pin is valid for this account.
     * @param pin the pin that should be validated
     * @return true, iff the pin fits to this account, false otherwise
     */
    @Override
    public boolean validatePin(int pin) {
        // TODO:
        if (baseAccount.validatePin(pin)) {
            return true;
        }
        return false;
    }

    /**
     * Returns the customer that owns this account.
     *
     * @return the owner of this account
     */
    @Override
    public Customer getOwner() {
        // TODO:
        return baseAccount.getOwner();
    }

    /**
     * Returns the account number of this account.
     *
     * @return the account number of this account
     */
    @Override
    public int getAccountNumber() {
        // TODO:
        return baseAccount.getAccountNumber();
    }

    /**
     * Returns the current balance of this account.
     * @return the current balance of this account
     */
    @Override
    public double getBalance() {
        // TODO:
        return baseAccount.getBalance();
    }

    /**
     * This method removes money from this account.
     * This is only valid for positive numbers and if money <= balance.
     * @param money a positive amount of money
     */
    @Override
    public void withdrawMoney(double money) {
        // TODO:
        baseAccount.withdrawMoney(money);
    }

    /**
     * This method adds money to this account.
     * This is only valid for positive numbers.
     * @param money -  a positive amount of money
     */
    @Override
    public void depositMoney(double money) {
        // TODO:
        baseAccount.depositMoney(money);
    }

    /**
     * This method returns a description of this account.
     * @return a string description of this account
     */
    @Override
    public final String getAccountInformation(){
        // TODO:
        String accountInformation = "Owner: " + baseAccount.getOwner() + ", AccountNumber: " + baseAccount.getAccountNumber() +  ", Balance: " + getBalance();
        return accountInformation;
    }
}
