/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Circle object which is a subclass of TwoDimensionalShape
 *
 */

public class Circle extends TwoDimensionalShape {

    //class variables
    private double radius;
    private double area;

    //constructor
    public Circle(double radius) {
        super(0,2);
        this.radius = radius;
    }

    //method to calculate volume
    @Override
    public double findArea() {
        this.area = Math.PI * Math.pow(radius, 2);
        return this.area;
    }
}
