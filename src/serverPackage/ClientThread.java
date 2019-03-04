/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPackage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author sakib
 */
public class ClientThread extends Thread{
    private final Socket clientSocket;
    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;
        this.start();
}

    @Override
    public void run() {
        clientThreading();

    }
    public void clientThreading (){
        try{
        OutputStream outputStream = clientSocket.getOutputStream(); // to send data to client
        outputStream.write("hello client from server".getBytes());
        } catch (IOException ex){
            ex.printStackTrace();
        }
        
        }
    
}
