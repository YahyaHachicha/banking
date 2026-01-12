package banking.account;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BaseBankAccountTest {

    BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.3.5", "Ligusterweg 4");
    BaseBankAccount test1 = new BaseBankAccount(12345, test2, 1544);


    BankCustomer test3 = new BankCustomer("Julia", "Meier", "1990.10.12", "Hauptstraße 5");
    BaseBankAccount test4 = new BaseBankAccount(98765, test3, 4321);


    @Test
    void validatePin() {
        assertEquals(true, test1.validatePin(1544));
        assertNotEquals(true, test1.validatePin(1546));
    }

    @Test
    void validatePin2() {
        assertEquals(true, test4.validatePin(4321));
        assertNotEquals(true, test4.validatePin(1111));
    }


    @Test
    void getOwner() {
        assertEquals(test2, test1.getOwner());
        assertNotEquals(null, test1.getOwner());
    }

    @Test
    void getOwner2() {
        assertEquals(test3, test4.getOwner());
        assertNotEquals(test2, test4.getOwner());
    }


    @Test
    void getAccountNumber() {
        assertEquals(12345, test1.getAccountNumber());
        assertNotEquals(12346, test1.getAccountNumber());
    }

    @Test
    void getAccountNumber2() {
        assertEquals(98765, test4.getAccountNumber());
        assertNotEquals(12345, test4.getAccountNumber());
    }


    @Test
    void getBalance() {
        assertEquals(0, test1.getBalance());
        assertNotEquals(500, test1.getBalance());
    }

    @Test
    void getBalance2() {
        assertEquals(0, test4.getBalance());
        test4.depositMoney(100);
        assertNotEquals(0, test4.getBalance());
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
    void withdrawMoney2() {
        test4.depositMoney(500);
        test4.withdrawMoney(100);
        assertEquals(400, test4.getBalance());

        test4.withdrawMoney(1000);
        assertEquals(400, test4.getBalance());
        assertNotEquals(-600, test4.getBalance());
    }


    @Test
    void depositMoney() {
        test1.depositMoney(5000);
        assertEquals(5000, test1.getBalance());

        test1.depositMoney(-5000);
        assertEquals(5000, test1.getBalance());
        assertNotEquals(0, test1.getBalance());
    }

    @Test
    void depositMoney2() {
        test4.depositMoney(250);
        assertEquals(250, test4.getBalance());

        test4.depositMoney(-100);
        assertEquals(250, test4.getBalance());
        assertNotEquals(150, test4.getBalance());
    }
}