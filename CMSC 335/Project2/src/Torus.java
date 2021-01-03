/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Torus object which is a subclass of ThreeDimensionalShape
 *
 */

import javax.swing.*;

public class Torus extends ThreeDimensionalShape {

    //class variables
    private double majorRadius;
    private double minorRadius;
    private double volume = 0;
    public final ImageIcon torusImage = new ImageIcon(getClass().getResource("torusIcon.png"));

    //constructor
    public Torus(double majorRadius, double minorRadius) {
        super(0,3);
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    //method to calculate volume
    @Override
    public double findVolume() {
        this.volume = (Math.PI * Math.pow(minorRadius, 2)) * (2 * Math.PI * majorRadius);
        return this.volume;
    }
}
