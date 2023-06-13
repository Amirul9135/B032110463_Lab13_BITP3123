package exercise3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 

public class ServerWordCountApp {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String [] args) throws IOException {

		// Launch the server frame
		ServerWordCountGUI serverFrame = new ServerWordCountGUI();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		// Message to indicate server is alive
		serverFrame.log("Server started on port " + portNo);
		 
		 
		
		// keep looping to always listen to request
		while (true) {
			
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// initialize input stream to read request data
			DataInputStream disRequest = new DataInputStream(clientSocket.getInputStream());
			
			String requestData = disRequest.readUTF();
			
			serverFrame.log("Received request containing: " + requestData);
			
			// initialize output stream to send response
			DataOutputStream dosResponse = new DataOutputStream(clientSocket.getOutputStream());
			
			// calculate length of array of the string split by space and send to client
			dosResponse.writeInt(requestData.split(" ").length);
			
			// close streams
			disRequest.close();
			dosResponse.close();
			
			
			
			
		}
			 
	}
}
