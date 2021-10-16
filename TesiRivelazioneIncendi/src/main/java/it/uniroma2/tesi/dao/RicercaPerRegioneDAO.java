package it.uniroma2.tesi.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.entity.Incendio;

public interface RicercaPerRegioneDAO {
	public String getListaIncendiRegione(HttpServletRequest request);
	public ArrayList<Incendio> ricercaIncendi(String regione) throws JSONException;
	public ArrayList<Incendio> ricercaIncendiConGravita(String regione, String gravità) throws JSONException;

}
