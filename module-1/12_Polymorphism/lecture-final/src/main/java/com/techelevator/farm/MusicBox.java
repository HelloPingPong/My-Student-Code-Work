package com.techelevator.farm;

public class MusicBox implements Sellable, Singable {

    private double price;

    public MusicBox(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return "Music Box";
    }

    @Override
    public String getSound() {
        return "Lalalalala";
    }

    @Override
    public double getDiscountedPrice(double discountAmount) {
        return getPrice();
    }

}
