package it.uniroma2.tesi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma2.tesi.dao.RicercaInItaliaDAO;
import it.uniroma2.tesi.daoImplementation.RicercaInItaliaDAOImp;

/**
 * Servlet implementation class RicercaInItalia
 */
public class RicercaInItalia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDB;
	private String usDB;
	private String pwDB;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public void init() throws ServletException {
			urlDB = getServletContext().getInitParameter("urlDatabaseItalia");
			usDB = getServletContext().getInitParameter("usernameDB");
			pwDB = getServletContext().getInitParameter("passwdDB");
		}

    public RicercaInItalia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RicercaInItaliaDAO ricercaInItalia=new RicercaInItaliaDAOImp(urlDB, usDB, pwDB);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(ricercaInItalia.gestisciRichiesta(request));
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
