/* CMSC 335 Project 2
 * Date: 14 November 2020
 * Author: Steven Thaw
 * Description: A class which extends JPanel and handles drawing a circle using input provided from the GUI
 *
 */

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JPanel {
    double radius;

    public DrawCircle(double radius){
        this.radius = radius;
    }
    public void paint(Graphics g){
        g.fillOval(300, 300, (int)radius, (int)radius);
    }
}
