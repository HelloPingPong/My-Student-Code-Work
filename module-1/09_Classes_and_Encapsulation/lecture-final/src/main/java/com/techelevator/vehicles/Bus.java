package com.techelevator.vehicles;

public class Bus {

    private final static int NUMBER_OF_SEATS = 40;

    /*
        Member variables
        define the classes state
     */
    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50;
    private boolean isDoorOpen = false;

    /*
        This is the no-argument default constructor, if another
        constructor is not provided this is one is added automatically by Java (but you can't see it)
     */
    public Bus() {

    }

    /*
        Constructor overloads provide multiple ways to create the
        same object.  Once an Overload is added then the default constructor
        is no longer free and must be explicitly added to the code.
     */
    public Bus(String routeName) {
        this.routeName = formatRouteName(routeName);
    }



    /*
        A getter allows public access to see the current value
        assigned to a member variable
     */
    public String getRouteName() {
        return this.routeName;
    }

    /*
        A setter allows public access to assign a new value to
        a member variable
     */
    public void setRouteName(String routeName) {
        this.routeName = formatRouteName(routeName);
    }

    public int getGallonsOfGas() {
        return this.gallonsOfGas;
    }

    public boolean isDoorOpen() {
        return this.isDoorOpen;
    }

    public void openDoor() {
        this.isDoorOpen = true;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    public void addGas(int gallonsToAdd) {
        this.gallonsOfGas += gallonsToAdd;
    }

    /*
        A derived property looks like a getter, but it calculates the
        value and returns it and NEVER STORES IT.
     */
    public int getRemainingSeats() {
        return NUMBER_OF_SEATS - this.passengers;
    }

    /*
        A method gives functionality (behavior) to the object
     */
    public boolean board() {
        if (getRemainingSeats() >= 1 && this.isDoorOpen) {
            this.passengers++;
            return true;
        }
        return false;
    }

    /*
        Method Overloading allows us to create multiple methods
        with the same name and different parameters to do the same
        things in different ways.
     */
    public boolean board(int numberOfPassengers) {
        if (getRemainingSeats() >= numberOfPassengers && isDoorOpen) {
            passengers += numberOfPassengers;
            return true;
        }
        return false;
    }

    private String formatRouteName(String routeName) {
        String name = routeName.replaceAll(" ", "-");
        return name.toUpperCase();
    }
}
