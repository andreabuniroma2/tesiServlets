package it.uniroma2.tesi.daoImplementation;



import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.dao.IncendiDao;
import support.PrintClass;

public class RicercaPerDistanzaImp   {
	IncendiDao incendiDao;


	public RicercaPerDistanzaImp(String urlDatabase, String userdb, String passwdb) {
		incendiDao=new IncendiDAOImp(urlDatabase, userdb, passwdb);

	}

	
	public String getIncendi(HttpServletRequest request) throws JSONException {
		// TODO Auto-generated method stub
		String ret = "";
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String distance = request.getParameter("distance");
		if (request.getParameterMap().containsKey("gravity"))
			try {
				String gravity = request.getParameter("gravity");
				ret = PrintClass.retrurnStatementToJSONArray(incendiDao.getIncendiWithDistanceAndGravity(latitude, longitude, distance, gravity)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				ret = PrintClass.retrurnStatementToJSONArray(incendiDao.getIncendiWithDistance(latitude, longitude, distance)).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ret;
	}


}
