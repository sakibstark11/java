
package clientPackage;
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
        ClientConnection connectClient = new ClientConnection("127.0.0.1", 1999);
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });    
    }
}