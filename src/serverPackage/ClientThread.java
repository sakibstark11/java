package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread extends Thread {
 private  Socket clientSocket = null;
 private BufferedReader bufferedReader = null;
 public ClientThread(Socket clientSocket) {
  this.clientSocket = clientSocket;
  this.start();
 }
 @Override
 public void run() {
  clientThreading();
 }
 public void clientThreading() {

  try {
        System.out.println("setting up input stream");
        this.bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.err.println(bufferedReader.readLine());
        handleData prepareData = new handleData(bufferedReader.readLine());
        
        
  } catch (IOException ex) {
   Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
  }
 }
}