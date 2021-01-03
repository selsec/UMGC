public class Boat extends Vehicle {
    
    private int maxSpeed;

    public Boat(int yearInit, String makeInit, String modelInit, String vehTypeInit, int maxSpeedInit) {
        super(yearInit, makeInit, modelInit, vehTypeInit);
        maxSpeed = maxSpeedInit;
        }
    
    public String toString() {
        return super.toString() + "\nMax Speed: " + this.maxSpeed + " Knots" + "\n";
    }

}
