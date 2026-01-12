package banking.account;

import java.util.Date;

/**
 * This class implements a simple bank customer.
 *
 */
public class BankCustomer implements Customer {
    // TODO:
    private String firstname, lastname, birthday, address;
    private int  customerNumber;

    /**
     * Constructor to create a finance.banking.account.BankCustomer.
     *
     * @param firstname      the firstname of the customer
     * @param lastname       the last name of the customer
     * @param birthday       the birthday
     * @param address        the address
     */
    public BankCustomer(String firstname, String lastname, String birthday, String address) {
        // TODO:
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.address = address;
    }

    /**
     * returns the last name of the customer.
     * @return the last name of the customer.
     */
    public String getLastname() {
        // TODO:
        return this.lastname;    
    }

    /**
     * returns the unique customer number.
     * @return the unique customer number.
     */
    public int getCustomerNumber() {
        // TODO:
        return customerNumber;
    }

    /**
     * Returns the first name of this customer.
     *
     * @return the first name of this customer
     */
    public String getName() {
        // TODO:
        return this.firstname;
    }

    /**
     * Returns the date of birth of this customer as string.
     *
     * @return the date of birth
     */
    public String getBirthday() {
        // TODO:
        return this.birthday;
    }

    /**
     * Returns the address of this customer.
     *
     * @return the address of this customer
     */
    public String getAddress() {
        // TODO:
        return this.address;
    }

    /**
     * Sets the customer number for this customer
     *
     * @param customerNumber the new customer number
     */
    public void setCustomerNumber(int customerNumber) {
        // TODO:
        this.customerNumber = customerNumber;
    }

    /**
     * Sets the last name of this customer.
     *
     * @param lastname the new last name
     */
    public void setLastname(String lastname) {
        // TODO:
        this.lastname = lastname;
    }

    /**
     * Sets the first name of this customer.
     *
     * @param name the new first name
     */
    public void setName(String name) {
        // TODO:
        this.firstname = name;
    }

    /**
     * Sets the new birthday of this customer.
     *
     * @param birthday the new birthday
     */
    public void setBirthday(String birthday) {
        // TODO:
        this.birthday = birthday;
    }

    /**
     * Sets the new address of this customer.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
