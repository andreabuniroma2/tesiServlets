package it.uniroma2.tesi.dao;

import java.util.ArrayList;

import org.json.JSONException;

import it.uniroma2.tesi.entity.Incendio;

public interface SingoloIncendioDAO {
public ArrayList<Incendio> getIncendio  (String idIncendio) throws JSONException;
}
