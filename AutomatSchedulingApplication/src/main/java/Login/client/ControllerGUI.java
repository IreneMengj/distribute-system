package Login.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Login.ds.service1.Service1Grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class ControllerGUI extends JFrame implements ActionListener {


    private JTextField entry1, entry2, reply;
    private JComboBox<String> dropdown;

    private JPanel getService1JPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        JLabel label1 = new JLabel("Username");
        panel.add(label1);
        JTextField entry1 = new JTextField(10);
        panel.add(entry1);

        JLabel label2 = new JLabel("Password");
        panel.add(label2);
        JTextField entry2 = new JTextField(10);
        panel.add(entry2);

        JLabel label3 = new JLabel("Login Type");
        panel.add(label3);
        JComboBox<String> dropdown = new JComboBox<String>();
        dropdown.addItem("Log in");
        dropdown.addItem("Sign up");
        dropdown.addActionListener(this);
        panel.add(dropdown);

        JLabel label4 = new JLabel("Result");
        panel.add(label4);
        JTextField reply = new JTextField(15);
        panel.add(reply);

        this.entry1 = entry1;
        this.entry2 = entry2;
        this.reply = reply;
        this.dropdown = dropdown;

        return panel;
    }

    public static void main(String[] args) {

        ControllerGUI gui = new ControllerGUI();

        gui.build();
    }
    public void showGUI(boolean visible) {
        setVisible(visible);
    }

    private void build() {

        JFrame frame = new JFrame("Log in");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add(getService1JPanel());


        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> dropdown = (JComboBox<String>) e.getSource();
        String selectedOption = (String) dropdown.getSelectedItem();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        Service1Grpc.Service1BlockingStub blockingStub = Service1Grpc.newBlockingStub(channel);
        //preparing message to send
        String username = entry1.getText();
        String password = entry2.getText();
        Login.ds.service1.RequestMessage request = Login.ds.service1.RequestMessage.newBuilder().setUsername(username).setPassword(password).build();

        if (selectedOption.equals("Log in")) {
            System.out.println("RPC LOGIN to be invoked ...");
            /*
             *
             */
            Login.ds.service1.ResponseMessage response = blockingStub.login(request);
            //retreving reply from Login.service
            int code = response.getCode();
            if (code == 1) {
                reply.setText("Login successfully");
            } else {
                reply.setText("Login unsuccessfully.");
            }
        } else if (selectedOption.equals("Sign up")) {
            System.out.println("RPC Signup to be invoked ...");
            /*
             *
             */
            //retreving reply from Login.service
            Login.ds.service1.ResponseMessage response = blockingStub.signup(request);
            int code = response.getCode();
            if (code == 1) {
                reply.setText("Sign up successfully");
            } else {
                reply.setText("Username taken. Try again.");
            }
        }

    }
}


