package banking.bank;

import banking.transfer.TransactionTransferSystem;

/**
 * Abstracts a transaction executor for international banks, i.e., SWIFT.
 *
 */
public interface SWIFTBank extends Bank {
    /**
     * Returns the bank code of this Financial Institution.
     *
     * @return the bank code
     */
    int getBIC();

    /**
     * Sets the bank code of this Financial Institution.
     * @param bankCode, the BIC to bind this Financial Institution to.
     * @param tts, the TransactionTransferSystem applying the BIC.
     *
     */
    void setBIC(int bankCode, TransactionTransferSystem tts);

    /**
     * Executes the given transaction.
     *
     * @param transaction the transaction to be executed between two (different) InternationalBanks.
     * @return true, if the execution was successful, false otherwise
     */
    boolean executeTransaction(Transaction transaction);
}
