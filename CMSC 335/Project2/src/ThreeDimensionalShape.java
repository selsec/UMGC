/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a ThreeDimensionalShape object which is a subclass of Shape
 *
 */

public class ThreeDimensionalShape extends Shape {

    //class variables
    protected double volume;

    //constructor
    public ThreeDimensionalShape(double volume, int numberOfDimensions) {
        super(numberOfDimensions);
        this.volume = volume;
        }

    //method to return volume
    public double findVolume() {
        return this.volume;
    }
}
