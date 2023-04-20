package com.techelevator;

public class BankAccount implements Accountable {


    //member variables (instance variables) - what qualities a class must have to be considered a bank account

    private String accountHolderName;
    private String accountNumber;
    private int balance;


    // constructors - different methods to create a SPECIFIC INSTANCE of a bank account with values for that instance

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    //getters (universal get methods to return a value from another source)

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }



    //METHODS - BEHAVIORS AN ACCOUNT CAN DO

    public int transferTo(BankAccount destinationAccount, int transferAmount) { // 1/2 done. withdraw good. figure how to direct deposit to different account.
        this.balance = withdraw(transferAmount);
        destinationAccount.balance = destinationAccount.balance + transferAmount;
        return getBalance();
    }


    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }

}
