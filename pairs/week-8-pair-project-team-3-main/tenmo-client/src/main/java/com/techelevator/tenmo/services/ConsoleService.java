package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: View your current balance");
        System.out.println("2: View your past transfers");
        System.out.println("3: View your pending requests");
        System.out.println("4: Send TE bucks");
        System.out.println("5: Request TE bucks");
        System.out.println("0: Exit");
        System.out.println();
    }


    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void displayTransfersArray(TransferService transferService){
        Transfer[] transfers = transferService.displayListOfTransfers();
        System.out.println("ID     FROM/TO                              AMOUNT");
        System.out.println("--------------------------------------------------");
        for (Transfer transfer : transfers) {
            int id = transfer.getTransfer_id();
            String toName = transferService.getUserName(transfer.getAccount_to());
            if(toName.length() > 27){
                toName = toName.substring(0,27)+"...";
            }
            String fromName = transferService.getUserName(transfer.getAccount_from());
            if(fromName.length() > 27){
                fromName = fromName.substring(0,27)+"...";
            }
            System.out.print(id + spacingGenerator(7,Integer.toString(id)));
            System.out.print(transferService.convertUserIdToAccountId(transferService.getCurrentUser().getUser().getId())==transfer.getAccount_from()?
                             "TO:   "+ toName + spacingGenerator(30, toName):
                             "FROM: "+ fromName + spacingGenerator(30,fromName));
            System.out.println("$"+ transfer.getAmount());
        }
    }

    public void displayTransferDetails(Transfer transfer, String fromName,String toName){
        System.out.println("------------------------------");
        System.out.println("       Transfer Details");
        System.out.println("------------------------------");
        System.out.println("ID:     " + transfer.getTransfer_id());
        System.out.println("FROM:   "+ fromName);
        System.out.println("TO:     "+ toName);
        int transferTypeId = transfer.getTransfer_type_id();
        System.out.println("TYPE:   " + (transferTypeId==1?"REQUEST":"SEND"));
        int transferStatusId = transfer.getTransfer_status_id();
        System.out.println("STATUS: " +(transferStatusId == 1?"PENDING":(transferStatusId == 2?"APPROVED":"REJECTED")));
        System.out.println("AMOUNT: $"+ transfer.getAmount());
    }

    public String spacingGenerator(int totalLength, String stringToCheck){
        return " ".repeat(totalLength - stringToCheck.length());
    }


    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

}
