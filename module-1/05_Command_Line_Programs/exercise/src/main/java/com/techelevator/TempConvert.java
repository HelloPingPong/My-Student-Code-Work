package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // to store user input

		System.out.println("*****Travis' Celsius/Fahrenheit Converter*****");
		System.out.println("Please Enter The Temperature"); // to capture user input of temp on next frame
		int inputTemperature = Integer.parseInt(userInput.nextLine()); // assigns input to the int variable "inputTemperature"
		//NTS - may need to convert this string to int or double later. Not sure if conversion formula works on string.
		//NTS - did do this. parsed it to int. If I need to reverse, change int to string & remove .parse. UNNEEDED.
		//NTS - may need to disallow other entries besides numbers here. Double check and confirm.

		System.out.println(inputTemperature + " degrees you say? "); // to display user input once received
		System.out.println("Is that in Celsius or Fahrenheit? SELECT: (C/F)");
		String userChoice = userInput.nextLine();//Allows user to input C or F for following calculations. DONE
		//NTS - may need to disallow selections besides C/F. Confirm and revise.

		if (userChoice.equalsIgnoreCase("C")) { //function for the Celsius selection
			//Action to take - take input temperature and assign formula for conversion and display old + new. DONE
			//Action to take - use "else" option and assign for the reverse selection. display old + new.
			//Action to take - be sure to label which temp as which in final display. DONE
			System.out.printf("That's " + inputTemperature + " degrees Celsius and %6.2f degrees Fahrenheit.", (inputTemperature * 1.8 + 32));
		}// NTS TESTED TO THIS POINT AND FUNCTIONS AS INTENDED. - encountered decimal problem. resolve. DONE.
		else if (userChoice.equalsIgnoreCase("F")) { //function for Fahrenheit selection.
			//Action to take - same as above. DONE
			System.out.printf("That's " + inputTemperature + " degrees Fahrenheit and %6.2f degrees Celsius.", ((inputTemperature - 32) / 1.8));
		}
	}

} // TESTED AND FUNCTIONS AS INTENDED. GOOD TO SUBMIT.
/*
ORIGINAL FAHRENHEIT OUT:
System.out.println("That's " + inputTemperature + " degrees Celsius and " + (inputTemperature * 1.8 + 32) +
" degrees Fahrenheit.");
	NTS - See explanation for save on ORIGINAL CELSIUS OUT line below.

FAHRENHEIT OUT DECIMAL FIX:
	System.out.printf("That's " + inputTemperature + " degrees Celsius and %6.2f degrees Fahrenheit.", (inputTemperature * 1.8 + 32));


ORIGINAL CELSIUS OUT: System.out.println("That's " + inputTemperature + " degrees Fahrenheit and " +
 ((inputTemperature - 32) / 1.8) +	" degrees Celsius.");
	NTS - Saved so I can change last line. Issue with a million decimal points. Attempt to reduce. Try format.

CELSIUS OUT DECIMAL FIX:
   System.out.printf("That's " + inputTemperature + " degrees Fahrenheit and %6.2f degrees Celsius.", ((inputTemperature - 32) / 1.8));
   NTS - first attempt at decimal fix. if no work try different format option. d?
   WORKED. SAVE AND REPLACE FAHRENHEIT VERSION TO FIX SAME ISSUE ON THAT SIDE JUST TO BE SURE.
 */