/*
Homework 4
CMIS 141 Intro to Programming
Steve Thaw
A program which allows the user to enter in state names and print out the state, state bird, and state song
*/
import java.io.*;
import java.util.*;
import java.lang.*;

public class TestHM4 {
    public static void main(String[] args) throws IOException {

        //initialize arrays, buffered reader, and string buffer
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner (System.in);

        //initialize variables used by program
        String userInput = "";
        String convert = "";
        String firstChar = "";
        int index = 0;
        int menuInit = 0;
        String state1 = "";
        String song1 = "";
        String bird1 = "";
        String totalInfo = "";

        //create string arrays for state, song, and bird
        String[] statesArray = new String[50];
        String[] songArray = new String[50];
        String[] birdArray = new String[50];
        //initialize array to handle finding two word states without an error by removing spaces between words
        String[] twoWordState = new String[50];

        //fill arrays from files containing states, birds, and songs retrieved from wikipedia
        try {

            Scanner s1 = new Scanner(new File("states.txt"));
            Scanner s2 = new Scanner(new File("bird.txt"));
            Scanner s3 = new Scanner(new File("song.txt"));
            Scanner s4 = new Scanner(new File("twoWordState.txt"));

            for (int i = 0; i < 50; i++) {
                statesArray[i] = s1.nextLine();
            }
            for (int j = 0; j < 50; j++) {
                birdArray[j] = s2.nextLine();
            }
            for (int l = 0; l < 50; l++) {
                songArray[l] = s3.nextLine();
            }
            for (int k = 0; k < 50; k++){
                twoWordState[k] = s4.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No Such File");
        }
        //begin user interaction
        System.out.println("Welcome to the States Program, where you can easily find" +
                "your favorite State's bird and song!");

        //while loop to continue the program until the user types none
        while (menuInit == 0) {
            System.out.print("Please enter a State to research (enter none to complete): ");
            //read user input
            convert = in.nextLine();
            //convert user input to all lower case
            convert = convert.toLowerCase();
            //create a substring consisting of the first character and convert it to upper case
            firstChar = convert.substring(0, 1).toUpperCase();
            //concantonate the two substrings back into one string, replacing the first letter with uppercase
            userInput = firstChar + convert.substring(1);
            try {
                //test for exit criteria, perform binary search of array to find the index of the state requested and append it to string buffer
                index = Arrays.binarySearch(twoWordState, userInput);
                state1 = statesArray[index];
                totalInfo = totalInfo + state1 + ", ";
                //retrieve and store state bird in required variables
                bird1 = birdArray[index];
                totalInfo = totalInfo + bird1 + ", ";
                //retrieve and store state song in required variables
                song1 = songArray[index];
                totalInfo = totalInfo + song1 + ", ";
                //print currently selected state and info
                System.out.println("Selected State: " + state1 + ". Bird: " + bird1 + ". Song: " + song1 + ".");
            } catch (Exception e) {
                System.out.println("");
                menuInit = 1;
            }
        }
        //thank the user and print out all information requested
        System.out.println("Thanks for using our program. Here are your results: ");
        System.out.println(totalInfo);
    }
}
