/*
 * A program which demonstrates recursion in a number sequence. For this number sequence,
 * the program will be determining the first 20 octets.
 * Author: Steve Thaw
 * Date: 5 Nov 19
 * CMIS 242 Intermediate Programming Week 6 Discussion
 */
import java.io.*;
import java.util.*;

public class RecDisc  {

   public static void octetCalculator(int n1, int n2) {

        if (n2 == 20) {
            System.out.println("Recursion Complete!");
        }
        else {
            n1 = n1 + 8;
            n2 = n2 + 1;

            System.out.println(n1 + " Continuing Recursion, attempt #" + n2);
            octetCalculator(n1, n2);
        }
    }

    public static void main(String[] args) {
        octetCalculator(0, 0);
    }
}

