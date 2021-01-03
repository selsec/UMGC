/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates a Cube object which is a subclass of ThreeDimensionalShape
 *
 */

import javax.swing.*;

public class Cube extends ThreeDimensionalShape {

    //class variables
    private double length;
    private double volume = 0;
    public final ImageIcon cubeImage = new ImageIcon(getClass().getResource("cubeIcon.jpg"));

    //constructor
    //the area of a cube is L * W * H, but because in a cube L=W=H, only length is used for simplicity
    public Cube (double length) {
        super(0,3);
        this.length = length;
    }

    //method to calculate volume
    @Override
    public double findVolume() {
        this.volume = Math.pow(length, 3);
        return this.volume;
    }
}
