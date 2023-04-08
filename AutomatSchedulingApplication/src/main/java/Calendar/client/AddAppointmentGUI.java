package Calendar.client;

import Calendar.ds.service2.Appointment;
import Calendar.ds.service2.ResponseMessage;
import Calendar.ds.service2.Service2Grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddAppointmentGUI extends JFrame {


    public void displayAppointmentGUI() {
        JFrame frame = new JFrame("Add Appointment");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField(20);

        JLabel descLabel = new JLabel("Description:");
        JTextArea descArea = new JTextArea(5, 20);
        JScrollPane descScroll = new JScrollPane(descArea);

        JLabel timeLabel = new JLabel("Time:");
        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);

        JLabel participantLabel = new JLabel("Participants:");
        JTextField participantField = new JTextField(20);

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
                String serviceType = "_grpc._tcp.local.";
                String serviceName="service2";
                ServiceInfo serviceInfo = jmdns.getServiceInfo(serviceType, serviceName);
                if (serviceInfo == null) {
                    System.err.println("Could not find service with name " + serviceName);
                    return;
                }
                // Use the address and port to create the ManagedChannel
                ManagedChannel channel  = ManagedChannelBuilder.forAddress(inetAddress.getHostAddress(), serviceInfo.getPort())
                        .usePlaintext()
                        .build();

                Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);
                String reply = addEvent(blockingStub);
                JOptionPane.showMessageDialog(frame, reply);
                frame.dispose();

            }
            public String addEvent(Service2Grpc.Service2BlockingStub blockingStub) {
                // Build an Appointment request to add a new appointment to the service
                int id = 1;
                Appointment request = Appointment.newBuilder().setId(id).setTitle(titleField.getText()).setDetail(descArea.getText()).setOccurTime(timeEditor.getFormat().format(timeSpinner.getValue())).setParticipants(participantField.getText()).build();
                System.out.println("RPC add appointment to be invoked ...");
                // Get the response code from the gRPC service
                ResponseMessage response = blockingStub.addEvent(request);
                int code = response.getCode();
                String reply;
                if (code == 1) {
                    reply = "Appointment saved successfully";
                } else {
                    reply = "Title can't be null";
                }
                return reply;
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
        panel.add(participantLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(participantField, c);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(saveButton, c);

        frame.add(panel);
        frame.setVisible(true);

    }

}

