package com.techelevator.farm;

/*
    The final keyword when used on a class makes it so that class
    cannot be used as a superclass, so no classes may extend it.
 */
public final class Cat extends FarmAnimal {
    public Cat() {
        super("Cat", "Meow", 1000);
    }

    /*
    getSound() cannot be Overridden because the method in the superclass is marked final
     */
//    @Override
//    public String getSound() {
//        return "MEOOOOOW!!!";
//    }

    @Override
    public void eat() {
        System.out.println("The Cat eats!");
    }

}
