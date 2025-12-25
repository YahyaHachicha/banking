package banking.account;

/**
 * This class models a check account implementing banking.accounts.BankAccount.
 *
 * @see BaseBankAccount
 *
 */
public class CheckingAccount implements BankAccount {
    // TODO:
    private int accountNumber, pin;
    private Customer owner;
    private double balance;

    /**
     * Creates a new checking bank account for the given customer.
     *
     * @param accountNumber the account number
     * @param owner the owner of the account
     * @param pin the pin for the account
     */
    public CheckingAccount(int accountNumber, Customer owner, int pin) {
        // TODO:
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.pin = pin;
    }

    @Override
    public final AccountType getAccountType() {
        // TODO:
        return AccountType.Checking;
    }

    @Override
    public final void closeAccount() {
        // TODO:
        AccountType closing = AccountType.Savings;
    }

    @Override
    public boolean validatePin(int pin) {
        // TODO:
        if (this.pin == pin) {
            return true;
        }
        return false;
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
    public final String getAccountInformation(){
        // TODO:
        String accountInformation = "Owner: " + this.owner + ", AccountNumber: " + this.accountNumber + ", Pin: " + this.pin + ", Balance: " + this.balance;
        return accountInformation;
    }
}
