package serverPackage;

import clientPackage.JsonHandler;
import com.oracle.util.Checksums;
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

public class DataHandler {

    private Socket clientSocket = null;
    private OutputStream clientOut = null;
    private JSONArray array = null;
    Connection con;
    JSONObject jsonDataGlobal;
    JsonHandler parseJson;

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
        switch (jsonDataGlobal.getString("command")) {
            case "create":
                try {
                    PreparedStatement statement = this.con.prepareStatement("INSERT INTO PURCHASEORDERS(DEPARTMENTCODE,STATUS,DELIVERYATTENTION,COMPLETEDSTATUS) VALUES (?,?,?,?)");
                    statement.setString(1, jsonDataGlobal.getString("departmentcode"));
                    statement.setString(2, jsonDataGlobal.getString("status"));
                    statement.setString(3, jsonDataGlobal.getString("deliveryattention"));
                    if (jsonDataGlobal.getString("completedstatus").equals("true")) {
                        statement.setBoolean(4, true);
                    } else {
                        statement.setBoolean(4, false);
                    }
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("added");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "update":
                update(con, "PURCHASEORDERS", jsonDataGlobal, "PURCHASEID", "DEPARTMENTCODE", "STATUS", "DELIVERYATTENTION", "COMPLETEDSTATUS");
                break;
            case "refresh":
                try {
                    PreparedStatement statement = this.con.prepareStatement("SELECT * FROM PURCHASEORDERS");
                    ResultSet result = statement.executeQuery();
                    sendToClient(parseJson.createJsonFromResult(result).toString());
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "delete":
                delete(con, "PURCHASEORDERS", jsonDataGlobal, "PURCHASEID");
                break;
            case "filter":
                filter(con, "PURCHASEORDERS", jsonDataGlobal, "DEPARTMENTCODE", "STATUS", "DELIVERYATTENTION", "COMPLETEDSTATUS");
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
        switch (jsonDataGlobal.getString("command")) {
            case "create":

                try {
                    PreparedStatement statement = this.con.prepareStatement("INSERT INTO STOREROOM(MANUFACTURER,MANUFACTURERPARTNUMBER,KANBANSIZE,SAFETYLEVEL) VALUES (?,?,?,?)");
                    statement.setString(1, jsonDataGlobal.getString("manufacturer"));
                    statement.setString(2, jsonDataGlobal.getString("manufacturerpartnumber"));
                    statement.setInt(3, Integer.parseInt(jsonDataGlobal.getString("kanbansize")));
                    statement.setInt(4, Integer.parseInt(jsonDataGlobal.getString("safetylevel")));
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("added");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "refresh":
                try {
                    PreparedStatement statement = this.con.prepareStatement("SELECT * FROM STOREROOM");
                    ResultSet result = statement.executeQuery();
                    sendToClient(parseJson.createJsonFromResult(result).toString());
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "delete":
                delete(con, "STOREROOM", jsonDataGlobal, "PARTID");
                break;
            case "update":
                update(con, "STOREROOM", jsonDataGlobal, "PARTID", "MANUFACTURER", "MANUFACTURERPARTNUMBER", "KANBANSIZE", "SAFETYLEVEL");

                break;
            case "filter":
                filter(con, "STOREROOM", jsonDataGlobal, "MANUFACTURER", "MANUFACTURERPARTNUMBER", "KANBANSIZE", "SAFETYLEVEL");
                break;

        }
    }

    private void delete(Connection con, String table, JSONObject jsonDataGlobal, String ID) {
        try {
            PreparedStatement statement = this.con.prepareStatement("DELETE FROM " + table + " WHERE " + ID + " = ?");
            statement.setInt(1, Integer.parseInt(jsonDataGlobal.getString(ID.toLowerCase())));
            statement.execute();
            System.out.println("deleted");
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void filter(Connection con, String table, JSONObject jsonDataGlobal, String one, String two, String three, String four) {
        switch (table) {
            case "STOREROOM":
                try {
                    PreparedStatement statement = this.con.prepareStatement("SELECT * FROM " + table + " WHERE " + one + " =? AND " + two + " = ? AND " + three + " = ? AND " + four + " = ?");
                    this.con.prepareStatement("SELECT * FROM " + table + " WHERE " + one + " =? AND " + two + " = ? AND " + three + " = ? AND " + four + " = ?");
                    statement.setString(1, jsonDataGlobal.getString(one.toLowerCase()));
                    statement.setString(2, jsonDataGlobal.getString(two.toLowerCase()));
                    statement.setInt(3, Integer.parseInt(jsonDataGlobal.getString(three.toLowerCase())));
                    statement.setInt(4, Integer.parseInt(jsonDataGlobal.getString(four.toLowerCase())));
                    ResultSet result = statement.executeQuery();
                    sendToClient(parseJson.createJsonFromResult(result).toString());
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "PURCHASEORDERS":
                try {
                    PreparedStatement statement = this.con.prepareStatement("SELECT * FROM " + table + " WHERE " + one + " =? AND " + two + " = ? AND " + three + " = ? AND " + four + " = ?");
                    statement.setString(1, jsonDataGlobal.getString(one.toLowerCase()));
                    statement.setString(2, jsonDataGlobal.getString(two.toLowerCase()));
                    statement.setString(3, jsonDataGlobal.getString(three.toLowerCase()));
                    if (jsonDataGlobal.getString(four.toLowerCase()).equals("true")) {
                        statement.setBoolean(4, true);
                    } else {
                        statement.setBoolean(4, false);
                    }
                    ResultSet result = statement.executeQuery();
                    sendToClient(parseJson.createJsonFromResult(result).toString());
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }

    }

    private void update(Connection con, String table, JSONObject jsonDataGlobal, String ID, String one, String two, String three, String four) {
        switch (table) {
            case "STOREROOM":
                try {
                    PreparedStatement statement = this.con.prepareStatement("UPDATE " + table + " SET " + one + " = ? ," + two + " = ?," + three + " = ?," + four + " = ? WHERE " + ID + " = ?");
                    statement.setInt(5, Integer.parseInt(jsonDataGlobal.getString(ID.toLowerCase())));
                    statement.setString(1, jsonDataGlobal.getString(one.toLowerCase()));
                    statement.setString(2, jsonDataGlobal.getString(two.toLowerCase()));
                    statement.setInt(3, Integer.parseInt(jsonDataGlobal.getString(three.toLowerCase())));
                    statement.setInt(4, Integer.parseInt(jsonDataGlobal.getString(four.toLowerCase())));
                    statement.execute();
                    System.out.println("updated");
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "PURCHASEORDERS":
                try {
                    PreparedStatement statement = this.con.prepareStatement("UPDATE " + table + " SET " + one + " = ? ," + two + " = ?," + three + " = ?," + four + " = ? WHERE " + ID + " = ?");
                    statement.setString(1, jsonDataGlobal.getString(one.toLowerCase()));
                    statement.setString(2, jsonDataGlobal.getString(two.toLowerCase()));
                    statement.setString(3, jsonDataGlobal.getString(three.toLowerCase()));
                    if (jsonDataGlobal.getString(four.toLowerCase()).equals("true")) {
                        statement.setBoolean(4, true);
                    } else {
                        statement.setBoolean(4, false);
                    }
                    statement.setInt(5, Integer.parseInt(jsonDataGlobal.getString(ID.toLowerCase())));
                    statement.execute();
                    System.out.println("updated");
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}
