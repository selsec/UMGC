/* CMSC 335 Object Oriented and Concurrent Programming
 * Date: 12 Dec 2020
 * Author: Steve Thaw
 * Description: GUI Class which draws the GUI and handles the logic
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GUI extends JFrame {

    private static final String PROGRAM_TITLE = "Intersection Simulator";
    private static final int MAIN_WIDTH = 900;
    private static final int MAIN_LENGTH = 800;

    private Timer timer;
    private Timer text1Timer;
    public java.util.List<StopLight> stopLights;
    private java.util.List<Thread> stopLightThread;
    private java.util.List<Car> vehicles;
    private java.util.List<Car> Cars1 = new ArrayList<>();
    private java.util.List<Car> Cars2 = new ArrayList<>();
    private java.util.List<Car> Cars3 = new ArrayList<>();



    public GUI() {
        super(PROGRAM_TITLE);
        setSize(MAIN_WIDTH, MAIN_LENGTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        addInfoPanes();
        stopLightThread = new ArrayList<>();

        for (StopLight stopLight : stopLights) {
            Thread thread = new Thread(stopLight);
            stopLightThread.add(thread);
        }

        for (Thread thread : stopLightThread) {
            thread.start();

        }
    }

    private void addInfoPanes() {
        functionLogicPane();
    }

   private void functionLogicPane() {

       JPanel buttonPanel1 = new JPanel(new GridLayout(1, 3));
       add(buttonPanel1, BorderLayout.SOUTH);
       JButton intersection1 = new JButton("Add Vehicle to Intersection 1");
       JButton intersection2 = new JButton("Add Vehicle to Intersection 2");
       JButton intersection3 = new JButton("Add Vehicle to Intersection 3");
       //JButton start = new JButton("Start");
       //JButton stop = new JButton("Stop");
       //JButton pause = new JButton("Pause");
       //JButton resume = new JButton("Resume");
       buttonPanel1.add(intersection1);
       buttonPanel1.add(intersection2);
       buttonPanel1.add(intersection3);
       //buttonPanel1.add(start);
       //buttonPanel1.add(stop);
       //buttonPanel1.add(pause);
       //buttonPanel1.add(resume);

       //text panels
       JPanel textbox = new JPanel(new GridLayout());
       add(textbox, BorderLayout.CENTER);
       JTextArea textbox1 = new JTextArea();
       JTextArea textbox2 = new JTextArea();
       JTextArea textbox3 = new JTextArea();
       textbox.add(textbox1, 0);
       textbox.add(textbox2, 1);
       textbox.add(textbox3, 2);

       //stoplight panels
       JPanel stopLightPanel = new JPanel(new GridBagLayout());
       GridBagConstraints gridBagConstraints = new GridBagConstraints();
       gridBagConstraints.gridx = 1;
       gridBagConstraints.ipadx = 50;

       //add stoplights
       stopLights = new ArrayList<>();
       StopLight stopLight1 = new StopLight("Stoplight 1");
       StopLight stopLight2 = new StopLight("Stoplight 2");
       StopLight stopLight3 = new StopLight("Stoplight 3");

       stopLights.add(stopLight1);
       stopLights.add(stopLight2);
       stopLights.add(stopLight3);

       for (int i = 0; i < 3; i++) {
           JLabel stoplightLabel = new JLabel(stopLights.get(i).getStoplightName());
           stoplightLabel.setHorizontalAlignment(JLabel.CENTER);
           stoplightLabel.setFont(new Font("Serif", Font.PLAIN, 20));

           gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
           gridBagConstraints.gridy = i * 2;
           gridBagConstraints.ipady = 0;
           stopLightPanel.add(stoplightLabel, gridBagConstraints);

           gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
           gridBagConstraints.gridy = i * 2 + 1;
           gridBagConstraints.ipady = 120;
           stopLightPanel.add(stopLights.get(i), gridBagConstraints);
       }

       add(stopLightPanel, BorderLayout.WEST);

       //timer
       JLabel timeLabel = new JLabel();
       final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

       timeLabel.setHorizontalAlignment(JLabel.CENTER);
       timeLabel.setFont(new Font("Serif", Font.PLAIN, 40));
       timeLabel.setPreferredSize(new Dimension(1000, 100));
       add(timeLabel, BorderLayout.NORTH);

       ActionListener timerListener = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Date date = new Date();
               String time = timeFormat.format(date);
               timeLabel.setText(time);
               //This code was to update the list of vehicles based on the light color, but I couldn't get it to work correctly.
               for (Car vehicle : Cars1) {
                   vehicle.changeSpeed(5);
                   vehicle.changeY(5);
                   System.out.println(vehicle.toString());
                   textbox1.setText(Cars1.toString());
               }
           }
       };

       //action listeners
       intersection1.addActionListener((ActionEvent e) -> {
           try {
               int numberOfCars = Cars1.size() + 1;
               Cars1.add(new Car(numberOfCars, 0, numberOfCars, 0));
               textbox1.setText(Cars1.toString());


           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Error");
           }
       });

       intersection2.addActionListener((ActionEvent e) -> {
           try {
               int numberOfCars = Cars2.size() + 1;
               Cars2.add(new Car(numberOfCars, 0, numberOfCars, 0));
               textbox2.setText(Cars2.toString());

           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Error");
           }
       });

       intersection3.addActionListener((ActionEvent e) -> {
           try {
               int NumberOfCars = Cars3.size() + 1;
               Cars3.add(new Car(NumberOfCars, 0, NumberOfCars, 0));
               textbox3.setText(Cars3.toString());

           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Error");
           }
       });

       //This was code for start, stop, pause, continue, but I couldn't get it to work correctly
/*       start.addActionListener((ActionEvent e) -> {
           try {

           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Unable to start threads");
           }
       });

       stop.addActionListener((ActionEvent e) -> {
           try {
               //TODO:code to stop threads
               for (StopLight stopLight : stopLights) {
                   stopLight.terminate();
               }

           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Unable to stop threads");
           }
       });

       pause.addActionListener((ActionEvent e) -> {
           try {
               //TODO:code to pause threads

           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Unable to pause threads");
           }
       });

       resume.addActionListener((ActionEvent e) -> {
           try {
               //TODO:code to resume threads

           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Unable to resume threads");
           }
       });*/

   }

    public static void main(String[] args) {
        new GUI();

    }
}
