
package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client{
    
    
    
    public static void main(String args[])
    {
        try {
            Socket sock = new Socket("localhost", 20);
            PrintStream PS = new PrintStream(sock.getOutputStream());
            PS.println("Hello this is client");
            InputStreamReader IR = new InputStreamReader(sock.getInputStream());
            BufferedReader BR = new BufferedReader(IR);
            String message = BR.readLine();
            System.out.println(message);
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}