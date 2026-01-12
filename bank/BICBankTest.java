package banking.bank;

import banking.account.BankCustomer;
import banking.account.CheckingAccount;
import banking.transfer.SWIFTSystem;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BICBankTest {

    SWIFTBank bank1 = new BICBank("Volksbank", 10, 10);
    SWIFTBank bank2 = new BICBank("ING-DiBa", 20, 50);
    SWIFTBank bank3 = new BICBank("Sparkasse", 25, 100);

    BankCustomer customer1 = new BankCustomer("Tom", "Zimmermann", "1997.3.5)", "Ligusterweg 4");
    BankCustomer customer2 = new BankCustomer("Tommy", "Mustermann", "2000.7.12", "Adenauerweg 18");
    BankCustomer customer3 = new BankCustomer("Max", "Müller", "1968.8.24", "Feldweg 104");

    @Test
    void executeTransactionCorrectSwift() {
        bank1.registerCustomer(customer1);
        bank1.createCheckingBankAccount(customer1.getCustomerNumber(), 43210);
        bank1.getBankAccount(0).depositMoney(1500);
        bank2.registerCustomer(customer2);
        bank2.createCheckingBankAccount(customer2.getCustomerNumber(), 43211);
        bank3.registerCustomer(customer3);
        bank3.createCheckingBankAccount(customer3.getCustomerNumber(), 43212);
        bank3.createSavingsBankAccount((CheckingAccount)bank3.getBankAccount(0), 99999);

        SWIFTSystem.SWIFT_INSTANCE.register(bank1);
        SWIFTSystem.SWIFT_INSTANCE.register(bank2);
        SWIFTSystem.SWIFT_INSTANCE.register(bank3);

        Transaction test1 = new Transaction(0, "Zimmermann", 0, "Mustermann", 1000, bank1, bank2);

        assertTrue(bank1.executeTransaction(test1));

        assertEquals(500.0, bank1.getBankAccount(0).getBalance());
        assertEquals(1000.0, bank2.getBankAccount(0).getBalance());
    }

    @Test
    void executeTransactionSavingsSwift() {
        bank1.registerCustomer(customer1);
        bank1.createCheckingBankAccount(customer1.getCustomerNumber(), 43210);
        bank1.getBankAccount(0).depositMoney(1500);
        bank2.registerCustomer(customer2);
        bank2.createCheckingBankAccount(customer2.getCustomerNumber(), 43211);
        bank3.registerCustomer(customer3);
        bank3.createCheckingBankAccount(customer3.getCustomerNumber(), 43212);
        bank3.createSavingsBankAccount((CheckingAccount)bank3.getBankAccount(0), 99999);
        bank3.getBankAccount(1).depositMoney(999.9);

        SWIFTSystem.SWIFT_INSTANCE.register(bank1);
        SWIFTSystem.SWIFT_INSTANCE.register(bank2);
        SWIFTSystem.SWIFT_INSTANCE.register(bank3);

        Transaction test2 = new Transaction(1, "Müller", 0, "Zimmermann", 500, bank3, bank1);

        assertFalse(bank3.executeTransaction(test2));

        assertNotEquals(499.9, bank3.getBankAccount(0).getBalance());
        assertNotEquals(2000.0, bank1.getBankAccount(0).getBalance());

    }

    @Test
    void executeTransactionCorrectInSameBank() {
        bank1.registerCustomer(customer1);
        bank1.createCheckingBankAccount(customer1.getCustomerNumber(), 43210);
        bank1.getBankAccount(0).depositMoney(1500);
        bank1.registerCustomer(customer2);
        bank1.createCheckingBankAccount(customer2.getCustomerNumber(), 43211);
        bank1.getBankAccount(1).depositMoney(5000);


        Transaction test3 = new Transaction(1, "Mustermann", 0, "Zimmermann", 550, bank1, bank1);

        assertTrue(bank1.executeTransaction(test3));

        assertEquals(4450.0, bank1.getBankAccount(1).getBalance());
        assertEquals(2050.0, bank1.getBankAccount(0).getBalance());
    }

    @Test
    void executeTransactionAlreadyFinished() {
        bank1.registerCustomer(customer1);
        bank1.createCheckingBankAccount(customer1.getCustomerNumber(), 43210);
        bank1.getBankAccount(0).depositMoney(2500);
        bank2.registerCustomer(customer2);
        bank2.createCheckingBankAccount(customer2.getCustomerNumber(), 43211);
        bank3.registerCustomer(customer3);
        bank3.createCheckingBankAccount(customer3.getCustomerNumber(), 43212);
        bank3.createSavingsBankAccount((CheckingAccount)bank3.getBankAccount(0), 99999);

        SWIFTSystem.SWIFT_INSTANCE.register(bank1);
        SWIFTSystem.SWIFT_INSTANCE.register(bank2);
        SWIFTSystem.SWIFT_INSTANCE.register(bank3);

        Transaction test1 = new Transaction(0, "Zimmermann", 0, "Mustermann", 1000, bank1, bank2);

        assertTrue(bank1.executeTransaction(test1));

        assertEquals(1500.0, bank1.getBankAccount(0).getBalance());
        assertEquals(1000.0, bank2.getBankAccount(0).getBalance());

        assertFalse(bank1.executeTransaction(test1));

        assertNotEquals(500.0, bank1.getBankAccount(0).getBalance());
        assertNotEquals(2000.0, bank2.getBankAccount(0).getBalance());
    }

    @Test
    void executeTransactionNotEnoughMoney() {
        bank1.registerCustomer(customer1);
        bank1.createCheckingBankAccount(customer1.getCustomerNumber(), 43210);
        bank1.getBankAccount(0).depositMoney(1);
        bank2.registerCustomer(customer2);
        bank2.createCheckingBankAccount(customer2.getCustomerNumber(), 43211);
        bank3.registerCustomer(customer3);
        bank3.createCheckingBankAccount(customer3.getCustomerNumber(), 43212);
        bank3.createSavingsBankAccount((CheckingAccount)bank3.getBankAccount(0), 99999);

        SWIFTSystem.SWIFT_INSTANCE.register(bank1);
        SWIFTSystem.SWIFT_INSTANCE.register(bank2);
        SWIFTSystem.SWIFT_INSTANCE.register(bank3);

        Transaction test1 = new Transaction(0, "Zimmermann", 0, "Mustermann", 1000, bank1, bank2);

        assertFalse(bank1.executeTransaction(test1));

        assertNotEquals(-999, bank1.getBankAccount(0).getBalance());
        assertNotEquals(1000.0, bank2.getBankAccount(0).getBalance());
    }
}