package GUI;

import Login.client.ControllerGUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JButton openLoginGUIButton;
    private ControllerGUI controllerGUI;

    public MainGUI() {
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a button to open the second GUI
        openLoginGUIButton = new JButton("Login");
        openLoginGUIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create the Controller GUI
                controllerGUI = new ControllerGUI(MainGUI.this);
                // show the Controller GUI
                controllerGUI.setVisible(true);
                // hide the First GUI
                MainGUI.this.setVisible(false);
            }
        });


        // add the buttons to the frame
        JPanel panel = new JPanel();
        panel.add(openLoginGUIButton);
        add(panel);

        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // method to show the First GUI and close the Controller GUI
    public void showFirstGUI() {
        setVisible(true);
        controllerGUI.dispose();
    }






    public static void main(String[] args) {
        new MainGUI();
    }

}

