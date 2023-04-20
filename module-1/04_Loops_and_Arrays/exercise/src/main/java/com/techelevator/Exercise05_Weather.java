package com.techelevator;

public class Exercise05_Weather {

    private final static int FREEZING_TEMPERATURE = 32;

    /*
    GaleForce Meteorologists recently developed a new weather station and need it to perform
    some common measurements for reporting.

    Note: Assume all temperatures are in Fahrenheit (°F) unless otherwise
    noted.
     */

    /*
    GaleForce needs to know the number of days in the upcoming forecast
    where the temperature is at or below freezing.

    Given an array of high temperatures, count the number of days when
    the high temperature is freezing (32° F) or below.

    Examples:
	belowFreezing([33, 30, 32, 37, 44, 31, 41]) → 3            The brackets tell you this is an array
	belowFreezing([-7, -3, 19, 35, 30])  → 4
	belowFreezing([]) → 0
    */
    //Where is the array of days? What is the int going to represent?-the number of days its freezing
	public int belowFreezing(int[] dailyHighs) {
        int numberOfFreezingDays = 0; //this is 0 because it is the starting point

        for (int i = 0; i < dailyHighs.length; i++) { //we search for daily highs bc it confirms freezing or not
            if (dailyHighs[i] <= 32) { //Now we are asking the question - is the daily high freezing or below
                numberOfFreezingDays++; // If it is, we have it add one to the count
            }
        }
        return numberOfFreezingDays; // solved part of the problem by discovering what we need to search for.
	}

    /*
    GaleForce also needs to determine the hottest day when given an upcoming forecast.

    Given an array of high temperatures, determine the hottest temperature. - the true question is find the biggest int
    - !!!!!!! Figure out - WHAT IS THE CORE QUESTION
    Note: The array of high temperatures is guaranteed to have at least one
    element.

    Examples:
	hottestDay([81, 93, 94, 105, 99, 95, 101, 90, 89, 92]) → 105
	hottestDay([23, 24] → 24
	hottestDay([34, 33] → 34
	hottestDay([55]) → 55
    */
    public int hottestDay(int[] dailyHighs) {
        int highestTemperature = dailyHighs[0]; //doesn't matter where you start so long as it's a comparison point

        for (int i = 0; i < dailyHighs.length; i++) {
            if (dailyHighs[i] > highestTemperature) {
                highestTemperature = dailyHighs [i];
            }
        }

        return highestTemperature; // really all this constitutes is: "what's the highest number lol"
    }

    /*
    GaleForce discovered an equipment malfunction. Every other reading, starting with the first,
    was off by 2 degrees Fahrenheit (°F).

    Given an array of Fahrenheit temperatures, fix each of the incorrect readings by adding
    2 degrees to its current value.

    Examples:
	fixTemperatures([33, 30, 32, 37, 44, 31, 41]) → [35, 30, 34, 37, 46, 31, 43]
	fixTemperatures([-7, -33, 19, 35]) → [-5, -33, 21, 35]
	fixTemperatures([-1, 0, 1] → [1, 0, 3]
    fixTemperatures([-1] → [1]
	fixTemperatures([]) → []
     */

    //really all we are doing is adding 2 to every integer
    public int[] fixTemperatures(int[] temperatures) {

        for (int i = 0; i < temperatures.length; i += 2) {
            temperatures[i] = temperatures[i] + 2;
        }

        return temperatures;
    }
}
