package com.techelevator.temart.inventory;

import java.util.Map;

public class Inventory {

    private InventoryBuilder inventoryBuilder;

    public Inventory() {
        inventoryBuilder = new InventoryBuilder();
    }

    public Map<String, Product> getProducts() {
        return inventoryBuilder.getInventory();
    }

    public Product getProductBySku(String sku) {
        return inventoryBuilder.getInventory().get(sku);
    }
}
