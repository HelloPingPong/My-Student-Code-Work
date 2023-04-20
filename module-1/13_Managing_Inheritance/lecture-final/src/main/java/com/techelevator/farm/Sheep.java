package com.techelevator.farm;

public class Sheep extends FarmAnimal {

    public Sheep() {
        super("Sheep", "Baa", 430);
    }

    @Override
    public void eat() {
        System.out.println("The Sheep consumes!");
    }
}
