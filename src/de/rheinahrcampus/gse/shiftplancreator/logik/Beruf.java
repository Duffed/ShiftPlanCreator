package de.rheinahrcampus.gse.shiftplancreator.logik;

import java.util.Arrays;
import java.util.List;

public enum Beruf {
	PFLEGEDIENSTLEITUNG("PDL", Berechtigung.SCHICHTPLAN_EINSEHEN), 
	STATIONSLEITUNG("SL", Berechtigung.SCHICHTPLAN_EINSEHEN, Berechtigung.SCHICHTPLAN_ERSTELLEN), 
	EXAMINIERTE_PFLEGEKRAFT("EPK", Berechtigung.SCHICHTPLAN_EINSEHEN), 
	PFLEGEKRAFT("PK", Berechtigung.SCHICHTPLAN_EINSEHEN), 
	PFLEGEHELFER("PH", Berechtigung.SCHICHTPLAN_EINSEHEN), 
	PFLEGESCHUELER("PS", Berechtigung.SCHICHTPLAN_EINSEHEN);

	private List<Berechtigung> berechtigungen;
	private String kuerzel;

	Beruf(String kuerzel, Berechtigung... berechtigungs) {
		berechtigungen = Arrays.asList(berechtigungs );
		this.kuerzel = kuerzel;
	}
	
	public String getName(){
		return this.toString().charAt(0) + this.toString().substring(1).toLowerCase().replace("_", " ");
	}
	
	public String getKuerzel(){
		return kuerzel;
	}
	
	//Veraltet
	public boolean hatBerechtigung(Berechtigung berechtigung) {
		return berechtigungen.contains(berechtigung);
	}
	
	public static Beruf ausKuerzel(String kuerzel) {
		for(Beruf b : Beruf.values()) {
			if(b.kuerzel.equals(kuerzel)) {
				return b;
			}
		}
		return null;
	}
}
