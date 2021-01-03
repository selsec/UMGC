/* CMSC Project 4
 * Date: 12 July 2020
 * Author: Steven Thaw
 * Description: Creates a GUI which will allow the user to select an input file, and then displays the
 * output of parenthesizedList, Hierarchy, as well as unreachable verticies and all the verticies.
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent; //I actually don't understand why this was needed. I already added java.awt.*, so why wouldn't this also import since it is a child of awt?

public class GUI extends JFrame {

    //start GUI construction
    private GUI() {

        //create main panel and set layout
        super("CMSC 350 Project 4: Graphs");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout());
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints components = new GridBagConstraints();
        JButton selectFile = new JButton("Select File");
        JLabel parenthesizedLabel = new JLabel("Parenthesized Graph:");
        JTextField parenthesizedText = new JTextField();
        JLabel hierarchyLabel = new JLabel("Hierarchy Output:");
        JTextArea hierarchyText = new JTextArea();
        JLabel unreachableLabel = new JLabel("Unreachable Verticies:");
        JTextArea unreachableText = new JTextArea();
        JLabel outLabel = new JLabel("All Verticies:");
        JTextArea outText = new JTextArea();
        components.fill = GridBagConstraints.HORIZONTAL;
        add(mainPanel);
        //select file button
        components.gridx = 0;
        components.gridy = 0;
        mainPanel.add(selectFile, components);
        //parenthesized label
        components.gridx = 0;
        components.gridy = 1;
        mainPanel.add(parenthesizedLabel, components);
        //parenthesized text area
        components.gridx = 0;
        components.gridy = 2;
        mainPanel.add(parenthesizedText, components);
        //hierarchy label
        components.gridx = 0;
        components.gridy = 3;
        mainPanel.add(hierarchyLabel, components);
        //hierarchy text area
        components.gridx = 0;
        components.gridy = 4;
        mainPanel.add(hierarchyText, components);
        //unreachable label
        components.gridx = 0;
        components.gridy = 5;
        mainPanel.add(unreachableLabel, components);
        //unreachable text area
        components.gridx = 0;
        components.gridy = 6;
        mainPanel.add(unreachableText, components);
        //output label
        components.gridx = 1;
        components.gridy = 1;
        mainPanel.add(outLabel, components);
        //output text area
        components.gridx = 1;
        components.gridy = 2;
        mainPanel.add(outText, components);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        //action listener for file selection
        selectFile.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setCurrentDirectory(new File("."));
            int userInput = fileChooser.showOpenDialog(fileChooser.getParent());
            if (userInput == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Scanner fileIn = new Scanner(file);
                    //Instantiate and create graph
                    DirectedGraph<String> graph = new DirectedGraph<>();
                    while (fileIn.hasNextLine()) {
                        parseVertexString(fileIn.nextLine(), graph);
                    }
                    DFSActionsInterface<String> parenthesizedList = new ParenthesizedList<>();
                    DFSActionsInterface<String> hierarchy = new Hierarchy<>();
                    graph.performDFS(parenthesizedList);
                    graph.performDFS(hierarchy);
                    parenthesizedText.setText(null);
                    parenthesizedText.setText(String.valueOf(parenthesizedList));
                    hierarchyText.setText(null);
                    hierarchyText.append(String.valueOf(hierarchy));
                    unreachableText.setText(null);
                    unreachableText.append(String.valueOf(graph.unreachable()));
                    outText.setText(null);
                    outText.append(String.valueOf(graph));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please select a valid file");
                }
            }
        });
    }

    //create edges from string
    private static void parseVertexString(String fileLine, DirectedGraph<String> graph) {
        String[] toArray = fileLine.split(" ");
        for (int i = 1; i < toArray.length; i++) {
            graph.createEdge(toArray[0], toArray[i]);
        }
    }

    //main
    public static void main(String[] args) throws Exception {
        new GUI();
    }

}
