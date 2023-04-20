package com.techelevator.temart.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileInventoryBuilder implements InventoryBuilder {

    private String filename;

    public FileInventoryBuilder(String filename) {
        this.filename = filename;
    }

    @Override
    public Map<String, Product> getInventory() throws FileNotFoundException {

        Map<String, Product> inventory = new LinkedHashMap<String, Product>();

        File inventoryFile = new File(filename);

        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while(fileScanner.hasNextLine()) {
                String lineFromFile = fileScanner.nextLine();
                String[] lineParts = lineFromFile.split("\\|");
                String sku = lineParts[1];
                Product product = buildProductFromParts( lineParts );
                inventory.put(sku, product);
            }
        }

        return inventory;
    }

    private Product buildProductFromParts(String[] parts) {
        Product product = null;

        String type = parts[0];
        String sku = parts[1];
        String name = parts[2];
        String description = parts[3];
        String price = parts[4];
        String weight = parts[5];
        String taxable = parts[6];

        if (type.equalsIgnoreCase("C")) {
            product = new Clothing(sku);
        } else if (type.equalsIgnoreCase("G")) {
            product = new Grocery(sku);
            product.setPerishable(true);
        } else if (type.equalsIgnoreCase("B")) {
            product = new Book(sku);
        } else if (type.equalsIgnoreCase("E")) {
            product = new Electronic(sku);
        }

        product.setName( name );
        product.setDescription( description );
        product.setPrice( Double.parseDouble(price) );
        product.setWeightInLbs( Integer.parseInt(weight) );
        product.setTaxable( taxable.equalsIgnoreCase("Y") );

        return product;
    }
}
