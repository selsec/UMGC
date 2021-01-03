public class Vehicle {
    
    public int year;
    public String make;
    public String model;
    public String vehType;

    public Vehicle(int yearInit, String makeInit, String modelInit, String vehTypeInit) {
        year = yearInit;
        make = makeInit;
        model = modelInit;
        vehType = vehTypeInit; 
    }

    public String toString() {
        return "Make: " + this.make + "\nModel: " + this.model + "\nYear: " + this.year + "\nVehicle Type: " + this.vehType + "\n";
    }
}
