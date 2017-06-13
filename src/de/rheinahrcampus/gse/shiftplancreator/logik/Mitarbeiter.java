package de.rheinahrcampus.gse.shiftplancreator.logik;

import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.AnlegenMitarbeiterBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.AnzeigenLassenGesamtansichtBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.AusdruckenSchichtplaeneStationBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.AusdruckenSchichtplaeneStationenBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.BearbeitenMitarbeiterBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.BereitstellenSchichtplanBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.EinsehenSchichtplaeneStationBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.EinsehenSchichtplaeneStationenBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.ErstellenSchichtplanBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.FestlegenZeitspanneBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.GenehmigenSchichtplanBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.VeroeffentlichenSchichtplanBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AnlegenMitarbeiter;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AnlegenMitarbeiterVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AnzeigenLassenGesamtansicht;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AnzeigenLassenGesamtansichtVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AusdruckenSchichtplaeneStation;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AusdruckenSchichtplaeneStationVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AusdruckenSchichtplaeneStationen;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AusdruckenSchichtplaeneStationenVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.BearbeitenMitarbeiter;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.BearbeitenMitarbeiterVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.BereitstellenSchichtplan;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.BereitstellenSchichtplanVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.EinsehenSchichtplaeneStation;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.EinsehenSchichtplaeneStationVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.EinsehenSchichtplaeneStationen;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.EinsehenSchichtplaeneStationenVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.ErstellenSchichtplan;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.ErstellenSchichtplanVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.FestlegenZeitspanne;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.FestlegenZeitspanneVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.GenehmigenSchichtplan;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.GenehmigenSchichtplanVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.VeroeffentlichenSchichtplan;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.VeroeffentlichenSchichtplanVerweigert;

public class Mitarbeiter {
	
	// Attribute:
	
	private String nachname;
	private String vorname;
	private String benutzername;
	private String passwort;
	private Arbeitspensum arbeitspensum;
	private Beruf beruf;
	
	private ErstellenSchichtplanBerechtigung erstellenSchichtplanBerechtigung;
	private BereitstellenSchichtplanBerechtigung bereitstellenSchichtplanBerechtigung;
	private VeroeffentlichenSchichtplanBerechtigung veroeffentlichenSchichtplanBerechtigung;
	private FestlegenZeitspanneBerechtigung festlegenZeitspanneBerechtigung;
	private AnlegenMitarbeiterBerechtigung anlegenMitarbeiterBerechtigung;
	private BearbeitenMitarbeiterBerechtigung bearbeitenMitarbeiterBerechtigung;
	private EinsehenSchichtplaeneStationBerechtigung einsehenSchichtplaeneStationBerechtigung;
	private AusdruckenSchichtplaeneStationBerechtigung ausdruckenSchichtplaeneStationBerechtigung;
	private EinsehenSchichtplaeneStationenBerechtigung einsehenSchichtplaeneStationenBerechtigung;
	private AusdruckenSchichtplaeneStationenBerechtigung ausdruckenSchichtplaeneStationenBerechtigung;
	private GenehmigenSchichtplanBerechtigung genehmigenSchichtplanBerechtigung;
	private AnzeigenLassenGesamtansichtBerechtigung anzeigenLassenGesamtansichtBerechtigung;
	
	public Mitarbeiter(String nachname, String vorname, Beruf beruf, String passwort) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.beruf = beruf;
		this.passwort = passwort;
		this.arbeitspensum = Arbeitspensum.HUNDERT;
		
		setStandartBerechtigungen();
	}
	
	public Mitarbeiter(String nachname, String vorname, Beruf beruf, String passwort, Arbeitspensum arbeitspensum) {
		this(nachname, vorname, beruf, passwort);
		this.arbeitspensum = arbeitspensum;
	}
	
	public void setStandartBerechtigungen() {
		erstellenSchichtplanBerechtigung = new ErstellenSchichtplanVerweigert();
		bereitstellenSchichtplanBerechtigung = new BereitstellenSchichtplanVerweigert();
		veroeffentlichenSchichtplanBerechtigung = new VeroeffentlichenSchichtplanVerweigert();
		festlegenZeitspanneBerechtigung = new FestlegenZeitspanneVerweigert();
		anlegenMitarbeiterBerechtigung = new AnlegenMitarbeiterVerweigert();
		bearbeitenMitarbeiterBerechtigung = new BearbeitenMitarbeiterVerweigert();
		einsehenSchichtplaeneStationBerechtigung = new EinsehenSchichtplaeneStationVerweigert();
		ausdruckenSchichtplaeneStationBerechtigung = new AusdruckenSchichtplaeneStationVerweigert();
		einsehenSchichtplaeneStationenBerechtigung = new EinsehenSchichtplaeneStationenVerweigert();
		ausdruckenSchichtplaeneStationenBerechtigung = new AusdruckenSchichtplaeneStationenVerweigert();
		genehmigenSchichtplanBerechtigung = new GenehmigenSchichtplanVerweigert();
		anzeigenLassenGesamtansichtBerechtigung = new AnzeigenLassenGesamtansichtVerweigert();
		
		if (beruf == Beruf.PFLEGEDIENSTLEITUNG) {
			einsehenSchichtplaeneStationenBerechtigung = new EinsehenSchichtplaeneStationen();
			ausdruckenSchichtplaeneStationenBerechtigung = new AusdruckenSchichtplaeneStationen();
			genehmigenSchichtplanBerechtigung = new GenehmigenSchichtplan();
			anzeigenLassenGesamtansichtBerechtigung = new AnzeigenLassenGesamtansicht();
		}
		
		if (beruf == Beruf.STATIONSLEITUNG) {
			erstellenSchichtplanBerechtigung = new ErstellenSchichtplan();
			bereitstellenSchichtplanBerechtigung = new BereitstellenSchichtplan();
			veroeffentlichenSchichtplanBerechtigung = new VeroeffentlichenSchichtplan();
			festlegenZeitspanneBerechtigung = new FestlegenZeitspanne();
			anlegenMitarbeiterBerechtigung = new AnlegenMitarbeiter();
			bearbeitenMitarbeiterBerechtigung = new BearbeitenMitarbeiter();
			einsehenSchichtplaeneStationBerechtigung = new EinsehenSchichtplaeneStation();
			ausdruckenSchichtplaeneStationBerechtigung = new AusdruckenSchichtplaeneStation();
		}
	}
	
	//Getters und Setters:
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getBenutzername() {
		return benutzername;
	}
	
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}
	
	public String getPasswort() {
		return passwort;
	}
	
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	public Arbeitspensum getArbeitspensum() {
		return arbeitspensum;
	}
	
	public void setArbeitspensum(Arbeitspensum arbeitspensum) {
		this.arbeitspensum = arbeitspensum;
	}
	
	public Beruf getBeruf() {
		return beruf;
	}
	
	public void setBeruf(Beruf beruf) {
		this.beruf = beruf;
	}

	public ErstellenSchichtplanBerechtigung getErstellenSchichtplanBerechtigung() {
		return erstellenSchichtplanBerechtigung;
	}

	public void setErstellenSchichtplanBerechtigung(ErstellenSchichtplanBerechtigung erstellenSchichtplanBerechtigung) {
		this.erstellenSchichtplanBerechtigung = erstellenSchichtplanBerechtigung;
	}

	public BereitstellenSchichtplanBerechtigung getBereitstellenSchichtplanBerechtigung() {
		return bereitstellenSchichtplanBerechtigung;
	}

	public void setBereitstellenSchichtplanBerechtigung(
			BereitstellenSchichtplanBerechtigung bereitstellenSchichtplanBerechtigung) {
		this.bereitstellenSchichtplanBerechtigung = bereitstellenSchichtplanBerechtigung;
	}

	public VeroeffentlichenSchichtplanBerechtigung getVeroeffentlichenSchichtplanBerechtigung() {
		return veroeffentlichenSchichtplanBerechtigung;
	}

	public void setVeroeffentlichenSchichtplanBerechtigung(
			VeroeffentlichenSchichtplanBerechtigung veroeffentlichenSchichtplanBerechtigung) {
		this.veroeffentlichenSchichtplanBerechtigung = veroeffentlichenSchichtplanBerechtigung;
	}

	public FestlegenZeitspanneBerechtigung getFestlegenZeitspanneBerechtigung() {
		return festlegenZeitspanneBerechtigung;
	}

	public void setFestlegenZeitspanneBerechtigung(FestlegenZeitspanneBerechtigung festlegenZeitspanneBerechtigung) {
		this.festlegenZeitspanneBerechtigung = festlegenZeitspanneBerechtigung;
	}

	public AnlegenMitarbeiterBerechtigung getAnlegenMitarbeiterBerechtigung() {
		return anlegenMitarbeiterBerechtigung;
	}

	public void setAnlegenMitarbeiterBerechtigung(AnlegenMitarbeiterBerechtigung anlegenMitarbeiterBerechtigung) {
		this.anlegenMitarbeiterBerechtigung = anlegenMitarbeiterBerechtigung;
	}

	public BearbeitenMitarbeiterBerechtigung getBearbeitenMitarbeiterBerechtigung() {
		return bearbeitenMitarbeiterBerechtigung;
	}

	public void setBearbeitenMitarbeiterBerechtigung(BearbeitenMitarbeiterBerechtigung bearbeitenMitarbeiterBerechtigung) {
		this.bearbeitenMitarbeiterBerechtigung = bearbeitenMitarbeiterBerechtigung;
	}

	public EinsehenSchichtplaeneStationBerechtigung getEinsehenSchichtplaeneStationBerechtigung() {
		return einsehenSchichtplaeneStationBerechtigung;
	}

	public void setEinsehenSchichtplaeneStationBerechtigung(
			EinsehenSchichtplaeneStationBerechtigung einsehenSchichtplaeneStationBerechtigung) {
		this.einsehenSchichtplaeneStationBerechtigung = einsehenSchichtplaeneStationBerechtigung;
	}

	public AusdruckenSchichtplaeneStationBerechtigung getAusdruckenSchichtplaeneStationBerechtigung() {
		return ausdruckenSchichtplaeneStationBerechtigung;
	}

	public void setAusdruckenSchichtplaeneStationBerechtigung(
			AusdruckenSchichtplaeneStationBerechtigung ausdruckenSchichtplaeneStationBerechtigung) {
		this.ausdruckenSchichtplaeneStationBerechtigung = ausdruckenSchichtplaeneStationBerechtigung;
	}

	public EinsehenSchichtplaeneStationenBerechtigung getEinsehenSchichtplaeneStationenBerechtigung() {
		return einsehenSchichtplaeneStationenBerechtigung;
	}

	public void setEinsehenSchichtplaeneStationenBerechtigung(
			EinsehenSchichtplaeneStationenBerechtigung einsehenSchichtplaeneStationenBerechtigung) {
		this.einsehenSchichtplaeneStationenBerechtigung = einsehenSchichtplaeneStationenBerechtigung;
	}

	public AusdruckenSchichtplaeneStationenBerechtigung getAusdruckenSchichtplaeneStationenBerechtigung() {
		return ausdruckenSchichtplaeneStationenBerechtigung;
	}

	public void setAusdruckenSchichtplaeneStationenBerechtigung(
			AusdruckenSchichtplaeneStationenBerechtigung ausdruckenSchichtplaeneStationenBerechtigung) {
		this.ausdruckenSchichtplaeneStationenBerechtigung = ausdruckenSchichtplaeneStationenBerechtigung;
	}

	public GenehmigenSchichtplanBerechtigung getGenehmigenSchichtplanBerechtigung() {
		return genehmigenSchichtplanBerechtigung;
	}

	public void setGenehmigenSchichtplanBerechtigung(GenehmigenSchichtplanBerechtigung genehmigenSchichtplanBerechtigung) {
		this.genehmigenSchichtplanBerechtigung = genehmigenSchichtplanBerechtigung;
	}

	public AnzeigenLassenGesamtansichtBerechtigung getAnzeigenLassenGesamtansichtBerechtigung() {
		return anzeigenLassenGesamtansichtBerechtigung;
	}

	public void setAnzeigenLassenGesamtansichtBerechtigung(
			AnzeigenLassenGesamtansichtBerechtigung anzeigenLassenGesamtansichtBerechtigung) {
		this.anzeigenLassenGesamtansichtBerechtigung = anzeigenLassenGesamtansichtBerechtigung;
	}
	
}
