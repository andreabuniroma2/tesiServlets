package it.uniroma2.tesi.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.dao.RicercaPerDistanzaDAO;
import it.uniroma2.tesi.entity.Incendio;
import support.CreateListIncendi;
import support.GeneratoreQuery;
import support.PrintClass;

public class RicercaPerDistanzaDAOImp implements RicercaPerDistanzaDAO {
	private Connection conn;
	ServletContext sc;

	public RicercaPerDistanzaDAOImp(String urlDatabase, String userdb, String passwdb) {
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
	public String getIncendi(HttpServletRequest request) throws JSONException {
		// TODO Auto-generated method stub
		String ret = "";
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String distance = request.getParameter("distance");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravity = request.getParameter("gravity");
				ret = PrintClass.retrurnStatementToJSONArray(getIncendiWithDistanceAndGravity(latitude, longitude, distance, gravity)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				ret = PrintClass.retrurnStatementToJSONArray(getIncendiWithDistance(latitude, longitude, distance)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}

	@Override
	public ArrayList<Incendio> getIncendiWithDistanceAndGravity(String latitude, String longitude, String distance,
			String gravity) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi = new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaPerDistanzaWithGravity(latitude, longitude, distance, gravity);
		System.out.println(sql);
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			incendi = CreateListIncendi.retrurnStatementToIncendiList(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return incendi;
	}

	@Override
	public ArrayList<Incendio> getIncendiWithDistance(String latitude, String longitude, String distance)
			throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi = new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaPerDistanza(latitude, longitude, distance);
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			incendi = CreateListIncendi.retrurnStatementToIncendiList(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return incendi;
	}

}
