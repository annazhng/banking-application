package bank;

import java.util.Scanner;

class BankAccount {
    /** A simple banking application. Functions include withdrawing money, depositing money,
     * checking account balance, and viewing previous transactions. */

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    /** Constructor: A bank account with customer name and customer ID. */
    BankAccount(String customername, String customerid) {
        customerName= customername;
        customerId= customerid;
    }

    /** Deposits amount into bank account. Throws IllegalArgumentException if amount is less than
     * zero. */
    void deposit(int amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException();
        if (amount > 0) {
            balance= balance + amount;
            previousTransaction= amount;
        }

    }

    /** Withdraws amount from bank account. Throws IllegalArgumentException if amount is greater
     * than the current balance, or if the amount is less than zero. */
    void withdraw(int amount) {
        if (amount > balance || amount < 0) throw new IllegalArgumentException();
        if (amount > 0) {
            balance= balance - amount;
            previousTransaction= -amount;
        }
    }

    /** Displays the previous transaction. */
    void getPreviousTransaction() {

        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured.");
        }

    }

    /** The menu for the banking application. Takes user input and executed the task according to
     * the selected option. */
    void showMenu() {
        char option= '\0';
        Scanner scanner= new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A: Check account balance");
        System.out.println("B: Deposit money");
        System.out.println("C: Withdraw money");
        System.out.println("D: See previous transaction");
        System.out.println("E: Exit");

        do {
            System.out.println("Please enter an option");
            option= scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {

            case 'A':
                System.out.println("Balance = " + balance);
                System.out.println("\n");
                break;

            case 'B':
                System.out.println("Enter an amount to deposit");
                int amount= scanner.nextInt();
                deposit(amount);
                System.out.println("\n");
                break;

            case 'C':
                System.out.println("Enter an amount to withdraw");
                int amount2= scanner.nextInt();
                withdraw(amount2);
                System.out.println("\n");
                break;

            case 'D':
                getPreviousTransaction();
                System.out.println("\n");
                break;

            case 'E':
                break;

            default:
                System.out.println("Invalid option selected");
                break;
            }

        } while (option != 'E');

        System.out.println("Thank you!");

    }

}
