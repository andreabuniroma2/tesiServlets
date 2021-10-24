package it.uniroma2.tesi.daoImplementation;



import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.dao.IncendiDao;
import support.PrintClass;

public class RicercaPerComuneImp {
	IncendiDao incendiDao;

	public RicercaPerComuneImp(String urlDatabase, String userdb, String passwdb) {
		// TODO Auto-generated constructor stub
		incendiDao=new IncendiDAOImp(urlDatabase, userdb, passwdb);
	}


	

	public String getListaIncendiComune(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ret = "";
		String comune = request.getParameter("comune");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravita = request.getParameter("gravity").trim();
				ret =PrintClass.retrurnStatementToJSONArray(incendiDao.ricercaIncendiConGravitaComune(comune, gravita)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {

				ret = PrintClass.retrurnStatementToJSONArray(incendiDao.ricercaIncendiComune(comune)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}

}
