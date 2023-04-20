package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Chicken chicken = new Chicken();
		chicken.layEgg();

		FarmAnimal chickenAsFarmAnimal = chicken;


		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Sheep() };
		Singable[] singers = new Singable[] { new Cow(), new Chicken(), new Sheep(), new Tractor(), new MusicBox(15) };
		Sellable[] sellables = new Sellable[] { new Cow(), new Chicken(), new Sheep(), new Egg(), new MusicBox(27) };

		for (Singable singer : singers) {
			String name = singer.getName();
			String sound = singer.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		System.out.println("\n\nAnimals for Sale");
		for (Sellable itemForSale : sellables) {
			String name = itemForSale.getName();
			double price = itemForSale.getPrice();
			System.out.println(name + "  $" + price + " sale price: " + itemForSale.getDiscountedPrice(.10));
		}


	}
}