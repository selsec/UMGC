public class Main {
    public static void main(String[] args) {

        Vehicle car1 = new Car(1989, "Honda", "Accord", "Car", 110, 4);
        Vehicle boat1 = new Boat(2010, "Sealine", "S29", "Boat", 15);
        Vehicle plane1 = new Plane(2019, "Cessna", "172", "Plane", 320, 3);
        
        System.out.println(car1.toString());
        System.out.println(boat1.toString());
        System.out.println(plane1.toString());

    }
}
