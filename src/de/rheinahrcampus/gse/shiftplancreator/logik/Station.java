package de.rheinahrcampus.gse.shiftplancreator.logik;

public class Station {
	private static final Station CHIRUGIE = new Station(Stationsname.CHIRUGIE);
	private static final Station GASTROENTEROLOGIE = new Station(Stationsname.GASTROENTEROLOGIE);
	private static final Station GYNAEKOLOGIE = new Station(Stationsname.GYNAEKOLOGIE);
	private static final Station INTENSIVSTATION = new Station(Stationsname.INTENSIVSTATION);
	private static final Station KARDIOLOGIE = new Station(Stationsname.KARDIOLOGIE);
	private static final Station NEUROLOGIE = new Station(Stationsname.NEUROLOGIE);
	private static final Station ONKOLOGIE = new Station(Stationsname.ONKOLOGIE);
	private static final Station ORTHOPAEDIE = new Station(Stationsname.ORTHOPAEDIE);
	
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

	private Stationsname stationsname;
	
	private Station(Stationsname stationsname){
		this.stationsname = stationsname;
	}
}
