/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClientConnection {
 private final String hostName;
 private final int serverPort;
 private Socket socket;
 private OutputStream clientOut;
 private OutputStreamWriter clientOutWriter;
 private PrintWriter printWriter;
 private InputStream serverIn;
 private BufferedReader bufferedIn;
 public ClientConnection(String hostName, int serverPort) {  
  this.hostName = hostName;
  this.serverPort = serverPort;
  
          
 }
 public boolean connect() {
  try {
   this.socket = new Socket(hostName, serverPort); //create new socket for client           
   return true; // return true on new connection otherwise false
  } catch (IOException ex) {
   ex.printStackTrace();
  }
  return false;
 }
 public void sendObject (String tosend){
       
   System.out.println("sending");
   try {
       
       this.clientOut = this.socket.getOutputStream();
       this.clientOut.write((tosend+"\n").getBytes());
       
   } catch (IOException ex) {
    Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
   }
 }
 
 public void recieveObject() {

        System.out.println("recieving");
     try {
               
         this.bufferedIn = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
         System.out.println("clientPackage.ClientConnection.recieveObject()");
         String incomingData;
         System.out.println();
         incomingData = this.bufferedIn.readLine();
         System.out.println("recieved");
         System.out.println(incomingData);
         JSONArray jsonParse = new JSONArray(incomingData);
              
 } catch (IOException ex) {
         Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
     
}
