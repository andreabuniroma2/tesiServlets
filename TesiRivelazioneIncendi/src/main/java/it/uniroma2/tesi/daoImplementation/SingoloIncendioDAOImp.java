package it.uniroma2.tesi.daoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.json.JSONException;

import it.uniroma2.tesi.dao.SingoloIncendioDAO;
import it.uniroma2.tesi.entity.Incendio;
import support.CreateListIncendi;
import support.GeneratoreQuery;

public class SingoloIncendioDAOImp implements SingoloIncendioDAO {
	private Connection conn;
	ServletContext sc;

	public SingoloIncendioDAOImp(String urlDB, String usDB, String pwDB) {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(urlDB, usDB, pwDB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Incendio> getIncendio(String idIncendio) throws JSONException {
		// TODO Auto-generated method stub
		ArrayList<Incendio> incendi= new ArrayList<Incendio>();
		String sql = GeneratoreQuery.queryStringRicercaPerIDIncendio(idIncendio);
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

}
