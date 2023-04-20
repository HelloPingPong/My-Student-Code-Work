package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!", 12);
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public void eat() {
		System.out.println("The Chicken pecks!");
	}
}