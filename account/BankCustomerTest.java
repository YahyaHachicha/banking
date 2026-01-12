package banking.account;

import banking.bank.Bank;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BankCustomerTest {


    @org.junit.jupiter.api.Test
    void getLastname() {
        BankCustomer test1 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        assertEquals("Zimmermann", test1.getLastname());
        assertNotEquals("Mustermann", test1.getLastname());
    }

    @org.junit.jupiter.api.Test
    void getLastname2() {
        BankCustomer test1 = new BankCustomer("Sarah", "Schmidt", "1997.5.3", "Hauptstraße 10");
        assertEquals("Schmidt", test1.getLastname());
        assertNotEquals("Zimmermann", test1.getLastname());
    }


    @org.junit.jupiter.api.Test
    void getCustomerNumber() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        test2.setCustomerNumber(1619);
        assertEquals(1619, test2.getCustomerNumber());
        assertNotEquals(1230, test2.getCustomerNumber());
    }

    @org.junit.jupiter.api.Test
    void getCustomerNumber2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1997.5.3", "Hauptstraße 10");
        test2.setCustomerNumber(9876);
        assertEquals(9876, test2.getCustomerNumber());
        assertNotEquals(1619, test2.getCustomerNumber());
    }


    @org.junit.jupiter.api.Test
    void getName() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        assertEquals("Tom", test2.getName());
        assertNotEquals("Thomas", test2.getName());
    }

    @org.junit.jupiter.api.Test
    void getName2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1992.1.5", "Hauptstraße 10");
        assertEquals("Sarah", test2.getName());
        assertNotEquals("Tom", test2.getName());
    }


    @org.junit.jupiter.api.Test
    void getBirthday() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        assertEquals("1997.5.3", test2.getBirthday());
        assertNotEquals("03.05.1997", test2.getBirthday());
    }

    @org.junit.jupiter.api.Test
    void getBirthday2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1992.1.5", "Hauptstraße 10");
        assertEquals("1992.1.5", test2.getBirthday());
        assertNotEquals("1997.3.5", test2.getBirthday());
    }


    @org.junit.jupiter.api.Test
    void getAddress() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        assertEquals("Ligusterweg 4", test2.getAddress());
        assertNotEquals("Ligusterweg 5", test2.getAddress());
    }

    @org.junit.jupiter.api.Test
    void getAddress2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1992.1.5", "Hauptstraße 10");
        assertEquals("Hauptstraße 10", test2.getAddress());
        assertNotEquals("Ligusterweg 4", test2.getAddress());
    }


    @org.junit.jupiter.api.Test
    void setCustomerNumber() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        test2.setCustomerNumber(5555);
        assertEquals(5555, test2.getCustomerNumber());
        assertNotEquals(5556, test2.getCustomerNumber());
    }

    @org.junit.jupiter.api.Test
    void setCustomerNumber2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1992.1.5", "Hauptstraße 10");
        test2.setCustomerNumber(4444);
        assertEquals(4444, test2.getCustomerNumber());
        assertNotEquals(5555, test2.getCustomerNumber());
    }


    @org.junit.jupiter.api.Test
    void setLastname() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        test2.setLastname("Müller");
        assertEquals("Müller", test2.getLastname());
        assertNotEquals("Zimmermann", test2.getLastname());
    }

    @org.junit.jupiter.api.Test
    void setLastname2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1992.1.5", "Hauptstraße 10");
        test2.setLastname("Bauer");
        assertEquals("Bauer", test2.getLastname());
        assertNotEquals("Schmidt", test2.getLastname());
    }


    @org.junit.jupiter.api.Test
    void setName() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        test2.setName("Thomas");
        assertEquals("Thomas", test2.getName());
        assertNotEquals("Tom", test2.getName());
    }

    @org.junit.jupiter.api.Test
    void setName2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1992.1.5", "Hauptstraße 10");
        test2.setName("Sabine");
        assertEquals("Sabine", test2.getName());
        assertNotEquals("Sarah", test2.getName());
    }


    @org.junit.jupiter.api.Test
    void setBirthday() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        test2.setBirthday("2006.5.21");
        assertEquals("2006.5.21", test2.getBirthday());
        assertNotEquals("21.05.2006", test2.getBirthday());
    }

    @org.junit.jupiter.api.Test
    void setBirthday2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1992.1.5", "Hauptstraße 10");
        test2.setBirthday("1985.11.30");
        assertEquals("1985.11.30", test2.getBirthday());
        assertNotEquals("1992.1.5", test2.getBirthday());
    }


    @org.junit.jupiter.api.Test
    void setAddress() {
        BankCustomer test2 = new BankCustomer("Tom", "Zimmermann", "1997.5.3", "Ligusterweg 4");
        test2.setAddress("Ligusterweg 10");
        assertEquals("Ligusterweg 10", test2.getAddress());
        assertNotEquals("Ligusterweg 4", test2.getAddress());
    }

    @org.junit.jupiter.api.Test
    void setAddress2() {
        BankCustomer test2 = new BankCustomer("Sarah", "Schmidt", "1992.1.5", "Hauptstraße 10");
        test2.setAddress("Schlossplatz 1");
        assertEquals("Schlossplatz 1", test2.getAddress());
        assertNotEquals("Hauptstraße 10", test2.getAddress());
    }
}