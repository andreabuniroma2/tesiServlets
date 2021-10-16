package support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import it.uniroma2.tesi.entity.Incendio;

public class CreateJSONS {
	public static JSONArray retrurnStatementToJSONArray(ResultSet rset) throws JSONException {
		JSONArray jArray = new JSONArray();
		ArrayList <Incendio> incendi= new ArrayList<Incendio>();
		try {
			while (rset.next()) {
				JSONObject obj = new JSONObject();
				int total_rows = rset.getMetaData().getColumnCount();
			    //System.out.println(rset.getString("pippo"));
				for (int i = 0; i < total_rows; i++) {
					obj.put(rset.getMetaData().getColumnLabel(i + 1).toLowerCase(), rset.getObject(i + 1));

				}
			
				jArray.put(obj);
			}

			rset.close();

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}
		return jArray;
	}

}
