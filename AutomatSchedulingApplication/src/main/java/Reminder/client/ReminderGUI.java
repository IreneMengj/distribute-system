package Reminder.client;


import GUI.MainGUI;
import Reminder.ds.service3.ReminderId;
import Reminder.ds.service3.ResponseMessage;
import Reminder.ds.service3.Service3Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
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
    String serviceType = "_grpc._tcp.local.";
    String serviceName = "service3";

    static int port;
    static String resolvedIP;

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
                        ResponseMessage response = service3BlockingStub.withDeadlineAfter(50,TimeUnit.SECONDS).getReminder(build);
                        String message = response.getMessage();
                        JOptionPane.showMessageDialog(null, message);
                    } catch (StatusRuntimeException ex) {
                        // Handle exception related to deadlines, metadata, or authentication
                        Status status = ex.getStatus();
                        if (status.getCode() == Status.Code.CANCELLED) {
                            JOptionPane.showMessageDialog(null, "The request was cancelled.");}
                        else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                            JOptionPane.showMessageDialog(null, "Request deadline exceeded");
                        } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                            JOptionPane.showMessageDialog(null, "Unauthenticated request");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error caught"+ex.getMessage());
                        }
                    }finally {
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
                    int selectedRow = selectedRows[i];
                    Object id1 = table.getValueAt(selectedRow, 0);
                    int id = Integer.parseInt(id1.toString());
                    ManagedChannel channel = createChannel();
                    try {
                        System.out.println("RPC delete reminder to be invoked ...");
                        Service3Grpc.Service3BlockingStub service3BlockingStub = Service3Grpc.newBlockingStub(channel);
                        // Here, we are calling the Remote reverseStream method. Using onNext, client sends a stream of messages.
                        ReminderId request = ReminderId.newBuilder().addID(id).build();
                        ResponseMessage responseMessage = service3BlockingStub.withDeadlineAfter(50,TimeUnit.SECONDS).deleteReminder(request);
                        JOptionPane.showMessageDialog(null,responseMessage.getMessage());
                    }catch (StatusRuntimeException ex) {
                        // Handle exception related to deadlines, metadata, or authentication
                        Status status = ex.getStatus();
                        if (status.getCode() == Status.Code.CANCELLED) {
                            JOptionPane.showMessageDialog(null, "The request was cancelled.");}
                        else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                            JOptionPane.showMessageDialog(null, "Request deadline exceeded");
                        } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                            JOptionPane.showMessageDialog(null, "Unauthenticated request");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error caught"+ex.getMessage());
                        }
                    }

                    finally {
                        channel.shutdown();
                        try {
                            channel.awaitTermination(5, TimeUnit.SECONDS);
                        } catch (InterruptedException error) {
                            error.printStackTrace();
                        }
                    }
                    tableModel.removeRow(selectedRows[i]);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // show the Main GUI
                try{
                    dispose();
                    mainGUI.showMainGUI();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error caught: "+ex.getMessage());
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

        ServiceInfo serviceInfo = jmdns.getServiceInfo(serviceType, serviceName);
        if (serviceInfo == null) {
            System.err.println("Could not find service with name " + serviceName);
            return null;
        }
        // Use the address and port to create the ManagedChannel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(inetAddress.getHostAddress(), serviceInfo.getPort()).usePlaintext().build();
        return channel;
    }


    private static class SampleListener implements ServiceListener {
        public void serviceAdded(ServiceEvent event) {
            System.out.println("Service added: " + event.getInfo());
        }
        public void serviceRemoved(ServiceEvent event) {
            System.out.println("Service removed: " + event.getInfo());
        }
        @SuppressWarnings("deprecation")
        public void serviceResolved(ServiceEvent event) {
            System.out.println("Service resolved: " + event.getInfo());
            ServiceInfo info = event.getInfo();
            port = info.getPort();
            resolvedIP = info.getHostAddress();
            System.out.println("IP Resolved - " + resolvedIP + ":" + port);
        }
    }



    public static void main(String[] args) {
        ReminderGUI gui = new ReminderGUI();
        gui.setVisible(true);
    }
}


