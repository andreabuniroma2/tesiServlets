package it.uniroma2.tesi.dao;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

public interface RicercaPerProvinciaDAO {
	public String getListaIncendiProvincia(HttpServletRequest request);
	public String ricercaIncendi(String provincia) throws JSONException;
	public String ricercaIncendiConGravita(String provincia, String gravità) throws JSONException;

}
