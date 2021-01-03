/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Cylinder object which is a subclass of ThreeDimensionalShape
 *
 */

import javax.swing.*;

public class Cylinder extends ThreeDimensionalShape {

    //class variables
    private double height;
    private double radius;
    private double volume = 0;
    public final ImageIcon cylinderImage = new ImageIcon(getClass().getResource("cylinderIcon.jpg"));

    //constructor
    public Cylinder (double height, double radius) {
        super(0,3);
        this.height = height;
        this.radius = radius;
    }

    //method to calculate volume
    @Override
    public double findVolume() {
        this.volume = Math.PI * Math.pow(radius, 2) * height;
        return this.volume;
    }
}
