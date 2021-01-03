/* CSMC 350 DATA STRUCTURES ASSIGNMENT 2
 * Author: Steven Thaw
 * Date: 6/13/2020
 * Defines an exception which is thrown by the constructor of the polynomial class should the constructor contain coefficients or exponents
 * of an improper type or fail to be listed in descending order.
 */
import javax.swing.JOptionPane;

public class InvalidPolynomialSyntax extends Throwable {
    public InvalidPolynomialSyntax(String errorMessage) {
        super(errorMessage);

    }
}
