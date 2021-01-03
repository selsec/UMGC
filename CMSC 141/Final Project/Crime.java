/**
 * CMIS141 Intro to Programming
 * Steve Thaw
 * Final Assignment
 * 21 Jul 2019
 * This class creates the Crime Class, build constructor, and getter methods (setter methods unneeded because they are set by the .csv file)
 */

public class Crime {
    //Declare required variables
    private	int year;
    private int pop;
    private	int violentCrime;
    private	double violentCrimeRate;
    private	int murderAndNonnegligentMan;
    private	double murderRate;
    private	int rape;
    private	double rapeRate;
    private	int robbery;
    private	double robberyRate;
    private	int aggAssault;
    private	double aggAssRate;
    private	int propertyCrime ;
    private	double propertyRate;
    private	int burglary;
    private	double burglaryRate;
    private	int larceny;
    private	double larcenyRate;
    private	int motorVehicle;
    private	double motorRate;

    //Crime Constructor
    public Crime(int year, int pop, int violentCrime, double violentCrimeRate, int murderAndNonnegligentMan, double murderRate,
                 int rape, double rapeRate, int robbery, double robberyRate, int aggAssault, double aggAssRate, int propertyCrime, double propertyRate,
                 int burglary, double burglaryRate, int larceny, double larcenyRate, int motorVehicle, double motorRate){

        this.year = year;
        this.pop = pop;
        this.violentCrime = violentCrime;
        this.violentCrimeRate = violentCrimeRate;
        this.murderAndNonnegligentMan = murderAndNonnegligentMan;
        this.murderRate = murderRate;
        this.rape = rape;
        this.rapeRate = rapeRate;
        this.robbery = robbery;
        this.robberyRate = robberyRate;
        this.aggAssault = aggAssault;
        this.aggAssRate = aggAssRate;
        this.propertyCrime = propertyCrime;
        this.propertyRate = propertyRate;
        this.burglary = burglary;
        this.burglaryRate = burglaryRate;
        this.larceny = larceny;
        this.larcenyRate = larcenyRate;
        this.motorVehicle = motorVehicle;
        this.motorRate = motorRate;

    }

    //Getter Methods
    public int getYear() {
        return year;
    }

    public int getPop() {
        return pop;
    }

    public int getViolentCrime() {
        return violentCrime;
    }

    public double getViolentCrimeRate() {
        return violentCrimeRate;
    }

    public int getMurderAndNonnegligentMan() {
        return murderAndNonnegligentMan;
    }

    public double getMurderRate() {
        return murderRate;
    }

    public int getRape() {
        return rape;
    }

    public double getRapeRate() {
        return rapeRate;
    }

    public int getRobbery() {
        return robbery;
    }

    public double getRobberyRate() {
        return robberyRate;
    }

    public int getAggAssault() {
        return aggAssault;
    }

    public double getAggAssRate() {
        return aggAssRate;
    }

    public int getPropertyCrime() {
        return propertyCrime;
    }

    public double getPropertyRate() {
        return propertyRate;
    }

    public int getBurglary() {
        return burglary;
    }

    public double getBurglaryRate() {
        return burglaryRate;
    }

    public int getLarceny() {
        return larceny;
    }

    public double getLarcenyRate() {
        return larcenyRate;
    }

    public int getMotorVehicle() {
        return motorVehicle;
    }

    public double getMotorRate() {
        return motorRate;
    }
}//end class
