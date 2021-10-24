package it.uniroma2.tesi.dao;

import java.util.ArrayList;

import org.json.JSONException;

import it.uniroma2.tesi.entity.Incendio;

public interface IncendiDao {
	public ArrayList<Incendio> ricercaIncendiConGravitaRegione(String regione, String gravità)throws JSONException ;
	public ArrayList<Incendio> ricercaIncendiRegione(String regione)throws JSONException;
	ArrayList<Incendio> getIncendiWithDistance(String latitude, String longitude, String distance)throws JSONException;
	ArrayList<Incendio> getIncendiWithDistanceAndGravity(String latitude, String longitude, String distance,
			String gravity)throws JSONException;
	 ArrayList<Incendio> ricercaIncendiConGravitaComune(String comune, String gravità)throws JSONException;
	 ArrayList<Incendio> ricercaIncendiComune(String comune) throws JSONException ;
	 ArrayList<Incendio> ricercaIncendiConGravitaProvincia(String provincia, String gravità) throws JSONException;
	 ArrayList<Incendio> ricercaIncendiProvincia(String provincia) throws JSONException;
}
