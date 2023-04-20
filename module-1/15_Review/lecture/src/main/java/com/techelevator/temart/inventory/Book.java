package com.techelevator.temart.inventory;

public class Book extends Product implements Taxable {
    public Book(String Sku) {
        super(Sku);
    }

    public Book (String sku, String name, double price, int weightInLbs, String description, boolean isPerishable, boolean isTaxable) {
        super(sku, name, price, weightInLbs, description, isPerishable, isTaxable);
    }


    @Override
    public double getShippingCost() {
        double originalShippingCost = super.getShippingCost();
        return originalShippingCost - (originalShippingCost * .25);
    }

    @Override
    public double getTaxRate() {
       if (isTaxable()){
           return 0.075;
       }
        return 0;
    }

    @Override
    public double getTaxAmount() {
        return getPrice() * getTaxRate();
    }
}
