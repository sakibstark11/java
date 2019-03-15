package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;

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
    } break;
   case "refresh": 
      try {
          JSONObject objectJson = null;
          JSONObject temp = new JSONObject();
          PreparedStatement statement = this.con.prepareStatement("SELECT * FROM PURCHASEORDERS");
          ResultSet result = statement.executeQuery();
          this.array = new JSONArray();
          
          while(result.next()){
              objectJson = new JSONObject();
          for (int x=1;x<(result.getMetaData().getColumnCount())+1;x++)
          {
              if(result.getMetaData().getColumnType(x)==java.sql.Types.INTEGER)
              {
                  objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), result.getInt(x));}
              else if(result.getMetaData().getColumnType(x)== java.sql.Types.VARCHAR)
              {
                  objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), result.getString(x));}
              else if(result.getMetaData().getColumnType(x)== java.sql.Types.BOOLEAN)
              {
                  objectJson.put(result.getMetaData().getColumnName(x).toLowerCase(), result.getBoolean(x));}
          }
              this.array.put(objectJson);
              
          }
          System.out.println(array);
          sendToClient(getRefreshJsonInString());
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
}