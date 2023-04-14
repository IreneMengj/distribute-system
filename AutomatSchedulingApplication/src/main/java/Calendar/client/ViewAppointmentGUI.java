package Calendar.client;

import Calendar.ds.service2.ResponseMessage;
import Calendar.ds.service2.Service2Grpc;
import Calendar.ds.service2.eventId;
import GUI.MainGUI;
import Login.ds.service1.Service1Grpc;
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
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ViewAppointmentGUI extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private List<Object[]> appointments;
    private AddAppointmentGUI addAppointmentGUI;
    private MainGUI mainGUI;


    public ViewAppointmentGUI(MainGUI mainGUI) {
        super("Appointments");
        // Initialize the appointments list
        this.mainGUI = mainGUI;
        appointments = new ArrayList<>();


        // Create a table model
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("TITLE");
        model.addColumn("DESCRIPTION");
        model.addColumn("TIME");
        model.addColumn("Reminder");
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
//                AddAppointmentGUI gui = new AddAppointmentGUI();
                // Use the address and port to create the ManagedChannel
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                        .usePlaintext()
                        .build();
                Service1Grpc.Service1BlockingStub service1BlockingStub = Service1Grpc.newBlockingStub(channel);
                Login.ds.service1.ResponseMessage service1Response = service1BlockingStub.isLogin(null);
                if (service1Response.getCode() == 0) {
                    JOptionPane.showMessageDialog(null, "Please log in first");
                    return;
                }
                addAppointmentGUI = new AddAppointmentGUI(ViewAppointmentGUI.this);
                addAppointmentGUI.displayAppointmentGUI("add", null);
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
                addAppointmentGUI = new AddAppointmentGUI(ViewAppointmentGUI.this);
                addAppointmentGUI.displayAppointmentGUI("edit", rowData);
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

                    ManagedChannel channel = createChannel();
                    try {
                        Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);
                        eventId request = eventId.newBuilder().setId(id).build();
                        System.out.println("RPC delete appointment to be invoked ...");
                        ResponseMessage responseMessage = blockingStub.deleteEvent(request);
                        int code = responseMessage.getCode();
                        if (code == 1) {
                            JOptionPane.showMessageDialog(null, "Delete successfully.");
                            model.removeRow(selectedRows[i]); // remove the row from the model
                        } else {
                            JOptionPane.showMessageDialog(null, "Delete unsuccessfully.");
                        }
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

        // create a button to go back to the main GUI
        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // show the First GUI
                mainGUI.showMainGUI();
            }
        });


        // Add the button to the button panel
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton); // add the backButton to the panel

        // Create a panel to hold tables and buttons
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the window
        add(panel);

        // Sets the window size and visibility
        setSize(800, 600);

        setVisible(true);
    }

    public ViewAppointmentGUI() {

    }

    // Set the data of the table
    public void setData(int id, Object[] newData) {
        // Find the row with the specified id and update its data
        for (int i = 0; i < appointments.size(); i++) {
            Object[] row = appointments.get(i);
            int o = Integer.parseInt(row[0].toString());
            if (o == id) {
                // Update the row data
                row[1] = newData[0];
                row[2] = newData[1];
                row[3] = newData[2];
                row[4] = newData[3];

                // Update the row in the table model
                for (int j = 1; j <= 4; j++) {
                    model.setValueAt(row[j], i, j);
                }

                return;
            }
        }
    }

    // Edit an existing appointment in the appointments list
    public void editingAppointment(int id, Object[] newAppointment) {
        // Update the row in the table model
        setData(id, newAppointment);

    }


    // Add an appointment to the appointments list
    public void addAppointment(Object[] appointment) {
        appointments.add(appointment);
        // Add the appointment data to the table
        model.addRow(appointment);
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
        return channel;
    }


    public static void main(String[] args) {
        ViewAppointmentGUI gui = new ViewAppointmentGUI();

    }
}


