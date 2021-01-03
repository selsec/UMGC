/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Rectangle object which is a subclass of TwoDimensional Shape
 *
 */

public class Rectangle extends TwoDimensionalShape {

    //class variables
    private double length;
    private double width;
    private double area;

    //constructor
    public Rectangle(double length, double width) {
        super(0, 2);
        this.length = length;
        this.width = width;
    }

    //method to calculate area
    @Override
    public double findArea() {
        this.area = this.length * this.width;
        return area;
    }
    //added in project two to get length and width
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
