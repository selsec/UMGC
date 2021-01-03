/*
* Basic light control program to demonstrate the creation of a UI using buttons
* Author: Steve Thaw
* Date: 23 Oct 19
* CMIS 242 Intermediate Programming
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//create UI class
public class UI {
    //UI private variables
    private JLabel kitchenLightLabel;
    private JLabel livingLightLabel;
    private JLabel bedroomLight;
    private JButton kitchenOn;
    private JButton kitchenOff;
    private JButton livingRoomOn;
    private JButton livingRoomOff;
    private JButton bedroomOn;
    private JButton bedroomOff;
    private JPanel panelMain;
    private JTextField kitchenTextField;
    private JTextField livingRoomTextField;
    private JTextField bedroomTextField;
    private JButton submit;
    private JButton getCurrent;
    private int kitchenBright;
    private int livingRoomBright;
    private int bedroomBright;

    //UI constructor
    public UI() {
        Lights kitchen = new Lights();
        Lights bedroom = new Lights();
        Lights livingRoom = new Lights();
        //listeners for mouse clicks, set object power to true or false, display message confirming action
        kitchenOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kitchen.setPower(true);
                JOptionPane.showMessageDialog(null, "Turning Kitchen Lights ON");
            }

        });
        kitchenOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kitchen.setPower(false);
                JOptionPane.showMessageDialog(null, "Turning Kitchen Lights OFF");
            }

        });
        livingRoomOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                livingRoom.setPower(true);
                JOptionPane.showMessageDialog(null, "Turning Living Room Lights ON");
            }

        });
        livingRoomOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                livingRoom.setPower(false);
                JOptionPane.showMessageDialog(null, "Turning Living Room Lights OFF");
            }

        });
        bedroomOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bedroom.setPower(true);
                JOptionPane.showMessageDialog(null, "Turning Bedroom Lights ON");
            }

        });
        bedroomOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bedroom.setPower(true);
                JOptionPane.showMessageDialog(null, "Turning Bedroom Lights OFF");
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kitchenBright = Integer.parseInt(kitchenTextField.getText());
                livingRoomBright = Integer.parseInt(livingRoomTextField.getText());
                bedroomBright = Integer.parseInt(bedroomTextField.getText());

                kitchen.setBrightness(kitchenBright);
                livingRoom.setBrightness(livingRoomBright);
                bedroom.setBrightness(bedroomBright);

            }
        });
        getCurrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kitchenTextField.setText(String.valueOf(kitchen.getBrightness()));
                livingRoomTextField.setText(String.valueOf(livingRoom.getBrightness()));
                bedroomTextField.setText(String.valueOf(bedroom.getBrightness()));

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UI");
        frame.setContentPane(new UI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
