package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		int x = 10;
		int y = x;
		y = 30;

		int[] nums = {10,20,30,40};
		int[] nums2 = nums;
		nums[2] = 444;
		nums2[1] = 555;
		nums2 = new int[] {50,60,70,80};
		nums2[2] = 222;

		String[] strArray = new String[4];

		System.out.println("************************************");
		System.out.println("******    CREATING OBJECTS    ******");
		System.out.println("************************************");

		Cake chocolateCake = new Cake("Chocolate", true);
		Cake strawberryCake = new Cake("Strawberry", false);
		Cake yellowCake = new Cake("Buttercream", true);

		yellowCake.setHasSprinkles(false);
		strawberryCake.setIcingType("Whipped");

		Cake anotherCake;
		anotherCake = new Cake("icing", true);


		// This will cause a NullPointerException
//		String name = null;
//		name.length();


		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create a new instance of String using a literal */
		String name = "John Fulton";
		String name2 = new String("John Fulton");

		String hello = "Hello, " + name;

		String fromNumber = String.valueOf(10);
		String fromBoolean = String.valueOf(true);

		char[] word = new char[]{ 'J', 'a', 'v', 'a'};
		String stringFromCharArr = new String(word);


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}


		System.out.println();
		System.out.println("******************************");
		System.out.println("**** STRING MEMBER METHODS ***");
		System.out.println("******************************");
		System.out.println();

		String person = "Laura";
		String personUpperCased = person.toUpperCase();
		System.out.println( person );
		System.out.println( personUpperCased );

		person = person.toLowerCase();
		System.out.println(person);

		String bootcamp = "Tech Elevator";

		for (int i = 0; i < bootcamp.length(); i++) {
			System.out.println( bootcamp.charAt( i ) );
		}

		// .substring( inclusive-starting-index, exclusive-ending-index)
		String subStr = bootcamp.substring(3, 6);

		// .substring ( starting-index ) - will continue until the end of the string
		String wordWithoutFirstLetter = bootcamp.substring(1);

		// Get the first letter of a String
		String firstLetter = bootcamp.substring(0, 1);

		// Get the last letter
		String lastLetter = bootcamp.substring( bootcamp.length() - 1 );

		// Get the middle of the string without the first or last letter
		String middleLetters = bootcamp.substring(1, bootcamp.length() - 1);

		// Get the last 2 letters
		String lastTwoLetters = bootcamp.substring( bootcamp.length() - 2 );

		int indexOfE = bootcamp.indexOf("E");  // index of first occurrence
		int indexOfVator = bootcamp.indexOf("vator");
		boolean startsWith = bootcamp.startsWith("Tech");
		String trimmedString = " no_extra  ".trim();
		String replaced = bootcamp.replaceAll("e", "3");
		String noEs = bootcamp.replaceAll("e", "");
		String noVator = bootcamp.replaceAll("vator", "_____");

		String[] splitOnE = bootcamp.split("e");

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */


		int negativeNumber = -500;
		int absoluteValue = Math.abs(negativeNumber);

		String countDown = String.join("-->", "Five", "Four", "Three", "Two", "One");
		System.out.println(countDown);
	}
}
