package com.techelevator.writing;

import java.io.*;

public class BufferedWriterExample {

    public static void main(String[] args) throws IOException {

        /*
         * Create a file and PrintWriter
         */
        String bufferedFilePath = "bufferedFile.txt";
        File fileObj = new File(bufferedFilePath);
        /*
         * To add buffering a Print Writer is still needed and will still do the writing.
         * A BufferedWriter is added and passed the Print Writer.  The Print Writer will still
         * write to the file and the buffered writer will provide buffering.
         */

        try ( PrintWriter printerWriter = new PrintWriter( fileObj );
              BufferedWriter bufferedWriter = new BufferedWriter( printerWriter) ) {
            bufferedWriter.write("Line one");
            bufferedWriter.newLine();
            bufferedWriter.write("Line Two");
        }
    }
}
