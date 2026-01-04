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

    @Override
    public final AccountType getAccountType() {
        // TODO:
        return AccountType.Checking;
    }

    @Override
    public final void closeAccount() {
        //TODO:
        double balance = baseAccount.getBalance();
        if (balance > 0) {
            baseAccount.withdrawMoney(balance);
        }
    }

    @Override
    public boolean validatePin(int pin) {
        // TODO:
        if (baseAccount.validatePin(pin)) {
            return true;
        }
        return false;
    }

    @Override
    public Customer getOwner() {
        // TODO:
        return baseAccount.getOwner();
    }

    @Override
    public int getAccountNumber() {
        // TODO:
        return baseAccount.getAccountNumber();
    }

    @Override
    public double getBalance() {
        // TODO:
        return baseAccount.getBalance();
    }

    @Override
    public void withdrawMoney(double money) {
        // TODO:
        baseAccount.withdrawMoney(money);
    }

    @Override
    public void depositMoney(double money) {
        // TODO:
        baseAccount.depositMoney(money);
    }

    @Override
    public final String getAccountInformation(){
        // TODO:
        String accountInformation = "Owner: " + baseAccount.getOwner() + ", AccountNumber: " + baseAccount.getAccountNumber() +  ", Balance: " + getBalance();
        return accountInformation;
    }
}
