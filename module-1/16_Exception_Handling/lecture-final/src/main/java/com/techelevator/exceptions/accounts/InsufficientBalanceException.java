package com.techelevator.exceptions.accounts;

public class InsufficientBalanceException extends Exception {

    private int fee;

    public InsufficientBalanceException(int fee) {
        super("Balance below minimum");
        this.fee = fee;
    }

    public int getFee() {
        return fee;
    }
}
