package banking.account;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static banking.account.BankAccount.AccountType.Checking;
import static banking.account.BankAccount.AccountType.Savings;

import static org.junit.jupiter.api.Assertions.*;


class CheckingAccountTest {

    BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.3.5", "Ligusterweg 4");
    CheckingAccount test1 = new CheckingAccount(12345, test2, 1544);

    BankCustomer test3 = new BankCustomer("Marc", "Mustermann", "1990.10.12", "Berliner Straße 1");
    CheckingAccount test4 = new CheckingAccount(54321, test3, 9999);

    @Test
    void getAccountType() {
        assertEquals(Checking, test1.getAccountType());
        assertNotEquals(Savings, test1.getAccountType());
    }

    @Test
    void getAccountType2() {
        // Auch ein zweites CheckingAccount-Objekt muss den Typ "Checking" haben
        assertEquals(Checking, test4.getAccountType());
        assertNotEquals(Savings, test4.getAccountType());
    }

    @Test
    void closeAccount() {
        test1.depositMoney(250.5);
        assertEquals(250.5, test1.getBalance());
        test1.closeAccount();
        assertEquals(0.0, test1.getBalance());
        assertNotEquals(250.5, test1.getBalance());
    }

    @Test
    void closeAccount2() {
        test4.depositMoney(1000.0);
        assertEquals(1000.0, test4.getBalance());
        test4.closeAccount();
        assertEquals(0.0, test4.getBalance());
        assertNotEquals(1000.0, test4.getBalance());
    }

    @Test
    void validatePin() {
        assertEquals(true, test1.validatePin(1544));
        assertNotEquals(true, test1.validatePin(1546));
    }

    @Test
    void validatePin2() {
        assertEquals(true, test4.validatePin(9999));
        assertNotEquals(true, test4.validatePin(0000));
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
        assertEquals(54321, test4.getAccountNumber());
        assertNotEquals(12345, test4.getAccountNumber());
    }

    @Test
    void getBalance() {
        assertEquals(0, test1.getBalance());
        assertNotEquals(500, test1.getBalance());
    }

    @Test
    void getBalance2() {
        test4.depositMoney(150.75);
        assertEquals(150.75, test4.getBalance());
        assertNotEquals(0.0, test4.getBalance());
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
        test4.withdrawMoney(100.50);
        assertEquals(399.50, test4.getBalance());

        // Teste Auszahlung von mehr als vorhanden ist
        test4.withdrawMoney(1000);
        assertEquals(399.50, test4.getBalance());
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
        test4.depositMoney(300.33);
        assertEquals(300.33, test4.getBalance());

        test4.depositMoney(-1.0);
        assertEquals(300.33, test4.getBalance());
    }

    @Test
    void getAccountInformation() {
        assertEquals(("Owner: " + test2 + ", AccountNumber: " + 12345 +  ", Balance: " + 0.0), test1.getAccountInformation());
        assertNotEquals("Owner: test2, AccountNumber: 12345, Balance: 0", test1.getAccountInformation());
    }

    @Test
    void getAccountInformation2() {
        String expected = "Owner: " + test3 + ", AccountNumber: 54321, Balance: 0.0";
        assertEquals(expected, test4.getAccountInformation());
        assertNotEquals("Owner: Tom Zimmermann...", test4.getAccountInformation());
    }
}