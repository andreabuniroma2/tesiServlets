package it.uniroma2.tesi.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.dao.RicercaPerComuneDAO;
import it.uniroma2.tesi.entity.Incendio;
import support.CreateListIncendi;
import support.GeneratoreQuery;
import support.PrintClass;

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
	public ArrayList<Incendio> ricercaIncendi(String comune) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi=new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaComune(comune);
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			incendi=CreateListIncendi.retrurnStatementToIncendiList(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return incendi;

	}

	@Override
	public ArrayList<Incendio> ricercaIncendiConGravita(String comune, String gravità) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi=new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaComuneConGravità(comune,gravità);
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			incendi=CreateListIncendi.retrurnStatementToIncendiList(rset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return incendi;
	}

	@Override
	public String getListaIncendiComune(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ret = "";
		String comune = request.getParameter("comune");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravita = request.getParameter("gravity").trim();
				ret =PrintClass.retrurnStatementToJSONArray(ricercaIncendiConGravita(comune, gravita)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {

				ret = PrintClass.retrurnStatementToJSONArray(ricercaIncendi(comune)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}

}
