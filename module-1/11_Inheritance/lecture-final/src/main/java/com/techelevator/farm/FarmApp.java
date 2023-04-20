package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class FarmApp {

    public static void main(String[] args) {

        Cow cow = new Cow();

        System.out.println(cow.getName() + " says " + cow.getSound());

        Chicken chicken = new Chicken();

        System.out.println(chicken.getName() + " says " + chicken.getSound());

        chicken.layEgg();


        List<FarmAnimal> farmAnimals = new ArrayList<FarmAnimal>();
        farmAnimals.add(cow);
        farmAnimals.add(chicken);

        for (FarmAnimal animal: farmAnimals) {
            System.out.println("The " + animal.getName() + " says " + animal.getSound());
        }
    }
}
