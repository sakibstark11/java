/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sakib
 */
public class Connection {
    private int port = 1999;
    private int clientNumber = 0;
    

    public Connection() {
        
        try {
            ServerSocket serverSocket = new ServerSocket(port); // creating instance of serversocket
            while(true){
                System.out.println("waiting for connection");
                Socket clientSocket = serverSocket.accept(); // the connection to a serversocket from a client
                System.out.println("client connected in que number: " + clientNumber);
                //whenever there is a connection create an indivisual thread for it
                //from the thread class
                ClientThread thread = new ClientThread(clientSocket);
                clientNumber++;
            }
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
        
    }
    
  
