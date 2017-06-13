package de.rheinahrcampus.gse.shiftplancreator.logik;

public class Mitarbeiter_old {
	private Beruf beruf;
	private String vorname;
	private String nachname;
	private int arbeitspensum;
	private String passwort;
	private String benutzername;
	
	public Mitarbeiter_old(String vorname, String nachname, Beruf beruf, String passwort){
		this.vorname = vorname;
		this.nachname = nachname;
		this.beruf = beruf;
		this.passwort = passwort;
		if (nachname.length() > 5) {
			this.benutzername = vorname.toLowerCase().substring(0, 1) + nachname.toLowerCase().substring(0, 6);
		} else {
			this.benutzername = vorname.toLowerCase().substring(0, 1) + nachname.toLowerCase();
		}
	}

	public String getBenutzername() {
		return benutzername;
	}

	public String getPasswort() {
		return passwort;
	}
	
	
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	public Beruf getBeruf() {
		return beruf;
	}


	public void setBeruf(Beruf beruf) {
		this.beruf = beruf;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public int getArbeitspensum() {
		return arbeitspensum;
	}


	public void setArbeitspensum(int arbeitspensum) {
		this.arbeitspensum = arbeitspensum;
	}


	public boolean hatBerechtigung(Berechtigung berechtigung) {
		return beruf.hatBerechtigung(berechtigung);
	}
}
