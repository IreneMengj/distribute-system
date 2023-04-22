package Login.client;

import GUI.MainGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import GUI.MainGUI;
import Login.ds.service1.RequestMessage;
import Login.ds.service1.ResponseMessage;
import Login.ds.service1.Service1Grpc;

import io.grpc.*;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;


public class LoginGUI extends JFrame implements ActionListener {


    private JTextField entry1, entry2, reply;
    private JComboBox<String> dropdown;
    private MainGUI mainGUI;
    String serviceType = "_grpc._tcp.local.";
    String serviceName = "service1";

    public JPanel getService1JPanel() {
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

    public LoginGUI(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
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
                try {
                    mainGUI.showMainGUI();
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null,"Error caught: "+ex.getMessage());
                }
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
        // Discover gRPC service with JmDNS
        JmDNS jmdns = null;
        InetAddress inetAddress = null;
        try {
            jmdns = JmDNS.create();
           inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        ServiceInfo serviceInfo = jmdns.getServiceInfo(serviceType, serviceName);
        if (serviceInfo == null) {
            JOptionPane.showMessageDialog(null,"Could not find service with name " + serviceName);
            return;
        }

        ManagedChannel channel = ManagedChannelBuilder.forAddress(inetAddress.getHostAddress(), serviceInfo.getPort()).usePlaintext().build();
        try {
            // Call gRPC service methods here
            // asynchronism stub
            Service1Grpc.Service1Stub service1Stub = Service1Grpc.newStub(channel);
            //preparing message to send
            String username = entry1.getText();
            String password = entry2.getText();
            Login.ds.service1.RequestMessage request = Login.ds.service1.RequestMessage.newBuilder().setUsername(username).setPassword(password).build();
            if (selectedOption.equals("Log in")) {
                System.out.println("RPC LOGIN to be invoked ...");
                StreamObserver<ResponseMessage> responseObserver = new StreamObserver<ResponseMessage>() {
                    @Override
                    public void onNext(ResponseMessage response) {
                        // Handle response
                        int code = response.getCode();
                        if (code == 1) {
                            reply.setText("Login successfully");
                        } else if (code == 0) {
                            reply.setText("Sign up first.");
                        } else {
                            reply.setText("Wrong username or password");
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        // Handle error
                        // Handle error
                        Status status = Status.fromThrowable(t);
                        if (status.getCode() == Status.Code.CANCELLED) {
                            reply.setText("The request was cancelled.");
                        } else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                            reply.setText("The request deadline was exceeded.");
                        } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                            reply.setText("The request was not authenticated.");
                        } else {
                            reply.setText("An error occurred: " + t.getMessage());
                        }
                    }

                    @Override
                    public void onCompleted() {
                        // Handle completion
                    }
                };

                StreamObserver<RequestMessage> requestObserver = service1Stub.login(responseObserver);
                requestObserver.onNext(request);
                // Call onNext() multiple times to send multiple requests
                requestObserver.onCompleted();

            } else if (selectedOption.equals("Sign up")) {
                System.out.println("RPC Signup to be invoked ...");

                // Handle response
                StreamObserver<ResponseMessage> responseObserver = new StreamObserver<ResponseMessage>() {
                    @Override
                    public void onNext(ResponseMessage response) {
                        int code = response.getCode();
                        if (code == 1) {
                            reply.setText("Sign up successfully");
                        } else if(code==0) {
                            reply.setText("Username taken. Try again.");
                        } else if(code==3){
                            JOptionPane.showMessageDialog(null,
                                    "Password should have at least one digit,one uppercase," +
                                            "one lowercase and one special character ");
                        } else {
                            reply.setText("Both length must be over 8");
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        // Handle error
                        Status status = Status.fromThrowable(t);
                        if (status.getCode() == Status.Code.CANCELLED) {
                            reply.setText("The request was cancelled.");
                        } else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                            reply.setText("The request deadline was exceeded.");
                        } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                            reply.setText("The request was not authenticated.");
                        } else {
                            reply.setText("An error occurred: " + t.getMessage());
                        }
                    }

                    @Override
                    public void onCompleted() {
                        // Handle completion
                    }
                };

                StreamObserver<RequestMessage> requestObserver = service1Stub.signup(responseObserver);
                requestObserver.onNext(request);
                // Call onNext() multiple times to send multiple requests
                requestObserver.onCompleted();
            }

        } finally {
            channel.shutdown();
            try {
                channel.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException error) {
                error.printStackTrace();
            }
        }
    }
}


