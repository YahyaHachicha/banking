package banking.service;

import banking.account.*;
import banking.bank.Bank;
import banking.bank.BaseBank;

import java.util.Date;

import static banking.service.BankStatementPrinter.printStatement;

public class Main {
    public static void main() {
        Bank test1 = new BaseBank("Volksbank", 10, 10);
        Customer test3 = new BankCustomer("Tom", "Zimmermann", "2000.5.3", "Ligusterweg 4");
        test1.registerCustomer(test3);
        test1.createCheckingBankAccount(0, 1111);
        test1.createSavingsBankAccount((CheckingAccount)test1.getBankAccount(0),2222);
        test1.getBankAccount(0).depositMoney(1000);

        printStatement(test1);
        //Test per Main methode, da ich nicht richtig Konsoleninput in JUnit Tests simulieren kann.
        //printStatement gibt immer das Ergebnis von printStatementOf wieder. Damit werden beide Methoden getestet.

        //testPrintStatementSuccess
        //  0
        //  1111
        //result true

        //testPrintStatementWrongPinThenRight
        //  0
        //  1234
        //  1111
        //result true

        //testPrintStatementWrongPin
        //  0
        //  1234
        //  4321
        //  0000
        //  5667
        //result false

        //testPrintStatementAccountNotFound
        //  50
        //result false;

        //testPrintStatementNoTerminalAccess
        //  1
        //  2222
        //result false;
    }
}
