package exercise6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TranslatorClientApp {

	public static void main(String [] args) {

		Scanner scanner =  new Scanner(System.in);
		while(true) {

			System.out.println("Insert text:");

			String input = scanner.nextLine();

			System.out.println("\nSelect target language:\n1)Bahasa Malaysia\n2)Arabic\n3)Korean\n4)exit");
			int languageId = scanner.nextInt() -1;
			if(languageId == 3)
				break;
 
			Socket socket;
			try {
				socket = new Socket(InetAddress.getLocalHost(), 4228);

				// establish streams
				DataInputStream disResponse = new DataInputStream(socket.getInputStream());
				DataOutputStream dosRequest = new DataOutputStream(socket.getOutputStream());


				dosRequest.writeUTF(input);
				dosRequest.writeInt(languageId); 
				
				String response =  disResponse.readUTF();
				System.out.println("Translated text: " + response);

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
		scanner.close();
	}
}
