package support;

public class GeneratoreQuery {
	static public String queryStringRicercaComune(String comune) {
		return "SELECT inc.IDincendio as IDincendio, X(inc.Coordinate) "
				+ "as LatitudineCoordinateCentrali , Y(inc.Coordinate) as LongitudineCoordinateCentrali , inc.Gravità as gravita, inc.DataInizio, X(pi.Coordinate) as Latitudine, "
				+ " Y(pi.Coordinate) as Longitudine, pi.DataOra FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.comune='"
				+ comune + "'";

	}

	static public String queryStringRicercaComuneConGravità(String comune, String gravità) {
		return "SELECT inc.IDincendio as IDincendio, X(inc.Coordinate) "
				+ "as LatitudineCoordinateCentrali , Y(inc.Coordinate) as LongitudineCoordinateCentrali , inc.Gravità as gravita, inc.DataInizio, X(pi.Coordinate) as Latitudine, "
				+ " Y(pi.Coordinate) as Longitudine, pi.DataOra FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.comune='"
				+ comune + "' AND" + " inc.Gravità='" + gravità + "'";

	}

	static public String queryStringRicercaPerDistanza(String latitudine, String longitudine, String distanza) {
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.DataOra,inc.Gravità as gravita , ( 6371 * acos( cos( radians("
				+ latitudine + ") ) * cos( radians(X(pi.Coordinate) ) ) * "
				+ " cos( radians( Y(pi.Coordinate) ) - radians(" + longitudine + ") ) + " + " sin( radians("
				+ latitudine
				+ ") ) * sin( radians( X(pi.Coordinate) ) ) ) ) AS distance, inc.IDincendio FROM partiincendio pi, incendio inc WHERE   inc.IDincendio=pi.IncendioIDincendio having distance < "
				+ distanza;

	}

	static public String queryStringRicercaPerDistanzaWithGravity(String latitudine, String longitudine,
			String distanza, String gravit) {
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.DataOra,inc.Gravità as gravita , ( 6371 * acos( cos( radians("
				+ latitudine + ") ) * cos( radians(X(pi.Coordinate) ) ) * "
				+ " cos( radians( Y(pi.Coordinate) ) - radians(" + longitudine + ") ) + " + " sin( radians("
				+ latitudine
				+ ") ) * sin( radians( X(pi.Coordinate) ) ) ) ) AS distance, inc.IDincendio FROM partiincendio pi, incendio inc WHERE   inc.IDincendio=pi.IncendioIDincendio having distance < "
				+ distanza + " AND inc.Gravità='" + gravit + "'";
	}

	static public String queryStringRicercaPerProvincia(String provincia) {
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.DataOra,inc.Gravità as gravita, inc.IDincendio FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.Provincia="
				+ provincia + "";

	}

	static public String queryStringRicercaPerProvinciaConGravità(String provincia, String gravità) {
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.DataOra,inc.Gravità as gravita, inc.IDincendio FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.Provincia="
				+ provincia + " AND inc.Gravità='" + gravità + "'";
	}

	public static String queryStringRicercaPerRegione(String regione) {
		// TODO Auto-generated method stub
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.DataOra,inc.Gravità as gravita, inc.IDincendio FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.Regione="
				+ regione;
	}

	public static String queryStringRicercaPerRegioneConGravità(String regione, String gravità) {
		// TODO Auto-generated method stub
		return "SELECT inc.IDincendio as IDincendio, X(inc.Coordinate) "
				+ "as LatitudineCoordinateCentrali , Y(inc.Coordinate) as LongitudineCoordinateCentrali , inc.Gravità as gravita, inc.DataInizio, X(pi.Coordinate) as Latitudine, "
				+ " Y(pi.Coordinate) as Longitudine, pi.DataOra FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.Regione="
				+ regione + " AND inc.Gravità='" + gravità + "'";

	}

	public static String queryStringRicercaPerIDIncendio(String idIncendio) {
		// TODO Auto-generated method stub
		return "SELECT inc.IDincendio as IDincendio, X(inc.Coordinate) "
				+ "as LatitudineCoordinateCentrali , Y(inc.Coordinate) as LongitudineCoordinateCentrali , inc.Gravità as gravita, inc.DataInizio, X(pi.Coordinate) as Latitudine, "
				+ " Y(pi.Coordinate) as Longitudine, pi.DataOra FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.IDincendio='"
				+ idIncendio + "'";
	}
	public static String queryStringRicercaNumeroRisorse(String idIncendio) {
		return "SELECT  COUNT(viginc.VigileDelFuocoCodiceFiscale) AS 'Numero Vigili', COUNT(incsc.ScaleIDScale) AS 'Numero Scale', COUNT(incvs.VeicoloDiSoccorsoIDVeicolo) as 'Numero Veicoli', COUNT(inck.KitIdraulicoIDKitIdraulico) as 'Numero Kit Idraulici', COUNT(incal.AltreaAttrezzatureIDattrezzatura) as 'Altro' FROM incendio as ince LEFT JOIN vigiledelfuoco_incendio as viginc ON ince.IDincendio = viginc.IncendioIDincendio LEFT JOIN incendio_scale as incsc ON ince.IDincendio = incsc.IncendioIDincendio LEFT JOIN incendio_veicolodisoccorso as incvs ON ince.IDincendio = incvs.IncendioIDincendio LEFT JOIN incendio_kitidraulico as inck ON ince.IDincendio = inck.IncendioIDincendio LEFT JOIN incendio_altreaattrezzature as incal ON ince.IDincendio = incal.IncendioIDincendio WHERE ince.IDincendio="+idIncendio+" GROUP BY ince.IDincendio";
	}
}
/*
 * query di prova RicercaPerDistanza SELECT X(inc.Coordinate) as
 * latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale,
 * X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.*,inc.* ,
 * ( 6371 * acos( cos( radians(41.70543535951623) ) * cos(
 * radians(X(pi.Coordinate) ) ) * cos( radians( Y(pi.Coordinate) ) -
 * radians(12.708195109878806) )+ sin( radians(41.70543535951623) ) * sin(
 * radians( X(pi.Coordinate) ) ) ) ) AS distance FROM partiincendio pi, incendio
 * inc WHERE inc.IDincendio=pi.IncendioIDincendio having distance < 0.8
 * 
SELECT  COUNT(viginc.VigileDelFuocoCodiceFiscale) AS "Numero Vigili",
COUNT(incsc.ScaleIDScale) AS "Numero Scale",
COUNT(incvs.VeicoloDiSoccorsoIDVeicolo) as "Numero Veicoli",
COUNT(inck.KitIdraulicoIDKitIdraulico) as "Numero Kit Idraulici",
COUNT(incal.AltreaAttrezzatureIDattrezzatura) as "Altro"
FROM incendio as ince 
  LEFT JOIN vigiledelfuoco_incendio as viginc ON ince.IDincendio = viginc.IncendioIDincendio
  LEFT JOIN incendio_scale as incsc ON ince.IDincendio = incsc.IncendioIDincendio
  LEFT JOIN incendio_veicolodisoccorso as incvs ON ince.IDincendio = incvs.IncendioIDincendio
  LEFT JOIN incendio_kitidraulico as inck ON ince.IDincendio = inck.IncendioIDincendio
  LEFT JOIN incendio_altreaattrezzature as incal ON ince.IDincendio = incal.IncendioIDincendio
  WHERE ince.IDincendio=6276
GROUP BY ince.IDincendio;
 */
