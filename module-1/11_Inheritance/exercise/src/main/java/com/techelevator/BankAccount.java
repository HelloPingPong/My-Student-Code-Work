package com.techelevator;

public class BankAccount {
// member variables ( instance variables ) - keep private

    private String accountHolderName;
    private String accountNumber;
    private int balance;

// constructors (special methods that create an "Instance" of a variable based on the "blueprint" above)
    // Specify "this." input variable = the one above - remember you can assign other variables manually so long -
    // - as they are included as an option in the class.
    // this is the assigned to zero one. the second one gets the default balance from the instance variable above.
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.balance=0;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

// methods
    public int deposit(int amountToDeposit){
        balance = balance+amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw){
        balance = balance-amountToWithdraw;
        return balance;
    }

// getters

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }


// setters

}
