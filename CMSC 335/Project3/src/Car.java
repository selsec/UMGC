/* CMSC 335 Object Oriented and Concurrent Programming
 * Date: 12 Dec 2020
 * Author: Steve Thaw
 * Description: A class to create vehicle objects which contain the name, starting coordinates, and starting speed
 */

public class Car implements Runnable {

    private final int name;
    private int xCoord = 0;
    private int yCoord = 0;
    private int speed = 0;

    public Car(int name, int startX, int startY, int startSpeed) {
        this.name = name;
        this.xCoord = startX;
        this.yCoord = startY;
        this.speed = startSpeed;
    }

    public synchronized int changeX (int changeX) {
        int currentCoord = xCoord;
        int coordDelta = changeX;
        int newCoord = 0;

        if (coordDelta <= 5 || coordDelta >= -5) {
            newCoord = xCoord + changeX;
            return newCoord;
        } else {
            return currentCoord;
        }
    }

    public synchronized int changeY (int changeY) {
        int currentCoord = yCoord;
        int coordDelta = changeY;
        int newCoord = 0;

        if (coordDelta <= 5 || coordDelta >= -5) {
            newCoord = yCoord + changeY;
            return newCoord;
        } else {
            return currentCoord;
        }
    }

    public synchronized int changeSpeed (int changeSpeed) {
        int currentSpeed = speed;
        int speedDelta = changeSpeed;
        int newSpeed = 0;

        if (speedDelta <= 5 || speedDelta >= 0) {
            newSpeed = currentSpeed + speedDelta;
            return newSpeed;
        } else {
            return currentSpeed;
        }
    }

    @Override
    public void run() {

    }

    @Override
    public String toString(){
        String string = "Car:" + name + ". X Position: " + xCoord + ". Y Position: " + yCoord + " Speed: " + speed + "\n";
        return string;
    }


}
