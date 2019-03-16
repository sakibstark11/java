package serverPackage;

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

public class handleData {
 private  Socket clientSocket = null;
 private OutputStream clientOut = null;
 private JSONArray array = null; 
 Connection con;
 JSONObject jsonDataGlobal;
 public handleData(JSONObject jsonData, OutputStream clientOutStream, Socket clientSocket) {
  this.clientSocket = clientSocket;
  this.clientOut = clientOutStream;
  this.jsonDataGlobal = jsonData;
  System.out.println(jsonDataGlobal);
  try {
   con = DriverManager.getConnection("jdbc:derby://localhost:1527/CJB_database", "sakib", "sakib");
   System.out.println("connected to the database");
   if (jsonDataGlobal.getString("order").equals("purchase")) {
    purchaseTableHandler();
   } else if (jsonDataGlobal.getString("order").equals("store")){
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
     Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
    } break;
   case "update":
           try {
     PreparedStatement statement = this.con.prepareStatement("UPDATE PURCHASEORDERS SET DEPARTMENTCODE = ?,STATUS = ?, DELIVERYATTENTION = ?, COMPLETEDSTATUS =  ? WHERE PURCHASEID = ?");
     statement.setString(1, jsonDataGlobal.getString("departmentcode"));
     statement.setString(2, jsonDataGlobal.getString("status"));
     statement.setString(3, jsonDataGlobal.getString("deliveryattention"));
     if (jsonDataGlobal.getString("completedstatus").equals("true")) {
      statement.setBoolean(4, true);
     } else {
      statement.setBoolean(4, false);
     }
     statement.setInt(5, Integer.parseInt(jsonDataGlobal.getString("purchaseid")));
     statement.execute();
     System.out.println("updated");
    } catch (SQLException ex) {
     Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
    }break;
   case "refresh": 
      try {
          JSONObject objectJson = null;
          PreparedStatement statement = this.con.prepareStatement("SELECT * FROM PURCHASEORDERS");
          ResultSet result = statement.executeQuery();
          this.array = new JSONArray();
          
          while(result.next()){
              objectJson = new JSONObject();
          for (int x=1;x<(result.getMetaData().getColumnCount())+1;x++)
          {
                  switch (result.getMetaData().getColumnType(x)) {
                      case java.sql.Types.INTEGER:
                          objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), String.valueOf(result.getInt(x)));
                          break;
                      case java.sql.Types.VARCHAR:
                          objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), String.valueOf(result.getString(x)));
                          break;
                      case java.sql.Types.BOOLEAN:
                          objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), String.valueOf(result.getBoolean(x)));
                          break;
                      default:
                          break;
                  }
          }
              this.array.put(objectJson);
              
          }
          System.out.println(array);
          sendToClient(getRefreshJsonInString());
          } catch (SQLException ex) {
          Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
      } break;
   case "delete":
  
      try {
          PreparedStatement statement = this.con.prepareStatement("DELETE FROM PURCHASEORDERS WHERE PURCHASEID = ?");
          statement.setInt(1, Integer.parseInt(jsonDataGlobal.getString("purchaseid")));
          statement.execute();
          System.out.println("deleted");
      } catch (SQLException ex) {
          Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
      } break;
      
     
       
  }     
 }
    public String getRefreshJsonInString() {
        return this.array.toString();
        
    }

    private void sendToClient(String JsonInString) {
     try {
         this.clientOut = this.clientSocket.getOutputStream();
         this.clientOut.write((JsonInString+"\n").getBytes());
         this.clientOut.flush();
         System.out.println("sent");
     } catch (IOException ex) {
         Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
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
     Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
    } break;
   case "refresh": 
      try {
          JSONObject objectJson;
          PreparedStatement statement = this.con.prepareStatement("SELECT * FROM STOREROOM");
          ResultSet result = statement.executeQuery();
          this.array = new JSONArray();
          
          while(result.next()){
              objectJson = new JSONObject();
          for (int x=1;x<(result.getMetaData().getColumnCount())+1;x++)
          {
                  switch (result.getMetaData().getColumnType(x)) {
                      case java.sql.Types.INTEGER:
                          objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), String.valueOf(result.getInt(x)));
                          break;
                      case java.sql.Types.VARCHAR:
                          objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), String.valueOf(result.getString(x)));
                          break;
                      case java.sql.Types.BOOLEAN:
                          objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), String.valueOf(result.getBoolean(x)));
                          break;
                      default:
                          break;
                  }
          }
              this.array.put(objectJson);
              
          }
          System.out.println(array);
          sendToClient(getRefreshJsonInString());
          } catch (SQLException ex) {
          Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
      } break;
   case "delete":
      try {
          PreparedStatement statement = this.con.prepareStatement("DELETE FROM STOREROOM WHERE PARTID = ?");
          statement.setInt(1, Integer.parseInt(jsonDataGlobal.getString("partid")));
          statement.execute();
          System.out.println("deleted");
      } catch (SQLException ex) {
          Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
      } break;
   case "update":
             try {
          PreparedStatement statement = this.con.prepareStatement("UPDATE STOREROOM SET MANUFACTURER = ?,MANUFACTURERPARTNUMBER = ?, KANBANSIZE = ?, SAFETYLEVEL =  ? WHERE PARTID =?");
          statement.setInt(5, Integer.parseInt(jsonDataGlobal.getString("partid")));
          statement.setString(1, jsonDataGlobal.getString("manufacturer"));
          statement.setString(2, jsonDataGlobal.getString("manufacturerpartnumber"));
          statement.setInt(3, Integer.parseInt(jsonDataGlobal.getString("kanbansize")));
          statement.setInt(4, Integer.parseInt(jsonDataGlobal.getString("safetylevel")));          
          statement.execute();
          System.out.println("updated");
      } catch (SQLException ex) {
          Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
      } break;
       
   
        
    }
    }
}