package com.techelevator.temart.inventory;

public class Clothing extends Product implements Taxable {

    public Clothing(String sku) {
        super(sku);
    }

    public Clothing(String sku, String name, double price, int weightInLbs,
                    String description, boolean isPerishable, boolean isTaxable) {
        super(sku, name,price,weightInLbs,description,isPerishable,isTaxable);
    }


    @Override
    public double getTaxRate() {
        return 0.075;
    }

    @Override
    public double getTaxAmount() {
        return getPrice() * getTaxRate();
    }
}
