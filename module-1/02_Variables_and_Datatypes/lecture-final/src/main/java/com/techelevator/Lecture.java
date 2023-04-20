package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;

		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half;
		half = 0.5;
		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";
		System.out.println(name);

		char firstLetter = 'T';


		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
			In a String escape characters allow us to represent special
			characters like Tab ( \t ) and newline ( \n ) in our String.
		 */
		String nameWithEscapeCharacters = "\tTech\nElevator";
		System.out.println(nameWithEscapeCharacters);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		float pi = 3.1416f;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String yourName = "your name";
		System.out.println(yourName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfButtonsOnYourMouse = 3;

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int percentageOfBatteryLeftOnPhone = 100;

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double sum = 12.3 + 32.1;
		System.out.println(sum);

		double halfOfFive = 5.0 / 2;
		double modulesHalfOfFive = 5 % 2;

		System.out.println(halfOfFive);
		System.out.println(modulesHalfOfFive);


		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Laura Martinez";

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String hello = "Hello, ";
		String helloLaura = hello + fullName;
		System.out.println(helloLaura);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		System.out.println(fullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Esquire";
		System.out.println(fullName);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw";
		saw += 2;
		System.out.println(saw);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		saw += 0;
		System.out.println(saw);

		/*
			Widening (converting/casting from a smaller data type to a larger one) is implicit, meaning
			Java just does it for us.
		 */
		int x = 10;
		long y = x;
		System.out.println(y);

		/*
			Narrowing (casting from a larger data type to a smaller one) must be done explicit, meaning we need
			to indicate the casting in the code
		 */
		long a = 10;
		int b = (int) a;
		System.out.println(b);


		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println( 4.4 / 2.2 );

		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println( 5.4 / 2 );

		/*
		20. What is 5 divided by 2?
		*/
		System.out.println( 5 / 2 );

		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println( 5.0 / 2 );

		int one = 5;
		int two = 2;
		double accurateResult = (double) one / two;


		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println(66.6 / 100);

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println( 5 % 2);

		System.out.println(20 % 17);

		/*
		24. What is 1,000,000,000 * 3?
		*/
		int resultOf24 = 1000000000 * 3;
		System.out.println(resultOf24);

		/*
		25. Create a variable that holds a boolean called isDoneWithExercises and
		set it to false.
		*/
		boolean isDoneWithExercises = true;
		/*
		26. Now set isDoneWithExercise to true.
		*/
		isDoneWithExercises = false;

		System.out.println(isDoneWithExercises);
		
	}

}
