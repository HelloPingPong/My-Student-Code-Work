package com.techelevator.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Demonstrates the difference between runtime and checked exceptions
 */
public class TypesOfExceptions {

    private String str;

    public static void main(String[] args) {
        new TypesOfExceptions().run();
    }

    public void run() {
       try {
            throwsARuntimeException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        }

        try {
            throwsACheckedException();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught");
        }
    }

    /*
        This method throws a runtime exception
        It is up to the programmer whether to handle a runtime exception
        If unhandled a runtime exception will automatically propagate up the call stack
     */
    private void throwsARuntimeException() {
        str.toUpperCase();
    }


    /*
        This method throws a checked exception
        Checked Exceptions must be handled by either catching them or using throws to propagate them
     */
    private void throwsACheckedException() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("test"));
    }





}
