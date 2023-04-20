package com.techelevator.tenmo;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.tenmo.services.AccountService;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;
import com.techelevator.tenmo.services.TransferService;

import java.math.BigDecimal;
import java.util.List;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private AuthenticatedUser currentUser;
    private final AccountService accountService = new AccountService(API_BASE_URL, currentUser);
    private final TransferService transferService = new TransferService(API_BASE_URL, currentUser);

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            transferService.setCurrentUser(currentUser);
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        } else {
            accountService.setAuthToken(currentUser.getToken());
            transferService.setAuthToken(currentUser.getToken());
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void viewCurrentBalance() {
        BigDecimal balance = accountService.getCurrentBalance();
        System.out.println("Your current account balance is: $" + balance + ".");
        //Removed Main Menu call here
	}


	private void viewTransferHistory() {
        consoleService.displayTransfersArray(transferService);
        int transferId = consoleService.promptForInt("Please enter transfer ID to view details (0 to cancel): ");
        if(transferId == 0){
            return;
        }
        Transfer transfer = transferService.getTransferById(transferId);
        consoleService.displayTransferDetails(transfer,transferService.getUserName(transfer.getAccount_from()),transferService.getUserName(transfer.getAccount_to()));
	}

	private void viewPendingRequests() {
		// TODO Auto-generated method stub
		
	}

	private void sendBucks() {
		// TODO Auto-generated method stub
        User[] users = transferService.listUsers();
        System.out.println("ID             NAME");
        for (User user : users) {
            System.out.println(user.getId() + "          " + user.getUsername());
        }
        int toId = consoleService.promptForInt("Please enter user ID of user you would like to send funds to (0 to cancel): ");
        if (toId == 0){
            return;
        }
        if (currentUser.getUser().getId() == toId){
            System.out.println("You cannot transfer to yourself. Please try again.");
            return;
        }
        BigDecimal amountToTransfer = consoleService.promptForBigDecimal("Please enter amount to transfer: ");
        boolean success = transferService.postNewTransfer(toId, amountToTransfer);
        if (success){
            System.out.println("Transfer completed successfully.");
        } else {
            System.out.println("Transfer unsuccessful. Please try again.");
        }
	}

	private void requestBucks() {
		// TODO Auto-generated method stub
		
	}

}
