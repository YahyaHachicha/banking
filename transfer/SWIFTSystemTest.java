package banking.transfer;

import banking.account.BankCustomer;
import banking.account.Customer;
import banking.bank.BICBank;
import banking.bank.SWIFTBank;
import banking.bank.Transaction;
import org.junit.jupiter.api.Test;

/**
 * A simple TransactionTransferSystem via SWIFTBanks.
 */
import static org.junit.jupiter.api.Assertions.*;

class SWIFTSystemTest {
    @Test
    void failedSubmitTransactionOnlyCash(){
        Transaction transaction1 = new Transaction(1, "Hachicha", 2, "Meinken", 1000, null, null);

        boolean result = SWIFTSystem.SWIFT_INSTANCE.submitTransaction(transaction1);

        assertFalse(result);
    }

    @Test
    void failedSubmitTransactionFake(){
        SWIFTBank receiverBank = new BICBank("Volksbank",10,10);
        Customer customer = new BankCustomer("Yahya", "Hachicha", null, null);
        SWIFTBank fakeBank = new fakeSWIFTBank("FakeBank");

        Transaction transaction2 = new Transaction(1, "Hachicha", 2, "Meinken", 1000, fakeBank, receiverBank);

        boolean result = SWIFTSystem.SWIFT_INSTANCE.submitTransaction(transaction2);

        assertFalse(result);
    }

    class fakeSWIFTBank implements SWIFTBank {

        private final String name;

        fakeSWIFTBank(String name) {
            this.name = name;
        }

        @Override
        public String getInstitutionName() {
            return name;
        }

        @Override
        public int getBIC() {
            return 0;
        }

        @Override
        public void setBIC(int bankCode, TransactionTransferSystem tts) {}

        @Override
        public boolean executeTransaction(Transaction transaction) {
            return false;
        }

        // Bank-Methoden
        @Override
        public int registerCustomer(banking.account.Customer customer){
            return 0;
        }
        @Override
        public int createCheckingBankAccount(int customerID, int pin){
            return 0;
        }
        @Override
        public int createSavingsBankAccount(banking.account.CheckingAccount checkingAccount, int pin){
            return 0;
        }
        @Override
        public banking.account.BankAccount getBankAccount(int accountNumber){
            return null;
        }
        @Override
        public double getBalance(int accountNumber){
            return 0;
        }
        @Override
        public boolean validatePin(int accountNumber, int pin){
            return false;
        }
        @Override
        public banking.bank.Transaction[] getTransactionHistory(int accountNumber){
            return new banking.bank.Transaction[0];
        }
        @Override
        public boolean withdraw(int accountNumber, double money){
            return false;
        }
    }


}