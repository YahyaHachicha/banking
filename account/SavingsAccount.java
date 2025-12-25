package banking.account;

/**
 * This class models a savings bank account implementing banking.accounts.BankAccount.
 *
 * @see BaseBankAccount
 *
 */
public class SavingsAccount implements BankAccount {
    // TODO:
    private int accountNumber, pin;
    private CheckingAccount checkingAccount;
    private double balance;
    private Customer owner;

    /**
     * Creates a new savings bank account for the given customer.
     *
     * @param accountNumber the account number
     * @param checkingAccount the checkingAccount of the account
     * @param pin the pin for the account
     */
    public SavingsAccount(int accountNumber, CheckingAccount checkingAccount, int pin){
        // TODO:
        this.accountNumber = accountNumber;
        this.checkingAccount = checkingAccount;
        this.pin = pin;
    }

    @Override
    public AccountType getAccountType() {
        // TODO:
        return AccountType.Savings;
    }

    @Override
    public void withdrawMoney(double money) {
        // TODO:
        if (money > 0 && money <= this.balance) {
            this.balance -= money;
        }
    }

    @Override
    public void depositMoney(double money) {
        // TODO:
        if (money > 0){
            this.balance += money;}
    }

    @Override
    public boolean accessibleFromTerminal() {
        // TODO:
        if (getAccountType() != AccountType.Checking)
            return false;
        return true;
    }

    @Override
    public Customer getOwner() {
        // TODO:
        return this.owner;
    }

    @Override
    public int getAccountNumber() {
        // TODO:
        return this.accountNumber;
    }

    @Override
    public double getBalance() {
        // TODO:
        return this.balance;
    }

    @Override
    public void closeAccount() {
        // TODO:
        AccountType closing = AccountType.Savings;
    }

    @Override
    public boolean validatePin(int pin) {
        // TODO:
        if (this.pin == pin){
            return true;
        }
        return false;
    }

    @Override
    public String getAccountInformation(){
        // TODO:
        String accountInformation = "Owner: " + this.owner + ", AccountNumber: " + this.accountNumber + ", Pin: " + this.pin + ", Balance: " + this.balance;
        return accountInformation;
    }
}
