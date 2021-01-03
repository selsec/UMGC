/*
 * A simple program which illustrates a generic program
 * Steve Thaw
 * CMIS 242 WK 7 Discussion - Generics
 */

import java.util.*;

public class Generic {
    public static void main(String[] args) {
        List<String> listTest = new ArrayList<String>();
        String string1 = "This is a string";
        String string2 = "The next index is an Integer";
        listTest.add(string1);
        listTest.add(string2);
        listTest.add(10);

        for (int i = 0; i < listTest.size(); i++) {
            System.out.println(listTest.get(i));
        }
    }
}

