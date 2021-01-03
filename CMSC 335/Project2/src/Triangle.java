/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a triangle object which is a subcless of TwoDimensional Shape
 * Area of a triangle is 1/2 B * H
 */

public class Triangle extends TwoDimensionalShape {

    //class variables
    private double base;
    private double height;
    private double area;

    //constructor
    public Triangle (double base, double height) {
        super(0, 2);
        this.base = base;
        this.height = height;
    }

    //method to calculate area
    @Override
    public double findArea() {
        this.area = (this.base * this.height) / 2;
        return area;
    }

    //added in project 2
    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}
