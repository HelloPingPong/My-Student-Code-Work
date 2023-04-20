package com.techelevator;

public class ArraysAndLoops {
<<<<<<< HEAD
}
    String[] instructors = new String [7];
    instructors [3] = "Steve";
    instructors [2] = "Matt";
    instructors [0] = "John";
    instructors [1] = "Rachelle";
    instructors [6] = "Scott";
    instructors [5] = "Dylan";
    instructors [4] = "Laura";

    int lengthOfArray = instructors.length;
    system.out.println(lengthOfArray);

    int[] numbers
=======

    public static void main(String[] args) {

        int[] numbers = new int[5];

        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        numbers[3] = numbers[3] + 50;

        String[] instructors = new String[7];
        instructors[3] = "Steve";
        instructors[2] = "Matt";
        instructors[0] = "John";
        instructors[1] = "Rachelle";
        instructors[6] = "Scott";
        instructors[5] = "Dylan";
        instructors[4] = "Laura";

        int lengthOfArray = instructors.length;
        System.out.println(lengthOfArray);

        int[] numbers2 = new int[] { 100, 200, 300, 400, 500};

        /*
            This line will cause an ArrayIndexOutOfBoundsException because
            the last index in the array is 6.   This exception is caused ONLY by
            trying to access an index that does not exist in the array.
         */
        //instructors[7] = "Kevin";


        for (int i = 0; i < 10; i++) {
            System.out.println( "Line " + (i + 1));
        }

        int sumOfEvenNumbersInRange = 0;
        for (int i = 200; i <= 357; i++) {
            if (i % 2 == 0) {
                sumOfEvenNumbersInRange += i;
            }
        }
        System.out.println(sumOfEvenNumbersInRange);

        for (int i = 200; i <= 357; i += 2) {
            sumOfEvenNumbersInRange += i;
        }



        for (int i = 200; i <= 357; i++) {
            /*
                Since sumOfRange is in the for block, it will be reset to 0 each
                time the loop runs
             */
            int sumOfRange = 0;
            if (i % 2 == 0) {
                sumOfRange += i;
            }
        }

        // Loop backwards 500 to 100 and skip any number divisible by 10 and the number after it
        for (int i = 500; i >= 100; i--) {
            if (i % 10 == 0) {
                i--;
                // Continue skips the rest of the code in the block for this iteration and starts
                // the next iteration
                continue;
            }
            System.out.print(i + " ");
        }

        for (int j = 0; j < 10; j++) {
            if (j == 5) {
                // break immediately ends the loop
                break;
            }
        }

        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            System.out.println( numbers[i] );
        }

        for (int i = instructors.length - 1; i >= 0; i--) {
            System.out.println( instructors[i] );
        }

        for (int i = 0; i < instructors.length; i++) {
            if (i % 2 == 1) {
                instructors[i] = instructors[i] + " is ODD";
            }
        }


    }

}
>>>>>>> 5d906bd1acba17ddbe932fca89fdccebd77e78b5
