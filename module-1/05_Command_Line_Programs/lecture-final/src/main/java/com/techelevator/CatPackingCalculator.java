package com.techelevator;


import java.util.Scanner;

public class CatPackingCalculator {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("What the length of the container?");
        String lengthFromUser = userInput.nextLine();

        System.out.println("What is the height of the container?");
        String heightFromUser = userInput.nextLine();

        System.out.println("What is the width of the container?");
        String widthFromUser = userInput.nextLine();

        double length = Double.parseDouble(lengthFromUser);
        double width = Double.parseDouble(widthFromUser);
        double height = Double.parseDouble(heightFromUser);

        double containerVolume = length * width * height;

        double avgVolumeOfHouseCat = 0.083;
        double catsByVolume = containerVolume / avgVolumeOfHouseCat;
        double packingDensityOfHouseCat = 0.5;
        double packedCats = catsByVolume * packingDensityOfHouseCat;

        System.out.printf("You can fit %1.0f cats in the box %n", packedCats);


    }
}
