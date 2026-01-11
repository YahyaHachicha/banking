package banking.service;

import banking.bank.Bank;
import banking.bank.Transaction;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Bank statement printer.
 *
 */
public class BankStatementPrinter {
    public static boolean printStatement(Bank bank) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("**********************************************************");
        System.out.println("Welcome to " + bank.getInstitutionName());
        System.out.println("**********************************************************");
        System.out.println("Please enter your account number:");

        return printStatementOf(bank, scanner1.nextInt());
    }

    public static boolean printStatementOf(Bank bank, int accountNumber) {
        if (bank.getBankAccount(accountNumber) != null) { //getbankaccount muss durch alle bankaccounts der institution laufen
            int triesLeft = 4;
            Scanner scanner2 = new Scanner(System.in);

            System.out.println("**********************************************************");
            System.out.print("Account found. \n Please enter your pin: ");
            for (int tries = 4; tries > 1; tries--) {
                if (bank.getBankAccount(accountNumber).validatePin(scanner2.nextInt())) {
                    System.out.println();
                    if (bank.getBankAccount(accountNumber).accessibleFromTerminal()) {
                        System.out.println("Your balance for this account is: " + bank.getBankAccount(accountNumber).getBalance());
                        return true;
                    } else {
                        System.out.println("Insufficient access to terminal. Process aborted");
                        return false;
                    }
                } else {
                    triesLeft -= 1;
                    System.out.println();
                    System.out.println("Wrong pin. Try again.");
                    System.out.println("Tries left: " + triesLeft);
                    System.out.print("Please enter your pin: ");
                }
            }
            System.out.println();
            System.out.println("No tries left. Process aborted.");
            return false;
        }
        return false;
    }
}


