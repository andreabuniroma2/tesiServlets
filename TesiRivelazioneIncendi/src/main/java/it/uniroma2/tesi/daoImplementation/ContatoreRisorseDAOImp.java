package it.uniroma2.tesi.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;

import it.uniroma2.tesi.dao.ContatoreRisorseDAO;
import support.CreateJSONS;
import support.GeneratoreQuery;

public class ContatoreRisorseDAOImp implements ContatoreRisorseDAO {
	private Connection conn;

	public ContatoreRisorseDAOImp(String urlDatabase, String userdb, String passwdb) {
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
	public String getContatori(HttpServletRequest request) throws JSONException {
		if (request.getParameterMap().containsKey("idIncendio")) {
			JSONArray jArray = new JSONArray();
			String idIncendio=request.getParameter("idIncendio");
			String sql = GeneratoreQuery.queryStringRicercaNumeroRisorse(idIncendio);
			System.out.println(sql);
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(sql);
				jArray = CreateJSONS.retrurnStatementToJSONArray(rset);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			return jArray.toString();
		} else
			return "";
	}

}
