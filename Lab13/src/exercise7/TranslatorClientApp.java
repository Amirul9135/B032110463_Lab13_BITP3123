package exercise7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthUI;

public class TranslatorClientApp {

	public static void main(String [] args) {
		
		TranslatorClientGUI gui = new TranslatorClientGUI();
		gui.setVisible(true);
		
		gui.setBtnAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Socket socket;
				try {
					socket = new Socket(InetAddress.getLocalHost(), 4228);

					// establish streams
					DataInputStream disResponse = new DataInputStream(socket.getInputStream());
					DataOutputStream dosRequest = new DataOutputStream(socket.getOutputStream());


					dosRequest.writeUTF(gui.getInput());
					dosRequest.writeInt(gui.getSelected()); 
					
					String response =  disResponse.readUTF();
					if(gui.getSelected() == 1) {
						gui.setFont("Arial");
						
					}
					else if(gui.getSelected() == 2) {
						gui.setFont("Malgun Gothic");
					}
					gui.setOutput(response); 

					dosRequest.close();
					disResponse.close();

				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
 
	}
}
