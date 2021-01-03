public class Plane extends Vehicle {
    
    private int maxSpeed;
    private int numWheels;

    public Plane(int yearInit, String makeInit, String modelInit, String vehTypeInit, int maxSpeedInit, int numWheelsInit) {
        super(yearInit, makeInit, modelInit, vehTypeInit);
        maxSpeed = maxSpeedInit;
        numWheels = numWheelsInit;
    }

    public String toString() {
        return super.toString() + "\nMax Speed: " + this.maxSpeed + " Knots\nWheels: " + this.numWheels + "\n";
    }
}
