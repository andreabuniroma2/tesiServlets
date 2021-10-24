package it.uniroma2.tesi.daoImplementation;


import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.dao.IncendiDao;
import support.PrintClass;

public class RicercaPerProvinciaImp   {
	IncendiDao incendiDao;


	public RicercaPerProvinciaImp(String urlDatabase, String userdb, String passwdb) {
		// TODO Auto-generated constructor stub
		incendiDao=new IncendiDAOImp(urlDatabase, userdb, passwdb);

	}

	public String getListaIncendiProvincia(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ret = "";
		String provincia = request.getParameter("province");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravita = request.getParameter("gravity").trim();
				ret =PrintClass.retrurnStatementToJSONArray(incendiDao.ricercaIncendiConGravitaProvincia(provincia, gravita)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {

				ret = PrintClass.retrurnStatementToJSONArray(incendiDao.ricercaIncendiProvincia(provincia)).toString();;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}


}
