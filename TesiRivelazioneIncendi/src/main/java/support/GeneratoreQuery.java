package support;

public class GeneratoreQuery {
	static public String queryStringRicercaComune(String comune) {
		return "SELECT inc.IDincendio as IDincendio, X(inc.Coordinate) "
				+ "as LatitudineCoordinateCentrali , Y(inc.Coordinate) as LongitudineCoordinateCentrali , inc.Gravit�, X(pi.Coordinate) as Latitudine, "
				+ " Y(pi.Coordinate) as Longitudine FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.comune='"+comune+"'";

	}
	static public String queryStringRicercaComuneConGravit�(String comune,String gravit�) {
		return "SELECT inc.IDincendio as IDincendio, X(inc.Coordinate) "
				+ "as LatitudineCoordinateCentrali , Y(inc.Coordinate) as LongitudineCoordinateCentrali , inc.Gravit�, X(pi.Coordinate) as Latitudine, "
				+ " Y(pi.Coordinate) as Longitudine FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.comune='"+comune+"' AND"
						+ " inc.Gravit�='"+gravit�+"'";

	}
	static public String queryStringRicercaPerDistanza(String latitudine, String longitudine, String distanza) {
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.*,inc.* , ( 6371 * acos( cos( radians("+latitudine+") ) * cos( radians(X(pi.Coordinate) ) ) * "
				+ " cos( radians( Y(pi.Coordinate) ) - radians("+longitudine+") ) + "
				+ " sin( radians("+latitudine+") ) * sin( radians( X(pi.Coordinate) ) ) ) ) AS distance FROM partiincendio pi, incendio inc WHERE   inc.IDincendio=pi.IncendioIDincendio having distance < "+ distanza;

	}
	static public String queryStringRicercaPerDistanzaWithGravity(String latitudine, String longitudine, String distanza, String gravit) {
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.*,inc.* , ( 6371 * acos( cos( radians("+latitudine+") ) * cos( radians(X(pi.Coordinate) ) ) * "
				+ " cos( radians( Y(pi.Coordinate) ) - radians("+longitudine+") ) + "
				+ " sin( radians("+latitudine+") ) * sin( radians( X(pi.Coordinate) ) ) ) ) AS distance FROM partiincendio pi, incendio inc WHERE   inc.IDincendio=pi.IncendioIDincendio having distance < "+ distanza+" AND inc.Gravit�='"+gravit+"'";
	}
	static public String queryStringRicercaPerProvincia(String provincia) {
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.*,inc.* FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.Provincia="+provincia+"";
		
	}
	static public String queryStringRicercaPerProvinciaConGravit�(String provincia,String gravit�) {
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.*,inc.* FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.Provincia="+provincia+" AND inc.Gravit�='"+gravit�+"'";
	}
	public static String queryStringRicercaPerRegione(String regione) {
		// TODO Auto-generated method stub
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.*,inc.* FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.Regione="+regione;
	}
	public static String queryStringRicercaPerRegioneConGravit�(String regione, String gravit�) {
		// TODO Auto-generated method stub
		return "SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.*,inc.* FROM incendio inc, partiincendio pi WHERE inc.IDincendio=pi.IncendioIDincendio AND inc.Regione="+regione+" AND inc.Gravit�='"+gravit�+"'";

	}
}
/*query di prova
 * RicercaPerDistanza
SELECT X(inc.Coordinate) as latitudinecentrale, Y(inc.Coordinate) as longitudinecentrale, X(pi.Coordinate) as latitudine,Y(pi.Coordinate) as longitudine, pi.*,inc.* , ( 6371 * acos( cos( radians(41.70543535951623) ) * cos( radians(X(pi.Coordinate) ) ) * 
                        cos( radians( Y(pi.Coordinate) ) - radians(12.708195109878806) )+ 
                        sin( radians(41.70543535951623) ) * sin( radians( X(pi.Coordinate) ) ) ) ) AS distance FROM partiincendio pi, incendio inc WHERE   inc.IDincendio=pi.IncendioIDincendio having distance < 0.8 

*/
