/*
 * Main UI for the ATM GUI
 * Author: Steven Thaw
 * Date: 23 Oct 19
 * CMIS 242 Intermediate Programming Project 2
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import java.io.*;

public class UI {
    //private variables for UI
    private JPanel atmMain;
    private JButton depositButton;
    private JButton withdrawlButton;
    private JRadioButton checkingRadio;
    private JRadioButton savingsRadio;
    private JButton transferButton;
    private JButton balanceButton;
    private JTextField userInputField;
    private int accountSelection;
    private double delta;
    private int numTrans;
    private double checkBalance;



    public UI() {
        //instantiate objects for checking and savings accounts
        Account checking = new Account();
        Account savings = new Account();

        //radio buttons to select account
        checkingRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountSelection = 1;
            }
        });
        savingsRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountSelection = 2;
            }
        });
        //listener for deposit clicks
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delta = Double.parseDouble(userInputField.getText());
                if (accountSelection == 1 && delta > 0) { //checks account selection and verifies input is greater than 0
                    checking.makeDeposit(delta); //makes deposit
                    numTrans = checking.checkTransaction();
                    JOptionPane.showMessageDialog(null, "Deposit to Checking Account Successful");
                    if (numTrans >= 4) { //checks transaction count to determine if transaction fee should be applied
                        checking.makeWithdrawl(1.50);
                        JOptionPane.showMessageDialog(null, "Transaction Fee Charged");
                    }
                }
                else if (accountSelection == 2 && delta > 0){ //checks account selection and verifies input is greater than 0
                    savings.makeDeposit(delta); //makes deposit
                    numTrans = savings.checkTransaction();
                    JOptionPane.showMessageDialog(null, "Deposit to Savings Account Successful");
                    if (numTrans >= 4) { //checks transaction count to determine if transaction fee should be applied
                        savings.makeWithdrawl(1.50);
                        JOptionPane.showMessageDialog(null, "Transaction Fee Charged");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Deposit value must be greater than $0");
                }
            }
        });
        //listener for balance button
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (accountSelection == 1) {
                    userInputField.setText(String.valueOf(checking.getBalance())); //sets text field to equal current balance of checking account
                }
                else if (accountSelection == 2) {
                    userInputField.setText(String.valueOf(savings.getBalance())); //sets text field to equal current balance of savings account
                }
            }
        });
        //listener for withdrawl
        withdrawlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delta = Double.parseDouble(userInputField.getText());
                if (accountSelection == 1) {
                    checkBalance = checking.getBalance();
                    if (checkBalance < delta) { //provides exception for insufficient funds
                        JOptionPane.showMessageDialog(null, "Insufficient Funds");
                    }
                    else if (delta > 0) {
                        checking.makeWithdrawl(delta);
                        numTrans = checking.checkTransaction();
                        JOptionPane.showMessageDialog(null, "Withdrawl from Checking Account Successful");
                        if (numTrans > 4) {
                            checking.makeWithdrawl(1.50);
                            JOptionPane.showMessageDialog(null, "Transaction Fee Charged");
                        }
                    }
                }
                else if (accountSelection == 2) {
                    checkBalance = savings.getBalance();
                    if (checkBalance < delta) {
                        JOptionPane.showMessageDialog(null, "Insufficient Funds");
                    }
                    else if (delta > 0) {
                        savings.makeWithdrawl(delta);
                        numTrans = savings.checkTransaction();
                        JOptionPane.showMessageDialog(null, "Withdrawl from Savings Account Successful");
                        if (numTrans > 4) {
                            savings.makeWithdrawl(1.50);
                            JOptionPane.showMessageDialog(null, "Transaction Fee Charged");
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Withdrawl value must be greater than $0");
                }
            }
        });
        //listener for transfer
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delta = Double.parseDouble(userInputField.getText());
                if (accountSelection == 1) {
                    checkBalance = checking.getBalance();
                    if (checkBalance < delta) {
                        JOptionPane.showMessageDialog(null, "Insufficient Funds");
                    }
                    else if (delta > 0) {
                        checking.makeWithdrawl(delta); //makes withdrawl from checking
                        savings.makeDeposit(delta); //makes deposit into savings
                        numTrans = checking.checkTransaction();
                        JOptionPane.showMessageDialog(null, "Transfer from Checking to Savings Complete");
                        if (numTrans > 4) {  //checks transactions
                            checking.makeWithdrawl(1.50);
                            JOptionPane.showMessageDialog(null, "Transaction Fee Charged");
                        }
                    }
                }
                else if (accountSelection == 2) {
                    checkBalance = savings.getBalance();
                    if (checkBalance < delta) {
                        JOptionPane.showMessageDialog(null, "Insufficient Funds");
                    }
                    else if (delta > 0) {
                        savings.makeWithdrawl(delta);
                        checking.makeDeposit(delta);
                        JOptionPane.showMessageDialog(null, "Transfer from Savings to Checking Complete");
                        numTrans = savings.checkTransaction();
                        if (numTrans > 4) {
                            savings.makeWithdrawl(1.50);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Transfer value must be greater than $0");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UI");
        frame.setContentPane(new UI().atmMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
