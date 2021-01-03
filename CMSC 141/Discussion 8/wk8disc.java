/*
CMIS 141 Intro to Programming
Disc 8
A program that reads lyrics in from a file and displays them on the screen, along with the number of
lines which get imported.
*/
import java.io.*;
import java.util.*;

public class wk8disc {

    public static void main(String[] args) throws IOException {

        //instantiate objects and and declare required variables
        File inputFile = new File("input.txt");
        Scanner fileIn = new Scanner(inputFile);
        String lyrics = "";
        int numberInputs = 0;

        //read the contents of the file, concantenate with lyrics string, and add 1 to number of inputs
        while (fileIn.hasNext()) {
            lyrics += fileIn.nextLine() + "\n";
            numberInputs += 1;
            }

        //output
        System.out.println("System has read " + numberInputs + " lines from input file!");
        System.out.println(lyrics);
        System.out.println("Sounds like Rush '2112' to me!");

        //close the scanner
        fileIn.close();

    }//end main
}//end class
