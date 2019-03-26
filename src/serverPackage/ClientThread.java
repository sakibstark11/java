//7650714 Sakib
package serverPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import org.json.JSONObject;
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
                String incomingData = "";
                incomingData = bufferedReader.readLine();
                if (incomingData.equals("") || incomingData.equals(null)){
                    System.err.println("client trying to send corrupt");
                }
                JSONObject createTempJSON = new JSONObject(incomingData);
                DataHandler parseData = new DataHandler(createTempJSON, clientOut, clientSocket);
            }
        } catch (IOException ex) {
        }
    }
}
