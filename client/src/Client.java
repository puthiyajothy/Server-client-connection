import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
  public static void main(String[] args) {
    try {

      Socket pingSocket = null;
      PrintWriter out = null;
      BufferedReader in = null;
      Scanner scanner = new Scanner(System.in);

      try {

        pingSocket = new Socket("127.0.0.1", 1111);
        out = new PrintWriter(pingSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(pingSocket.getInputStream()));
      } catch (IOException e) {
        return;
      }

      out.println("jothi");
      String input;
      System.out.println(in.readLine());

      while (!(input = scanner.nextLine()).equals("q")) {

        out.println(input);
        System.out.println(in.readLine());

      }

      out.close();
      in.close();
      pingSocket.close();


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
