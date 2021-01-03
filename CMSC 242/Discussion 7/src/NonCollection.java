/*
 * A simple program which illustrates non-generic, non-collection program
 * Steve Thaw
 * CMIS 242 Week 7 Discussion - Non-Generics
 */


import java.lang.reflect.Array;

public class NonCollection {
    public static void main(String[] args) {
        Array[] listTest = new Array[3];
        listTest[0] = "This is a String";
        listTest[1] = "The next index is an Integer";
        listTest[2] = 10

        for (int i = 0; i < listTest.length; i++) {
            System.out.println(listTest[i];
        }
    }
}
/*
Give an example of a program that uses the nongeneric version of a class from the STL and the equivalent
program that uses the generic version. How do the two implementations differ? Why is having the syntax of
generics better?
 */