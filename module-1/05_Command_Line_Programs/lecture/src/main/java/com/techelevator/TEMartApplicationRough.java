package com.techelevator;

import java.util.Scanner;

public class TEMartApplicationRough {

    public static void main(String[] args) {
        double shippingCost = 5.00;
        Scanner userInput = new Scanner(System.in);

        String[] products = new String[4];
        products[0] = "Water Bottle,20.99";
        products[1] = "Cups,4.98";
        products[2] = "Straws,0.99";
        products[3] = "Cat,100.00";

        System.out.println("************************");
        System.out.println("   Welcome to TE Mart   ");
        System.out.println("************************");

        System.out.println("Please Enter Your Username");
        String Username = userInput.nextLine();

        System.out.printf("Hello %s, here is our available inventory:%n%n", Username);

        /*
            1. ask the user their name
            2. store the user's name in a variable
            3. print out: "Hello <User's name>, here is what is available"
         */
// when we know we want to do something with everything in an array, we will need a loop
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ")" + products[i]);
        }

        System.out.print("Select Your Product My Dude >>> ");
        String id = userInput.nextLine();

        int productID = Integer.parseInt(id);
        int productIndex = productID - 1;

        if (productIndex <0 || productIndex >= products.length) {
            System.out.println("That Product Ain't Here My Guy");
        } else {
            String selectedProduct = products[productIndex];

            System.out.println(selectedProduct);
            System.out.print("Is that correct? (Y/N) >>> ");
            String userChoice = userInput.nextLine();

            if (userChoice.equalsIgnoreCase("Y")) {

                String[] parts = selectedProduct.split(",");
                String productName = parts[0];
                double productPrice = Double.parseDouble(parts[1]);
                double priceWithShipping = productPrice + shippingCost;

                System.out.println("Your Order");
                System.out.printf("%1s Price: $%3.2f ", productName, productPrice);
                System.out.printf("Shipping: $%3.2f Total: $%3.2f %n", shippingCost, priceWithShipping);

            } else {
                System.out.println("Please try again");
            }
        }

        System.out.println();
        System.out.println("Thanks for buying our shit! Have yourself a heckin great day!");
    }
}
