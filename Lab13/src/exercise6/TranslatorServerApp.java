package exercise6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TranslatorServerApp {

	public static void main(String [] args) throws IOException {

		String [][] translations = {
				new String[] {"Selamat pagi","Selamat malam","Apa khabar?","Terima kasih","Selamat tinggal ","Ada apa?"},
				new String[] {"صباح الخير","طاب مساؤك","كيف حالك؟","شكرا لك","مع السالمة","ما أخبارك؟"},
				new String[] {"좋은 아침","안녕히 주무세요","어떻게 지내세요?","감사합니다","안녕","뭐야?"}
		}; 
		String []textEng = {"good morning","good night","gow are you?","thank you","goodbye ","what’s up?"};  

		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		// Message to indicate server is alive
		System.out.println("Server started on port " + portNo); 

		// keep looping to always listen to request
		while (true) {


			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();

			// initialize input stream to read request data
			DataInputStream disRequest = new DataInputStream(clientSocket.getInputStream());

			String requestString = disRequest.readUTF();
			int languageIndex = disRequest.readInt();

			System.out.println("Received request containing: " + requestString +" lang" + languageIndex);

			// initialize output stream to send response
			DataOutputStream dosResponse = new DataOutputStream(clientSocket.getOutputStream());

			//find matches in english list
			requestString = requestString.toLowerCase();
			String response = "";
			for(int index=0; index < translations[languageIndex].length;index++) {
				System.out.println("loop");

				//break and assign match to response
				if(requestString.equals(textEng[index])) {
					response = translations[languageIndex][index];
					break;
				}
			} 

			//send response
			dosResponse.writeUTF(response);
			System.out.println("res"+response);

			// close streams
			disRequest.close();
			dosResponse.close();


		}

	}
}
