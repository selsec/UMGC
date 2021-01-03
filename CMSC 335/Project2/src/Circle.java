/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Circle object which is a subclass of TwoDimensionalShape
 *
 */

import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {

    //class variables
    public double radius;
    private double area;

    //constructor
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    //method to calculate area
    public double findArea() {
        this.area = Math.PI * Math.pow(radius, 2);
        return this.area;
    }
    //added in project 2 to allow a way to get the radius
    public double getRadius(){
        return radius;
    }
}






