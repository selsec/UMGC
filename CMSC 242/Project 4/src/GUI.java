 /*
  * A GUI class which is used to interface with the hashmap of the student class.
  * Author: Steve Thaw
  * CMIS 242 Intermediate Programming Final Project
  * Date: 22 Nov 19
  */
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent; //I actually don't understand why this was needed. I already added java.awt.*, so why wouldn't this also import since it is a child of awt??
 import java.util.*;


 public class GUI extends JFrame {
     //class variables
     private String name;
     private String major;
     private String option;
     private String studentID;
     //hash map for storing data
     HashMap<String, Student> studentData = new HashMap<>();

     //start gui construction
     private GUI() {
         //create the main panel and set the layout
         super("Steve's Student Extravaganza");
         JPanel mainPanel = new JPanel();
         mainPanel.setLayout(new GridLayout());
         mainPanel.setLayout(new GridBagLayout());
         GridBagConstraints components = new GridBagConstraints();
         //create labels for the text fields and combo box
         JLabel studentIDLabel = new JLabel("Student ID:");
         JLabel nameLabel = new JLabel("Student Name:");
         JLabel majorLabel = new JLabel("Assigned Major:");
         JLabel selectLabel = new JLabel("Select Operation");
         //create text boxes for labels and the button
         JTextField studentIDText = new JTextField(null);
         JTextField nameText = new JTextField(null);
         JTextField majorText = new JTextField(null);
         JButton operationButton = new JButton("Next");
         //create combo box and selections
         String[] comboBoxOptions = {"Add", "Delete", "Update", "Find"};
         JComboBox<String> operationComboBox = new JComboBox<>(comboBoxOptions);
         String[] gradeOptions = {"A", "B", "C", "D", "F"};
         String[] creditOptions = {"1", "2", "3", "4"};
         //now time to add the components to the panel
         components.fill = GridBagConstraints.HORIZONTAL;
         add(mainPanel);
         //id label
         components.gridx = 0;
         components.gridy = 0;
         mainPanel.add(studentIDLabel, components);
         //id text field
         components.gridx = 1;
         components.gridy = 0;
         mainPanel.add(studentIDText, components);
         //name label
         components.gridx = 0;
         components.gridy = 1;
         mainPanel.add(nameLabel, components);
         //name text field
         components.gridx = 1;
         components.gridy = 1;
         mainPanel.add(nameText, components);
         //major label
         components.gridx = 0;
         components.gridy = 2;
         mainPanel.add(majorLabel, components);
         //major text field
         components.gridx = 1;
         components.gridy = 2;
         mainPanel.add(majorText, components);
         //combo box selection label
         components.gridx = 0;
         components.gridy = 3;
         mainPanel.add(selectLabel, components);
         //combo box
         components.gridx = 1;
         components.gridy = 3;
         mainPanel.add(operationComboBox, components);
         //operation button
         components.gridx = 0;
         components.gridy = 4;
         mainPanel.add(operationButton, components);
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         setSize(300, 300);
         setLocationRelativeTo(null);
         setResizable(true);
         setVisible(true);
         //operation button handler
         operationButton.addActionListener((ActionEvent e) -> {
             //collects text in field and assigns to class variable
             studentID = studentIDText.getText();
             name = nameText.getText();
             major = majorText.getText();
             option = operationComboBox.getSelectedItem().toString();

             //check to see if student ID is empty
             try {
                 if (studentID.isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Please enter a Student ID!");
                     throw new NullPointerException();
                 }
                 else {
                     switch (option) {
                         //case for add
                         case "Add":
                             //checks to see if student id is already in database, adds student if it doesn't exist
                             if (studentData.containsKey(studentID)) {
                                 JOptionPane.showMessageDialog(null, "Student ID already exists, please use 'Update' option.");
                             } else {
                                 studentData.put(studentID, new Student(name, major));
                                 JOptionPane.showMessageDialog(null, "Operation Successful: Student Added");
                                 studentIDText.setText(null);
                                 nameText.setText(null);
                                 majorText.setText(null);

                             }
                             break;

                         //case for delete
                         case "Delete":
                             //checks to see if student id is in database, deletes student if it is
                             if (studentData.containsKey(studentID)) {
                                 studentData.remove(studentID);
                                 JOptionPane.showMessageDialog(null, "Operation Successful: Student Deleted");
                                 studentIDText.setText(null);
                                 nameText.setText(null);
                                 majorText.setText(null);
                             } else {
                                 JOptionPane.showMessageDialog(null, "Student ID does not exist, please use add feature");
                             }
                             break;

                         //case for update
                         case "Update":
                             //check to see if student id exists, if it does, gives dialog to add grade and number of credits, then calls courseCompleted() from Student class
                             if (studentData.containsKey(studentID)) {
                                 String grade = (String) JOptionPane.showInputDialog(null, "Enter Grade:", "Grade Selection", JOptionPane.QUESTION_MESSAGE , null, gradeOptions, gradeOptions[0]);
                                 if (grade != null) {
                                     String creditHours = (String) JOptionPane.showInputDialog(null, "Enter Credits:", "Credit Selection", JOptionPane.QUESTION_MESSAGE, null, creditOptions, creditOptions[0]);
                                     if (creditHours != null) {
                                         studentData.get(studentID).courseCompleted(grade, Integer.parseInt(creditHours));
                                         JOptionPane.showMessageDialog(null, "Update Complete");
                                         studentIDText.setText(null);
                                         nameText.setText(null);
                                         majorText.setText(null);
                                     } else {
                                         JOptionPane.showMessageDialog(null, "Credits were not entered");
                                     }
                                 } else {
                                     JOptionPane.showMessageDialog(null, "Grade was not entered");
                                 }
                             } else {
                                 JOptionPane.showMessageDialog(null, "Student ID Does Not Exist!");
                                 studentIDText.setText(null);
                                 nameText.setText(null);
                                 majorText.setText(null);
                             }
                             break;

                         //case for find
                         case "Find":
                             //checks to see if student id exists, and if it does, call the toString() method from the Student class
                             if (!studentData.containsKey(studentID)) {
                                 JOptionPane.showMessageDialog(null, "Student Does Not Exist!");
                             } else {
                                 studentData.get(studentID);
                                 String toString = studentData.get(studentID).toString();
                                 JOptionPane.showMessageDialog(null, "Current Student Data:\n" + toString);
                                 studentIDText.setText(null);
                                 nameText.setText(null);
                                 majorText.setText(null);
                             }
                             break;

                     }
                 }
             } catch (NullPointerException er) {
                 JOptionPane.showMessageDialog(null, "Please enter a Student ID!");
             }
         });
     }

    //run the program
    public static void main(String[] args) {
        new GUI();
     }
 }
