package com.techelevator;

public class CreditCardAccount implements Accountable{
    //member variables
    private String accountHolder;
    private String accountNumber;
    private int debt;


    public CreditCardAccount(String accountHolder, String accountNumber){
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.debt = 0;
    }

    public int pay(int amountToPay){
        this.debt = debt - amountToPay;
        return this.debt;
    }

    public int charge(int amountToCharge){
        this.debt = debt + amountToCharge;
        return this.debt;

    }

    @Override
    public int getBalance() {
        return this.debt;
    }

    //getters
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }
}
