package support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateJSONS {
	public static JSONArray retrurnStatementToJSONArray(ResultSet rset) throws JSONException {
		JSONArray jArray=new JSONArray();
		try {
			while (rset.next()) {
	            JSONObject obj = new JSONObject();
	            int total_rows = rset.getMetaData().getColumnCount();
	            for (int i = 0; i < total_rows; i++) {
	                obj.put(rset.getMetaData().getColumnLabel(i + 1)
	                        .toLowerCase(), rset.getObject(i + 1));

	            }
	            System.out.println(obj.toString());
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
