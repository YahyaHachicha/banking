package banking.account;

import org.junit.jupiter.api.Test;

import static banking.account.BankAccount.AccountType.Checking;
import static banking.account.BankAccount.AccountType.Savings;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    Customer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");
    CheckingAccount test1 = new CheckingAccount(12345, test2, 1544);
    SavingsAccount test3 = new SavingsAccount(54321, test1, 3567);

    @Test
    void getAccountType() {
        assertEquals(Savings, test3.getAccountType());
        assertNotEquals(Checking, test3.getAccountType());
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
    void depositMoney() {
        test1.depositMoney(5000);
        assertEquals(5000, test1.getBalance());

        test1.depositMoney(-5000);
        assertEquals(5000, test1.getBalance());
        assertNotEquals(0, test1.getBalance());
    }

    @Test
    void accessibleFromTerminal() {
        assertEquals(false, test3.accessibleFromTerminal());
        assertNotEquals(true, test3.accessibleFromTerminal());
    }

    @Test
    void getOwner() {
        assertEquals(test2, test3.getOwner());
        assertNotEquals(test1, test3.getOwner());
    }

    @Test
    void getAccountNumber() {
        assertEquals(54321, test3.getAccountNumber());
        assertNotEquals(12345, test3.getAccountNumber());
    }

    @Test
    void getBalance() {
        assertEquals(0, test3.getBalance());
        assertNotEquals(500, test3.getBalance());
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
    void validatePin() {
        assertEquals(true, test3.validatePin(3567));

        assertNotEquals(true, test3.validatePin(1544));
    }

    @Test
    void getAccountInformation() {
        assertEquals(("Owner: " + test2 + ", AccountNumber: " + 54321 +  ", Balance: " + 0.0), test3.getAccountInformation());
        assertNotEquals("Owner: test2, AccountNumber: 54321, Balance: 0", test3.getAccountInformation());
    }
}