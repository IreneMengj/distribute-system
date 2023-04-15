package Reminder.client;

import Calendar.ds.service2.Service2Grpc;
import Calendar.ds.service2.eventId;
import GUI.MainGUI;
import Login.ds.service1.RequestMessage;
import Reminder.ds.service3.ReminderId;
import Reminder.ds.service3.ResponseMessage;
import Reminder.ds.service3.Service3Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReminderGUI extends JFrame {
    private JSpinner timeSpinner;
    private JTextField titleField;
    private JTextField idField;
    private DefaultTableModel tableModel;
    private JButton addButton;
    private JButton getButton;
    private JButton deleteButton;
    private JButton backButton;
    private AddReminderGUI addReminderGUI;
    private JTable reminderTable;
    private JTable table;
    private MainGUI mainGUI;

    public ReminderGUI() {

    }

    public ReminderGUI(MainGUI mainGUI) {
        // 设置窗口标题
        setTitle("Reminder");
        this.mainGUI = mainGUI;
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
                addReminderGUI = new AddReminderGUI(ReminderGUI.this, tableModel);
                addReminderGUI.setVisible(true);
            }
        });

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int[] selectedRows = table.getSelectedRows();
                for (int i = 0; i < selectedRows.length; i++) {
                    int selectedRow = selectedRows[i];
                    Object id1 = table.getValueAt(selectedRow, 0);
                    int id = Integer.parseInt(id1.toString());
                    ManagedChannel channel = createChannel();
                    try {
                        System.out.println("RPC get reminder to be invoked ...");
                        Service3Grpc.Service3BlockingStub service3BlockingStub = Service3Grpc.newBlockingStub(channel);
                        ReminderId build = ReminderId.newBuilder().addID(id).build();
                        ResponseMessage response = service3BlockingStub.getReminder(build);
                        String message = response.getMessage();
                        JOptionPane.showMessageDialog(null, message);
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
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    tableModel.removeRow(selectedRows[i]);
                    int selectedRow = selectedRows[i];
                    Object id1 = table.getValueAt(selectedRow, 0);
                    int id = Integer.parseInt(id1.toString());
                    ManagedChannel channel = createChannel();
                    try {
                        System.out.println("RPC delete reminder to be invoked ...");
                        Service3Grpc.Service3BlockingStub service3BlockingStub = Service3Grpc.newBlockingStub(channel);
                        ReminderId build = ReminderId.newBuilder().setID(0,id).build();

                        JOptionPane.showMessageDialog(null, "haha");
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

    public ManagedChannel createChannel () {
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
        String serviceName = "service3";
        ServiceInfo serviceInfo = jmdns.getServiceInfo(serviceType, serviceName);
        if (serviceInfo == null) {
            System.err.println("Could not find service with name " + serviceName);
            return null;
        }
        // Use the address and port to create the ManagedChannel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(inetAddress.getHostAddress(), serviceInfo.getPort())
                .usePlaintext()
                .build();
        return channel;
    }

    public static void main(String[] args) {
        ReminderGUI gui = new ReminderGUI();
        gui.setVisible(true);
    }
}


