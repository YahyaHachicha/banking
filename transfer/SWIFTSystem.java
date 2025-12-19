package banking.transfer;

import banking.bank.SWIFTBank;
import banking.bank.Transaction;

/**
 * A simple TransactionTransferSystem via SWIFTBanks.
 */
public class SWIFTSystem implements TransactionTransferSystem {
    private static final int SWIFT_BANKS_COUNT = 100;
    public static final TransactionTransferSystem SWIFT_INSTANCE
            = new SWIFTSystem(SWIFT_BANKS_COUNT);

    // TODO:

    /**
     * Creates a simple transaction transfer system for the
     * given maximum number of executors (banks).
     *
     * @param size the maximum number of executors (banks) that can be registered
     */
    private SWIFTSystem(int size){
        // TODO:
    }

    @Override
    public boolean submitTransaction(Transaction tx) {
        // TODO:
        return false;
    }

    @Override
    public boolean register(SWIFTBank pSwiftBank) {
        // TODO:
        return false;
    }

    @Override
    public SWIFTBank getByBIC(int bic) {
        // TODO:
        return null;
    }

    @Override
    public SWIFTBank getByName(String bankName) {
        // TODO:
        return null;
    }

    @Override
    public SWIFTBank[] getAll() {
        // TODO:
        return null;
    }
}
