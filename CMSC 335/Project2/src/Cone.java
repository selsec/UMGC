/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Cone object which is a subclass of ThreeDimensionalShape
 *
 */

import javax.swing.*;

public class Cone extends ThreeDimensionalShape {

    //class variables
    private double height;
    private double radius;
    private double volume = 0;
    public final ImageIcon coneImage = new ImageIcon(getClass().getResource("coneIcon.jpg"));

    //constructor
    public Cone(double height, double radius) {
        super(0, 3);
        this.height = height;
        this.radius = radius;

    }

    //method to calculate volume
    @Override
    public double findVolume() {
        this.volume = Math.PI * Math.pow(radius, 2) * (height / 3);
        return this.volume;
    }
}
