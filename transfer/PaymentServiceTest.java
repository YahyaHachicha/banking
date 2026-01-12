package banking.transfer;

import banking.account.BankCustomer;
import banking.account.Customer;
import banking.bank.*;
import org.junit.jupiter.api.Test;

/**
 * A simple TransactionTransferSystem without a SWIFTBank by senders.
 * e.g. WesternUnion, MoneyGram, PayPal, Wero, Klarna etc.
 */
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    @Test
    void successCashPaymentViaPaymentService(){
        SWIFTBank receiverBank = new BICBank("Volksbank",10,10);
        Customer customer = new BankCustomer("Yahya", "Hachicha", null, null);
        receiverBank.registerCustomer(customer);
        int access = receiverBank.createCheckingBankAccount(customer.getCustomerNumber(), 43210);

        Transaction transaction1 = new Transaction(0, "Hachicha", 0, "Meinken", 99.9, receiverBank);

        boolean result = PaymentService.PAYPAL.submitTransaction(transaction1);

        assertTrue(result);
    }

    @Test
    void failureSubmitNullTransaction(){
        boolean result = PaymentService.WERO.submitTransaction(null);

        assertFalse(result);
    }

    @Test
    void finishedTransaction(){
        Transaction transaction2 = new Transaction(0, "Hachicha", 1, "Meinken", 10.0, null, null);
        transaction2.setFinishDate(null);
        boolean result = PaymentService.KLARNA.submitTransaction(transaction2);
        assertFalse(result);
    }

    @Test
    void unknownService(){
        SWIFTBank bank = PaymentService.APPLE_PAY.getByName("UnknownService");
        assertNull(bank);
    }

    @Test
    void successPaymentService(){
        SWIFTBank bank = new BICBank("Sparkasse", 5, 5);
        boolean result = PaymentService.MONEY_GRAM.register(bank);
        assertTrue(result);
    }
}
