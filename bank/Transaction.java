package banking.bank;

import java.util.Date;

/**
 * Models a transaction between two customers.
 *
 */
public class Transaction {
    /**
     * The institution the transaction is applied from, i.e., money is taken from.
     */
    private Bank fromBank;

    /**
     * The institution the transaction is applied to, i.e., money is transferred to.
     */
    private Bank toBank;

    /**
     * The account number of the sender account
     */
    private int fromAccountNumber;
    /**
     * The name of the sender account owner
     */
    private String senderLastName;
    /**
     * The account number of the recipient account
     */
    private int toAccountNumber;
    /**
     * The name of the recipient account owner
     */
    private String recipientLastName;
    /**
     * The amount of money transferred
     */
    private double amount;
    /**
     * The transaction init. time
     */
    private Date startDate;

    /**
     * The transaction end time
     */
    private Date finishDate;

    /**
     * @return fromBank, the Bank of which the money is taken from.
     */
    public Bank getFromBank() {
        return fromBank;
    }

    /**
     * @return toBank, the Bank of which the money is sent to.
     */
    public Bank getToBank() {
        return toBank;
    }

    /**
     * Creates a new transaction for the given sender and recipient.
     *
     * @param fromAccountNumber the sender account number
     * @param senderLastName the sender´s last name
     * @param toAccountNumber the recipient account number
     * @param recipientLastName the recipient´s last name
     * @param amount the amount of money that has been transferred
     * @param fromBank the bank of where the sender is registered
     * @param toBank the bank of where the recipient is registered
     */
    public Transaction(
            int fromAccountNumber,
            String senderLastName,
            int toAccountNumber,
            String recipientLastName,
            double amount,
            Bank fromBank,
            Bank toBank)
    {
        this.fromAccountNumber = fromAccountNumber;
        this.senderLastName = senderLastName;
        this.toAccountNumber = toAccountNumber;
        this.recipientLastName = recipientLastName;
        this.amount = amount;
        this.fromBank = fromBank;
        this.toBank = toBank;
        this.startDate = new Date(System.currentTimeMillis());
        this.finishDate = null;
    }

    /**
     * Returns the transaction time as date.
     *
     * @return the time of the transaction
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Returns the transaction finish time as date.
     *
     * @return the finish time of the transaction
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * Returns the account number of the sender account.
     *
     * @return the number of the sender account
     */
    public int getFromAccountNumber() {
        return fromAccountNumber;
    }

    /**
     * Returns the last name of the sender
     * @return the Lastname of the sender.
     */
    public String getSenderLastName() {
        return senderLastName;
    }

    /**
     * Returns the account number of the recipient account.
     *
     * @return the number of the recipient account
     */
    public int getToAccountNumber() {
        return toAccountNumber;
    }

    /**
     * Returns the last name of the recipient.
     *
     * @return the last name of the recipient
     */
    public String getRecipientLastName() {
        return recipientLastName;
    }

    /**
     * Returns the amount of money that has been transferred.
     *
     * @return the transferred amount of money
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns true, if this transaction has affected the accountNumber.
     * @param accountNumber, the account number to be checked within this transaction.
     * @return the transferred amount of money
     */
    public boolean affectsAccountNumber(int accountNumber) {
        return fromAccountNumber == accountNumber ||  toAccountNumber == accountNumber;
    }

    /**
     * Sets the finishing date of this transaction, i.e., the time when its executed.
     * @param date, the execution date of this transaction.
     */
    public void setFinishDate(Date date) {
        this.finishDate = date;
    }
}
