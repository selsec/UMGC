/* CMSC 350 Data Structures and Analysis
 * Project 1
 * Author: Steven Thaw
 * Date: 05/31/20
 * This is the exception class of the program which displays a JOptionPane Window informing the user of invalid syntax.
 */
import javax.swing.*;

public class SyntaxError extends Throwable {
    public static void message() {
        JOptionPane.showMessageDialog(null, "Invalid Syntax!");
    }
}
