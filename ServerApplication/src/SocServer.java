import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
public static void main(String[] args) throws Exception {
		// Client one Connection
		System.out.println("Server is Stsrted");
		ServerSocket ss = new ServerSocket(1111);
		System.out.println("Server is Connected");
		Socket s = ss.accept();
		System.out.println("Client Connected");
		
		// Read Data from some ware - client
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = br.readLine();	
		System.out.println(str);
		
		String nickname = str.substring(0, 2);
		
		OutputStreamWriter op = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(op);
		out.println(nickname);
		out.flush();
		
		System.out.println("Data Send from server to client");


		
		


	}


}
