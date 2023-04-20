package com.techelevator;

import java.io.*;
import java.util.Scanner;


/*
    1. Get the User input and output filenames
    2. Read the input file
    3. For each word in the input file lines
        - If the word length is 3 change it to FIZZ
        - If the word length is 5 change it to BUZZ
        - If the word length is 7 change it to RAZZ
        - otherwise don't change the word
    4. Write the new lines to the output file
    5. Tell the User the Process is finished
 */
public class FizzBuzzRazz {

    private final static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.print("Input file: ");
        String inputFileName = userInput.nextLine();

        System.out.print("Output file: ");
        String outputFileName = userInput.nextLine();


        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        try (Scanner fileScanner = new Scanner(inputFile);
             PrintWriter printerWriter = new PrintWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(printerWriter)) {

            while(fileScanner.hasNextLine()) {
                String nextLine = fileScanner.nextLine();
                String[] words = nextLine.split(" ");
                String newLine = "";

                for (String word : words) {
                    if (word.length() == 3) {
                        newLine += "FIZZ";
                    } else if (word.length() == 5) {
                        newLine += "BUZZ";
                    } else if (word.length() == 7) {
                        newLine += "RAZZ";
                    } else {
                        newLine += word;
                    }
                    newLine += " ";
                }

                bufferedWriter.write(newLine.trim());
                bufferedWriter.newLine();
            }

            System.out.println("New File written");

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }


    }



}
