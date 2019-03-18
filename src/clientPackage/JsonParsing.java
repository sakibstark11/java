package clientPackage;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import serverPackage.handleData;

public class JsonParsing implements Serializable {

    private String stringJSON = "";
    private JSONArray array;
    public JsonParsing() {
    }

    public String parseJsonIntoString(String part, Vector< String> keys, Vector< String> values, String command) {
        JSONObject jsonFor = new JSONObject();
        jsonFor.put("order", part);
        jsonFor.put("command", command);
        for (int x = 0; x < keys.size(); x++) {
            jsonFor.put(keys.get(x), values.get(x));
        }
        System.err.println(jsonFor);
        stringJSON = jsonFor.toString();
        return stringJSON;
    }

    public JSONArray parseStringIntoArray(String JSONInString) {
        JSONArray array = new JSONArray(JSONInString);
        System.out.println(array);
        return array;
    }
    public JSONArray createJsonFromResult(ResultSet result) {
            this.array = new JSONArray();
        try {
                    JSONObject objectJson;

                    while (result.next()) {
                        objectJson = new JSONObject();
                        for (int x = 1; x < (result.getMetaData().getColumnCount()) + 1; x++) {
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
                        array.put(objectJson);

                    }
                    System.out.println(array);
                } catch (SQLException ex) {
                    Logger.getLogger(handleData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return this.array;
        
    }
}
