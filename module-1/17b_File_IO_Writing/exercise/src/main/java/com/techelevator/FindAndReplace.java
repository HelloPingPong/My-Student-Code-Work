package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */

        //user input prompts go here. enter prompts on sout then assign input to a related string variable.
        System.out.print("Enter word to find: ");
        String wordToFind = userInput.nextLine();

        System.out.print("Enter replacement word: ");
        String replacementWord = userInput.nextLine();

        System.out.print("Enter source file: ");
        String sourceFileName = userInput.nextLine();

        System.out.print("Enter destination file: ");
        String destinationFileName = userInput.nextLine();

       //file assignments from user string inputs to actual new files go hereVVV
        File inputFile = new File(sourceFileName);

        File outputFile = new File(destinationFileName);

        //scanning through input file and orienting appropriate output file here
        try (Scanner inputScanner = new Scanner(inputFile);
        PrintWriter printWriter = new PrintWriter(outputFile)){

            while(inputScanner.hasNextLine()) {
                String nextLine = inputScanner.nextLine();
                nextLine = nextLine.replaceAll(wordToFind, replacementWord);


                    printWriter.println(nextLine);

//                    if (word == wordToFind) {
//                        newLine += wordToFind;
//                    } else if (word == replacementWord) {
//                        newLine += replacementWord;
//                    } else {
//                        newLine += word;
//                    }
//                    newLine += " ";
                }



        } // handle exception below!
        catch (FileNotFoundException e) {
            System.out.printf("Unable to locate file");
        }

        }

    }
