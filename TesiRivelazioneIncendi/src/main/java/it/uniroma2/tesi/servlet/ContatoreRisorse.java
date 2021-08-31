package it.uniroma2.tesi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import it.uniroma2.tesi.dao.ContatoreRisorseDAO;
import it.uniroma2.tesi.daoImplementation.ContatoreRisorseDAOImp;

/**
 * Servlet implementation class ContatoreRisorse
 */
public class ContatoreRisorse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDB;
	private String usDB;
	private String pwDB;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatoreRisorse() {
        super();
        // TODO Auto-generated constructor stub
    }

	 public void init() throws ServletException {
			urlDB = getServletContext().getInitParameter("urlDatabaseLocale");
			usDB = getServletContext().getInitParameter("userLocale");
			pwDB = getServletContext().getInitParameter("passwdLocale");
		}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContatoreRisorseDAO contRis=new ContatoreRisorseDAOImp(urlDB, usDB, pwDB);
		String jarray="";
		try {
			jarray = contRis.getContatori(request);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!jarray.equals("")) {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println(jarray);
			out.print(jarray);
			out.flush();
		}else
		response.getWriter().append("Errore");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
