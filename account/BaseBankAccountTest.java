package banking.account;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BaseBankAccountTest {

    Customer test2 = new BankCustomer("Tom", "Zimmermann", new Date(1997, 3, 5), "Ligusterweg 4");
    BaseBankAccount test1 = new BaseBankAccount(12345, test2, 1544);
    @Test
    void validatePin() {

        assertEquals(true, test1.validatePin(1544));

        assertNotEquals(true, test1.validatePin(1546));
    }

    @Test
    void getOwner() {
        assertEquals(test2, test1.getOwner());
        assertNotEquals(null, test1.getOwner());
    }

    @Test
    void getAccountNumber() {
        assertEquals(12345, test1.getAccountNumber());

        assertNotEquals(12346, test1.getAccountNumber());
    }

    @Test
    void getBalance() {
        assertEquals(0, test1.getBalance());
        assertNotEquals(500, test1.getBalance());


    }

    @Test
    void withdrawMoney() {
        test1.withdrawMoney(200);
        assertEquals(0, test1.getBalance());
        assertNotEquals(-200, test1.getBalance());

        test1.depositMoney(1000);
        test1.withdrawMoney(250);
        assertEquals(750, test1.getBalance());
        assertNotEquals(1250, test1.getBalance());
    }

    @Test
    void depositMoney() {
        test1.depositMoney(5000);
        assertEquals(5000, test1.getBalance());

        test1.depositMoney(-5000);
        assertEquals(5000, test1.getBalance());
        assertNotEquals(0, test1.getBalance());
    }
}