/* CSMC 350 DATA STRUCTURES ASSIGNMENT 2
 * Author: Steven Thaw
 * Date: 6/13/2020
 * A utility class that contains two overloaded implementations of a
 * method named checkSorted, which determines whether a List object, supplied as a parameter, is in strictly
 * ascending order. Both methods should be class (static) methods. The first of the overloaded methods should
 * accept a list that contains elements that implement Comparable. The second should instead be supplied an
 * additional parameter that is an object of a class that implements the Comparator interface
 */

import java.util.*;

public class OrderedList {

    public static <T extends Comparable<? super T>> boolean checkSorted(List<T> list) {
        boolean isSorted = true;

        for (int i = list.size() - 1; i > 0; i--) {
            T current = list.get(i);
            if(!checkSorted(list, current)) {
                isSorted = false;
            }
        }
        return isSorted;
    }
    public static <T extends Comparable<? super T>> boolean checkSorted(List<T> list, T current) {

        T currentValue = list.get(list.indexOf(current));
        T nextValue = list.get(list.indexOf(current) - 1);

        if (nextValue != null) {
            return currentValue.compareTo(nextValue) > 0;
        }
        return true;
    }
}