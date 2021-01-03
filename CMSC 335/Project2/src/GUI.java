/* CMSC 335 Object Oriented and Concurrent Programming Project 2
 * Author: Steven Thaw
 * Date: 14 Nov 2020
 * This is the main class of the program which will create the GUI and allow the user to choose a shape to draw
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; //I actually don't understand why this was needed. I already added java.awt.*, so why wouldn't this also import since it is a child of awt?
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUI extends JFrame {
    //required variables for user input
    //start GUI construction
    private GUI() {
        //create main panel and set layout
        super("CMSC 335 Project 2: Draw Shapes");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout());
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints components = new GridBagConstraints();
        //create label
        JLabel userInput = new JLabel("Please press a button to draw a shape: ");
        //create text boxes and buttons
        JButton drawCircle = new JButton("Draw Circle");
        JButton drawCone = new JButton("Draw Cone");
        JButton drawCube = new JButton("Draw Cube");
        JButton drawCylinder = new JButton("Draw Cylinder");
        JButton drawRectangle = new JButton("Draw Rectangle");
        JButton drawSphere = new JButton("Draw Sphere");
        JButton drawSquare = new JButton("Draw Square");
        JButton drawTorus = new JButton("Draw Torus");
        JButton drawTriangle = new JButton("Draw Triangle");
        //add components to panel
        components.fill = GridBagConstraints.HORIZONTAL;
        add(mainPanel);
        //user input label
        components.gridx = 3;
        components.gridy = 0;
        mainPanel.add(userInput, components);
        //Circle
        components.gridx = 1;
        components.gridy = 1;
        mainPanel.add(drawCircle, components);
        //Cone
        components.gridx = 2;
        components.gridy = 1;
        mainPanel.add(drawCone, components);
        //Cube
        components.gridx = 3;
        components.gridy = 1;
        mainPanel.add(drawCube, components);
        //Cylinder
        components.gridx = 4;
        components.gridy = 1;
        mainPanel.add(drawCylinder, components);
        //Rectangle
        components.gridx = 5;
        components.gridy = 1;
        mainPanel.add(drawRectangle, components);
        //Sphere
        components.gridx = 1;
        components.gridy = 2;
        mainPanel.add(drawSphere, components);
        //Square
        components.gridx = 2;
        components.gridy = 2;
        mainPanel.add(drawSquare, components);
        //Torus
        components.gridx = 3;
        components.gridy = 2;
        mainPanel.add(drawTorus, components);
        //Triangle
        components.gridx = 4;
        components.gridy = 2;
        mainPanel.add(drawTriangle, components);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);


        //build circle
        drawCircle.addActionListener((ActionEvent e) -> {
            try {
                double radius = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Radius:"));
                Circle circle = new Circle(radius);
                JFrame circleFrame = new JFrame("Circle");
                circleFrame.add(new DrawCircle(circle.getRadius()));
                circleFrame.setSize(600, 600);
                circleFrame.setLocationRelativeTo(null);
                circleFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

        //build Cone
        drawCone.addActionListener((ActionEvent e) -> {
            try {
                double radius = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Radius:"));
                double height = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Height:"));
                Cone cone = new Cone(radius, height);
                JFrame coneFrame = new JFrame("Cone");
                JLabel coneImage = new JLabel(cone.coneImage);
                coneFrame.add(coneImage);
                coneImage.setVisible(true);
                coneImage.setSize(700, 700);
                coneFrame.setSize(700, 700);
                coneFrame.setLocationRelativeTo(null);
                coneFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

        //cube action listener
        drawCube.addActionListener((ActionEvent e) -> {
            try {
                double length = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Length:"));
                Cube cube = new Cube(length);
                JFrame cubeFrame = new JFrame("Cube");
                JLabel cubeImage = new JLabel(cube.cubeImage);
                cubeFrame.add(cubeImage);
                cubeImage.setVisible(true);
                cubeImage.setSize(1000, 1000);
                cubeFrame.setSize(1000, 1000);
                cubeFrame.setLocationRelativeTo(null);
                cubeFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

        //cylinder action listener done
        drawCylinder.addActionListener((ActionEvent e) -> {
            try {
                double height = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Height:"));
                double radius = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Radius:"));
                Cylinder cylinder = new Cylinder(height, radius);
                JFrame cylinderFrame = new JFrame("Cylinder");
                JLabel cylinderImage = new JLabel(cylinder.cylinderImage);
                cylinderFrame.add(cylinderImage);
                cylinderImage.setVisible(true);
                cylinderImage.setSize(600, 600);
                cylinderFrame.setSize(600, 600);
                cylinderFrame.setLocationRelativeTo(null);
                cylinderFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

        //rectangle action listener done
        drawRectangle.addActionListener((ActionEvent e) -> {
            try {
                double length = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Length:"));
                double width = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Width:"));
                Rectangle rectangle = new Rectangle(length, width);
                JFrame rectangleFrame = new JFrame("Rectangle");
                rectangleFrame.add(new DrawRectangle(rectangle.getLength(), rectangle.getWidth()));
                rectangleFrame.setSize(600, 600);
                rectangleFrame.setLocationRelativeTo(null);
                rectangleFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

        //sphere action listener done
        drawSphere.addActionListener((ActionEvent e) -> {
            try {
                double radius = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Radius:"));
                Sphere sphere = new Sphere(radius);
                JFrame sphereFrame = new JFrame("Sphere");
                JLabel sphereImage = new JLabel(sphere.sphereImage);
                sphereFrame.add(sphereImage);
                sphereImage.setVisible(true);
                sphereImage.setSize(600, 600);
                sphereFrame.setSize(600, 600);
                sphereFrame.setLocationRelativeTo(null);
                sphereFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

        //square action listener done
        drawSquare.addActionListener((ActionEvent e) -> {
            try {
                double length = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Length:"));
                Square square = new Square(length);
                JFrame squareFrame = new JFrame("Square");
                squareFrame.add(new DrawSquare(square.getLength()));
                squareFrame.setSize(600, 600);
                squareFrame.setLocationRelativeTo(null);
                squareFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

        //Torus action listener
        drawTorus.addActionListener((ActionEvent e) -> {
            try {
                double majorRaduis = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Major Radius:"));
                double minorRadius = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Minor Radius:"));
                Torus torus = new Torus(majorRaduis, minorRadius);
                JFrame torusFrame = new JFrame("Torus");
                JLabel torusImage = new JLabel(torus.torusImage);
                torusFrame.add(torusImage);
                torusImage.setVisible(true);
                torusImage.setSize(600, 600);
                torusFrame.setSize(600, 600);
                torusFrame.setLocationRelativeTo(null);
                torusFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

        //triangle action listener
        drawTriangle.addActionListener((ActionEvent e) -> {
            try {
                double base = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Base:"));
                double height = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Height:"));
                Triangle triangle = new Triangle(base, height);
                JFrame triangleFrame = new JFrame("Triangle");
                triangleFrame.add(new DrawTriangle(triangle.getBase(), triangle.getHeight()));
                triangleFrame.setSize(600, 600);
                triangleFrame.setLocationRelativeTo(null);
                triangleFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter input in the correct format!");
            }
        });

    }

    public static void main(String[] args) {
        new GUI();
    }
}
