
package clientPackage;
import java.io.Serializable;
import org.json.*;

public class jsonParsing implements Serializable{
    private String stringJSON = "";

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
        stringJSON = jsontype.toString();  
    }
    // to get a json object in the form of a string
    public String getJSONString() {
        return stringJSON;
}
}
