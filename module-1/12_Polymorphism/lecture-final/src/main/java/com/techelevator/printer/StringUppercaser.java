package com.techelevator.printer;

public class StringUppercaser implements Displayable {

    private String str;

    public StringUppercaser(String str) {
        this.str = str;
    }

    public void display() {
        System.out.println(str.toUpperCase());
    }
}
