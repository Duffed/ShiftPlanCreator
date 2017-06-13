package de.rheinahrcampus.gse.shiftplancreator.logik;

import java.util.ArrayList;
import java.util.List;

public class Station {
	private static final Station CHIRUGIE = new Station(Stationsname.CHIRUGIE);
	private static final Station GASTROENTEROLOGIE = new Station(Stationsname.GASTROENTEROLOGIE);
	private static final Station GYNAEKOLOGIE = new Station(Stationsname.GYNAEKOLOGIE);
	private static final Station INTENSIVSTATION = new Station(Stationsname.INTENSIVSTATION);
	private static final Station KARDIOLOGIE = new Station(Stationsname.KARDIOLOGIE);
	private static final Station NEUROLOGIE = new Station(Stationsname.NEUROLOGIE);
	private static final Station ONKOLOGIE = new Station(Stationsname.ONKOLOGIE);
	private static final Station ORTHOPAEDIE = new Station(Stationsname.ORTHOPAEDIE);
	
	private List<Mitarbeiter> mitarbeiter = new ArrayList<>();
	private List<Schichtplan> schichtplaene = new ArrayList<>();
	
	private Stationsname stationsname;
	
	private Station(Stationsname stationsname){
		this.stationsname = stationsname;
	}
	
	public void fuegeMitarbeiterHinzu(Mitarbeiter mitarbeiter){
		this.mitarbeiter.add(mitarbeiter);
	}
	
	public void fuegeSchichtplanHinzu(Schichtplan schichtplan){
		this.schichtplaene.add(schichtplan);
	}

	public Iterable<Schichtplan> getSchichtplaene(){
		return schichtplaene;
	}
	
	public static Station getChirugie() {
		return CHIRUGIE;
	}

	public static Station getGastroenterologie() {
		return GASTROENTEROLOGIE;
	}

	public static Station getGynaekologie() {
		return GYNAEKOLOGIE;
	}

	public static Station getIntensivstation() {
		return INTENSIVSTATION;
	}

	public static Station getKardiologie() {
		return KARDIOLOGIE;
	}

	public static Station getNeurologie() {
		return NEUROLOGIE;
	}

	public static Station getOnkologie() {
		return ONKOLOGIE;
	}

	public static Station getOrthopaedie() {
		return ORTHOPAEDIE;
	}

}
