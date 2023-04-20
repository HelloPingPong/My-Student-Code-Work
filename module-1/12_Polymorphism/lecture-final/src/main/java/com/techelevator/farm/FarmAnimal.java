package com.techelevator.farm;

public class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private int price;

	public FarmAnimal(String name, String sound, int price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSound() {
		return sound;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public double getDiscountedPrice(double discountAmount) {
		return price - ( price * discountAmount);
	}

}