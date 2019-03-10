
package serverPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class handleData {
Connection con;
JSONObject jsonDataGlobal;
    public handleData(JSONObject jsonData){
        this.jsonDataGlobal = jsonData;
        System.out.println(jsonDataGlobal);
        try {
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/CJB_database","sakib","sakib");
            System.out.println("connected");
            System.out.println(jsonDataGlobal.getString("order"));
            System.out.println(jsonDataGlobal.getString("command"));
            if (jsonDataGlobal.getString("order") == "purchase"){
                switch(jsonDataGlobal.getString("command")){
                    case "create":
                        createPurchase();
                }
            }
            else {
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }

    private void createPurchase() {
    try {
        PreparedStatement statement = con.prepareStatement("INSERT INTO PURCHASEORDER(DEPARTMENTCODE,STATUS,DELIVERYATTENTION,COMPLETEDSTATUS)");
        System.out.println("serverPackage.handleData.createPurchase()");
        statement.setString(1, jsonDataGlobal.getString("deptcode"));
        statement.setString(2,jsonDataGlobal.getString("stat"));
        statement.setString(3, jsonDataGlobal.getString("dev"));
        if (jsonDataGlobal.getString("comp")== "yes"){
            
            statement.setBoolean(4, true);
        }else
        {statement.setBoolean(4,false);}
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted>0){
            System.out.println("added");
        }
    } catch (SQLException ex) {
        Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }
            
    
}
