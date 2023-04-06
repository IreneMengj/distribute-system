package Calendar.client;
import javax.swing.*;
import java.awt.event.*;

public class CalendarGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calendar");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addButton = new JButton("Add Appointment");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame addFrame = new JFrame("Add Appointment");
                addFrame.setSize(200, 150);
                addFrame.setVisible(true);
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

        JButton deleteButton = new JButton("Delete Appointment");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame deleteFrame = new JFrame("Delete Appointment");
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
