package banking.transfer;

import banking.bank.SWIFTBank;
import banking.bank.Transaction;

/**
 * A simple TransactionTransferSystem via SWIFTBanks.
 */
public class SWIFTSystem implements TransactionTransferSystem {
    private static final int SWIFT_BANKS_COUNT = 100;
    public static final TransactionTransferSystem SWIFT_INSTANCE = new SWIFTSystem(SWIFT_BANKS_COUNT);
    private int maxBanks, bankCount = 0;
    SWIFTBank[] banks;
    /**
     * Creates a simple transaction transfer system for the
     * given maximum number of executors (banks).
     *
     * @param size the maximum number of executors (banks) that can be registered
     */
    private SWIFTSystem(int size){
        this.maxBanks = size;
        banks = new SWIFTBank[maxBanks];
    }

    /**
     * No need for documentation here! This method is defined and
     * documented in the given interface. The documentation is inherited
     * automatically from the interface. If you want to add additional
     * documentation to an implemented method, you can use {&#64;inheritDoc}
     * (see below).
     * <br />
     * <br />
     * {@inheritDoc}
     */

    @Override
    public boolean submitTransaction(Transaction tx) {

        if (tx.getFromBank() instanceof SWIFTBank) {
            for (SWIFTBank banktmp : banks) {
                if (tx.getFromBank() == banktmp) {
                    tx.getFromBank().getBankAccount(tx.getFromAccountNumber()).withdrawMoney(tx.getAmount());
                    tx.getToBank().getBankAccount(tx.getToAccountNumber()).depositMoney(tx.getAmount());
                    return true;
                }
            }
            return false;
        }
        return false;

    }

    @Override
    public boolean register(SWIFTBank pSwiftBank) {
        if (pSwiftBank == null) {
            return false;
        }

        if (bankCount >= banks.length) {
            return false;
        }

        for (SWIFTBank banktmp : banks) {
            if (banktmp == pSwiftBank) {
                return false;
            }
        }

        banks[bankCount] = pSwiftBank;
        banks[bankCount].setBIC(bankCount, SWIFTSystem.SWIFT_INSTANCE);
        bankCount += 1;
        return true;
    }

    @Override
    public SWIFTBank getByBIC(int bic) {
        return banks[bic];
    }

    @Override
    public SWIFTBank getByName(String bankName) {
        for (SWIFTBank banktmp : banks) {
            if (banktmp != null) {
                if (banktmp.getInstitutionName().equals(bankName)) {
                    return banktmp;
                }
            }
        }
        return null;
    }

    @Override
    public SWIFTBank[] getAll() {
       return banks;
    }
}
