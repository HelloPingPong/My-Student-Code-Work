package com.techelevator.printer;

import java.util.ArrayList;
import java.util.List;

public class PrinterApp {

    public static void main(String[] args) {

        Product product = new Product("A01", "Surviving TE Book", 12.99, "", 2);
        Animal cat = new Animal("Cat", "Meow");
        StringReverse stringReverse = new StringReverse("Reverse This String");
        Fibonnaci fibonnaci = new Fibonnaci(100);
        StringUppercaser uppercaser = new StringUppercaser("this will be uppercase");

        List<Displayable> displayables = new ArrayList<Displayable>();
        displayables.add(product);
        displayables.add(cat);
        displayables.add(stringReverse);
        displayables.add(fibonnaci);
        displayables.add(uppercaser);

        displayDisplayables( displayables );
    }


    private static void displayDisplayables(List<Displayable> displayables) {

        for (Displayable thingToDisplay : displayables) {
            thingToDisplay.display();
            System.out.println();
        }
    }

}
