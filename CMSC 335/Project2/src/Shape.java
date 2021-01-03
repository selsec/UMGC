/* CMSC 335 Project 1
 * Date: 1 November 2020
 * Author: Steven Thaw
 * Description: Creates an obj Shape with number of dimensions
 *
 */

public class Shape {

    //class variables
    protected int numberOfDimensions = 0;

    //constructor
    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    //method to return number of dimensions
    public int findNumDim() {
        return this.numberOfDimensions;
    }
}
