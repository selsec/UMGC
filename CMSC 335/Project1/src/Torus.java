/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Torus object which is a subclass of ThreeDimensionalShape
 *
 */

public class Torus extends ThreeDimensionalShape {

    //class variables
    private double majorRadius;
    private double minorRadius;
    private double volume = 0;

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
