
package clientPackage;
import java.io.Serializable;
import org.json.*;

public class JsonParsing implements Serializable{
    private String stringJSON = "";

    public JsonParsing(String part,String keys,String values,String command){
        String[] key;
        String[] value;
        String split = "-";
        key = keys.split(split);
        value = values.split(split);
        JSONObject jsonFor = new JSONObject();  
        jsonFor.put("order",part);
        jsonFor.put("command", command);
        for(int x=0; x<key.length;x++){
         jsonFor.put(key[x], value[x]);   
        }   
        System.err.println(jsonFor);
        stringJSON = jsonFor.toString();  
    }
    // to get a json object in the form of a string
    public String getJSONString() {
        return stringJSON;
}
}
