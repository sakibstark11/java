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
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author sakib
 */
public class ClientConnection {

    private final String hostName;
    private final int serverPort;
    private Socket socket;
    private OutputStream clientOut;
    private PrintWriter printWriter;
    private InputStream serverIn;
    private BufferedReader bufferedIn;
    public ClientConnection (String hostName,int serverPort, String msg){
        this.hostName = hostName;
        this.serverPort = serverPort;
        if(connect()){
            System.out.println("connected");
                    try {
            //this.clientOut = socket.getOutputStream();
            System.out.println(msg);
            this.serverIn = socket.getInputStream();
            this.clientOut = socket.getOutputStream();
            this.bufferedIn = new BufferedReader(new InputStreamReader(serverIn));
            clientOut.write((msg+ "\n").getBytes());
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
            System.out.println("connection failed for some reason");
            connect();
        }
    }
    private boolean connect() {
        try {
            this.socket = new Socket(hostName,serverPort); //create new socket for client           
            return true; // return true on new connection otherwise false
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
        return false;
        }


}
    
