package com.techelevator.temart.inventory;

import java.util.HashMap;
import java.util.Map;

public class MemoryInventoryBuilder implements InventoryBuilder {


    public Map<String, Product> getInventory() {
        Map<String, Product> inventory = new HashMap<String, Product>();

        Product groceryProduct = new Grocery("G01");
        groceryProduct.setName("Chicken");
        groceryProduct.setDescription("A fluffy chicken");
        groceryProduct.setPrice(8.95);
        groceryProduct.setPerishable(true);
        groceryProduct.setWeightInLbs(7);
        groceryProduct.setTaxable(false);

        inventory.put("GO1", groceryProduct);

        inventory.put("C22", new Clothing("C22", "Shirt",25, 1,
                "A red glittery shirt", false, true));

        inventory.put("EA42", new Electronic("EA42", "Walkman", 12, 10,
                "A yellow box", false, true));

        inventory.put("B0005", new Book("B0005", "Head First Java", 22, 2,
                "John's favorite Java Book", false, true));

        inventory.put("B1234", new Book("B1234", "Tax Guide", 8, 5, "A tax guide",
                false, false));

        return inventory;
    }

}
