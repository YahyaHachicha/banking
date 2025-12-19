package banking.transfer;

import banking.bank.SWIFTBank;
import banking.bank.Transaction;

/**
 * This class models a transfer system for banking transactions.
 * A banking.bank.FinancialInstitution can register itself with a transactionTransferSystem,
 * which will provide a unique id for the institution.
 *
 */
public interface TransactionTransferSystem {
    /**
     * @param tx the Transaction to be executed
     * @return true if the Transaction was executed successful, false otherwise.
     */
    boolean submitTransaction(Transaction tx);

    /**
     * This method can be used to register a banking.bank.Bank to the TransactionTransferSystem.
     * @param executor the institution to register
     * @return true, if the SWIFT could be registered, false otherwise.
     */
    boolean register(SWIFTBank executor);

    /**
     * @return All registered SWIFT institutions
     */
    SWIFTBank[] getAll();

    /**
     * This method return the operating transaction executor of the Institution Number.
     * @param bic the institution number.
     * @return the unique ID for the institution
     */
    SWIFTBank getByBIC(int bic);

    /**
     * This method return the operating transaction executor of the Institution Name.
     * @param bankName the institution name.
     * @return the unique ID for the institution
     */
    SWIFTBank getByName(String bankName);
}
