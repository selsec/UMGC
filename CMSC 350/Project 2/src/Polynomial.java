/* CSMC 350 DATA STRUCTURES ASSIGNMENT 2
 * Author: Steven Thaw
 * Date: 6/13/2020
 * Defines an individual polynomial represented by a singly linked list. Each node contains one term
 * of the polynomial consisting of coefficient and exponent. Create the nodes of the linked list as
 * instances of a static nested class. Contains 4 public methods: Constructor, compareTo, iterator, toString.
 */

import java.util.*;

public class Polynomial implements Iterable<Polynomial.PNode>, Comparable<Polynomial> {
    private PNode head;

    //Linked List Implementation
    static class PNode {
        private double coefficient;
        private int exponent;
        private PNode next;

        //linked list constructor
        private PNode(double coeff, int exp) {
            coefficient = coeff;
            exponent = exp;
            next = null;
        }

        //get coefficient in node
        private double getCoefficient() {
            return coefficient;
        }

        //get exponent in node
        private int getExponent() {
            return exponent;
        }

        //get next node in list
        private PNode getNext() {
            return next;
        }
        //overridden toString for PNode
        @Override
        public String toString() {
            String output = String.format("%.1f", coefficient);
            if (exponent == 0) {
                return output;
            } else if (exponent == 1) {
                return output + "x";
            } else {
                return output + "x^" + exponent;
            }
        }
    }

    //constructor for polynomial class which throws exception if polynomials in file are not in proper format
    public Polynomial(String fileInput) throws InvalidPolynomialSyntax {
        head = null;
        Scanner sc = new Scanner(fileInput);
        try {
            while (sc.hasNext()) {
                addTerm(sc.nextDouble(), sc.nextInt());
            }
        } catch (Exception ex) {
            throw new InvalidPolynomialSyntax("Incorrect Syntax");
        }
    }

    //setter for terms, which throws exception if exponent is negative number
    public void addTerm(double coefficient, int exponent) throws InvalidPolynomialSyntax {
            if (exponent < 0) {
                throw new InvalidPolynomialSyntax("Exponents cannot be negative");
            }

        PNode current = head;
        if (current == null) {
            head = new PNode(coefficient, exponent);
            head.next = null;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new PNode(coefficient, exponent);
        }
    }

    //compareTo method override
    @Override
    public int compareTo(Polynomial comparePoly) {
        PNode initalPoly = this.head;
        PNode compareToInit = comparePoly.head;

        while (initalPoly != null && compareToInit != null) {
            /*
            if (initalPoly.getExponent() != compareToInit.getExponent()) {
                return initalPoly.getExponent() - compareToInit.getExponent();
            } else if (initalPoly.getCoefficient() != compareToInit.getCoefficient()) {
                if (initalPoly.getCoefficient() > compareToInit.getCoefficient()) {
                    return 1;
                } else if (initalPoly.getCoefficient() < compareToInit.getCoefficient()) {
                    return -1;
                }
            }
            */
            if (initalPoly.getExponent() != compareToInit.getExponent()) {
                return initalPoly.getExponent() - compareToInit.getExponent();
            }

            initalPoly = initalPoly.getNext();
            compareToInit = compareToInit.getNext();
        }
        if (initalPoly == null && compareToInit == null) {
            return 0;
        }
        if (initalPoly == null) {
            return -1;
        } else {
            return 1;
        }
    }

    //Iterator class override
    @Override
    public Iterator<PNode> iterator() {
        return new Iterator<>() {
            private PNode current = getHead();

            @Override
            public boolean hasNext() {
                return current != null && current.getNext() != null;
            }

            @Override
            public PNode next() {
                PNode data = current;
                current = current.next;
                return data;
            }
        };
    }

    //toString method override
    @Override
    public String toString() {
        String output = head.toString();

        for (PNode stringOutput = head.next; stringOutput != null; stringOutput = stringOutput.next) {
            output = output + " + " + (stringOutput.toString());
        }
        return output;
    }

    //getter method for first node
    private PNode getHead() {
        return head;
    }
}
