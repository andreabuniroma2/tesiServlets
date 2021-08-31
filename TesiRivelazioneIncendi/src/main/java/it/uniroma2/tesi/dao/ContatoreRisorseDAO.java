package it.uniroma2.tesi.dao;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

public interface ContatoreRisorseDAO {
	public String getContatori(HttpServletRequest request) throws JSONException;

}
