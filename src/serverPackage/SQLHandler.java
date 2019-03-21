/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPackage;

import clientPackage.JsonHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author sakib
 */
public abstract class SQLHandler {

    protected Connection connection;
    protected String table;
    protected String ID;
    protected String one, two, three, four;
    protected JSONObject jsonData;
    protected JsonHandler parseJson = new JsonHandler();

    protected void delete() {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM " + this.table + " WHERE " + ID + " = ?");
            statement.setInt(1, Integer.parseInt(this.jsonData.getString(this.ID.toLowerCase())));
            statement.execute();
            System.out.println("deleted");
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected ResultSet filter() {
        ResultSet result = null;
        switch (this.table) {
            case "STOREROOM":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM " + table + " WHERE " + one + " =? AND " + two + " = ? AND " + three + " = ? AND " + four + " = ?");
                    this.connection.prepareStatement("SELECT * FROM " + table + " WHERE " + one + " =? AND " + two + " = ? AND " + three + " = ? AND " + four + " = ?");
                    statement.setString(1, this.jsonData.getString(one.toLowerCase()));
                    statement.setString(2, this.jsonData.getString(two.toLowerCase()));
                    statement.setInt(3, Integer.parseInt(this.jsonData.getString(three.toLowerCase())));
                    statement.setInt(4, Integer.parseInt(this.jsonData.getString(four.toLowerCase())));
                    result = statement.executeQuery();

                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "PURCHASEORDERS":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM " + table + " WHERE " + one + " =? AND " + two + " = ? AND " + three + " = ? AND " + four + " = ?");
                    statement.setString(1, this.jsonData.getString(one.toLowerCase()));
                    statement.setString(2, this.jsonData.getString(two.toLowerCase()));
                    statement.setString(3, this.jsonData.getString(three.toLowerCase()));
                    if (this.jsonData.getString(four.toLowerCase()).equals("true")) {
                        statement.setBoolean(4, true);
                    } else {
                        statement.setBoolean(4, false);
                    }
                    result = statement.executeQuery();

                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
        return result;

    }

    protected void update() {
        switch (this.table) {
            case "STOREROOM":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("UPDATE " + this.table + " SET " + this.one + " = ? ," + this.two + " = ?," + this.three + " = ?," + this.four + " = ? WHERE " + this.ID + " = ?");
                    statement.setInt(5, Integer.parseInt(this.jsonData.getString(ID.toLowerCase())));
                    statement.setString(1, this.jsonData.getString(one.toLowerCase()));
                    statement.setString(2, this.jsonData.getString(two.toLowerCase()));
                    statement.setInt(3, Integer.parseInt(this.jsonData.getString(three.toLowerCase())));
                    statement.setInt(4, Integer.parseInt(this.jsonData.getString(four.toLowerCase())));
                    statement.execute();
                    System.out.println("updated");
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "PURCHASEORDERS":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("UPDATE " + this.table + " SET " + this.one + " = ? ," + this.two + " = ?," + this.three + " = ?," + this.four + " = ? WHERE " + this.ID + " = ?");
                    statement.setString(1, this.jsonData.getString(one.toLowerCase()));
                    statement.setString(2, this.jsonData.getString(two.toLowerCase()));
                    statement.setString(3, this.jsonData.getString(three.toLowerCase()));
                    if (this.jsonData.getString(four.toLowerCase()).equals("true")) {
                        statement.setBoolean(4, true);
                    } else {
                        statement.setBoolean(4, false);
                    }
                    statement.setInt(5, Integer.parseInt(this.jsonData.getString(ID.toLowerCase())));
                    statement.execute();
                    System.out.println("updated");
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    protected ResultSet refresh() {
        ResultSet result = null;
        switch (this.table) {
            case "PURCHASEORDERS":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM PURCHASEORDERS");
                    result = statement.executeQuery();

                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "STOREROOM":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM STOREROOM");
                    result = statement.executeQuery();

                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
        return result;
    }

    protected void create() {
        switch (this.table) {
            case "PURCHASEORDERS":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("INSERT INTO PURCHASEORDERS(DEPARTMENTCODE,STATUS,DELIVERYATTENTION,COMPLETEDSTATUS) VALUES (?,?,?,?)");
                    statement.setString(1, this.jsonData.getString(one.toLowerCase()));
                    statement.setString(2, this.jsonData.getString(two.toLowerCase()));
                    statement.setString(3, this.jsonData.getString(three.toLowerCase()));
                    if (this.jsonData.getString(four.toLowerCase()).equals("true")) {
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
            case "STOREROOM":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("INSERT INTO STOREROOM(MANUFACTURER,MANUFACTURERPARTNUMBER,KANBANSIZE,SAFETYLEVEL) VALUES (?,?,?,?)");
                    statement.setString(1, this.jsonData.getString(one.toLowerCase()));
                    statement.setString(2, this.jsonData.getString(two.toLowerCase()));
                    statement.setInt(3, Integer.parseInt(this.jsonData.getString(three.toLowerCase())));
                    statement.setInt(4, Integer.parseInt(this.jsonData.getString(four.toLowerCase())));
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("added");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
    }
}
