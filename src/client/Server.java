
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.org.xml.sax.InputSource;


public class Server {
    
    
    
    public static void main(String args[]) throws IOException
    {
        ServerSocket serverSock = new ServerSocket(20);
            Socket sock = serverSock.accept();
            InputStreamReader IR = new InputStreamReader(sock.getInputStream());
            BufferedReader BR = new BufferedReader(IR);
            String message = BR.readLine();
            System.out.println(message);
            if (message !=null){
                PrintStream PS = new PrintStream(sock.getOutputStream());
                PS.println("message caught");
            }
    }
    
}
