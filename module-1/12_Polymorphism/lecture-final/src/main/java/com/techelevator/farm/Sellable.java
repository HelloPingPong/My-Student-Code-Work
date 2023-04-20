package com.techelevator.farm;

public interface Sellable {

    double getPrice();
    String getName();
    double getDiscountedPrice(double discountAmount);
}
