package Calendar.client;
import javax.swing.*;
import java.awt.event.*;

public class CalendarGUI extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calendar");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addButton = new JButton("Add Appointment");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddAppointmentGUI gui = new AddAppointmentGUI();
                gui.displayAppointmentGUI();

            }
        });

        JButton updateButton = new JButton("Update Appointment");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame updateFrame = new JFrame("Update Appointment");
                updateFrame.setSize(200, 150);
                updateFrame.setVisible(true);
            }
        });

        JButton deleteButton = new JButton("View Appointment");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame deleteFrame = new JFrame("View Appointment");
                deleteFrame.setSize(200, 150);
                deleteFrame.setVisible(true);
            }
        });

        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        frame.add(panel);

        frame.setVisible(true);
    }
}
