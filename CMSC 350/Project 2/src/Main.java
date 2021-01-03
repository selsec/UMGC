/* CSMC 350 DATA STRUCTURES ASSIGNMENT 2
 * Author: Steven Thaw
 * Date: 6/13/2020
 * Main program logic. Allows selection of a file through JFileChooser class and then populate an arraylist of objects
 * of Polynomial class. Check if input is in sorted order according to two orders:
 * First check: compareTo method from polynomial class. This is strong order
 * Second check: Use of a comparator. This is weak order.
 * A lambda expression then which implements comparator which only considers exponenets in comparing the polynomials.
 */

import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {
    //create arraylist for file input
    private static List<Polynomial> inputList = new ArrayList<>();

    //open file chooser and select file
    public static void getFileInput() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int userChoice = fileChooser.showOpenDialog(null);
        if (userChoice == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                if (file.length() == 0) {
                    throw new IOException("File Error");
                }

                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while (line != null) {
                    if(line.length() > 0) {
                        Polynomial poly = new Polynomial(line);
                        System.out.println(poly);
                        inputList.add(poly);
                    }
                    line = br.readLine();
                }
                strongOrWeak();
            } catch (InvalidPolynomialSyntax ips) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ips.getMessage());
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ioe.getMessage());
            }
        }
    }

    public static void strongOrWeak() {
        if (OrderedList.checkSorted(inputList) == true) {
            System.out.println("Polynomials are Strongly Ordered");
        } else {
            System.out.println("Polynomials are Weakly Ordered");
        }
    }

    public static void main(String[] args) {
        try {
            getFileInput();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ioe.getMessage());
        }
    }
}
