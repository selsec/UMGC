/*
Discussion 7: Random Number Generator
CMIS 141 Intro to Programming
Steve Thaw
A program which generates X random integers from 0 through Y, as determined by user input
*/
import java.io.*;
import java.util.Random;

public class DiscSeven {
    public static void main(String[] args) throws IOException {
        //Declare and instantiate a buffered reader object
        BufferedReader stdin = new BufferedReader (
                new InputStreamReader (System.in));

        Random rand = new Random();

        //Declare and intitialize variables required
        int userInputX = 0;
        int userInputY = 0;


        //Welcome to the program and take user input

        System.out.println("Welcome to the Random Number Generator!");
        System.out.print("How many random integers would you like to generate? ");
        userInputX = Integer.parseInt (stdin.readLine());

        System.out.print("What is the last number in the range? ");
        userInputY = Integer.parseInt (stdin.readLine());

        //declare an array for the random values
        int [] randArray = new int [userInputX];
        userInputY = userInputY + 1;

        //generate random values based on user input and store in the array
        for (int i = 0; i < userInputX; i++){
            randArray[i] = rand.nextInt(userInputY);
        }

        //print the array
        System.out.println("Here are your randomly generated numbers!");

        for (int j = 0; j < randArray.length; j++){
            System.out.print(randArray[j]);
            if (j != randArray.length -1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
        System.out.println("Thanks for using the Random Number Generator!");
    }
}
