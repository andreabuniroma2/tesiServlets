package it.uniroma2.tesi.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.entity.Incendio;

public interface RicercaPerProvinciaDAO {
	public String getListaIncendiProvincia(HttpServletRequest request);
	public ArrayList<Incendio> ricercaIncendi(String provincia) throws JSONException;
	public ArrayList<Incendio> ricercaIncendiConGravita(String provincia, String gravità) throws JSONException;

}
