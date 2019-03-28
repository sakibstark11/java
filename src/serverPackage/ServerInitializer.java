//7650714 Sakib
package serverPackage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/**
 * takes care of setting up server and all its jobs such as client communication, keeping track of client numbers
 * @author sakib
 */
public class ServerInitializer {
    private final int port;
    private int clientNumber = 0;
    private final ArrayList<ClientThread> clientList = new ArrayList<>(); // for broadcasting purpose
    ServerInitializer(int port) {
        this.port = port;
        serverThreading();
    }
    private void serverThreading() {
        try {
            ServerSocket serverSocket = new ServerSocket(port); // creating instance of serversocket
            while (true) {
                System.out.println("waiting for connection");
                try {
                    Socket clientSocket = serverSocket.accept(); // the connection to a serversocket from a client
                    ClientThread thread = new ClientThread(clientSocket);
                    clientList.add(thread);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("client connected in que number: " + clientNumber);
                //whenever there is a connection create an individual thread for it
                //from the thread class
                clientNumber++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
