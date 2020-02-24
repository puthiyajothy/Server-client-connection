import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ThreadHandler extends Thread {
  Socket newSocket;
  int n;

  ThreadHandler(Socket newSocket, int n) {
    this.newSocket = newSocket;
    this.n = n;

  }

  @Override
  public void run() {
    try {
      DataInputStream dataInputStream = new DataInputStream(newSocket.getInputStream());
      PrintStream outPutStream = new PrintStream(newSocket.getOutputStream());

      outPutStream.println("hello::enter q to exit");
      boolean more_data = true;
      boolean firstTime = true;
      while (more_data) {

        String line = dataInputStream.readLine();
//        if (firstTime){
//          Server.stringSocketHashMap.put(line,newSocket);
//          firstTime=!firstTime;
//        }

        if (line.equals("list")) {
          String list[] = {""};
          Server.stringSocketHashMap.keySet().forEach(e -> {
            String youOnot = "";
            System.out.println(newSocket.getRemoteSocketAddress());
            if (newSocket.getRemoteSocketAddress().equals(Server.stringSocketHashMap.get(e).getRemoteSocketAddress())) {
              youOnot = "you";
            }
            list[0] += e +youOnot+ ",";
          });
          outPutStream.println(list[0]);
        }
        System.out.println(line);
        if (line == null) more_data = false;
        else {
          outPutStream.println("From Server: " + line + Math.random() + "in");
          if (line.trim().equals("q")) more_data = false;
        }
      }
      newSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
