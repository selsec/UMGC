/**
 * CMIS141 Intro to Programming
 * Steve Thaw
 * Final Assignment
 * 21 Jul 2019
 * This class provides the functionality for the user to read the file and get the required information from the command line
 */

import java.util.*;

public class TestCrime {

    public static void main(String[] args) {

        //variable to set time started
        long startTime = System.currentTimeMillis();
        //instantiate the UsCrimeStats class with args from the command line
        UsCrimeStats crimeStat = new UsCrimeStats(args[0]);
        //open the scanner for user input
        Scanner userInput = new Scanner(System.in);

        //begin the menu
        try {

            String option;
            do {

                System.out.println("Welcome to the Crime Stats Program! Select a menu option, or 'Q' to exit the program");
                System.out.println("1: List percentage population growth for each consecutive year");
                System.out.println("2: List year with highest robbery rate");
                System.out.println("3: List year with lowest robbery rate");
                System.out.println("4: List year with highest murder rate");
                System.out.println("5: List year with lowest murder rate");
                System.out.println("6: List year with highest aggrevated assault");
                System.out.println("7: List year with lowest aggrevated assault");
                System.out.println("8: List year with highest violent crime");
                System.out.println("9: List year with lowest violent crime");
                System.out.println("10: List year with the highest amount of larceny");
                System.out.println("11: List year with the lowest amount of larceny");
                System.out.println("Q: Quit the program");
                System.out.print("Enter your selection: ");

                //read user input with scanner
                option = userInput.next();
                System.out.println("");

                //switch statement to process user input
                switch (option) {
                    case "1":
                        System.out.println("The percentage in population growth for each consecutive year is:  " + crimeStat.getPopulationGrowth());
                        break;
                    case "2":
                        System.out.println("The year with the highest robbery rate was: " + crimeStat.getMaxRobberyYear());
                        break;
                    case "3":
                        System.out.println("The year with the lowest robbery rate was " + crimeStat.getMinRobberyYear());
                        break;
                    case "4":
                        System.out.println("The year with the highest murder rate was: " + crimeStat.getMaxMurderYear());
                        break;
                    case "5":
                        System.out.println("The year with the lowest murder rate was: " + crimeStat.getMinMurderYear());
                        break;
                    case "6":
                        System.out.println("The year with the highest aggrevated assault was " + crimeStat.getMaxAggAssaultYear());
                        break;
                    case "7":
                        System.out.println("The year with the lowest aggrevated assault was " + crimeStat.getMinAggAssaultYear());
                        break;
                    case "8":
                        System.out.println("The year with the highest violent crime was " + crimeStat.getMaxViolentCrime());
                        break;
                    case "9":
                        System.out.println("The year with the lowest violent crime was " + crimeStat.getMinViolentCrime());
                        break;
                    case "10":
                        System.out.println("The year with the highest amount of larceny was " + crimeStat.getMaxLarceny());
                        break;
                    case "11":
                        System.out.println("The year with the lowest amount of larceny was " + crimeStat.getMinLarceny());
                        break;
                }//end switch

                System.out.println("");
            }
            //Makes the Q option case insensitive for ease of use
            while (!option.equalsIgnoreCase("Q"));

            //calculate finish time and print to screen
            long endTime = System.currentTimeMillis();
            long totalTime = (endTime - startTime) / 1000;
            System.out.println("Thank you for using the Crime Statistics Program! " + "Your total time using the program was: " + totalTime + " Seconds");


        }//end try

        catch (Exception io) {
            io.getMessage();
        }//end catch
        //close the scanner
        try {
            if (userInput != null) {
                userInput.close();
            }
        }

        catch (Exception e) {
            e.getMessage();
        }
    }//end main
}//end class
