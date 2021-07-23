package it.uniroma2.tesi.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import it.uniroma2.tesi.dao.RicercaInItaliaDAO;

public class RicercaInItaliaDAOImp implements RicercaInItaliaDAO {
	private Connection conn;
	ServletContext sc;

	public RicercaInItaliaDAOImp(String urlDatabase, String userdb, String passwdb) {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(urlDatabase, userdb, passwdb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getListaProvince(String codiceRegione) throws JSONException {
		// TODO Auto-generated method stub
		JSONArray jArray = new JSONArray();
		System.out.println("dentro get lista province");
		String sql = "SELECT id,nome from province WHERE id_regione=" + codiceRegione + "";
		System.out.println(sql);
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			System.out.println(rset);
			while (rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("id", rset.getObject(1));
				jobj.put("nome", rset.getObject(2));
				jArray.put(jobj);
			}

			rset.close();
			stmt.close();

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

		return jArray.toString();

	}

	@Override
	public String getListaComuni(String codiceProvincia) throws JSONException {
		// TODO Auto-generated method stub
		JSONArray jArray = new JSONArray();
		String sql = "SELECT id,nome from comuni WHERE id_provincia=" + codiceProvincia + "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);

			while (rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("id", rset.getObject(1));
				jobj.put("nome", rset.getObject(2));
				jArray.put(jobj);

			}

			rset.close();
			stmt.close();

		} catch (SQLException e) {

			e.printStackTrace();

			return null;
		}

		return jArray.toString();

	}

	@Override
	public String gestisciRichiesta(HttpServletRequest richiesta) {
		// TODO Auto-generated method stub
		String ret = "";
		String tipoDiRichiesta = richiesta.getParameter("tipo").trim();
		String id = richiesta.getParameter("id");
		if (tipoDiRichiesta.equals("provincia"))
			try {
				System.out.println("prima della ricerca siamo nel gestisci richiesta");
				ret = getListaProvince(id);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if (tipoDiRichiesta.equals("comune"))
			try {
				ret = getListaComuni(id);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}

}
