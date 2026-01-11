package banking.account;

import banking.bank.Bank;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class BankCustomerTest {

    @org.junit.jupiter.api.Test
    void getLastname() {
        BankCustomer test1 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");
        assertEquals("Zimmermann", test1.getLastname());

        assertNotEquals("Mustermann", test1.getLastname());
    }

    @org.junit.jupiter.api.Test
    void getCustomerNumber() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        test2.setCustomerNumber(1619);

        assertEquals(1619, test2.getCustomerNumber());

        assertNotEquals(1230, test2.getCustomerNumber());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        assertEquals("Tom", test2.getName());

        assertNotEquals("Thomas", test2.getName());
    }

    @org.junit.jupiter.api.Test
    void getBirthday() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        assertEquals("05.03.1997", test2.getBirthday());

        assertNotEquals("05.03.1996", test2.getBirthday());
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        assertEquals("Ligusterweg 4", test2.getAddress());

        assertNotEquals("Ligusterweg 5", test2.getAddress());

    }

    @org.junit.jupiter.api.Test
    void setCustomerNumber() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        test2.setCustomerNumber(5555);

        assertEquals(5555, test2.getCustomerNumber());

        assertNotEquals(5556, test2.getCustomerNumber());
    }

    @org.junit.jupiter.api.Test
    void setLastname() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        test2.setLastname("Müller");

        assertEquals("Müller", test2.getLastname());

        assertNotEquals("Zimmermann", test2.getLastname());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        test2.setName("Thomas");

        assertEquals("Thomas", test2.getName());

        assertNotEquals("Tom", test2.getName());
    }

    @org.junit.jupiter.api.Test
    void setBirthday() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        test2.setBirthday("21.05.2006");

        assertEquals("21.05.2006", test2.getBirthday());

        assertNotEquals("05.03.1997", test2.getBirthday());
    }

    @org.junit.jupiter.api.Test
    void setAddress() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "05.03.1997", "Ligusterweg 4");

        test2.setAddress("Ligusterweg 10");

        assertEquals("Ligusterweg 10", test2.getAddress());

        assertNotEquals("Ligusterweg 4", test2.getAddress());
    }
}