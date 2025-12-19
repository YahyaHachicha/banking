package banking.bank;

/**
 * A simple buffer with FIFO ordering.
 *
 */
public class TransactionBuffer {
    /**
     * The buffer array for the transactions
     */
    private final Transaction[] buffer;
    /**
     * The position for the next transaction within the buffer
     */
    private int nextPosition;

    /**
     * Creates a new buffer with the given size.
     *
     * @param size the size of the buffer
     */
    public TransactionBuffer(int size) {
        this.buffer = new Transaction[size];
    }

    /**
     * Adds a transaction to this buffer and overrides
     * the oldest transaction, if the buffer is full.
     *
     * @param transaction the transaction to be added to the buffer
     */
    public void addTransaction(Transaction transaction) {
        this.buffer[this.nextPosition] = transaction;
        this.nextPosition = (this.nextPosition+1) % this.buffer.length;
    }

    /**
     * Returns the transactions of this buffer in the correct order
     *
     * @return an array containing all transactions of this
     * buffer in the correct order
     */
    public Transaction[] getTransactions() {
        Transaction[] result;
        if (this.buffer[this.nextPosition] == null) {
            result = new Transaction[this.nextPosition];
            System.arraycopy(this.buffer, 0, result, 0, result.length);
        }
        else {
            result = new Transaction[this.buffer.length];
            int pos = this.nextPosition;

            for(int i = 0; i < result.length; i++, pos = (pos+1) % this.buffer.length)
                result[i] = this.buffer[pos];
        }
        return result;
    }
}
