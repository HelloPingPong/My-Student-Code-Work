package com.techelevator.temart.inventory;

import java.io.FileNotFoundException;
import java.util.Map;

public class Inventory {

    private Map<String, Product> inventory;
    private InventoryBuilder inventoryBuilder;

    public Inventory(String filename) throws FileNotFoundException {
        this.inventoryBuilder = new FileInventoryBuilder(filename);
        this.inventory = inventoryBuilder.getInventory();
    }

    public Map<String, Product> getProducts() {
        return inventory;
    }

    public Product getProductBySku(String sku) {
        return inventory.get(sku);
    }
}
