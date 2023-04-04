import Login.client.ControllerGUI;
import Login.ds.service1.Service1Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FirstGUI extends JFrame {
    private JButton openLoginGUIButton;
    private ControllerGUI controllerGUI;

    public FirstGUI() {
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a button to open the second GUI
        openLoginGUIButton = new JButton("Login");
        openLoginGUIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create the Controller GUI
                controllerGUI = new ControllerGUI(FirstGUI.this);
                // show the Controller GUI
                controllerGUI.setVisible(true);
                // hide the First GUI
                FirstGUI.this.setVisible(false);
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



   class ControllerGUI extends JFrame implements ActionListener {


        private JTextField entry1, entry2, reply;
        private JComboBox<String> dropdown;
        private FirstGUI firstGUI;

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

        public ControllerGUI(FirstGUI firstGUI) {
            this.firstGUI = firstGUI;
            setTitle("Login");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
            panel.add(getService1JPanel());

            // create a button to go back to the First GUI
            JButton backButton = new JButton("Back to Main Menu");
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // show the First GUI
                    firstGUI.showFirstGUI();
                }
            });

            panel.add(backButton); // add the backButton to the panel

            add(panel);

            setSize(600, 300);
            setLocationRelativeTo(null);
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


    public static void main(String[] args) {
        new FirstGUI();
    }

}

