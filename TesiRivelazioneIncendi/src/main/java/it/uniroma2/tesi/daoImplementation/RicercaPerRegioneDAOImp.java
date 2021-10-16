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

import it.uniroma2.tesi.dao.RicercaPerRegioneDAO;
import it.uniroma2.tesi.entity.Incendio;
import support.CreateListIncendi;
import support.GeneratoreQuery;
import support.PrintClass;

public class RicercaPerRegioneDAOImp implements RicercaPerRegioneDAO {
	private Connection conn;
	ServletContext sc;

	public RicercaPerRegioneDAOImp(String urlDatabase, String userdb, String passwdb) {
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
	public String getListaIncendiRegione(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ret = "";
		String region = request.getParameter("region");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravita = request.getParameter("gravity").trim();
				ret = PrintClass.retrurnStatementToJSONArray(ricercaIncendiConGravita(region, gravita)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				ret = PrintClass.retrurnStatementToJSONArray(ricercaIncendi(region)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}

	@Override
	public ArrayList<Incendio> ricercaIncendi(String regione) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi = new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaPerRegione(regione);
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
	public ArrayList<Incendio> ricercaIncendiConGravita(String regione, String gravità) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi = new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaPerRegioneConGravità(regione, gravità);
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

}
