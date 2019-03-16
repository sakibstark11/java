
package clientPackage;
import java.io.Serializable;
import java.util.Vector;
import org.json.*;

public class JsonParsing implements Serializable{
    private String stringJSON = "";

    public JsonParsing(){      
    }
    public String parseJsonIntoString (String part,Vector <String> keys,Vector <String> values,String command){
//        String[] key;
//        String[] value;
//        String split = "-";
//        key = keys.split(split);
//        value = values.split(split);
        JSONObject jsonFor = new JSONObject();  

        
        jsonFor.put("order",part);
        jsonFor.put("command", command);
        for(int x=0; x<keys.size();x++){
         jsonFor.put(keys.get(x), values.get(x));   
        }   
        System.err.println(jsonFor);
        stringJSON = jsonFor.toString();  
        return stringJSON;
    }
    public JSONArray parseStringIntoArray( String JSONInString){
        JSONArray array = new JSONArray(JSONInString);
        System.out.println(array);
        return array;
    } 
    
    
}
