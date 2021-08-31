package it.uniroma2.tesi.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;

import it.uniroma2.tesi.dao.RicercaPerComuneDAO;
import support.CreateJSONS;
import support.GeneratoreQuery;

public class RicercaPerComuneDAOImp implements RicercaPerComuneDAO {
	private Connection conn;

	public RicercaPerComuneDAOImp(String urlDatabase, String userdb, String passwdb) {
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
	public String ricercaIncendi(String comune) throws JSONException {
		// TODO Auto-generated method stub
		JSONArray jArray = new JSONArray();
		String sql = GeneratoreQuery.queryStringRicercaComune(comune);
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
	public String ricercaIncendiConGravita(String comune, String gravità) throws JSONException {
		// TODO Auto-generated method stub
		JSONArray jArray = new JSONArray();
		String sql = GeneratoreQuery.queryStringRicercaComuneConGravità(comune,gravità);
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
	public String getListaIncendiComune(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ret = "";
		String comune = request.getParameter("comune");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravita = request.getParameter("gravity").trim();
				ret = ricercaIncendiConGravita(comune, gravita);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {

				System.out.println("prima della ricerca siamo nel gestisci richiesta");
				ret = ricercaIncendi(comune);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}

}
