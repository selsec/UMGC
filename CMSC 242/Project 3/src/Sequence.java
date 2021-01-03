/*
 * A class which contains two methods, a recursive method and iterative method, for finding nth number in the fibonacci sequence
 * as well as calculating the efficiency of each method. Finally, there is a method which is executed on UI close that
 * computes efficiency values with values of n from 0 to 10 and written to a file. Each line of the file should contain
 * the value of n, the efficiency of the iterative method for that value of n and the efficiency of the recursive method.
 * Author: Steven Thaw
 * Date: 9 Nov 19
 * CMIS 242: Intermediate Programming Project 3
 */
import javax.swing.*;
import java.io.*;

public class Sequence {

    //method to compute recursive index
    public static long computeRecursiveIndex(long n, long i) {
        long efficiencyIndex = i;
        if ((n == 0) || (n == 1))
            return efficiencyIndex;
        else
            efficiencyIndex++;
        return computeRecursiveIndex(n - 1, efficiencyIndex) + computeRecursiveIndex(n - 2, efficiencyIndex);
    }

    //method to compute Nth number recursively
    public static long computeRecursiveResult(long n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return computeRecursiveResult(n - 1) + computeRecursiveResult(n - 2);
    }

    //method to compute and return the Nth number
    public static long computeIterativelyResult(long stop) {
        long n1, n2 = 0, currentNumber = 1;

        for (long i = 1; i < stop; i++) {

            n1 = n2;

            n2 = currentNumber;

            currentNumber = n1 + n2;

        }
        return currentNumber;
    }

    //method to compute and return the efficiency index
    public static long computeIterativelyIndex(long stop) {
        long n1, n2 = 0, currentNumber = 1;
        long index = 0;
        for (long i = 1; i < stop; i++) {
            n1 = n2;
            n2 = currentNumber;
            currentNumber = n1 + n2;
            index++;
        }
        return index;
    }

    //method to calculate values of n 0-10 and efficiency values of both recursive and iterative methods
    //and output them to a .csv to import into excel
    public static void calculateOnClose() throws FileNotFoundException {

        //create output stream to file and set system out to file instead of console
        PrintStream fileOut = new PrintStream("./out.txt");
        System.setOut(fileOut);

        //calculate values of n 0-10 and efficiency recursively
        for (int i = 0; i <= 10; i++) {
            System.out.println(computeRecursiveResult(i) + ", " + computeRecursiveIndex(i, 0) + "\n");
        }

        //calculate values of n 0-10 and efficiency iteratively
        for (int y = 0; y <= 10; y++) {
            System.out.println(computeIterativelyResult(y) + ", " + computeIterativelyIndex(y) + "\n");
        }
    }
}