/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Main program logic
 *
 */

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws Exception {

        //variables
        int choice = 0;
        boolean exit = false;

        //flow control loop
        while (!exit) {

            //main menu
            System.out.println("Welcome to the Shape Creator, which type of shape would you like to create?");
            System.out.println("1: Triangle");
            System.out.println("2: Rectangle");
            System.out.println("3: Square");
            System.out.println("4: Sphere");
            System.out.println("5: Cube");
            System.out.println("6: Cone");
            System.out.println("7: Cylinder");
            System.out.println("8: Torus");
            System.out.println("9: Circle");
            System.out.println("10: Exit Program");
            System.out.println("User Choice: ");

            //scanner object creation
            Scanner scanner = new Scanner(System.in);

            //try catch to catch IO Exception
            try {
                choice = scanner.nextInt();
            } catch (Exception ex) {
                System.out.println("Please enter a valid selection");
            }

            //switch statement flow control
            switch(choice) {
                case 1:
                    System.out.println("Please enter the Triangle base and height in the following format (Base  Height): ");
                    try {
                        Triangle triangle = new Triangle(scanner.nextDouble(), scanner.nextDouble());
                        System.out.println("Triangle Area is: " + triangle.findArea() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                    break;
                case 2:
                    System.out.println("Please enter the Length and Width in the following format (Length Width): ");
                    try {
                        Rectangle rectangle = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
                        System.out.println("Rectangle Area is: " + rectangle.findArea() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                    break;
                case 3:
                    System.out.println("Please enter the Length of the square: ");
                    try {
                        Square square = new Square(scanner.nextDouble());
                        System.out.println("Square Area is: " + square.findArea() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                    break;
                case 4:
                    System.out.println("Please enter the radius of the Sphere: ");
                    try {
                        Sphere sphere = new Sphere(scanner.nextDouble()) ;
                        System.out.println("Sphere Volume is: " + sphere.findVolume() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                    break;
                case 5:
                    System.out.println("Please enter the Length of the Cube: ");
                    try {
                        Cube cube = new Cube(scanner.nextDouble()) ;
                        System.out.println("Cube Volume is: " + cube.findVolume() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                    break;
                case 6:
                    System.out.println("Please enter the Height and Radius of the Cone in the following format (Height Radius): ");
                    try {
                        Cone cone = new Cone(scanner.nextDouble(), scanner.nextDouble()) ;
                        System.out.println("Cone Volume is: " + cone.findVolume() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                    break;
                case 7:
                    System.out.println("Please enter the Height and Radius of the Cylinder in the following format (Height Radius): ");
                    try {
                        Cylinder cylinder = new Cylinder(scanner.nextDouble(), scanner.nextDouble()) ;
                        System.out.println("Cylinder Volume is: " + cylinder.findVolume() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                    break;
                case 8:
                    System.out.println("Please enter the Major Radius and Minor Radius of the Torus in the following format (Major Radius Minor Radius): ");
                    try {
                        Torus torus = new Torus(scanner.nextDouble(), scanner.nextDouble()) ;
                        System.out.println("Torus Volume is: " + torus.findVolume() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                    break;
                case 9:
                    System.out.println("Please enter the radius of the Circle: ");
                    try {
                        Circle circle = new Circle(scanner.nextDouble());
                        System.out.println("Circle area is: " + circle.findArea() + "\n");
                    } catch (Exception ex) {
                        System.out.println("Please enter valid input in correct format\n");
                    }
                case 10:
                    exit = true;
                    break;
            } //end switch
        } //end loop

        //exit statement
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Thank you for using the Area/Volume Calculator! The current date/time is: " + dtf.format(now));
    }//end main
}//end Main
