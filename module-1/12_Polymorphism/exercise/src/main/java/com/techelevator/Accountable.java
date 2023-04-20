package com.techelevator;



public interface Accountable {

    public int getBalance();


    //add transfer method to bank account - to be inherited by checking and saving so remember---
    // only withdraw should subtract from the balance
    // only deposit should add


    //transfer is 2 steps
    // 1. removal of x dollars from account A
    // 2. addition of x dollars to account b
    //then think about which gets changed

    //balance of accountable should just be that account
    // remember balance != debt. credit cards dont use balance. they account for debt. debt is a negative number


    // bank customer class IS NOT accountable. YOU don't have a balance, your ACCOUNT does


    // you're gonna have to convert the array in the getAccounts() method into a list.
}
