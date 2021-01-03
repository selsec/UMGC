/* CMSC 335 Project 2
 * Date: 14 November 2020
 * Author: Steven Thaw
 * Description: A class which extends JPanel and handles drawing a triangle using input provided from the GUI
 * Because there is no "draw triangle" method in Graphics, points of the triangle must be stored in an array and passed to
 * the fillPolygon() method
 */


import javax.swing.*;
import java.awt.*;

public class DrawTriangle extends JPanel {
    private double base;
    private double height;


    public DrawTriangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    public void paint(Graphics g){
        int xPoints[] = {250, (250 - ((int)Math.round(base)/2)), 250 + ((int)Math.round(base)/2)};
        int yPoints[] = {100, (int)Math.round(height) + 100, (int)Math.round(height) + 100};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}