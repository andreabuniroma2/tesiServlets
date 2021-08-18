package it.uniroma2.tesi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import it.uniroma2.tesi.dao.SingoloIncendioDAO;
import it.uniroma2.tesi.daoImplementation.SingoloIncendioDAOImp;

/**
 * Servlet implementation class SingoloIncendio
 */
@WebServlet("/SingoloIncendio")
public class SingoloIncendio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDB;
	private String usDB;
	private String pwDB;
	 public void init() throws ServletException {
			urlDB = getServletContext().getInitParameter("urlDatabaseLocale");
			usDB = getServletContext().getInitParameter("userLocale");
			pwDB = getServletContext().getInitParameter("passwdLocale");
		}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SingoloIncendio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameterMap().containsKey("idincendio"))
			try {
				SingoloIncendioDAO ricercaIncendo = new SingoloIncendioDAOImp(urlDB, usDB, pwDB);
				response.getWriter().append(ricercaIncendo.getIncendio(request.getParameter("idincendio")));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			response.getWriter().append("errore");
		
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
