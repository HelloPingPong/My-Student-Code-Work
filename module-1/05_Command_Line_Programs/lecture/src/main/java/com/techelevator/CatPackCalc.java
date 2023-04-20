package com.techelevator;

import java.util.Scanner;

public class CatPackCalc {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the length of the container?");
        String lengthFromUser = userInput.nextLine();

        System.out.println("What is the height of the container?");
        String heightFromUser = userInput.nextLine();

        System.out.println("What is the width of the container?");
        String widthFromUser = userInput.nextLine();

        double length = Double.parseDouble(lengthFromUser);
        double width = Double.parseDouble(widthFromUser);
        double height = Double.parseDouble(heightFromUser);

        double containerVolume = length * width * height;

        double avgVolumeOfHouseCat = 0.83;
        double catsByVolume = containerVolume / avgVolumeOfHouseCat;
        double packingDensityOfHouseCat = 0.5;
        double packedCats = catsByVolume * packingDensityOfHouseCat;

        System.out.printf("You can fit %1.0f cats in the box %n", packedCats);
        // the percentage sign tells me how many spaces I want. the 0 tells me how many decimals I want.
        // needs a datatype at the end. usually s = string, f = floating point
        // dont forget to put the data for each formatter (in our case - 1st one is 1.0) - the data is "packedCats"
        // percent sign = formatter. if you put %n it puts it on a new line.

    }

}
