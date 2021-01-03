/*
 * A student class which contains the required constructor,
 * getter, and method for computing GPA for the student objects
 * Author: Steve Thaw
 * CMIS 242 Intermediate Programming - Project 4
 * Date: 19 Nov 2019
 */

//import decimal format for GPA.
import java.text.DecimalFormat;

public class Student {
    //class variables
    private String name;
    private String major;
    private double creditsTotal;
    private double qualityPointsTotal;
    private double creditsGrade;
    private double gpa = 4.0;
    private double qualityPoints;
    //decimal format object for GPA display
    private static DecimalFormat df = new DecimalFormat("#0.00");

    //constructor
    public Student(String name, String major) {
        this.name = name;
        this.major = major;
        gpa = 4.0;
        creditsTotal = 0;
        creditsGrade = 0;
    }

    //method for computing GPA based on input from GUI
    public void courseCompleted(String grade, double credits) {
        //method to change grade to lower case to ignore user input case
        String gradeConvert = grade.toLowerCase();
        //switch to check input and convert grade to decimal for computation
        switch (gradeConvert) {
            case "a":
                creditsGrade = 4.0;
                break;
            case "b":
                creditsGrade = 3.0;
                break;
            case "c":
                creditsGrade = 2.0;
                break;
            case "d":
                creditsGrade = 1.0;
                break;
            case "f":
                creditsGrade = 0.0;
                break;
        }
        //add credits from class to credit total
        creditsTotal = creditsTotal + credits;
        //calculate quality points
        qualityPoints = creditsGrade * credits;
        //calculate total quality points
        qualityPointsTotal = qualityPointsTotal + qualityPoints;
        //calculate GPA
        gpa = qualityPointsTotal / creditsTotal;
    }

    //toString method to display data from student object
    public String toString() {
        return "Name: " + name + "\nMajor: " + major + "\nGPA: " + df.format(gpa);
    }
}
