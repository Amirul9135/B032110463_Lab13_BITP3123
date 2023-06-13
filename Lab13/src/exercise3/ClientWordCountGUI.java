package exercise3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class ClientWordCountGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblWordCount;
	private JButton btnCount;
	private JTextArea txtInput;

	
	
	public ClientWordCountGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//set layout to use absolute layout
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//button to trigger the server connection
		btnCount = new JButton("Count");
		btnCount.setBounds(32, 281, 302, 38);
		contentPane.add(btnCount);
		
		//text area to contain user input
		 txtInput = new JTextArea();
		txtInput.setBounds(32, 72, 302, 198);
		contentPane.add(txtInput);
		 
		
		JLabel lblTitle = new JLabel("Word Counter");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(32, 11, 302, 50);
		contentPane.add(lblTitle);
		
		lblWordCount = new JLabel("Word count: ");
		lblWordCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWordCount.setBounds(32, 345, 302, 32);
		contentPane.add(lblWordCount);
	}
	
	//this method assign an action to the count button which will be executed on click
	public void setBtnCountAction(ActionListener action) {
		btnCount.addActionListener(action);
	}
	
	//this method assign the text content of the word count label to show the value
	public void setCount(int count) {
		lblWordCount.setText("Word Count: " + count);
	}
	
	public String getInput() {
		
		return txtInput.getText();
	}
	 
}
