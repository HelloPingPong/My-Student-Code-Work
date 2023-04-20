package com.techelevator.temart;

import java.util.Map;
import com.techelevator.temart.inventory.Product;
import com.techelevator.temart.inventory.Inventory;
import com.techelevator.temart.view.Menu;

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
        inventory = new Inventory();
        menu.showWelcomeScreen();

        Map<String, Product> products = inventory.getProducts();

        menu.showProducts( products );

        String sku = menu.askUserForSku();
        Product product = inventory.getProductBySku(sku);
        menu.showProductToUser(product);
    }

}
