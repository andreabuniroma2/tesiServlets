package it.uniroma2.tesi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma2.tesi.daoImplementation.RicercaPerRegioneImp;

/**
 * Servlet implementation class RicercaPerRegione
 */
public class RicercaPerRegione extends HttpServlet {
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
    public RicercaPerRegione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RicercaPerRegioneImp ricercaIncendiPerComune=new RicercaPerRegioneImp(urlDB, usDB, pwDB);
		response.getWriter().append(ricercaIncendiPerComune.getListaIncendiRegione(request));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
