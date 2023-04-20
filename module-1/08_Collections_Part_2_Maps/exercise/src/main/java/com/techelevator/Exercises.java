package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises{

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash"). - CHECKED AND GOOD
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd". - CHECKED AND GOOD
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown". - CHECKED AND GOOD
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		String unknown = "unknown";
		Map<String, String> herdNames = new HashMap<String, String>();
		herdNames.put("RHINO", "Crash");
		herdNames.put("GIRAFFE", "Tower");
		herdNames.put("ELEPHANT", "herd");
		herdNames.put("LION", "Pride");
		herdNames.put("CROW", "Murder");
		herdNames.put("PIGEON", "Kit");
		herdNames.put("FLAMINGO", "Pat");
		herdNames.put("DEER", "Herd");
		herdNames.put("DOG", "Pack");
		herdNames.put("CROCODILE", "Float");


		if (animalName == null)
		return unknown;
		String valueToReturn = herdNames.get(animalName.toUpperCase());
		if (animalName.isEmpty()) {
			return unknown;
		} if (valueToReturn == null) {
			return unknown;
		}
			return valueToReturn;

//			String returnKey = herdNames.get(animalName.toUpperCase()); {
//				if (animalName.toUpperCase() == null || animalName == "") {
//					String poop = "unknown";
//					return returnKey;
//				} else if (animalName.toUpperCase() != null && animalName.toUpperCase() != "") {
//					return returnKey;
//				} else
//					return returnKey;
//					//return herdNames.getOrDefault(animalName.toUpperCase(), "unknown");

			}

	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		double notOnSale = 0.00;
		Map<String, Double> itemSaleList = new HashMap<String, Double>();
		itemSaleList.put("KITCHEN4001", 0.20);
		itemSaleList.put("GARAGE1070", 0.15);
		itemSaleList.put("LIVINGROOM", 0.10);
		itemSaleList.put("KITCHEN6073", 0.40);
		itemSaleList.put("BEDROOM3434", 0.60);
		itemSaleList.put("BATH0073", 0.15);

		if (itemNumber == null) {
			return notOnSale;
		}
		if (itemSaleList.get(itemNumber.toUpperCase()) == null) {
			return notOnSale;
		}
		double valueToReturn = itemSaleList.get(itemNumber.toUpperCase());
			if (itemNumber.isEmpty()){
				return notOnSale;
		}
		if (valueToReturn == 0.00) {
			return notOnSale;
		}

		return valueToReturn;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
	 * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		if (peterPaul.get("Peter") > 0 && peterPaul.get("Paul") <1000){
			int halfOfPeter = peterPaul.get("Peter") /2;
			int originalFirstAccountBalance = peterPaul.get("Peter");
			int newFirstAccountBalance = originalFirstAccountBalance - halfOfPeter;
			int newPaulBalance = peterPaul.get("Paul") + halfOfPeter;
		    peterPaul.put("Peter", newFirstAccountBalance);
			peterPaul.put("Paul", newPaulBalance);
		}
		return peterPaul;
	}
		/*
		STEPS:
		if get( Peter) > 0 && if get ( Paul) < 1000
			get half of Peter's Money
			set Peter's new balance to original balance - half of Peter's money
			Set Paul's new balance to original balance + half of Peter's money


			NOT - original balance or original / 2. THAT WILL NOT WORK WITH INTEGER DIVISION

		 */


	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 * NTS - LOOK AT PERSONAL SCRATCH PAD FROM THIS LESSON
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		if (peterPaul.get("Peter") >= 5000 && peterPaul.get("Paul") >= 10000){
			int petersShare = peterPaul.get("Peter") / 4;
			int originalPeterBalance = peterPaul.get("Peter");
			int peterPostSharingBalance = originalPeterBalance - petersShare;
			int paulsShare = peterPaul.get("Paul") / 4;
			int originalPaulBalance = peterPaul.get("Paul");
			int paulPostSharingBalance = originalPaulBalance - paulsShare;
			int petePaulPartnership = petersShare + paulsShare;
			peterPaul.put("PeterPaulPartnership", petePaulPartnership);
			peterPaul.put("Peter", peterPostSharingBalance);
			peterPaul.put("Paul", paulPostSharingBalance);
		}
		return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> answerMap = new HashMap<String, String>();
			for (String word : words) { // looping through each entry in the array "words"
				answerMap.put(word.valueOf(word.length()+1 - word.length()) ,word.valueOf(word.length())+1 );
			}

		return answerMap;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> answerMap = new HashMap<String, Integer>();
		if (words != null) { // making sure the array entry isnt null and passed on
		 for (String entry : words) { // for each looping entry in array of words
			if (!answerMap.containsKey(entry)) { // if the map doesn't contain a key name being the entry
				answerMap.put(entry, 1); // assign it as a key in the map with the value of 1
				} else { // otherwise
				answerMap.put(entry, answerMap.get(entry) + 1); // put that key as ts the entry and get the last entry as the value with an addition of one.
				}
			}
		} return answerMap;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
//		for (int intCounts : ints) {
//			if (counts.containsKey(intCounts)) {
//				counts.put(intCounts, counts.get(ints) + 1);
//			}// update map entry where key is index # and value gets an additional 1
//			else {
//				counts.put(intCounts, 1);
//			}
//			}
		return counts; // return the map
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> answerMap = new HashMap<String, Boolean>();
		return answerMap;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {

		Map<String, Integer> consolidatedWarehouse = new HashMap<String, Integer>();

		/*
		1. pick one warehouse for example main
		2. loop through the other (remote)
		for each key in remote
			if exists in main then update that key in main to be sum of that key's value in both
			if it does not exist in main then add it with the value from remote.
		 */



		return consolidatedWarehouse;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		Map<String, Integer> answerMap = new HashMap<String, Integer>();
		return answerMap;
	}

}
