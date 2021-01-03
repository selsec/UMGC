/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Sphere object which is a subcless of ThreeDimensionalShape
 *
 */

import javax.swing.*;

public class Sphere extends ThreeDimensionalShape {

    //class variables
    private double radius;
    private double volume;
    public final ImageIcon sphereImage = new ImageIcon(getClass().getResource("sphereIcon.jpg"));

    //constructor
    public Sphere (double radius) {
        super(0, 3);
        this.radius = radius;
    }

    //method to calculate volume
    @Override
    public double findVolume() {
        this.volume = (4/3) * Math.PI * Math.pow(radius, radius);
        return this.volume;
    }
}
