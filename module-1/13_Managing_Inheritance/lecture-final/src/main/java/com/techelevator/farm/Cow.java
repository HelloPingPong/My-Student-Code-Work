package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!", 2500);
	}

	@Override
	public void eat() {
		System.out.println("The Cow chews!");
	}



}