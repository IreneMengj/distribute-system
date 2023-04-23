package Appointment.client;

import Appointment.ds.service2.Appointment;
import Appointment.ds.service2.Response;
import Appointment.ds.service2.ResponseMessage;
import Appointment.ds.service2.Service2Grpc;


import io.grpc.*;
import io.grpc.stub.MetadataUtils;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class AddAppointmentGUI extends JFrame {
    private static int nextId = 1;
    private ViewAppointmentGUI viewAppointmentGUI;
    JFrame frame;
    JLabel titleLabel;
    JTextField titleField;
    JLabel descLabel;
    JTextArea descArea;
    JScrollPane descScroll;
    JLabel timeLabel;
    JSpinner timeSpinner;
    JSpinner.DateEditor timeEditor;
    JLabel reminderLabel;
    JComboBox<String> reminderField;
    int id;
    String serviceType = "_grpc._tcp.local.";
    String serviceName = "service2";

    public AddAppointmentGUI(ViewAppointmentGUI viewAppointmentGUI) {
        this.viewAppointmentGUI = viewAppointmentGUI;
    }

    public void displayAppointmentGUI(String str, Object[] rowData) {

        if (str == "add") {
            frame = new JFrame("Add Appointment");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            titleLabel = new JLabel("Title:");
            titleField = new JTextField(20);

            descLabel = new JLabel("Description:");
            descArea = new JTextArea(5, 20);
            descScroll = new JScrollPane(descArea);


            timeLabel = new JLabel("Time:");
            timeSpinner = new JSpinner(new SpinnerDateModel());
            timeEditor = new JSpinner.DateEditor(timeSpinner, "yyyy-MM-dd");
            timeSpinner.setEditor(timeEditor);

            reminderLabel = new JLabel("Reminder:");
            String[] options = {"Yes", "No"};
            reminderField = new JComboBox<>(options);

        } else {
            frame = new JFrame("Update Appointment");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            titleLabel = new JLabel("Title:");
            titleField = new JTextField(20);
            titleField.setText(rowData[1].toString());

            descLabel = new JLabel("Description:");
            descArea = new JTextArea(5, 20);
            descScroll = new JScrollPane(descArea);
            descArea.setText(rowData[2].toString());

            timeLabel = new JLabel("Time:");
            timeSpinner = new JSpinner(new SpinnerDateModel());
            timeEditor = new JSpinner.DateEditor(timeSpinner, "yyyy-MM-dd");
            timeSpinner.setEditor(timeEditor);

            reminderLabel = new JLabel("Reminder:");
            String[] options = {"Yes", "No"};
            reminderField = new JComboBox<>(options);
        }

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

                // Use the address and port to create the ManagedChannel
                @SuppressWarnings("deprecation")
                ManagedChannel channel1 = ManagedChannelBuilder.forAddress(inetAddress.getHostAddress(), serviceInfo.getPort())
                        .usePlaintext()
                        .build();
                try {
                    Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel1);
                    // Build an Appointment request to add a new appointment to the service

                    if (str == "add") {
                        id = nextId++;
                        Appointment request = Appointment.newBuilder().setId(id).setTitle(titleField.getText()).setDetail(descArea.getText()).setOccurTime(timeEditor.getFormat().format(timeSpinner.getValue())).setReminder((String) reminderField.getSelectedItem()).build();
                        System.out.println("RPC add appointment to be invoked ...");

                        // Get the response code from the gRPC service
                        Iterator<Response> response = blockingStub.withDeadlineAfter(50, TimeUnit.SECONDS).addEvent(request);
                        int code = response.next().getCode();
                        String reply;
                        if (code == 1) {
                            reply = "Appointment saved successfully";
                        } else {
                            reply = "Title can't be null";
                        }
                        JOptionPane.showMessageDialog(frame, reply);
                        // Create a new appointment with the input details
                        Object[] appointment = new Object[]{id, titleField.getText(), descArea.getText(), timeEditor.getFormat().format(timeSpinner.getValue()), (String) reminderField.getSelectedItem()};
                        // Get the instance of ViewAppointmentGUI and add the new appointment

                        viewAppointmentGUI.addAppointment(appointment);
                    } else {
                        id = Integer.parseInt(rowData[0].toString());
                        String title = titleField.getText();
                        String desc = descArea.getText();
                        String time = timeEditor.getFormat().format(timeSpinner.getValue());
                        String reminder = (String) reminderField.getSelectedItem();
                        Appointment request = Appointment.newBuilder().setId(id).setTitle(title).setDetail(desc).setOccurTime(time).setReminder(reminder).build();
                        System.out.println("RPC edit appointment to be invoked ...");

                        // Get the response code from the gRPC service
                        Metadata.Key<String> AUTHORIZATION_KEY = Metadata.Key.of("Authorization",
                                Metadata.ASCII_STRING_MARSHALLER);
                        // Create the metadata object
                        Metadata metadata = new Metadata();
                        metadata.put(AUTHORIZATION_KEY, "nice day");
                        blockingStub= MetadataUtils.attachHeaders(blockingStub, metadata);
                        ResponseMessage responseMessage = blockingStub.withDeadlineAfter(
                                50,TimeUnit.SECONDS).updateEvent(request);
                        int code = responseMessage.getCode();
                        String reply;
                        if (code == 1) {
                            reply = "Appointment edited successfully";
                        } else {
                            reply = "Appointment edited unsuccessfully";
                        }
                        JOptionPane.showMessageDialog(frame, reply);
                        // Create a new appointment with the input details
                        Object[] appointment = new Object[]{title, desc, time, reminder};
                        // Get the instance of ViewAppointmentGUI and add the new appointment
                        viewAppointmentGUI.editingAppointment(id, appointment);
                    }
                }catch (StatusRuntimeException ex) {
                    // Handle exception related to deadlines, metadata, or authentication
                    Status status = ex.getStatus();
                    if (status.getCode() == Status.Code.CANCELLED) {
                        JOptionPane.showMessageDialog(null, "The request was cancelled.");}
                    else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                        JOptionPane.showMessageDialog(null, "The request exceeded the deadline.");
                    } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                        JOptionPane.showMessageDialog(null, "Unauthenticated request");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error caught: "+ex.getMessage());
                    }
                }

                channel1.shutdown();

                frame.dispose();
                dispose();
            }
        });
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(titleLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(titleField, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(descLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(descScroll, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(timeLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(timeSpinner, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(reminderLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(reminderField, c);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(saveButton, c);

        frame.add(panel);
        frame.setVisible(true);
    }
}




