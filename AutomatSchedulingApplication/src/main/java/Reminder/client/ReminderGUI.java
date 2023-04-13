package Reminder.client;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;

public class ReminderGUI extends JFrame {
    private  JSpinner timeSpinner;
    private  JTextField titleField;
    private JTextField idField;
    private  JTable table;
    private  DefaultTableModel tableModel;
    private JButton addButton;
    private JButton getButton;
    private JButton deleteButton;
    private JButton backButton;
    private AddReminderGUI addReminderGUI;
    private JTable reminderTable;

    public ReminderGUI() {
        // 设置窗口标题
        setTitle("Reminder");
        reminderTable = new JTable();

        String[] columnNames = {"ID", "Title", "Time"};
        Object[][] rowData = {};
        tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);

        // 创建滚动面板
        JScrollPane scrollPane = new JScrollPane(table);

        // 创建按钮
        addButton = new JButton("Add");
        getButton = new JButton("Get");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");

        // 创建文本框和时间选择器
        idField = new JTextField();
        titleField = new JTextField();
        timeSpinner = new JSpinner(new SpinnerDateModel());

        // 设置按钮布局
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(getButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        // 添加按钮事件
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 显示添加提醒界面
                addReminderGUI = new AddReminderGUI(ReminderGUI.this,tableModel);
                addReminderGUI.setVisible(true);
            }
        });

        // 添加按钮布局
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);




        // 设置窗口大小、位置和关闭方式
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        ReminderGUI gui=new ReminderGUI();
        gui.setVisible(true);
    }
}

