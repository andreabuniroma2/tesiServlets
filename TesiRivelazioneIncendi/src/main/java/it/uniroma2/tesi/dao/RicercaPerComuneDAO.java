package it.uniroma2.tesi.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.entity.Incendio;

public interface RicercaPerComuneDAO {
	public String getListaIncendiComune(HttpServletRequest request);
	public ArrayList<Incendio> ricercaIncendi(String comune) throws JSONException;
	public ArrayList<Incendio> ricercaIncendiConGravita(String comune, String gravità) throws JSONException;

}
