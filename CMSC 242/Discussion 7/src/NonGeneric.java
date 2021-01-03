/*
 * A simple program which illustrates non-generic program
 * Steve Thaw
 * CMIS 242 Week 7 Discussion - Non-Generics
 */


import java.util.*;

public class NonGeneric {
    public static void main(String[] args) {
        List listTest = new ArrayList<String>();
        listTest.add("This is a String");
        listTest.add("The next index is an Integer");
        listTest.add(10);

        for (int i = 0; i < listTest.size(); i++) {
            System.out.println(listTest.get(i);
        }
    }
}
