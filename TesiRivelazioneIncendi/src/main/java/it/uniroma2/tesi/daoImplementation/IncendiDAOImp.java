package it.uniroma2.tesi.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONException;

import it.uniroma2.tesi.dao.IncendiDao;
import it.uniroma2.tesi.entity.Incendio;
import support.CreateListIncendi;
import support.GeneratoreQuery;

public class IncendiDAOImp implements IncendiDao{
	private Connection conn;

	public IncendiDAOImp(String urlDatabase, String userdb, String passwdb) {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(urlDatabase, userdb, passwdb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Incendio> ricercaIncendiComune(String comune) throws JSONException {
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


	public ArrayList<Incendio> ricercaIncendiConGravitaComune(String comune, String gravit�) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi=new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaComuneConGravit�(comune,gravit�);
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
	public ArrayList<Incendio> ricercaIncendiRegione(String regione) throws JSONException {
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

	
	public ArrayList<Incendio> ricercaIncendiConGravitaRegione(String regione, String gravit�) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi = new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaPerRegioneConGravit�(regione, gravit�);
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
	public ArrayList<Incendio> ricercaIncendiProvincia(String provincia) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi = new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaPerProvincia(provincia);
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

	
	public ArrayList<Incendio> ricercaIncendiConGravitaProvincia(String provincia, String gravit�) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi = new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaPerProvinciaConGravit�(provincia, gravit�);
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
