package de.rheinahrcampus.gse.shiftplancreator.logik;

public enum Beruf {
	
	PFLEGEDIENSTLEITUNG("PDL", "Pflegedienstleitung"), 
	STATIONSLEITUNG("SL", "Stationsleitung"), 
	EXAMINIERTE_PFLEGEKRAFT("EPK", "Examinierte Pflegekraft"), 
	PFLEGEKRAFT("PK", "Pflegekraft"), 
	PFLEGEHELFER("PH", "Pflegehelfer"), 
	PFLEGESCHUELER("PS", "Pflegeschueler"),
	SEKETARIAT("S", "Sekretariat");

	private String kuerzel;
	private String name;

	Beruf(String kuerzel, String name) {
		this.name = name;
		this.kuerzel = kuerzel;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public String getName() {
		return name;
	}
	
}
