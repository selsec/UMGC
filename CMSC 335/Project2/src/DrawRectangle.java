/* CMSC 335 Project 2
 * Date: 14 November 2020
 * Author: Steven Thaw
 * Description: A class which extends JPanel and handles drawing a rectangle using input provided from the GUI
 *
 */

import javax.swing.*;
import java.awt.*;

public class DrawRectangle extends JPanel {
    private double length;
    private double width;

    public DrawRectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public void paint(Graphics g){
        g.fillRect(300, 300, (int)length, (int)width);
    }
}
