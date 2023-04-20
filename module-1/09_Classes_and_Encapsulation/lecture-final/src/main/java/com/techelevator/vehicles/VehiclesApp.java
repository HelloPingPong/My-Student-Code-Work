package com.techelevator.vehicles;

import java.util.Scanner;

public class VehiclesApp {
    public static void main(String[] args) {

        Bus busOne = new Bus();
        Bus busTwo = new Bus();

        busOne.setRouteName("High Street");
        busTwo.setRouteName("Front Street");

        busOne.openDoor();
        boolean ableToBoard = busOne.board();

        busOne.board(10);

        Bus busThree = new Bus("Third Street Express");

    }
}
