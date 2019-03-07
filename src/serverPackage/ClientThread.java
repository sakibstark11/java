package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

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
            System.out.println("setting up input stream");
            InputStream inputStream = clientSocket.getInputStream(); // to read incoming data
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));//to read incoming data line by line
            //OutputStream outputStream = clientSocket.getOutputStream(); // to send data to client
            //outputStream.write("this is server".getBytes());
            String incomingData;
            while ((incomingData = bufferedReader.readLine())!=null){
                
                System.out.println(incomingData);
            }
            
            
        } catch (IOException ex){
            ex.printStackTrace();
        }      
        }
}
