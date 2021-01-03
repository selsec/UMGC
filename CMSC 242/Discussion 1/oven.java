/* Oven Class and Tester
Author: Steve Thaw
CMIS242
WK 1 Discussion
A public oven class for smart ovens along with a tester main
 */
import java.io.*;

public class oven {
    public static int maxTemp = 550; // sets a static class value that all objects in the class of oven can have a maximum value of 550 degrees which cannot be changed
    public static int minTemp = 0; // sets a static class value that all objects in the class of oven can have a minimum value of 0 degrees which cannot be changed
    public int power = 0; // sets a class value that all objects in the class of oven for power, 0 being off and 1 being on
    public int bakeTemp = 0; // sets a class value that all objects in the class of oven for bake temp have

    public oven() {
        int power = 0; // sets instance power variable default to 0. This can be changed with methods and can be different for each object
        int bakeTemp = 0; // sets instance bake temp variable default to 0. This can be changed with methods and can be different for each object

    }

    //method to turn the power on or off and retrieve the current power state
    public void setPower(int newPower) {
        power = newPower;
        if (power == 0) {
            bakeTemp = 0;
        }
    }

    public int getPower() {
        return power;
    }

    //method to set the power and return the current power
    public void setTemp(int newTemp) {
        if (newTemp > maxTemp || newTemp < minTemp) {
             System.out.println("That is out of the allowable temperature range.");
        }
        else {
            bakeTemp = newTemp;

        }
    }

    public int getTemp() {
        return bakeTemp;
    }

    //method to get the min and max bake temp
    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }


    public static void main(String[] args) throws IOException {
        //Declare and instantiate two oven objects
        oven ovenOne = new oven();
        oven ovenTwo = new oven();

        //get values for ovens
        System.out.println("The current power for oven 1 and 2 are " + ovenOne.getPower() + " and " + ovenTwo.getPower());
        System.out.println("Turning on both ovens and setting Oven 1 to 350 degrees and Oven 2 to 450 degrees");

        ovenOne.setPower(1);
        ovenTwo.setPower(2);
        ovenOne.setTemp(350);
        ovenTwo.setTemp(450);

        System.out.println("The current power for oven 1 and 2 are " + ovenOne.getPower() + " and " + ovenTwo.getPower());
        System.out.println("The current temp for oven 1 and 2 are " + ovenOne.getTemp() + " and " + ovenTwo.getTemp());
        System.out.println("Attempting to set oven 2 temp above maximum");
        ovenTwo.setTemp(1000);
        System.out.println("Current temp for oven 2 is " + ovenTwo.getTemp());

        // instance  variables to determine the difference between oven 1 and oven 2 temperature. They have no effect on the objects.
        System.out.println("Retriving the difference between Oven 1 and Oven 2 Temp....");
        int oven1Temp = ovenOne.getTemp();
        int oven2Temp = ovenTwo.getTemp();
        int diff = oven2Temp - oven1Temp;
        System.out.println("The difference between Oven 1 and Oven 2 Temp is: " + diff + " degrees.");
        System.out.println("Powering down all ovens...");
        ovenOne.setPower(0);
        ovenTwo.setPower(0);
        System.out.println("The current power for oven 1 and 2 are " + ovenOne.getPower() + " and " + ovenTwo.getPower());
        System.out.println("The current temp for oven 1 and 2 are " + ovenOne.getTemp() + " and " + ovenTwo.getTemp());
    }
}
