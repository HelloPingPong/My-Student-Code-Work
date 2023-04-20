package com.techelevator.farm;

public class Egg implements Sellable {

    public double getPrice() {
        return 1;
    }

    @Override
    public String getName() {
        return "Egg";
    }

    @Override
    public double getDiscountedPrice(double discountAmount) {
        return getPrice() - ( getPrice() * (discountAmount / 2));
    }
}
