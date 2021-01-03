/*
 * UI elements for Fibonacci Sequencer. Contains all elements and listeners required for the Sequence class
 * Also prints Fibonacci Sequence to file on exit
 * Author: Steven Thaw
 * Date: 9 Nov 19
 * CMIS 242: Intermediate Programming Project 3
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UI {
    private JPanel fibonacciSequencer;
    private JRadioButton iterative;
    private JRadioButton recursive;
    private JTextField efficiencyTextField;
    private JTextField resultTextField;
    private JTextField enterNTextField;
    private JButton calculateButton;
    private JLabel enterN;
    private JLabel endResult;
    private JLabel efficiency;
    private JButton button1;
    private int methodSelection;
    private long maxNumber;
    private long complete;
    private long efficiencyIndex;


    public UI() {

        iterative.setSelected(true); //make iterative the default selection
        resultTextField.setEditable(false); //make the result text field uneditable
        efficiencyTextField.setEditable(false); //make the efficiency text field uneditable

        iterative.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methodSelection = 1;

            }
        });
        recursive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methodSelection = 2;
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (methodSelection == 1) {
                        maxNumber = Long.parseLong(enterNTextField.getText());
                        complete = Sequence.computeIterativelyResult(maxNumber);
                        efficiencyIndex = Sequence.computeIterativelyIndex(maxNumber);
                        resultTextField.setText(String.valueOf(complete));
                        efficiencyTextField.setText(String.valueOf(efficiencyIndex));
                    } else if (methodSelection == 2) {
                        maxNumber = Long.parseLong(enterNTextField.getText());
                        complete = Sequence.computeRecursiveResult(maxNumber);
                        efficiencyIndex = Sequence.computeRecursiveIndex(maxNumber, 0);
                        resultTextField.setText(String.valueOf(complete));
                        efficiencyTextField.setText(String.valueOf(efficiencyIndex));
                    }
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Please enter an Integer!");
                }
            }
        });

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("UI");

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                try {
                    Sequence.calculateOnClose();
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "File Not Found!");
                }

            }
        }, "Shutdown-thread"));

        frame.setContentPane(new UI().fibonacciSequencer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}