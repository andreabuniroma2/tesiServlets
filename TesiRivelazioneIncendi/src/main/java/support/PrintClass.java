package support;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import it.uniroma2.tesi.entity.Incendio;

public class PrintClass {
	public static JSONArray retrurnStatementToJSONArray(ArrayList<Incendio> incendi) throws JSONException {
		JSONArray jArray = new JSONArray();
		for(Incendio inc: incendi) {
			jArray.put(inc.getJson());
		}
		return jArray;
	}

}
