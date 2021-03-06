package it.uniroma2.tesi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import it.uniroma2.tesi.daoImplementation.RicercaPerDistanzaImp;

/**
 * Servlet implementation class Incendi
 */
public class RicercaPerDistanza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDB;
	private String usDB;
	private String pwDB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RicercaPerDistanza() {
		super();
		// TODO Auto-generated constructor stub

	}

	 public void init() throws ServletException {
			urlDB = getServletContext().getInitParameter("urlDatabaseLocale");
			usDB = getServletContext().getInitParameter("userLocale");
			pwDB = getServletContext().getInitParameter("passwdLocale");
		}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RicercaPerDistanzaImp incendi = new RicercaPerDistanzaImp(urlDB, usDB, pwDB);
		String jarray;
		try {
			jarray = incendi.getIncendi(request);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jarray="[]";
		}
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jarray);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
