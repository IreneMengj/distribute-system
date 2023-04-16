package Reminder.client;


import Login.ds.service1.RequestMessage;
import Login.ds.service1.ResponseMessage;
import Login.ds.service1.Service1Grpc;
import Reminder.ds.service3.Reminder;
import Reminder.ds.service3.Response;
import Reminder.ds.service3.Service3Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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
    static int port;
    static String resolvedIP;
    private static final String SERVICE_TYPE = "_http._tcp.local.";
    private static final String SERVICE_NAME = "service3";


    private DefaultTableModel tableModel;

    public AddReminderGUI(ReminderGUI reminderGUI, DefaultTableModel tableModel) {
        this.reminderGUI = reminderGUI;
        this.tableModel = tableModel;
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
                String ID = descField.getText();

                LocalDateTime time = LocalDateTime.parse(timeEditor.getFormat().format(timeSpinner.getValue()), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


                JMDNS();
                // Use the address and port to create the ManagedChannel
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
//                ManagedChannel channel = ManagedChannelBuilder.forAddress(inetAddress.getHostAddress(), serviceInfo.getPort()).usePlaintext().build();
                //preparing message to send
                Reminder request = Reminder.newBuilder()
                        .setID(Integer.parseInt(ID))
                        .setYear(String.valueOf(time.getYear()))
                        .setMonth(String.valueOf(time.getMonthValue()))
                        .setHour(String.valueOf(time.getHour()))
                        .setMin(String.valueOf(time.getMinute()))
                        .setSec(String.valueOf(time.getSecond()))
                        .build();

                // Call gRPC service methods here
                Service3Grpc.Service3Stub service3Stub = Service3Grpc.newStub(channel);
                System.out.println("RPC set reminder to be invoked ...");
                service3Stub.setReminder(request, new StreamObserver<Response>() {
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
                        // Handle error from gRPC service
                        // Handle error from gRPC service
                        System.out.println("An error occurred: " + throwable.getMessage());
                        JOptionPane.showMessageDialog(null, "An error occurred: " + throwable.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                    }

                    @Override
                    public void onCompleted() {

                    }
                });

                // 发送添加提醒请求
                Object[] rowData = {ID, title, time};
                tableModel.addRow(rowData);


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


    public static void JMDNS() {
        try {
            // 创建JmDNS实例
            JmDNS jmdns = JmDNS.create();

            // 创建服务监听器
            ServiceListener listener = new ServiceListener() {
                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service added: " + event.getName());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getName());
                }

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Service resolved: " + event.getName());

                    ServiceInfo info = event.getInfo();
                    int port = info.getPort();

                    System.out.println("Service address: " + resolvedIP);
                    System.out.println("Service port: " + port);
                }
            };

            // 添加服务监听器
            jmdns.addServiceListener(SERVICE_TYPE, listener);

            ServiceInfo[] serviceInfos = jmdns.list(SERVICE_TYPE);
            for (ServiceInfo info : serviceInfos) {
                System.out.println("## resolve service " + info.getName()  + " : " + info.getURL());
            }

            // 关闭JmDNS实例
            jmdns.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

