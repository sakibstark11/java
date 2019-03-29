//7650714 Sakib
package serverPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 * takes care of sql queries and returns succession/failure results
 *
 * @author sakib
 */
public abstract class SQLHandler {

    protected Connection connection;
    protected String table;
    protected String ID;
    protected String one, two, three, four, five;
    protected JSONObject jsonData;

    /**
     * does a delete operation on the table
     *
     * @return boolean from server
     */
    protected boolean delete() {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM " + this.table + " WHERE " + this.ID + " = ? ");
            statement.setInt(1, Integer.parseInt(this.jsonData.getString(this.ID.toLowerCase())));
            statement.execute();
            System.out.println("deleted");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * does a filter operation on the table
     *
     * @return
     */
    protected ResultSet filter() {
        ResultSet result = null;
        switch (this.table) {
            case "STOREROOM":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM " + this.table + " WHERE " + this.one + " =? AND " + this.two + " = ? AND " + this.three + " = ? AND " + this.four + " = ?");
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
                    PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM " + this.table + " WHERE " + this.one + " =? AND " + this.two + " = ? AND " + this.three + " = ? AND " + this.four + " = ?");
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
            case "PURCHASEORDERLINE":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM " + this.table + " WHERE " + this.one + " =? AND " + this.two + " =? AND " + this.three + " =? AND " + this.four + " =? AND " + this.five + " =? ");
                    statement.setInt(1, Integer.parseInt(this.jsonData.getString(one.toLowerCase())));
                    statement.setInt(2, Integer.parseInt(this.jsonData.getString(two.toLowerCase())));
                    statement.setInt(3, Integer.parseInt(this.jsonData.getString(three.toLowerCase())));
                    statement.setDouble(4, Double.parseDouble(this.jsonData.getString(four.toLowerCase())));
                    statement.setString(5, this.jsonData.getString(five.toLowerCase()));
                    result = statement.executeQuery();

                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
        return result;
    }

    /**
     * does an update operation on the table
     *
     * @return a boolean to clarify the update
     */
    protected boolean update() {
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
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            case "PURCHASEORDERLINE":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("UPDATE " + this.table + " SET " + this.one + "=?," + this.two + "=?," + this.three + "=?," + this.four + "=?," + this.five + "=? WHERE " + this.ID + "=?");
                    statement.setInt(1, Integer.parseInt(this.jsonData.getString(one.toLowerCase())));
                    statement.setInt(2, Integer.parseInt(this.jsonData.getString(two.toLowerCase())));
                    statement.setInt(3, Integer.parseInt(this.jsonData.getString(three.toLowerCase())));
                    statement.setDouble(4, Double.parseDouble(this.jsonData.getString(four.toLowerCase())));
                    statement.setString(5, this.jsonData.getString(five.toLowerCase()));
                    statement.setInt(6, Integer.parseInt(this.jsonData.getString(ID.toLowerCase())));
                    statement.execute();
                    System.out.println("updated");
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
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
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
        }
        return false;
    }

    /**
     * does a refresh operation on the table
     *
     * @return
     */
    protected ResultSet refresh() {
        ResultSet result = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM " + this.table);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * does a create record operation on the table
     */
    protected void create() {
        switch (this.table) {
            case "PURCHASEORDERLINE":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("INSERT INTO " + this.table + "( " + this.one + "," + this.two + "," + this.three + "," + this.four + "," + this.five + " ) " + "VALUES (?,?,?,?,?)");
                    statement.setInt(1, Integer.parseInt(this.jsonData.getString(one.toLowerCase())));
                    statement.setInt(2, Integer.parseInt(this.jsonData.getString(two.toLowerCase())));
                    statement.setInt(3, Integer.parseInt(this.jsonData.getString(three.toLowerCase())));
                    statement.setDouble(4, Double.parseDouble(this.jsonData.getString(four.toLowerCase())));
                    statement.setString(5, this.jsonData.getString(five.toLowerCase()));
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("added");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "PURCHASEORDERS":
                try {
                    PreparedStatement statement = this.connection.prepareStatement("INSERT INTO " + this.table + " ( " + this.one + "," + this.two + "," + this.three + "," + this.four + ")" + "VALUES (?,?,?,?)");
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
                break;
        }
    }
}
