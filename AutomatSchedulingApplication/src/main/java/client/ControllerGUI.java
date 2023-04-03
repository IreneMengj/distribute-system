package client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ds.service1.Service1Grpc;
import ds.service2.Appointment;
import ds.service2.AppointmentOrBuilder;
import ds.service2.Service2Grpc;
import ds.service3.Service3Grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class ControllerGUI implements ActionListener{


	private JTextField entry1_1, reply1_1;
	private JTextField entry1_2,reply1_2;


	private JPanel getService1Method1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label1 = new JLabel("Username")	;
		panel.add(label1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1_1 = new JTextField("",10);
		panel.add(entry1_1);

		JLabel label2 = new JLabel("Password")	;
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1_1 = new JTextField("",10);
		panel.add(entry1_1);

		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton button = new JButton("Log in");
		button.addActionListener(this);
		panel.add(button);

		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		reply1_1 = new JTextField("", 20);
		reply1_1 .setEditable(false);
		panel.add(reply1_1 );

		panel.setLayout(boxlayout);

		return panel;

	}
	private JPanel getService1Method2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label1 = new JLabel("Username")	;
		panel.add(label1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1_2 = new JTextField("",10);
		panel.add(entry1_2);

		JLabel label2 = new JLabel("Password")	;
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1_2 = new JTextField("",10);
		panel.add(entry1_2);

		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton button = new JButton("Sign up");
		button.addActionListener(this);
		panel.add(button);

		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		reply1_2 = new JTextField("", 20);
		reply1_2 .setEditable(false);
		panel.add(reply1_2 );

		panel.setLayout(boxlayout);

		return panel;

	}





	public static void main(String[] args) {

		ControllerGUI gui = new ControllerGUI();

		gui.build();
	}

	private void build() { 

		JFrame frame = new JFrame("Automated Scheduling Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getService1Method1JPanel() );
		panel.add( getService1Method2JPanel() );



		// Set size for the frame
		frame.setSize(500, 500);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		Service1Grpc.Service1BlockingStub blockingStub = Service1Grpc.newBlockingStub(channel);
		//preparing message to send
		String username = entry1_1.getText();
		String password = entry1_2.getText();
		ds.service1.RequestMessage request = ds.service1.RequestMessage.newBuilder().setUsername(username).setPassword(password).build();
		ds.service1.ResponseMessage response = blockingStub.service1Do(request);
		if (label.equals("Log in")) {
			System.out.println("RPC LOGIN to be invoked ...");
			/*
			 * 
			 */

			//retreving reply from service
			int code = response.getCode();
			if(code==1) {
				reply1_1.setText("Login successfully");
			}else{
				reply1_1.setText("Login unsuccessfully.");
			}
		}else if(label.equals("Sign up")){
			System.out.println("RPC Signup to be invoked ...");
			/*
			 *
			 */
			//retreving reply from service
			int code = response.getCode();
			if(code==1) {
				reply1_2.setText("Sign up successfully");
			}else{
				reply1_2.setText("Sign up unsuccessfully.");
			}
		}

	}

}
