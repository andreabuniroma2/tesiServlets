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
import it.uniroma2.tesi.dao.RicercaPerProvinciaDAO;
import support.CreateJSONS;
import support.GeneratoreQuery;

public class RicercaPerProvinciaDAOImp implements RicercaPerProvinciaDAO {
	private Connection conn;
	ServletContext sc;
	public RicercaPerProvinciaDAOImp(String urlDatabase, String userdb, String passwdb) {
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
	public String getListaIncendiProvincia(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ret = "";
		String provincia = request.getParameter("province");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravita = request.getParameter("gravity").trim();
				ret = ricercaIncendiConGravita(provincia, gravita);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {

				System.out.println("prima della ricerca siamo nel gestisci richiesta");
				ret = ricercaIncendi(provincia);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}

	@Override
	public String ricercaIncendi(String provincia) throws JSONException {
		// TODO Auto-generated method stub
		JSONArray jArray = new JSONArray();
		String sql = GeneratoreQuery.queryStringRicercaPerProvincia(provincia);
		System.out.println(sql);
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			jArray=CreateJSONS.retrurnStatementToJSONArray(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return jArray.toString();
	}

	@Override
	public String ricercaIncendiConGravita(String provincia, String gravità) throws JSONException {
		// TODO Auto-generated method stub
		JSONArray jArray = new JSONArray();
		String sql = GeneratoreQuery.queryStringRicercaPerProvinciaConGravità(provincia,gravità);
		System.out.println(sql);
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			jArray=CreateJSONS.retrurnStatementToJSONArray(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return jArray.toString();
	}

}
