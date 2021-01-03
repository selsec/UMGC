/* This is a sample program to illustrate exception propagation
* 
* Author: Steve Thaw
* Class: CMIS242 Intermediate Programming Discussion Wk 3
* Date: 16 Oct 19
*/

import java.io.*;
import java.util.*;

public class TestExceptionPropagation {
    
    private int testNumber;
    
    TestExceptionPropagation() {
    }

    public void setNumber(int number) {
        this.testNumber = number;
    }

    public int getNumber() {
        return testNumber;
    }

    public int divideNumberByZero() {
        testNumber = testNumber / 0;
        return testNumber;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a Number: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   
        int input = reader.readLine();
        TestExceptionPropagation testException = new TestExceptionPropagation();
        testException.setNumber(input);
        System.out.println("The number selected is: " + testException.getNumber());
        System.out.println("Hold on to your pants, dividing by 0! Here goes the universe!");

        try {
            int errorCreator = testException.divideNumberByZero();
        } catch (Exception e) {
            System.out.println("Exception has been handled, destruction of the universe has been averted!");
        }

        System.out.println("Mike Drop...");
    }
}

