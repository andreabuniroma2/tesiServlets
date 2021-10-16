package support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import it.uniroma2.tesi.entity.Incendio;

public class CreateListIncendi {
	public static ArrayList<Incendio> retrurnStatementToIncendiList(ResultSet rset) throws JSONException {
		ArrayList <Incendio> incendi= new ArrayList<Incendio>();
		try {
			while (rset.next()) {
	            JSONObject obj = new JSONObject();
	            int total_rows = rset.getMetaData().getColumnCount();
	            for (int i = 0; i < total_rows; i++) {
	                obj.put(rset.getMetaData().getColumnLabel(i + 1)
	                        .toLowerCase(), rset.getObject(i + 1));

	            }
	            Incendio inc=new Incendio(obj);
	            incendi.add(inc);
	        }

			rset.close();

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}
		return incendi;
	}


}
