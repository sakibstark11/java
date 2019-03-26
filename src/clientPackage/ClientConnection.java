//7650714 Sakib
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
/**
 * creates a connection to the server
 * @return a boolean to assert connection status
 */
    public boolean connect() {
        try {
            this.socket = new Socket(hostName, serverPort); //create new socket for client           
            return true; // return true on new connection otherwise false
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
/**
 * sends the information to send to the server
 * @param tosend the information to send in a string format
 */
    public void sendObject(String tosend) {
        System.out.println("sending");
        try {
            System.err.println(tosend);
            this.clientOut = this.socket.getOutputStream();
            this.clientOut.write((tosend + "\n").getBytes());
            this.clientOut.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * receive an information from the server
 * @return the information in a string format
 */
    public String recieveObject() {
        System.out.println("recieving");
        try {
            this.bufferedIn = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String incomingData = "";
            incomingData = this.bufferedIn.readLine();
            System.out.println("recieved");
            System.err.println(incomingData);
            return incomingData;
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}