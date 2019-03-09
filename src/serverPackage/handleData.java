
package serverPackage;

import clientPackage.jsonParsing;
import org.json.JSONObject;

public class handleData {
    jsonParsing parseData = new jsonParsing(null, null, null);
    public handleData(String JSONInString){
    JSONObject toParse = new JSONObject(this.parseData.getStringJSON(JSONInString));
    System.out.println("in here");
    
    }
            
    
}
