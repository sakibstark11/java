/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientPackage;
import java.io.Serializable;
import javax.print.DocFlavor;
import org.json.*;
/**
 *
 * @author sakib
 */
public class jsonParsing implements Serializable{
    JSONObject jsontype = null;

    public jsonParsing(String mainkey,String keys,String values){
        String[] key;
        String[] value;
        String split = "-";
        key = keys.split(split);
        value = values.split(split);
        JSONObject jsonFor = new JSONObject();  
        for(int x=0; x<key.length;x++){
         jsonFor.put(key[x], value[x]);   
        }   
        JSONObject jsontype = new JSONObject();
        jsontype.append(mainkey, jsonFor);
        System.err.println(jsontype);
    }
    public String getJSON() {
        //return null;
        String stringJSON = jsontype.toString();
        return stringJSON;
}
}
