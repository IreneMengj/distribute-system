package Reminder.client;
import Calendar.client.ViewAppointmentGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddReminderGUI extends JFrame {
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel descLabel;
    private JTextField descField;
    private JLabel timeLabel;
    private JSpinner timeSpinner;
    private JButton okButton;
    private ReminderGUI reminderGUI;

    public AddReminderGUI(ReminderGUI reminderGUI) {
        this.reminderGUI = reminderGUI;
        // 设置窗口标题
        setTitle("Add Reminder");

        // 创建组件
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

        // 设置时间格式
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "yyyy-MM-dd HH:mm:ss");
        timeSpinner.setEditor(timeEditor);

        // 添加确认按钮事件
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取输入的信息
                String title = titleField.getText();
                String desc = descField.getText();
                LocalDateTime time = LocalDateTime.parse(timeEditor.getFormat().format(timeSpinner.getValue()), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // 发送添加提醒请求
//                ReminderGUI.

                // 关闭窗口
                dispose();
            }
        });
        // 设置组件的位置和大小
        // 设置组件的位置和大小
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5); // 设置组件之间的间距
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
        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}