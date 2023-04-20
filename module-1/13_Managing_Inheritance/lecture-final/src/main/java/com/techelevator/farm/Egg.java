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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Egg) {
            Egg otherEgg = (Egg) obj;
            if (this.getPrice() == otherEgg.getPrice() && this.getName().equals(otherEgg.getName())) {
                return true;
            }
        } else {
            return false;
        }
        return true;
    }
}
