package banking.account;

/**
 * This class models a savings bank account implementing banking.accounts.BankAccount.
 *
 * @see BaseBankAccount
 *
 */
public class SavingsAccount implements BankAccount {
    // TODO:
    private CheckingAccount connectedCheckingAccount;
    private BaseBankAccount baseAccount;

    /**
     * Creates a new savings bank account for the given customer.
     *
     * @param accountNumber the account number
     * @param checkingAccount the checkingAccount of the account
     * @param pin the pin for the account
     */
    public SavingsAccount(int accountNumber, CheckingAccount checkingAccount, int pin){
        // TODO:
        this.baseAccount = new BaseBankAccount(accountNumber, checkingAccount.getOwner(), pin);
        this.connectedCheckingAccount = checkingAccount;
    }

    /**
     * This method returns the BankAccount variant type.
     * @return AccountTyp of this BankAccount.
     */
    @Override
    public AccountType getAccountType() {
        // TODO:
        return AccountType.Savings;
    }

    /**
     * This method removes money from this account.
     * This is only valid for positive numbers and if money <= balance.
     * Does not work with a savings account.
     * @param money a positive amount of money
     */
    @Override
    //Not allowed to withdraw from SavingsAccount so method stays empty
    public void withdrawMoney(double money) {
    }

    /**
     * This method adds money to this account.
     * This is only valid for positive numbers.
     * @param money -  a positive amount of money
     */
    @Override
    public void depositMoney(double money) {
        // TODO:
        this.baseAccount.depositMoney(money);
    }

    /**
     * Returns if this account is accessible from a terminal.
     * This is always true for check accounts e.g.
     *
     * @return true by default. Only Savings Accounts can't access terminal.
     */
    @Override
    public boolean accessibleFromTerminal() {
        // TODO:
        if (getAccountType() != AccountType.Checking) {
            return false;
        }
        return true;
    }

    /**
     * Returns the customer that owns this account.
     *
     * @return the owner of this account
     */
    @Override
    public Customer getOwner() {
        // TODO:
        return this.baseAccount.getOwner();
    }

    /**
     * Returns the account number of this account.
     *
     * @return the account number of this account
     */
    @Override
    public int getAccountNumber() {
        // TODO:
        return this.baseAccount.getAccountNumber();
    }

    /**
     * Returns the current balance of this account.
     * @return the current balance of this account
     */
    @Override
    public double getBalance() {
        // TODO:
        return this.baseAccount.getBalance();
    }

    /**
     * Closes the banking account by withdrawing the money for checking accounts
     * or for savings accounts, depositing the money back to the checking account.
     */
    @Override
    public void closeAccount() {
        if (this.baseAccount.getBalance() > 0) {
            connectedCheckingAccount.depositMoney(this.baseAccount.getBalance());
            this.baseAccount.withdrawMoney(this.baseAccount.getBalance()); //balance set to zero.
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
        if (baseAccount.validatePin(pin)){
            return true;
        }
        return false;
    }

    /**
     * This method returns a description of this account.
     * @return a string description of this account
     */
    @Override
    public String getAccountInformation(){
        // TODO:
        String accountInformation = "Owner: " + this.baseAccount.getOwner() + ", AccountNumber: " + this.baseAccount.getAccountNumber() + ", Balance: " + this.baseAccount.getBalance();
        return accountInformation;
    }
}
