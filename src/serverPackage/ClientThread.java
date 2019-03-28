//7650714 Sakib
package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import org.json.JSONObject;

/**
 * takes care of care incoming data and routes them to the parsing data handler classes
 *
 * @author sakib
 */
public class ClientThread extends Thread {

    private Socket clientSocket = null;
    private OutputStream clientOut;
    private BufferedReader bufferedReader = null;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        super.start();
    }

    @Override
    public void run() {
        clientThreading();
    }

    public void clientThreading() {
        try {
            while (clientSocket != null) {
                System.out.println("setting up input stream");
                this.bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String incomingData = bufferedReader.readLine();
                while (incomingData != null) {
                    JSONObject createTempJSON = new JSONObject(incomingData);
                    DataHandler parseData = new DataHandler(createTempJSON, clientOut, clientSocket);
                    incomingData = bufferedReader.readLine();
                }
                System.err.println("client tried to send corrupted data");
            }
        } catch (IOException ex) {
            System.out.println("something went wrong/ a client got disconnected");
        }
    }
}
