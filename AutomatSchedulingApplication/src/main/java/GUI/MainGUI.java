package GUI;

import Calendar.client.ViewAppointmentGUI;
import Login.client.LoginGUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JButton openLoginGUIButton;
    private JButton openAppButton;
    private LoginGUI loginGUI;
    private ViewAppointmentGUI viewAppGUI;

    public MainGUI() {
        setTitle("Automated Scheduling applications");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a button to open the second GUI
        openLoginGUIButton = new JButton("Login");
        openLoginGUIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create the Controller GUI
                loginGUI = new LoginGUI(MainGUI.this);
                // show the Controller GUI
                loginGUI.setVisible(true);
                // hide the First GUI
                MainGUI.this.setVisible(false);
            }
        });
        openAppButton = new JButton("View Appointment");
        openAppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create the Controller GUI
                viewAppGUI = new ViewAppointmentGUI(MainGUI.this);
                // show the Controller GUI
                viewAppGUI.setVisible(true);
                // hide the First GUI
                MainGUI.this.setVisible(false);
            }
        });


        // add the buttons to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(openLoginGUIButton);
        panel.add(openAppButton );
        add(panel);

        // add the panel to the main frame using GridBagLayout
        setLayout(new GridBagLayout());
        add(panel, new GridBagConstraints());


        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // method to show the Main GUI and close the Controller GUI
    public void showMainGUI() {
        setVisible(true);
        loginGUI.dispose();
        viewAppGUI.dispose();
    }

    public static void main(String[] args) {
        new MainGUI();
    }

}

