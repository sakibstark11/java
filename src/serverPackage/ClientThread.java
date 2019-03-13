package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class ClientThread extends Thread {
 private  Socket clientSocket = null;
 private OutputStream clientOut;
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
        while (clientSocket!=null){
        System.out.println("setting up input stream");
        this.bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while(bufferedReader.readLine()!=null){
        String incomingData = (bufferedReader.readLine());
        JSONObject createTempJSON = new JSONObject(incomingData);
        handleData parseData = new handleData(createTempJSON);}}
        //this.clientOut = clientSocket.getOutputStream();
        //this.clientOut.write((parseData.getRefreshJsonInString()+"\n").getBytes());
        System.err.println("sent");
  } catch (IOException ex) {
   ;
  }
 }
}