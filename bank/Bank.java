package banking.bank;

import banking.account.CheckingAccount;
import banking.account.BankAccount;
import banking.account.Customer;

/**
 * This interface models a general banking.bank.Bank with basic banking functionality.
 */
public interface Bank {
    /**
     * This method returns the name the financial institution.
     * @return -  a String containing the institutions name.
     */
    String getInstitutionName(

    );
	
	/**
	 * Registers a new customer and returns its (positive) customer number.
	 * @param customer the customer to be registered
	 * @return the new customer number or -1, if the registration
	 * was not successful
	 */
	int registerCustomer(
            Customer customer
    );

	/**
	 * Creates a new checking account for the customer with the given customer number.
	 * @param customerID the number of an existing customer
	 * @param pin the PIN code for the new account
	 * @return the account number of the new bank account
	 */
	int createCheckingBankAccount(
            int customerID,
            int pin
    );

    /**
     * Creates a new savings account for the customer with the given customer number.
     * @return the account number of the new bank account
     */
    int createSavingsBankAccount(
            CheckingAccount checkingAccount,
            int pin
    );

    /**
     * This method provides a BankAccount for a given account number
     *
     * @param accountNumber the account number
     * @return a BankAccount with the provided account number OR null if three is no matching account.
     */
    BankAccount getBankAccount(
            int accountNumber
    );

    /**
     * This method checks if the given account number belongs to the financial institute.
     * @param accountNumber - the account number to validate
     * @return -  true: if the account number belongs to the bank, false: if not!
     */
    default boolean isValidAccountNumber(int accountNumber) {
        return this.getBankAccount(accountNumber) != null;
    }

    /**
     * Utility-method to check if a name matches the name of the owner of a BankAccount.
     *
     * @param account the account to check
     * @param name    the name to check
     * @return true if the account owners name matches the provided name
     */
    default boolean lastnamesMatches(BankAccount account, String name) {
        return account != null && account.getOwner().getLastname().equalsIgnoreCase(name);
    }

    /**
     * This method returns a description of an account.
     * If the specified account is invalid this is indicated by the returned String.
     * @param accountNumber - the account number
     * @return - a string description of the account
     */
    default String getAccountInformation(int accountNumber) {
        if(!this.isValidAccountNumber(accountNumber))
            return "";

        return getBankAccount(accountNumber)
                .getAccountInformation();
    }
	
	/**
	 * Returns the current balance of the account with the given account number.
	 * @param accountNumber the number of the account the balance should be returned for
	 * @return the current balance of the given account
	 */
	double getBalance(
            int accountNumber
    );

    /**
     * This method validates if a pin is valid for a specific account.
     * @param accountNumber the number of the account the pin should be validated against
     * @param pin the pin that should be validated
     * @return true, iff the pin fits to the given account, false otherwise
     */
    boolean validatePin(
            int accountNumber,
            int pin
    );

    /**
     * Returns the transaction history for the account with
     * the given account number.
     *
     * @param accountNumber the number of the requested account
     * @return the transactions in the correct temporal order
     */
    Transaction[] getTransactionHistory(
            int accountNumber
    );

    /**
     * This method removes money from a specified account.
     * This is only valid for positive numbers and if money <= balance.
     * @param accountNumber - the account number
     * @param money -  a positive amount of money
     * @return - true if money <= balance and money > 0
     */
    default boolean deposit(int accountNumber, double money) {
        if(money <= 0 || !this.isValidAccountNumber(accountNumber))
            return false;

        this.getBankAccount(accountNumber).depositMoney(money);
        return true;
    }

    /**
     * This method removes money from a specified account.
     * This is only valid for positive numbers and if money <= balance and for checking accounts.
     * @param accountNumber - the account number
     * @param money -  a positive amount of money
     * @return - true if money <= balance and money > 0
     */
    boolean withdraw(int accountNumber, double money);

    /**
     * This method transfers money from one account to another.
     * Transfer is only possible if money < balance on the source account and
     * if the owners lastname of the target account is correct.
     * @param fromAccountNumber - the source account number.
     * @param toCustomerName - the last name of the owner of the target account.
     * @param toAccountNumber - the account number of the target account.
     * @param money - the amount of money to transfer.
     * @return -  boolean: true if transfer was successful, false otherwise.
     */
    default boolean transferWithinBank(int fromAccountNumber,
                                       String toCustomerName,
                                       int toAccountNumber,
                                       double money)
    {
        if(!this.isValidAccountNumber(fromAccountNumber) ||
                !this.isValidAccountNumber(toAccountNumber))
            return false;

        BankAccount target = this.getBankAccount(toAccountNumber);
        if (!this.lastnamesMatches(target, toCustomerName))
            return false;

        boolean withdrawSuccess = this.withdraw(fromAccountNumber, money);
        if(!withdrawSuccess)
            return false;

        boolean depositSuccess = this.deposit(toAccountNumber, money);
        if (!depositSuccess) {
            this.deposit(fromAccountNumber, money);
            return false;
        }

        return true;
    }
}
