package com.techelevator.temart.inventory;

public class Electronic extends Product implements Taxable {

    public Electronic(String sku) {
        super(sku);
    }

    public Electronic(String sku, String name, double price, int weightInLbs,
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
