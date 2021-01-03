/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Square object which is a subclass of TwoDimensional Shape
 *
 */

public class Square extends TwoDimensionalShape {

    //class variables
    private double length;
    private double area;

    //constructor
    //the area of a square is L * W, but because in a square L=W, only length is used for simplicity
    public Square(double length) {
        super(0, 2);
        this.length = length;

    }

    //method to calculate area
    @Override
    public double findArea() {
        this.area = Math.pow(this.length, 2) ;
        return area;
    }
}
