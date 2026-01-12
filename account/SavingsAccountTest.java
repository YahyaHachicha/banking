package banking.account;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static banking.account.BankAccount.AccountType.Checking;
import static banking.account.BankAccount.AccountType.Savings;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.3.5", "Ligusterweg 4");
    CheckingAccount test1 = new CheckingAccount(12345, test2, 1544);
    SavingsAccount test3 = new SavingsAccount(54321, test1, 3567);

    BankCustomer test4 = new BankCustomer("Lisa", "Müller", "1990.10.12", "Schlossallee 1");
    CheckingAccount test5 = new CheckingAccount(67890, test4, 1111);
    SavingsAccount test6 = new SavingsAccount(99999, test5, 2222);

    @Test
    void getAccountType() {
        assertEquals(Savings, test3.getAccountType());
        assertNotEquals(Checking, test3.getAccountType());
    }

    @Test
    void getAccountType2() {
        assertEquals(Savings, test6.getAccountType());
        assertNotEquals(Checking, test6.getAccountType());
    }

    @Test
    void withdrawMoney() {
        test3.withdrawMoney(200);
        assertEquals(0, test3.getBalance());
        assertNotEquals(-200, test3.getBalance());

        test3.depositMoney(1000);
        test3.withdrawMoney(250);
        assertEquals(1000, test3.getBalance());
        assertNotEquals(750, test3.getBalance());
    }

    @Test
    void withdrawMoney2() {
        test6.withdrawMoney(50);
        assertEquals(0, test6.getBalance());
        assertNotEquals(-50, test6.getBalance());

        test6.depositMoney(500);
        test6.withdrawMoney(100);
        assertEquals(500, test6.getBalance());
        assertNotEquals(400, test6.getBalance());
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
        test5.depositMoney(300);
        assertEquals(300, test5.getBalance());

        test5.depositMoney(-100);
        assertEquals(300, test5.getBalance());
        assertNotEquals(200, test5.getBalance());
    }

    @Test
    void accessibleFromTerminal() {
        assertEquals(false, test3.accessibleFromTerminal());
        assertNotEquals(true, test3.accessibleFromTerminal());
    }

    @Test
    void accessibleFromTerminal2() {
        assertEquals(false, test6.accessibleFromTerminal());
        assertNotEquals(true, test6.accessibleFromTerminal());
    }

    @Test
    void getOwner() {
        assertEquals(test2, test3.getOwner());
        assertNotEquals(test1, test3.getOwner());
    }

    @Test
    void getOwner2() {
        assertEquals(test4, test6.getOwner());
        assertNotEquals(test5, test6.getOwner());
    }

    @Test
    void getAccountNumber() {
        assertEquals(54321, test3.getAccountNumber());
        assertNotEquals(12345, test3.getAccountNumber());
    }

    @Test
    void getAccountNumber2() {
        assertEquals(99999, test6.getAccountNumber());
        assertNotEquals(67890, test6.getAccountNumber());
    }

    @Test
    void getBalance() {
        assertEquals(0, test3.getBalance());
        assertNotEquals(500, test3.getBalance());
    }

    @Test
    void getBalance2() {
        assertEquals(0, test6.getBalance());
        test6.depositMoney(150);
        assertEquals(150, test6.getBalance());
    }

    @Test
    void closeAccount() {
        test3.depositMoney(250.5);
        assertEquals(250.5, test3.getBalance());
        assertEquals(0.0, test1.getBalance());

        test3.closeAccount();

        assertEquals(0.0, test3.getBalance());
        assertNotEquals(250.5, test3.getBalance());

        assertEquals(250.5, test1.getBalance());
        assertNotEquals(0.0, test1.getBalance());
    }

    @Test
    void closeAccount2() {
        test6.depositMoney(700.0);
        assertEquals(700.0, test6.getBalance());
        assertEquals(0.0, test5.getBalance());

        test6.closeAccount();

        assertEquals(0.0, test6.getBalance());
        assertEquals(700.0, test5.getBalance());
    }

    @Test
    void validatePin() {
        assertEquals(true, test3.validatePin(3567));
        assertNotEquals(true, test3.validatePin(1544));
    }

    @Test
    void validatePin2() {
        assertEquals(true, test6.validatePin(2222));
        assertNotEquals(true, test6.validatePin(1111));
    }

    @Test
    void getAccountInformation() {
        assertEquals(("Owner: " + test2 + ", AccountNumber: " + 54321 +  ", Balance: " + 0.0), test3.getAccountInformation());
        assertNotEquals("Owner: test2, AccountNumber: 54321, Balance: 0", test3.getAccountInformation());
    }

    @Test
    void getAccountInformation2() {
        assertEquals(("Owner: " + test4 + ", AccountNumber: " + 99999 +  ", Balance: " + 0.0), test6.getAccountInformation());
        assertNotEquals("Owner: Lisa Müller, AccountNumber: 99999, Balance: 0", test6.getAccountInformation());
    }
}