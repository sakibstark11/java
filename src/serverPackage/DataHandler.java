package serverPackage;

import clientPackage.JsonHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataHandler extends SQLHandler {

    private Socket clientSocket = null;
    private OutputStream clientOut = null;
    private JSONArray array = null;
    private Connection con;
    private JSONObject jsonDataGlobal;
    private JsonHandler parseJson;

    public DataHandler(JSONObject jsonData, OutputStream clientOutStream, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.clientOut = clientOutStream;
        this.jsonDataGlobal = jsonData;
        this.parseJson = new JsonHandler();
        System.out.println(jsonDataGlobal);
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/CJB_database", "sakib", "sakib");
            System.out.println("connected to the database");
            if (jsonDataGlobal.getString("order").equals("purchase")) {
                purchaseTableHandler();
            } else if (jsonDataGlobal.getString("order").equals("store")) {
                storeTableHandler();
            }
        } catch (SQLException ex) {
            System.out.println("database not connected");
        }
    }

    private void purchaseTableHandler() {
        {
            connection = con;
            table = "PURCHASEORDERS";
            ID = "PURCHASEID";
            one = "DEPARTMENTCODE";
            two = "STATUS";
            three = "DELIVERYATTENTION";
            four = "COMPLETEDSTATUS";
            jsonData = jsonDataGlobal;
        }
        switch (jsonDataGlobal.getString("command")) {
            case "create":
                super.create();
                break;
            case "update":
                super.update();
                break;
            case "refresh":
                sendToClient((parseJson.createJsonFromResult(super.refresh())).toString());

                break;
            case "delete":
                super.delete();
                break;
            case "filter":
                sendToClient((parseJson.createJsonFromResult(super.filter())).toString());
                break;
        }
    }

    public String getRefreshJsonInString() {
        return this.array.toString();

    }

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
        switch (jsonDataGlobal.getString("command")) {
            case "create":
                super.create();
                break;
            case "refresh":
                sendToClient((parseJson.createJsonFromResult(super.refresh())).toString());
                break;
            case "delete":
                super.delete();
                break;
            case "update":
                super.update();
                break;
            case "filter":
                sendToClient((parseJson.createJsonFromResult(super.filter())).toString());
                break;
        }
    }
}
