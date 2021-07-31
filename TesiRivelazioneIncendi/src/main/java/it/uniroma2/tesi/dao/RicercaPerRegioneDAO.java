package it.uniroma2.tesi.dao;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

public interface RicercaPerRegioneDAO {
	public String getListaIncendiRegione(HttpServletRequest request);
	public String ricercaIncendi(String regione) throws JSONException;
	public String ricercaIncendiConGravita(String regione, String gravità) throws JSONException;

}
