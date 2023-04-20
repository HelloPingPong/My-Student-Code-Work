package com.techelevator;

import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts;


    public BankCustomer() {
    }

//    public void addAccount(Accountable newAccount){
//        accounts.add(0, newAccount);
//    }

    public Accountable[] getAccounts(){

        return new Accountable[0];
    }

//    public boolean isVIP(){ // COME BACK TO THIS ONE
//        return false;
//    }

    //getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }




    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
