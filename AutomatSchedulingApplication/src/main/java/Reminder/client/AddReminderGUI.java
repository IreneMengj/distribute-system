package Reminder.client;


import Login.ds.service1.RequestMessage;
import Reminder.ds.service3.Reminder;
import Reminder.ds.service3.Response;
import Reminder.ds.service3.Service3Grpc;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class AddReminderGUI extends JFrame {
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel descLabel;
    private JTextField descField;
    private JLabel timeLabel;
    private JSpinner timeSpinner;
    private JButton okButton;
    private ReminderGUI reminderGUI;
    String serviceType = "_grpc._tcp.local.";
    String serviceName = "service3";


    private DefaultTableModel tableModel;

    public AddReminderGUI(ReminderGUI reminderGUI, DefaultTableModel tableModel) {
        this.reminderGUI = reminderGUI;
        this.tableModel = tableModel;
        // Set the window title
        setTitle("Add Reminder");

        // Create components
        descLabel = new JLabel("ID:");
        descField = new JTextField(5);
        descField.setFont(new Font("Arial", Font.PLAIN, 12));
        descField.setPreferredSize(new Dimension(200, 20));
        titleLabel = new JLabel("Title:");
        titleField = new JTextField(5);
        titleField.setFont(new Font("Arial", Font.PLAIN, 12));
        titleField.setPreferredSize(new Dimension(200, 20));
        timeLabel = new JLabel("Time:");
        timeSpinner = new JSpinner(new SpinnerDateModel());
        okButton = new JButton("OK");

        // Set the time format
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "yyyy-MM-dd HH:mm:ss");
        timeSpinner.setEditor(timeEditor);

        // Add a confirmation button event
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String title = titleField.getText();
                String ID = descField.getText();

                LocalDateTime time = LocalDateTime.parse(timeEditor.getFormat().format(timeSpinner.getValue()), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

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
                    System.err.println("Could not find service with name " + serviceName);
                    return;
                }
                ManagedChannel channel = null;
                // Use the address and port to create the ManagedChannel
                try {
                    channel = ManagedChannelBuilder.forAddress(inetAddress.getHostAddress(), serviceInfo.getPort())
                            .usePlaintext()
                            .build();


                    // Add metadata to the channel
                    Metadata metadata = new Metadata();
                    metadata.put(Metadata.Key.of("token", Metadata.ASCII_STRING_MARSHALLER), "my-token");

                    Reminder request = null;
                    // preparing message to send

                    try {
                        int id = Integer.parseInt(ID);
                        if (id <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a positive integer for ID.");
                            ID = JOptionPane.showInputDialog(null, "ID:");
                        } else {
                            request = Reminder.newBuilder()
                                    .setID(id)
                                    .setYear(String.valueOf(time.getYear()))
                                    .setMonth(String.valueOf(time.getMonthValue()))
                                    .setHour(String.valueOf(time.getHour()))
                                    .setMin(String.valueOf(time.getMinute()))
                                    .setSec(String.valueOf(time.getSecond()))
                                    .build();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID should be a positive integer");
                        return;
                    }


                    // Call gRPC service methods here
                    Service3Grpc.Service3Stub service3Stub = Service3Grpc.newStub(channel);
                    System.out.println("RPC set reminder to be invoked ...");
//                service3Stub.setReminder(request, new StreamObserver<Response>()
                    StreamObserver<Reminder> requestObserver = service3Stub.setReminder(new StreamObserver<Response>() {
                        @Override
                        public void onNext(Response response) {
                            // Handle response from gRPC service
                            int code = response.getCode();
                            if (code == 1) {
                                JOptionPane.showMessageDialog(null, response.getMessage());
                            } else {
                                JOptionPane.showMessageDialog(null, response.getMessage());
                            }
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            Status status = Status.fromThrowable(throwable);
                            if (status.getCode() == Status.Code.CANCELLED) {
                                JOptionPane.showMessageDialog(null, "The request was cancelled.");
                            } else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                                JOptionPane.showMessageDialog(null, "The request deadline was exceeded.");
                            } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                                JOptionPane.showMessageDialog(null, "The request was not authenticated.");
                            } else {
                                JOptionPane.showMessageDialog(null, "An error occurred: " + throwable.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        @Override
                        public void onCompleted() {

                        }

                    });
                    requestObserver.onNext(request);
                    // Call onNext() multiple times to send multiple requests
                    requestObserver.onCompleted();
                } finally {
                    channel.shutdown();
                    try {
                        channel.awaitTermination(5, TimeUnit.SECONDS);
                    } catch (InterruptedException error) {
                        error.printStackTrace();
                    }
                }

                // Send the add reminder request
                Object[] rowData = {ID, title, time};
                tableModel.addRow(rowData);
                // Close the window
                dispose();
            }
        });
        // Set the location and size of the component
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new

                Insets(5, 5, 5, 5); // 设置组件之间的间距

        c.gridx = 0;
        c.gridy = 0;
        panel.add(descLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(descField, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(titleLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(titleField, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(timeLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(timeSpinner, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(okButton, c);

        getContentPane().

                add(panel);

        pack();

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}



