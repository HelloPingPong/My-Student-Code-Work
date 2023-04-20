package com.techelevator.farm;

/*
	Marking a class abstract means it can only be used as a superclass and
	it itself can never be instantiated into an object
 */
public abstract class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private int price;
	private boolean isSleeping;

	public FarmAnimal(String name, String sound, int price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	/*
		An abstract method works like an interface.  It provides a method signature
		and requires any subclass to implement an Override for that method to
		give functionality.

		abstract methods can only exist in an abstract class.
	 */
	public abstract void eat();


	@Override
	public String getName() {
		return name;
	}

	/*
	The final keyword keeps a subclass from
	Overriding the method with its own version.
	 */
	@Override
	public final String getSound() {
		if (isSleeping) {
			return "Zzzzzzzzzz....";
		}
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

	public boolean isSleeping() {
		return isSleeping;
	}

	public void wakeup() {
		isSleeping = false;
	}

	public void sleep() {
		isSleeping = true;
	}


}