/* CMSC 350 Data Structures and Analysis
 * Project 1
 * Author: Steven Thaw
 * Date: 05/29/20
 * This is the main class of the program which will create the GUI and take user input to pass to the evaluator class
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; //I actually don't understand why this was needed. I already added java.awt.*, so why wouldn't this also import since it is a child of awt?

public class GUI extends JFrame {
    //required variables for user input
    public String userInput = "";
    public String result = "";
    Evaluator Input = new Evaluator();

    //start GUI construction
    private GUI() {
        //create main panel and set layout
        super("Steve's Prefix/Postfix Converter");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout());
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints components = new GridBagConstraints();
        //create labels for text fields and buttons
        JLabel enterExpressionLabel = new JLabel("Enter Expression: ");
        JLabel resultLabel = new JLabel("Result: ");
        //create text boxes and buttons
        JTextField enterExpressionText = new JTextField(null);
        JButton preToPostButton = new JButton("Prefix to Postfix");
        JButton postToPreButton = new JButton("Postfix to Prefix");
        JTextField resultText = new JTextField(null);
        //add components to panel
        components.fill = GridBagConstraints.HORIZONTAL;
        add(mainPanel);
        //expression label
        components.gridx = 0;
        components.gridy = 0;
        mainPanel.add(enterExpressionLabel, components);
        //expression text box
        components.gridx = 1;
        components.gridy = 0;
        mainPanel.add(enterExpressionText, components);
        //prefix to postfix button
        components.gridx = 0;
        components.gridy = 1;
        mainPanel.add(preToPostButton, components);
        //postfix to prefix button
        components.gridx = 1;
        components.gridy = 1;
        mainPanel.add(postToPreButton, components);
        //results label
        components.gridx = 0;
        components.gridy = 4;
        mainPanel.add(resultLabel, components);
        //results textbox
        components.gridx = 1;
        components.gridy = 4;
        mainPanel.add(resultText, components);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        //pre to post operation handler
        preToPostButton.addActionListener((ActionEvent e) ->{
            //collects text in field and stores in variable
            userInput = enterExpressionText.getText();
            //call prefix to postfix function
            try {
                resultText.setText("");
                resultText.setText(Input.preToPost(userInput));
            } catch (Exception ex) {
                SyntaxError.message();
            }
        });

        //post to pre operation handler
        postToPreButton.addActionListener((ActionEvent e) -> {
            //collects text in field and stores in variable
            userInput = enterExpressionText.getText();
            //call prefix to postfix function
            try {
                resultText.setText("");
                resultText.setText(Input.postToPre(userInput));
            } catch (Exception ex) {
                SyntaxError.message();
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
