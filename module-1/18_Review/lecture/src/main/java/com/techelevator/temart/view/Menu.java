package com.techelevator.temart.view;

import com.techelevator.temart.inventory.Product;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Scanner in = new Scanner(System.in);

    public void showWelcomeScreen() {
        System.out.println("**************************");
        System.out.println(" Welcome to TE Mart ");
        System.out.println("**************************");
        System.out.println();
    }

    public void showProducts(Map<String, Product> products) {

        for (Map.Entry<String, Product> entry : products.entrySet()) {
            String sku = entry.getKey();
            Product product = entry.getValue();

            // Sku : Product Name - $price
            System.out.printf("%-5s : %-20s $%1.2f %n",
                    sku, product.getName(), product.getPrice());
        }

    }

    public String askUserForSku() {
        System.out.print("Select a Sku >>>");
        String selectedSku = in.nextLine();
        return selectedSku;
    }

    public void showProductToUser(Product product) {
        System.out.println(product);
    }
}
