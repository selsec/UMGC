import java.io.*;
import java.util.*;

public class States {

    public States(){
        String state = "";
        String bird = "";
        String song = "";
        int location = 0;
    }

    String[] statesArray = new String[50];
    String[] songArray = new String[50];
    String[] birdArray = new String[50];

    public void fillArray() {

        try {

            Scanner s1 = new Scanner(new File("states.txt"));
            Scanner s2 = new Scanner(new File("bird.txt"));
            Scanner s3 = new Scanner(new File("song.txt"));

            for (int i = 0; i < 50; i++) {
                statesArray[i] = s1.nextLine();
            }
            for (int j = 0; j < 50; j++) {
                birdArray[j] = s2.nextLine();
            }
            for (int l = 0; l < 50; l++) {
                songArray[l] = s3.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No Such File");
        }
    }

    public int getIndex(String input) {
        int arrayLoc = Arrays.binarySearch(statesArray, input);
        return arrayLoc;
    }

    public String getState(int input) {
        String state = statesArray[arrayLoc];
        return state;
    }

    public String getBird(int input) {
        String bird = birdArray[arrayLoc];
        return bird;
    }

    public String getSong(int input) {
        String song = songArray[arrayLoc];
        return song;
    }
}
