import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
  public static HashMap<String,Socket> stringSocketHashMap=new HashMap<>();

  public static void main(String[] args) {

    try {
      int nreq = 1;
		System.out.println("Server is Stsrted");
      ServerSocket serverSocket = new ServerSocket(1111);

      for (; ; ) {
  		System.out.println("Server is Connected");

        Socket newSocket = serverSocket.accept();
		System.out.println("Client Connected");



        System.out.println("Creting a Thread ....");
        DataInputStream dataInputStream = new DataInputStream(newSocket.getInputStream());
        String line = dataInputStream.readLine();
        System.out.println(line+"front");

        Thread thread = new ThreadHandler(newSocket, nreq);
        stringSocketHashMap.put(line,newSocket);

        thread.start();
        nreq++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
