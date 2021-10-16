package it.uniroma2.tesi.entity;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Incendio {
	private String gravita;
	private String idIncendio;
	private String latitudineCentrale;
	private String longitudineCentrale;
	private String latitudine;
	private String longitudine;
	private String dataInizio;
	private String dataOra;
	private JSONObject json;

	public Incendio(JSONObject obj) throws JSONException {
		if (obj.has("idincendio")) {
		    //get Value of video
			setIdIncendio(obj.getString("idincendio"));
		}
		if (obj.has("latitudinecentrale")) {
		    //get Value of video
			setLatitudineCentrale(obj.getString("latitudinecentrale"));
		}
		if (obj.has("longitudinecentrale")) {
		    //get Value of video
			setLongitudineCentrale(obj.getString("longitudinecentrale"));
		}
		if (obj.has("latitudine")) {
		    //get Value of video
			setLatitudine(obj.getString("latitudine"));
		}
		if (obj.has("longitudine")) {
		    //get Value of video
			setLongitudine(obj.getString("longitudine"));
		}
		if (obj.has("datainizio")) {
		    //get Value of video
			setDataInizio(obj.getString("datainizio"));
		}
		if (obj.has("dataora")) {
		    //get Value of video
			setDataOra(obj.getString("dataora"));
		}
		if (obj.has("gravita")) {
		    //get Value of video
			setGravita(obj.getString("gravita"));
		}
		setJson(obj);
		
	}
	
	public String getIdIncendio() {
		return idIncendio;
	}
	public void setIdIncendio(String idIncendio) {
		this.idIncendio = idIncendio;
	}
	public String getLatitudineCentrale() {
		return latitudineCentrale;
	}
	public void setLatitudineCentrale(String latitudineCentrale) {
		this.latitudineCentrale = latitudineCentrale;
	}
	public String getLongitudineCentrale() {
		return longitudineCentrale;
	}
	public void setLongitudineCentrale(String longitudineCentrale) {
		this.longitudineCentrale = longitudineCentrale;
	}
	public String getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}
	public String getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public String getDataOra() {
		return dataOra;
	}
	public void setDataOra(String dataOra) {
		this.dataOra = dataOra;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
	
	public String getGravita() {
		return gravita;
	}

	public void setGravita(String gravita) {
		this.gravita = gravita;
	}
	public String jsonToString() {
		return json.toString();
	}

	public String contenuto() {
		String contenuto="";
		contenuto="id :"+idIncendio+"\n latitudineCentrale"+latitudineCentrale+"\n longitudineCentrale"+longitudineCentrale+"\n datainizio:"+dataInizio+
				"\n latitudine:"+latitudine+"\n longitudine:"+longitudine+"\n data ora:"+dataOra;
		System.out.println(contenuto);
		return contenuto;
	}

}
