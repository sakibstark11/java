package serverPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class handleData {
 Connection con;
 JSONObject jsonDataGlobal;
 public handleData(JSONObject jsonData) {
  this.jsonDataGlobal = jsonData;
  System.out.println(jsonDataGlobal);
  try {

   con = DriverManager.getConnection("jdbc:derby://localhost:1527/CJB_database", "sakib", "sakib");
   System.out.println("connected");
   if (jsonDataGlobal.getString("order").equals("purchase")) {
    purchaseTableHandler();
   } else {}

  } catch (SQLException ex) {
   Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
  }

 }

 private void purchaseTableHandler() {
  switch (jsonDataGlobal.getString("command")) {
   case "create":
    try {
     PreparedStatement statement = this.con.prepareStatement("INSERT INTO PURCHASEORDERS(DEPARTMENTCODE,STATUS,DELIVERYATTENTION,COMPLETEDSTATUS) VALUES (?,?,?,?)");
     statement.setString(1, jsonDataGlobal.getString("dept"));
     statement.setString(2, jsonDataGlobal.getString("stat"));
     statement.setString(3, jsonDataGlobal.getString("dev"));
     if (jsonDataGlobal.getString("comp").equals("yes")) {
      statement.setBoolean(4, true);
     } else {
      statement.setBoolean(4, false);
     }
     int rowsInserted = statement.executeUpdate();
     if (rowsInserted > 0) {
      System.out.println("added");
     }
    } catch (SQLException ex) {
     Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
    }
   case "refresh": 
      try {
          PreparedStatement statement = this.con.prepareStatement("SELECT * FROM PURCHASEORDERS");
          ResultSet result = statement.executeQuery();
          JSONObject objectJson = new JSONObject();
          while(result.next()){
          for (int x=1;x<(result.getMetaData().getColumnCount())+1;x++)
          {
              if(result.getMetaData().getColumnType(x)==java.sql.Types.INTEGER)
              {objectJson.put(result.getMetaData().getColumnName(x), result.getInt(x));}
              if(result.getMetaData().getColumnType(x)== java.sql.Types.VARCHAR)
              {objectJson.put(result.getMetaData().getColumnName(x), result.getString(x));}
              if(result.getMetaData().getColumnType(x)== java.sql.Types.BOOLEAN)
              {objectJson.put(result.getMetaData().getColumnName(x), result.getBoolean(x));}
          }
          }
          System.out.println(objectJson);
          
      } catch (SQLException ex) {
          Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
 }
}