package com.techelevator.exceptions.accounts;

import java.util.Scanner;

public class Menu {

    private final Scanner in = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Welcome to the Java Blue bank");
    }

    public int getAmountFromUser() {

        int amount = 0;
        while (amount == 0) {
            System.out.print("Amount to withdraw >>> ");
            String userInput = in.nextLine();
            try {
                amount = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("No bad! Try again");
            }
        }
        return amount;

    }

    public void showBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println();
    }

    public void showWithdrawSucceessMessage(int amount) {
        System.out.println(amount + " was withdrawn");
    }


    public void insufficientBalanceWarning(Account account, int fee) {
        System.out.printf("$%1.2f is below the minimum balance.  A $%1.2f fee has been charged %n",
                (double) account.getBalance(), (double) fee);
    }

}
