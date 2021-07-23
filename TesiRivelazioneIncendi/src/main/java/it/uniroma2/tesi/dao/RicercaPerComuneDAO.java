package it.uniroma2.tesi.dao;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

public interface RicercaPerComuneDAO {
	public String getListaIncendiComune(HttpServletRequest request);
	public String ricercaIncendi(String comune) throws JSONException;
	public String ricercaIncendiConGravita(String comune, String gravit�) throws JSONException;

}
