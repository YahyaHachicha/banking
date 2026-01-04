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

    @Override
    public AccountType getAccountType() {
        // TODO:
        return AccountType.Savings;
    }

    @Override
    //Not allowed to withdraw from SavingsAccount so method stays empty
    public void withdrawMoney(double money) {
    }

    @Override
    public void depositMoney(double money) {
        // TODO:
        this.baseAccount.depositMoney(money);
    }

    @Override
    public boolean accessibleFromTerminal() {
        // TODO:
        if (getAccountType() != AccountType.Checking) {
            return false;
        }
        return true;
    }

    @Override
    public Customer getOwner() {
        // TODO:
        return this.baseAccount.getOwner();
    }

    @Override
    public int getAccountNumber() {
        // TODO:
        return this.baseAccount.getAccountNumber();
    }

    @Override
    public double getBalance() {
        // TODO:
        return this.baseAccount.getBalance();
    }

    @Override
    public void closeAccount() {
        if (this.baseAccount.getBalance() > 0) {
            connectedCheckingAccount.depositMoney(this.baseAccount.getBalance());
            this.baseAccount.withdrawMoney(this.baseAccount.getBalance()); //balance set to zero.
        }
    }

    @Override
    public boolean validatePin(int pin) {
        // TODO:
        if (baseAccount.validatePin(pin)){
            return true;
        }
        return false;
    }

    @Override
    public String getAccountInformation(){
        // TODO:
        String accountInformation = "Owner: " + this.baseAccount.getOwner() + ", AccountNumber: " + this.baseAccount.getAccountNumber() + ", Balance: " + this.baseAccount.getBalance();
        return accountInformation;
    }
}
