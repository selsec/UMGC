/* This is the main test class for the project. It reads data from a file and sorts that data into the appropriate arrays
* and prints that data to the console
* Author: Steve Thaw
* Class: CMIS242 Intermediate Programming
* Date: 13 Oct 19
*/

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        
        Employee[] employee2015 = new Employee[6]; // creates an object array for 2019 employees with a maximum of 10 employees      //// These should be set to 10 instead of 6, so you can read up to 10
        Employee[] employee2014 = new Employee[6]; // creates an object array for 2018 employees with a maximum of 10 employees      //// Right now, if I go to the passed file and make 10 entries, all 2015, it wil show 6 for 2015 max 
           
        //start reading the data with buffered reader
        try {
            
            BufferedReader readFile = new BufferedReader(new FileReader("EmployeeData.txt"));
            String line = readFile.readLine();
            int i = 0;
            //System.out.println("Looping");
            //loop through the data while the file still has lines
            while (line != null) {
                //System.out.println("Loop #: " + i);
                //store read data into variables to be used in object constructors
                String[] storeLine = line.split(" ");
                String year = storeLine[0];
                String type = storeLine[1];                                                                                          //// Since the file should be in the format of
                String name = storeLine[2];                                                                                          //// <year> <position> <name> <salary> <if exec or sales will have stock price or commission here>
                int salary = Integer.parseInt(storeLine[3]);                                                                         
                int stockPrice = Integer.parseInt(storeLine[4]);                                                                     //// if (type.equals("Executive") || type.equals("Salesman") {
                int annualSales = Integer.parseInt(storeLine[5]);                                                                    ////   int payModifier = Integer.parseInt(storeLine[4]);
                                                                                                                                     ////  }
                // tests the data for the employee type and year, creates an object of the appropriate class, and stores it in the appropriate array by year
                if (storeLine[0].equals("2015") && storeLine[1].equals("Employee")){
                    Employee empObj = new Employee(name, salary);
                    employee2015[i] = empObj;
                    //System.out.println(employee2015[i]);
                    i++;
                }
                else if (storeLine[0].equals("2015") && storeLine[1].equals("Executive")) {
                    
                    Executive exObj = new Executive(name, salary, stockPrice);                                                       //// instead of passing stockPrice you would now pass payModifier for all Executive and Salesman.
                    employee2015[i] = exObj;
                    //System.out.println(employee2015[i]);
                    i++;
                }
                else if (storeLine[0].equals("2015") && storeLine[1].equals("Salesman")) {
                    
                    Salesman salObj = new Salesman(name, salary, annualSales);
                    employee2015[i] = salObj;
                    //System.out.println(employee2015[i]);
                    i++;
                }
                else if (storeLine[0].equals("2014") && storeLine[1].equals("Employee")){
                    Employee empObj = new Employee(name, salary);
                    employee2014[i] = empObj;
                    //System.out.println(employee2018[i]);
                    i++;
                }
                else if (storeLine[0].equals("2014") && storeLine[1].equals("Executive")) {
                    
                    Executive exObj = new Executive(name, salary, stockPrice);
                    employee2014[i] = exObj;
                    //System.out.println(employee2018[i]);
                    i++;
                }
                else if (storeLine[0].equals("2014") && storeLine[1].equals("Salesman")) {
                    
                    Salesman salObj = new Salesman(name, salary, annualSales);
                    employee2014[i] = salObj;
                    //System.out.println(employee2018[i]);
                    i++;
                }
                line = readFile.readLine();
            //System.out.println("Loop Complete: " + i);
            }
            if (readFile != null) {
                readFile.close();
            }
        } catch (Exception e) {
            e.getMessage();
            }
        //code to print employee information and total salaries for 2015
        System.out.println("Employees for 2015:");
        for (int x = 0; x < employee2015.length; x++) {
            System.out.println(employee2015[x]);
        }
        //code to print employee information and total salaries for 2014
        System.out.println("Employees for 2014:");
        for (int y = 0; y < employee2014.length; y++) {
            System.out.println(employee2014[y]);
        } 
    }
}
