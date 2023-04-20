package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       BigDecimal");
		System.out.println("####################");
		BigDecimal firstNumber = new BigDecimal(10);
		BigDecimal secondNumber = BigDecimal.ZERO;

		firstNumber = firstNumber.add(new BigDecimal(10));
		secondNumber = secondNumber.subtract(new BigDecimal(5));
		BigDecimal result = firstNumber.multiply(secondNumber);

		System.out.println("####################");
		System.out.println("       LocalDate");
		System.out.println("####################");

		// Today's Date
		LocalDate today = LocalDate.now();

		// Tomorrow's date
		LocalDate tomorrow = today.plusDays(1);

		// Specific Date
		LocalDate april132010 = LocalDate.of(2010, 4, 13);

		// Specific Date from a String
		LocalDate nov171980 = LocalDate.parse("1980-11-17");

		// DateTimeFormatter can be used to format the date for printing
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println( dateFormatter.format(nov171980) );

		LocalDate halloween = LocalDate.parse("10/31/2023", dateFormatter);

		System.out.println("####################");
		System.out.println("       LISTS");


		List<String> instructors = new ArrayList<String>();

		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Laura");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println( instructors.get(i) );
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		instructors.add("John");

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		instructors.add(3, "Rachelle");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		instructors.remove(2);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean isJohnInTheList = instructors.contains("John");

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		String nameToSearchFor = "Rachelle";
		int indexOfRachelle = instructors.indexOf( nameToSearchFor );

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorsAsArray = instructors.toArray( new String[ instructors.size() ] );


		System.out.println("####################");
		System.out.println("Array can be turned into a List");
		System.out.println("####################");

		String[] letters = {"A", "B", "C", "D", "E"};
		List<String> lettersList = Arrays.asList(letters);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(instructors);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(instructors);

		System.out.println("####################");
		System.out.println("Lists can be shuffled");
		System.out.println("####################");

		Collections.shuffle(instructors);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String name : instructors) {
			System.out.println( name );
		}

		int[] nums = new int[] {10,20,30,40};

		for (int nextValue : nums) {
			int valueAddedTo22 = nextValue + 22;
			System.out.println(valueAddedTo22);
		}

		String ourString = "hello";
		for (char nextLetter : ourString.toCharArray()) {
			System.out.println(nextLetter);
		}

		System.out.println("####################");
		System.out.println("       AUTOBOXING");
		System.out.println("####################");

		List<Integer> numbersList = new ArrayList<Integer>();
		numbersList.add( 10 );
		numbersList.add( 20 );
		numbersList.add( 30 );

		Integer numberOfEmployees = new Integer( 25 );
		Integer piecesOfCake = new Integer("24");

		if (numberOfEmployees > piecesOfCake) {
			System.out.println("Not enough cake");
		}

		numberOfEmployees += 2;
		int x = numberOfEmployees;
	}
}
