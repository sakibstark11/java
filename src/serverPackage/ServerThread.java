
package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {

 private final int port;
 private int clientNumber = 0;
 ServerThread(int port) {
  this.port = port;
  this.start();
 }

 @Override
 public void run() {
  ServerThreading();
 }
 private void ServerThreading() {
  try {
   ServerSocket serverSocket = new ServerSocket(port); // creating instance of serversocket
   while (true) {
    System.out.println("waiting for connection");
    try {
     Socket clientSocket = serverSocket.accept(); // the connection to a serversocket from a client
     ClientThread thread = new ClientThread(clientSocket);
    } catch (IOException ex) {
     ex.printStackTrace();
    }
    System.out.println("client connected in que number: " + clientNumber);
    //whenever there is a connection create an indivisual thread for it
    //from the thread class
    clientNumber++;
   }
  } catch (IOException ex) {
   ex.printStackTrace();
  }
 }

}