package exercise7;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TranslatorClientGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblOutput;
	private JTextField txtInput;
	private JButton btnTranslate;
	private JComboBox cmbLanguage;

	
	
	public TranslatorClientGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//set layout to use absolute layout
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		
		JLabel lblTitle = new JLabel("Translator App");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(32, 11, 302, 50);
		contentPane.add(lblTitle);
		
		lblOutput = new JLabel("Translated:");
		lblOutput.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblOutput.setBounds(32, 185, 302, 32);
		contentPane.add(lblOutput);
		
		txtInput = new JTextField();
		txtInput.setBounds(32, 72, 302, 26);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		btnTranslate = new JButton("Translate");
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTranslate.setBounds(32, 151, 302, 23);
		contentPane.add(btnTranslate);
		
		 cmbLanguage = new JComboBox();
		cmbLanguage.setModel(new DefaultComboBoxModel(new String[] {"Bahasa Malaysia", "Arabic", "Korean"}));
		cmbLanguage.setBounds(32, 118, 302, 22);
		contentPane.add(cmbLanguage);
	}
	
	//this method assign an action to the count button which will be executed on click
	public void setBtnAction(ActionListener action) {
		btnTranslate.addActionListener(action);
	}
	
	//this method assign the text content of the word count label to show the value
	public void setOutput(String output) {
		lblOutput.setText("Translated: " + output);
	}
	
	public String getInput() {
		return txtInput.getText();
	}
	
	public int getSelected() {
		return cmbLanguage.getSelectedIndex();
	}
	
	public void setFont(String fontName) {
		lblOutput.setFont(new Font(fontName, Font.PLAIN, 15));
	}
}
