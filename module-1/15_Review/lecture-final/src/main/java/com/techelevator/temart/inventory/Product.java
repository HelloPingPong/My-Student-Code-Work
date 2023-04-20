package com.techelevator.temart.inventory;

import java.util.Objects;

public abstract class Product {

    private final static double BASE_SHIPPING_COST = 5.00;

    private String sku;
    private String name;
    private double price;
    private int weightInLbs;
    private String description;
    private boolean isPerishable;
    private boolean isTaxable;

    public Product(String sku) {
        this.sku = sku;
    }

    public Product(String sku, String name, double price, int weightInLbs,
                   String description, boolean isPerishable, boolean isTaxable) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.weightInLbs = weightInLbs;
        this.description = description;
        this.isPerishable = isPerishable;
        this.isTaxable = isTaxable;
    }

    /*
        if weight <= 5 then base shipping cost
        if weight 5 - 10 then double base cost
        if weight > 10 then 4xs base cost

        if the item is perishable add $2 fee.
     */
    public double getShippingCost() {
        double shippingCost = BASE_SHIPPING_COST;
        if (weightInLbs > 5 && weightInLbs <= 10) {
            shippingCost *=2;
        } else if (weightInLbs > 10) {
            shippingCost *= 4;
        }

        if (isPerishable) {
            shippingCost += 2;
        }

        return shippingCost;
    }

    public double getTotalCostWithShipping() {
        return price + getShippingCost();
    }


    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weightInLbs=" + weightInLbs +
                ", description='" + description + '\'' +
                ", isPerishable=" + isPerishable +
                ", isTaxable=" + isTaxable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && weightInLbs == product.weightInLbs && isPerishable == product.isPerishable && isTaxable == product.isTaxable && Objects.equals(sku, product.sku) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, price, weightInLbs, description, isPerishable, isTaxable);
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeightInLbs() {
        return weightInLbs;
    }

    public void setWeightInLbs(int weightInLbs) {
        this.weightInLbs = weightInLbs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }

    public boolean isTaxable() {
        return isTaxable;
    }

    public void setTaxable(boolean taxable) {
        isTaxable = taxable;
    }
}
