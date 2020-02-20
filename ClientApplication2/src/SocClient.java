import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocClient {

	public static void main(String[] args)throws Exception {

		String ip = "localhost";
		int port = 1110;
		Socket s = new Socket(ip,port);
		
		String str = "Jothi";
		
		// Read Data from some ware - Server
		OutputStreamWriter opw = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(opw);
//		opw.write(str)
		out.println(str);
		opw.flush();
		
		// fetch value from server
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String name= br.readLine();	
		System.out.println("Fetch from server " + name);
	}

}
