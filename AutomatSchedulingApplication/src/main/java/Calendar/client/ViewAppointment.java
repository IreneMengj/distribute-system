package Calendar.client;

import Calendar.ds.service2.Appointment;
import Calendar.ds.service2.ResponseMessage;
import Calendar.ds.service2.Service2Grpc;
import Calendar.ds.service2.eventId;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewAppointment extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<Object[]> data;

    public ViewAppointment() {
        super("Appointments");


        // Create a table model
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("TITLE");
        model.addColumn("DESCRIPTION");
        model.addColumn("TIME");
        model.addColumn("PARTICIPANTS");
        model.addColumn("SELECT");

        // Create the table and set the model as its data source
        table = new JTable(model);

        // Add a check box for each row in the table
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn selectColumn = columnModel.getColumn(5);
        selectColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
        selectColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));

        // Create a scroll panel to contain the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a panel to place the Add, Modify, and Delete buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddAppointmentGUI gui = new AddAppointmentGUI();
                ArrayList<Appointment> appointments = gui.displayAppointmentGUI("Add Appointment");

                setData(appointments);
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取选中行的索引
                int[] selectedRows = table.getSelectedRows();

                // 如果没有选中行或选中多行，则弹出提示框并返回
                if (selectedRows.length != 1) {
                    JOptionPane.showMessageDialog(null, "Please select one row to modify.");
                    return;
                }

                // 获取选中行的数据
                int rowIndex = selectedRows[0];
                Object[] rowData = new Object[model.getColumnCount()];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = model.getValueAt(rowIndex, i);
                }

                // 创建编辑面板并将数据填充到编辑面板中
                JPanel editPanel = new JPanel(new GridLayout(0, 2));

                JLabel idLabel = new JLabel("ID:");
                JTextField idField = new JTextField(rowData[0].toString());
                idField.setEditable(false);
                editPanel.add(idLabel);
                editPanel.add(idField);

                JLabel titleLabel = new JLabel("TITLE:");
                JTextField titleField = new JTextField(rowData[1].toString());
                editPanel.add(titleLabel);
                editPanel.add(titleField);

                JLabel descLabel = new JLabel("TITLE:");
                JTextField descField = new JTextField(rowData[2].toString());
                editPanel.add(descLabel);
                editPanel.add(descField);

                JLabel timeLabel = new JLabel("TIME:");
                JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
                JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "yyyy-MM-dd HH:mm:ss");
                timeSpinner.setEditor(timeEditor);
                timeSpinner.setValue((Date) rowData[3]);
                editPanel.add(timeLabel);
                editPanel.add(timeSpinner);

                JLabel participantLabel = new JLabel("PARTICIPANTS:");
                JTextField participantField = new JTextField(rowData[4].toString());
                editPanel.add(participantLabel);
                editPanel.add(participantField);

                JFrame frame = new JFrame("Edit Panel Example");
                frame.add(editPanel);
                frame.pack();
                frame.setVisible(true);

                // 创建确认按钮
                JButton confirmButton = new JButton("Confirm");

                // 创建一个用于保存确认按钮状态的变量
                final boolean[] isEditEnabled = {false};

                // 点击确认按钮后更新模型中的数据
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 获取用户修改后的数据
                        Object[] updatedRowData = new Object[model.getColumnCount()];
                        updatedRowData[0] = rowData[0];
                        updatedRowData[1] = titleField.getText();
                        updatedRowData[2] = descField.getText();
                        updatedRowData[3] = timeSpinner.getValue();
                        updatedRowData[4] = participantField.getText();

                        // 更新模型中的数据
                        model.setValueAt(updatedRowData[1], rowIndex, 1);
                        model.setValueAt(updatedRowData[2], rowIndex, 2);
                        model.setValueAt(updatedRowData[3], rowIndex, 3);
                        model.setValueAt(updatedRowData[4], rowIndex, 4);

                        // 关闭编辑面板
                        isEditEnabled[0] = false;
                        frame.dispose();
                    }
                });
            }
        });


        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gets the index of the selected row
                int[] selectedRows = table.getSelectedRows();
                // If no row is selected, a dialog box is displayed
                if (selectedRows.length == 0) {
                    JOptionPane.showMessageDialog(null, "Select the row to delete.");
                    return;
                }
                // Get the ID of the selected row
                for (int i = 0; i < selectedRows.length; i++) {
                    int id = Integer.parseInt(model.getValueAt(selectedRows[i], 0).toString());
                    Service2Grpc.Service2BlockingStub blockingStub = createChannel();
                    eventId request = eventId.newBuilder().setId(id).build();
                    ResponseMessage responseMessage = blockingStub.deleteEvent(request);
                    int code = responseMessage.getCode();
                    if (code == 1) {
                        JOptionPane.showMessageDialog(null, "Delete successfully.");
                        model.removeRow(selectedRows[i]); // remove the row from the model
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete unsuccessfully.");
                    }
                }


            }
        });

        // 将按钮添加到按钮面板中
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // 创建一个面板来放置表格和按钮
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // 将主面板添加到窗口中
        add(panel);

        // 设置窗口大小并可见
        setSize(800, 600);
        setVisible(true);
    }

    // 将数据添加到表格中
    public void setData(ArrayList<Appointment> data) {

        // 将新数据添加到模型中
        for (Appointment row : data) {
            model.addRow(new Appointment[]{row});
        }
    }

    public Service2Grpc.Service2BlockingStub createChannel() {
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
        String serviceName = "service2";
        ServiceInfo serviceInfo = jmdns.getServiceInfo(serviceType, serviceName);
        if (serviceInfo == null) {
            System.err.println("Could not find service with name " + serviceName);
            return null;
        }
        // Use the address and port to create the ManagedChannel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(inetAddress.getHostAddress(), serviceInfo.getPort())
                .usePlaintext()
                .build();

        Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);
        return blockingStub;
    }


    public static void main(String[] args) {
//        // 创建一个新的ListGUI对象
        ViewAppointment gui = new ViewAppointment();
        // 创建一些数据并将其添加到表格中
//        ArrayList<Object[]> data = new ArrayList<>();
//
//        data.add(new Object[]{"1", "talk about recruiment", "we need new graduate", "2022-01-01", "John, Jane"});
//        data.add(new Object[]{"2", "department meeting", "not urgent", "2022-01-02", "Mary"});
//        data.add(new Object[]{"3", "team building", "spring is coming", "2022-01-03", "Bob, Alice"});
//        data.add(new Object[]{"4", "team building", "spring is coming", "2022-01-03", "Bob, Alice"});




    }
}


