package it.uniroma2.tesi.dao;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

public interface RicercaPerDistanzaDAO {
	public String getIncendi (HttpServletRequest request) throws JSONException;
	public String getIncendiWithDistanceAndGravity(String latitude,String longitude,String distance,String gravity) throws JSONException;
	public String getIncendiWithDistance(String latitude,String longitude,String distance) throws JSONException;
	

}
