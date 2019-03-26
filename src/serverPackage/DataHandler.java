package serverPackage;
import clientPackage.JsonHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
public class DataHandler extends SQLHandler {
    private Socket clientSocket = null;
    private OutputStream clientOut = null;
    private JSONArray array = null;
    private Connection con = null;
    private JSONObject jsonDataGlobal = null;
    private JsonHandler jsonWoker = null;
    /**
     * routes the request to their respective function
     *
     * @param jsonData, the jsonobject data to scan through for requests
     * @param clientOutStream, the object stream
     * @param clientSocket, the socket from the client
     */
    public DataHandler(JSONObject jsonData, OutputStream clientOutStream, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.clientOut = clientOutStream;
        this.jsonDataGlobal = jsonData;
        this.jsonWoker = new JsonHandler();
        System.out.println(jsonDataGlobal);
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/CJB_database", "sakib", "sakib");
            System.out.println("connected to the database");
            if (jsonDataGlobal.getString("order").equals("purchase")) {
                purchaseTableHandler();
            } else if (jsonDataGlobal.getString("order").equals("store")) {
                storeTableHandler();
            } else if (jsonDataGlobal.getString("order").equals("line")) {
                purchaseLineHandler();
            }
        } catch (SQLException ex) {
            System.out.println("database not connected");
        }
    }
    /**
     * upon getting a request related to purchase table, this function is called
     * and it routes to the type of requests
     */
    private void purchaseTableHandler() {
        {
            connection = this.con;
            table = "PURCHASEORDERS";
            ID = "PURCHASEID";
            one = "DEPARTMENTCODE";
            two = "STATUS";
            three = "DELIVERYATTENTION";
            four = "COMPLETEDSTATUS";
            jsonData = this.jsonDataGlobal;
        }
        switch (this.jsonDataGlobal.getString("command")) {
            case "create":
                super.create();
                break;
            case "update":
                super.update();
                break;
            case "refresh":
                sendToClient((this.jsonWoker.createJsonFromResult(super.refresh())).toString());
                break;
            case "delete":
                if (!super.delete()) {
                    sendToClient("failed");
                } else {
                    sendToClient("done");
                }
                break;
            case "filter":
                sendToClient((this.jsonWoker.createJsonFromResult(super.filter())).toString());
                break;
        }
    }
    /**
     * sends back replies from server
     *
     * @param JsonInString, the information to send to client
     */
    private void sendToClient(String JsonInString) {
        try {
            this.clientOut = this.clientSocket.getOutputStream();
            this.clientOut.write((JsonInString + "\n").getBytes());
            this.clientOut.flush();
            System.out.println("sent");
        } catch (IOException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * handles requests related to purchaseorderline
     */
    private void purchaseLineHandler() {
        {
            connection = this.con;
            table = "PURCHASEORDERLINE";
            ID = "LINEID";
            one = "PURCHASEID";
            two = "PARTID";
            three = "QUANTITY";
            four = "PRICEPERUNIT";
            five = "SUPPLIER";
            jsonData = this.jsonDataGlobal;
        }
        switch (this.jsonDataGlobal.getString("command")) {
            case "create":
                super.create();
                break;
            case "refresh":
                sendToClient((this.jsonWoker.createJsonFromResult(super.refresh())).toString());
                break;
            case "delete":
                if (!super.delete()) {
                    sendToClient("failed");
                } else {
                    sendToClient("done");
                }
                break;
            case "update":
                super.update();
                break;
            case "filter":
                sendToClient(this.jsonWoker.createJsonFromResult(super.filter()).toString());
                break;
        }
    }
    /**
     * routes requests related to table store
     */
    private void storeTableHandler() {
        {
            connection = this.con;
            table = "STOREROOM";
            ID = "PARTID";
            one = "MANUFACTURER";
            two = "MANUFACTURERPARTNUMBER";
            three = "KANBANSIZE";
            four = "SAFETYLEVEL";
            jsonData = this.jsonDataGlobal;
        }
        switch (this.jsonDataGlobal.getString("command")) {
            case "create":
                super.create();
                break;
            case "refresh":
                sendToClient((this.jsonWoker.createJsonFromResult(super.refresh())).toString());
                break;
            case "delete":
                if (!super.delete()) {
                    sendToClient("failed");
                } else {
                    sendToClient("done");
                }
                break;
            case "update":
                super.update();
                break;
            case "filter":
                sendToClient((this.jsonWoker.createJsonFromResult(super.filter())).toString());
                break;
        }
    }
}