/* CMSC 350 Data Structures and Analysis Project 3
 * Author: Steven Thaw
 * Date: 27 Apr 2020
 * This is the main class of the program which will create the GUI and take user input to create the tree and perform
 * operations to determine if tree is balanced, full, proper, and determine the height, number of nodes, and print out
 * the in-order traversal of the tree.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; //I actually don't understand why this was needed. I already added java.awt.*, so why wouldn't this also import since it is a child of awt?

public class GUI extends JFrame {
    //required variables for user input
    private static BinaryTree inputTree;
    ImageIcon icon = new ImageIcon("icon.jpg");

    //start GUI construction
    private GUI() {
        //create main panel and set layout
        super("CMSC 350 Project 3: Binary Trees");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout());
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints components = new GridBagConstraints();
        //create labels for text fields and buttons
        JLabel userInput = new JLabel("Input: ");
        JLabel outputLabel = new JLabel("Result: ");
        //create text boxes and buttons
        JTextField input = new JTextField(50);
        JButton makeTree = new JButton("Make Tree");
        JButton isBalanced = new JButton("Is Balanced?");
        JButton isFull = new JButton("Is Full?");
        JButton isProper = new JButton("Is Proper?");
        JButton height = new JButton("Height");
        JButton nodes = new JButton("Number of Nodes");
        JButton inOrder = new JButton("In Order");
        JTextField output = new JTextField(50);
        //add components to panel
        components.fill = GridBagConstraints.HORIZONTAL;
        add(mainPanel);
        //user input label
        components.gridx = 2;
        components.gridy = 0;
        mainPanel.add(userInput, components);
        //user input text box
        components.gridx = 3;
        components.gridy = 0;
        mainPanel.add(input, components);
        //make tree button
        components.gridx = 0;
        components.gridy = 1;
        mainPanel.add(makeTree, components);
        //balanced button
        components.gridx = 1;
        components.gridy = 1;
        mainPanel.add(isBalanced, components);
        //full button
        components.gridx = 2;
        components.gridy = 1;
        mainPanel.add(isFull, components);
        //proper button
        components.gridx = 3;
        components.gridy = 1;
        mainPanel.add(isProper, components);
        //height button
        components.gridx = 4;
        components.gridy = 1;
        mainPanel.add(height, components);
        //nodes button
        components.gridx = 5;
        components.gridy = 1;
        mainPanel.add(nodes, components);
        //in order button
        components.gridx = 6;
        components.gridy = 1;
        mainPanel.add(inOrder, components);
        //output label
        components.gridx = 2;
        components.gridy = 4;
        mainPanel.add(outputLabel, components);
        //output textbox
        components.gridx = 3;
        components.gridy = 4;
        mainPanel.add(output, components);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 150);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);


        //make tree
        makeTree.addActionListener((ActionEvent e) -> {
            try {
                output.setText("");
                inputTree = new BinaryTree(input.getText());
                output.setText(inputTree.toString());
            }
            catch (InvalidTreeSyntax except) {
                JOptionPane.showMessageDialog(getParent(),except.getMessage());
            }catch (IndexOutOfBoundsException indexExcept) {
                JOptionPane.showMessageDialog(null, "Hey Laser Lips, Need Input!", "Input Error", 0, icon);
            }
        });

        //isBalanced operation handler
        isBalanced.addActionListener((ActionEvent e) -> {
            try {
                output.setText("");
                output.setText(String.valueOf(inputTree.isBalanced()));
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Binary Tree is Empty");
            }
        });

        //isFull operation handler
        isFull.addActionListener((ActionEvent e) -> {
            try {
                output.setText("");
                output.setText(String.valueOf(inputTree.isFull()));
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Binary Tree is Empty");
            }
        });

        //isProper operation handler
        isProper.addActionListener((ActionEvent e) -> {
            try {
                output.setText("");
                output.setText(String.valueOf(inputTree.isProper()));
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Binary Tree is Empty");
            }
        });

        //height operation handler
        height.addActionListener((ActionEvent e) -> {
            try {
                output.setText("");
                output.setText(String.valueOf(inputTree.height()));
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Binary Tree is Empty");
            }
        });

        //nodes operation handler
        nodes.addActionListener((ActionEvent e) -> {
            try {
                output.setText("");
                output.setText(String.valueOf(inputTree.numNodes()));
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Binary Tree is Empty");
            }

        });

        //inOrder operation handler
        inOrder.addActionListener((ActionEvent e) -> {
            try {
                output.setText("");
                output.setText(String.valueOf(inputTree.inOrder()));
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Binary Tree is Empty");
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
