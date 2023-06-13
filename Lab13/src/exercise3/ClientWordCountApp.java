package exercise3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientWordCountApp {
	
	public static void main(String [] args) {

		// Launch client-gui frame
		ClientWordCountGUI gui = new ClientWordCountGUI();
		gui.setVisible(true);

		gui.setBtnCountAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Connect to the server @ localhost, port 4228
				Socket socket;
				try {
					socket = new Socket(InetAddress.getLocalHost(), 4228);

					// establish streams
					DataInputStream disResponse = new DataInputStream(socket.getInputStream());
					DataOutputStream dosRequest = new DataOutputStream(socket.getOutputStream());
					
					
					dosRequest.writeUTF(gui.getInput());
					gui.setCount(disResponse.readInt());
					
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
