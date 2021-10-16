package it.uniroma2.tesi.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import it.uniroma2.tesi.entity.Incendio;

public interface RicercaPerDistanzaDAO {
	public String getIncendi (HttpServletRequest request) throws JSONException;
	public ArrayList<Incendio> getIncendiWithDistanceAndGravity(String latitude,String longitude,String distance,String gravity) throws JSONException;
	public ArrayList<Incendio> getIncendiWithDistance(String latitude,String longitude,String distance) throws JSONException;
	

}
