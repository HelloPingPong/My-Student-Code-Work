package com.techelevator;

public class Elevator {
    //METHOD VARIABLES
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    //CONSTRUCTORS
    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
        this.currentFloor=1;
        this.doorOpen=false;
    }
    //METHODS
    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen && desiredFloor <= numberOfFloors && desiredFloor > currentFloor);
            currentFloor = desiredFloor;
    }

    public void goDown(int desiredFloor) {
        if (!doorOpen && desiredFloor >= 1 && currentFloor > desiredFloor);
            currentFloor = desiredFloor;
    }

    // getters
    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }
}
