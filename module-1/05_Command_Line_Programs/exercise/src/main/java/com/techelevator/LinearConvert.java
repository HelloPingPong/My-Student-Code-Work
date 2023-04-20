package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // to store user input
		System.out.println("Please Enter The Measurement"); // to capture user input of measurement on next frame
		int inputMeasurement = Integer.parseInt(userInput.nextLine()); // assigns input to the int variable "inputTemperature"
		//NTS - may need to convert this string to int or double later. - UNNEEDED. parse was solution. RESOLVED.
		//NTS - parse int like the temp converter assignment. don't make same mistake like 1st time.

		System.out.println(inputMeasurement + " isn't specific enough. Might as well be in nanometers or light years"); // to display user input.
		System.out.println("Is that in Feet or Meters? SELECT: (F/M)");
		String userChoice = userInput.nextLine();//Allows user to input F or M for following calculations. DONE
		//NTS - may need to disallow selections besides F/M. Confirm and revise if needed.

		if (userChoice.equalsIgnoreCase("F")) { //function for feet selection
			//Action to take - take input measure and assign formula for conversion and display old + new. DONE
			//Action to take - use "else" option and assign for the reverse selection. display old + new.
			//Action to take - be sure to label respective measurements in final display. DONE
			System.out.printf("That's " + inputMeasurement + " feet and %5.2f meters.", (inputMeasurement * 0.3048));
		}// NTS TESTED TO THIS POINT AND FUNCTIONS AS INTENDED..
		else if (userChoice.equalsIgnoreCase("M")) { //function for meter selection.
			//Action to take - same as above. DONE
			System.out.printf("That's " + inputMeasurement + " meters and %5.2f feet.", (inputMeasurement * 3.2808399));
		}
	}

} // TESTED AND FUNCTIONS AS INTENDED. GOOD TO SUBMIT.
