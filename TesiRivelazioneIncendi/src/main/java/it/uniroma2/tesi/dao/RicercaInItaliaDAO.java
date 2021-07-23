package it.uniroma2.tesi.dao;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

public interface RicercaInItaliaDAO {
	public String gestisciRichiesta(HttpServletRequest rihiesta);
	public String getListaProvince(String codiceRegione) throws JSONException;
	public String getListaComuni(String codiceProvincia) throws JSONException;

}
