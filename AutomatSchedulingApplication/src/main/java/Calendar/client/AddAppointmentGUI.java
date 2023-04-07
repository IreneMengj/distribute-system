package Calendar.client;

import Calendar.ds.service2.Appointment;
import Calendar.ds.service2.ResponseMessage;
import Calendar.ds.service2.Service2Grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;

public class AddAppointmentGUI extends JFrame implements ActionListener{


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
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                        .usePlaintext()
                        .build();
                Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);
                int id=1;
                Appointment request = Appointment.newBuilder().setId(id).setTitle(titleField.getText()).setDetail(descArea.getText()).setOccurTime(timeEditor.getFormat().format(timeSpinner.getValue())).setParticipants(participantField.getText()).build();
                System.out.println("RPC add appointment to be invoked ...");
                ResponseMessage response = blockingStub.addEvent(request);
                int code = response.getCode();
                String reply;
                if (code == 1) {
                    reply="Appointment saved successfully";
                } else {
                    reply="Appointment saved unsuccessfully";
                }
                JOptionPane.showMessageDialog(frame, reply);
                frame.dispose();
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}

