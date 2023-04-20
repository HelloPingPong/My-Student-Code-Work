package com.techelevator;

import java.util.Scanner;

public class TEMartApplication {

    public static void main(String[] args) {

        double shippingCost = 5;

        Scanner userInput = new Scanner(System.in);

        String[] products = new String[4];
        products[0] = "Water bottle,20.99";
        products[1] = "Cups,4.98";
        products[2] = "Straws,0.99";
        products[3] = "Cat,100.00";

        System.out.println("************************");
        System.out.println("   Welcome to TE Mart   ");
        System.out.println("************************");
        System.out.println();

        /*
            1) Ask the user their name
            2) Store the user's name in a variable
            3) Print out: "Hello <user's name>, here is what is available"
         */
        System.out.print("What is your name >>> ");
        String username = userInput.nextLine();
        System.out.printf("Hello %1s, here is what is available %n%n", username);

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ") " + products[i]);
        }

        System.out.print("Select product >>> ");
        String id = userInput.nextLine();

        int productId = Integer.parseInt(id);
        int productIndex = productId - 1;

        if (productIndex < 0 || productIndex >= products.length) {
            System.out.println("That product doesn't exist");
        } else {
            String selectedProduct = products[productIndex];

            System.out.println(selectedProduct);
            System.out.print("Is that correct? (Y/N) >>> ");
            String userChoice = userInput.nextLine();

            if (userChoice.equalsIgnoreCase("Y") ) {

                String[] parts = selectedProduct.split(",");
                String productName = parts[0];
                double productPrice = Double.parseDouble(parts[1]);
                double priceWithShipping = productPrice + shippingCost;

                System.out.println("Your order");
                System.out.printf("%1s Price: $%3.2f ", productName, productPrice);
                System.out.printf("Shipping: $%3.2f Total: $%3.2f %n", shippingCost, priceWithShipping);

            } else {
                System.out.println("Please try again");
            }
        }

        System.out.println();
        System.out.println("Thank you for shopping with us!");



    }
}
