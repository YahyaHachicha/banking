package banking.account;

/**
 * This class models a savings bank account implementing banking.accounts.BankAccount.
 *
 * @see BaseBankAccount
 *
 */
public class SavingsAccount implements BankAccount {
    // TODO:

    /**
     * Creates a new savings bank account for the given customer.
     *
     * @param accountNumber the account number
     * @param checkingAccount the checkingAccount of the account
     * @param pin the pin for the account
     */
    public SavingsAccount(int accountNumber, CheckingAccount checkingAccount, int pin){
        // TODO:
    }

    @Override
    public AccountType getAccountType() {
        // TODO:
        return null;
    }

    @Override
    public void withdrawMoney(double money) {
        // TODO:
    }

    @Override
    public void depositMoney(double money) {
        // TODO:
    }

    @Override
    public boolean accessibleFromTerminal() {
        // TODO:
        return true;
    }

    @Override
    public Customer getOwner() {
        // TODO:
        return null;
    }

    @Override
    public int getAccountNumber() {
        // TODO:
        return 0;
    }

    @Override
    public double getBalance() {
        // TODO:
        return 0;
    }

    @Override
    public void closeAccount() {
        // TODO:
    }

    @Override
    public boolean validatePin(int pin) {
        // TODO:
        return false;
    }

    @Override
    public String getAccountInformation(){
        // TODO:
        return null;
    }
}