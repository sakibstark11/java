/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sakib
 */
public class server {
    
    
    
    
    
    
    
    
    
    
    public void connectClients(){
    
    
        System.out.println("connecting clients");
        try (ServerSocket serversock = new ServerSocket(2000)){
            try (
                    Socket sock = serversock.accept();
                    PrintWriter printWriter = new PrintWriter(sock.getOutputStream(), true);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sock.getInputStream()))
                    
                    );
        
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }   catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
