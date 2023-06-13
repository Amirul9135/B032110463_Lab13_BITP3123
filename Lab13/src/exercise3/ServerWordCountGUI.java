package exercise3;
 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerWordCountGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea txtLog =  new JTextArea();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public ServerWordCountGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		txtLog.setBounds(10, 53, 414, 370);
		txtLog.setEditable(false);
		contentPane.add(txtLog);
		
		JLabel lblNewLabel = new JLabel("Server Application");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 31);
		contentPane.add(lblNewLabel);
	}
	
	//this method allow adding content to the log text area
	public void log(String message) {
		
		//get current time and append content into textarea
        LocalDateTime now = LocalDateTime.now(); 
		txtLog.setText(txtLog.getText() + "\n>" + formatter.format(now) + ": " + message);
		
	}
}
