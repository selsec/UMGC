/**
 * CMIS141 Intro to Programming
 * Steve Thaw
 * Final Assignment
 * 21 Jul 2019
 * This class reads the .csv file, stores the info, and returns the info
 */

import java.io.*;

public class UsCrimeStats {
    private Crime[] crimeArray;
    private final int NUMYEAR = 20;

    public UsCrimeStats(String Crimes) {

        //Attempts to read Crime.csv (or file stated at command line)
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(Crimes));
            String line = readFile.readLine();
            crimeArray = new Crime[NUMYEAR];
            int i = 0;

            while ((line = readFile.readLine()) != null) {
                String[] storeLine = line.split(",");
                int year = Integer.parseInt(storeLine[0]);
                int pop = Integer.parseInt(storeLine[1]);
                int violentCrime = Integer.parseInt(storeLine[2]);
                double violentCrimeRate = Double.parseDouble(storeLine[3]);
                int murderAndNonnegligentMan = Integer.parseInt(storeLine[4]);
                double murderRate = Double.parseDouble(storeLine[5]);
                int rape = Integer.parseInt(storeLine[6]);
                double rapeRate = Double.parseDouble(storeLine[7]);
                int robbery = Integer.parseInt(storeLine[8]);
                double robberyRate = Double.parseDouble(storeLine[9]);
                int aggAssault = Integer.parseInt(storeLine[10]);
                double aggAssRate = Double.parseDouble(storeLine[11]);
                int propertyCrime = Integer.parseInt(storeLine[12]);
                double propertyRate = Double.parseDouble(storeLine[13]);
                int burglary = Integer.parseInt(storeLine[14]);
                double burglaryRate = Double.parseDouble(storeLine[15]);
                int larceny = Integer.parseInt(storeLine[16]);
                double larcenyRate = Double.parseDouble(storeLine[17]);
                int motorVehicle = Integer.parseInt(storeLine[18]);
                double motorRate = Double.parseDouble(storeLine[19]);

                //Instantiate a crime object
                Crime crimeObj = new Crime(year, pop, violentCrime, violentCrimeRate, murderAndNonnegligentMan, murderRate,
                        rape, rapeRate, robbery, robberyRate, aggAssault, aggAssRate, propertyCrime, propertyRate,
                        burglary, burglaryRate, larceny, larcenyRate, motorVehicle, motorRate);

                crimeArray[i] = crimeObj;
                i++;
            }

            if (readFile != null) {
                readFile.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //methods for determining min and max plus population growth

    public int getMaxMurderYear() {
        double maxMurderRate = -1;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getMurderRate();
            if (maxMurderRate < holder) {
                maxMurderRate = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }


    public int getMinMurderYear() {
        double minMurderRate = 1000;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getMurderRate();
            if (minMurderRate > holder) {
                minMurderRate = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public int getMaxRobberyYear() {
        double maxRobberyRate = -1;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getRobberyRate();
            if (maxRobberyRate < holder) {
                maxRobberyRate = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public int getMinRobberyYear() {
        double minRobberyRate = 1000;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getRobberyRate();
            if (minRobberyRate > holder) {
                minRobberyRate = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public int getMaxAggAssaultYear() {
        double maxAggAssault = 100;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getAggAssault();
            if (maxAggAssault < holder) {
                maxAggAssault = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public int getMinAggAssaultYear() {
        double minAggAssault = 1113179;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getAggAssault();
            if (minAggAssault > holder) {
                minAggAssault = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public int getMaxLarceny() {
        double maxLarceny = 100;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getLarceny();
            if (maxLarceny < holder) {
                maxLarceny = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public int getMinLarceny() {
        double minLarceny = 8000000;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getLarceny();
            if (minLarceny > holder) {
                minLarceny = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public int  getMaxViolentCrime() {
        double maxViolentCrime = 100;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getViolentCrime();
            if (maxViolentCrime < holder) {
                maxViolentCrime = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public int getMinViolentCrime() {
        double minViolentCrime = 1113179;
        int year = 0;
        for (int i = 0; i < NUMYEAR; i++) {
            double holder = crimeArray[i].getViolentCrime();
            if (minViolentCrime > holder) {
                minViolentCrime = holder;
                year = crimeArray[i].getYear();
            }
        }
        return year;
    }

    public String getPopulationGrowth() {
        String popGrowth = "";
        for (int i = 0; i < NUMYEAR - 1; i++) {
            int population1 = crimeArray[i].getPop();
            int population2 = crimeArray[i + 1].getPop();
            int year1 = crimeArray[i].getYear();
            int year2 = crimeArray[i + 1].getYear();
            double percentage = (double) (population2 - population1) / population1 * 100;
            popGrowth = year1 + "-" + year2 + ":" + percentage + "% \n";
        }
        return popGrowth;
    }
}//end class
