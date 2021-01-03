/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a TwoDimensional object which is a subclass of Shape
 *
 */

public class TwoDimensionalShape extends Shape {

    //class variables
    protected double area;

    //constructor
    public TwoDimensionalShape(double area, int numberOfDimensions) {
        super(numberOfDimensions);
        this.area = area;
    }

    //class method to return area
    protected double findArea() {
        return this.area;
    }
}
