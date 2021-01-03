/* CMSC 335 Object Oriented and Concurrent Programming
 * Date: 12 Dec 2020
 * Author: Steve Thaw
 * Description: A class to handle creation of traffic lights and a color map for retriving the current color
 */

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StopLight extends JPanel implements Runnable{

    final Color redLight = Color.RED;
    final Color greenLight = Color.GREEN;
    final Color yellowLight = Color.YELLOW;

    private final static Map<String, String> COLOR_MAP;

    private Color color;
    private final String name;
    private boolean running = true;

    static {
        COLOR_MAP = new HashMap<>();
        COLOR_MAP.put("java.awt.Color[r=0,g=255,b=0]", "Green");
        COLOR_MAP.put("java.awt.Color[r=255,g=255,b=0]", "Yellow");
        COLOR_MAP.put("java.awt.Color[r=255,g=0,b=0]", "Red");
    }

    public StopLight(String name) {
        Random random = new Random();
        int colorChoice = random.nextInt(100);

        if (colorChoice < 33) {
            this.color = greenLight;
        } else if (colorChoice < 66) {
            this.color = yellowLight;
        } else {
            this.color = redLight;
        }

        this.name = name;
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setName(name);
        repaint();
    }

    public synchronized void changeColor() {
        if (redLight.equals(color)) {
            this.color = greenLight;
        } else if (greenLight.equals(color)) {
            this.color = yellowLight;
        } else {
            this.color = redLight;
        }

        repaint();
    }

    public synchronized String getColor() {
        return COLOR_MAP.get(color.toString());
    }

    public synchronized String getStoplightName() {
        return name;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, getWidth(), getHeight());
    }

    public void terminate() {
        running = false;
    }

    public void run() {
        while (running) {
            try {
                if (greenLight.equals(color)) {
                    Thread.sleep(10000); // green for 10 seconds
                } else if (yellowLight.equals(color)) {
                    Thread.sleep(2000);  // yellow for 2 seconds
                } else if (redLight.equals(color)) {
                    Thread.sleep(12000); // red for 12 seconds
                }
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }

            changeColor();
        }
    }
}