package com.techelevator.temart;


import com.techelevator.temart.inventory.Inventory;
import com.techelevator.temart.inventory.Product;
import com.techelevator.temart.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;

public class TEMartApplication {

    private Menu menu;
    private Inventory inventory;

    public static void main(String[] args) {
        Menu menu = new Menu();
        TEMartApplication app = new TEMartApplication(menu);
        app.run();
    }

    public TEMartApplication(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        String filename = menu.askUserForFilename();
        try {
            inventory = new Inventory(filename);
        } catch (FileNotFoundException e) {
            menu.showFileNotFound();
            return;
        }
        menu.showWelcomeScreen();

        Map<String, Product> products = inventory.getProducts();

        menu.showProducts( products );

        String sku = menu.askUserForSku();
        Product product = inventory.getProductBySku(sku);
        menu.showProductToUser(product);
    }



}
