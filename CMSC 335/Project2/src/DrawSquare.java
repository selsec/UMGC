/* CMSC 335 Project 2
 * Date: 14 November 2020
 * Author: Steven Thaw
 * Description: A class which extends JPanel and handles drawing a square using input provided from the GUI
 *
 */

import javax.swing.*;
import java.awt.*;

public class DrawSquare extends JPanel {
    private double length;

    public DrawSquare(double length) {
        this.length = length;
    }

    public void paint(Graphics g){
        g.fillRect(300, 300, (int)length, (int)length);
    }
}