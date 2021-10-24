package it.uniroma2.tesi.daoImplementation;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.dao.IncendiDao;
import support.PrintClass;

public class RicercaPerRegioneImp {
	IncendiDao incendiDao;

	public RicercaPerRegioneImp(String urlDatabase, String userdb, String passwdb) {
		// TODO Auto-generated constructor stub
		incendiDao = new IncendiDAOImp(urlDatabase, userdb, passwdb);

	}

	public String getListaIncendiRegione(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ret = "";
		String region = request.getParameter("region");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravita = request.getParameter("gravity").trim();
				ret = PrintClass
						.retrurnStatementToJSONArray(incendiDao.ricercaIncendiConGravitaRegione(region, gravita))
						.toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				ret = PrintClass.retrurnStatementToJSONArray(incendiDao.ricercaIncendiRegione(region)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}

}
