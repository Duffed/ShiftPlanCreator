package de.rheinahrcampus.gse.shiftplancreator.logik;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schichtplan {
	private static final Map<Quartalszahl, Month> START_DATUM;
	private static final Map<Quartalszahl, Month> END_DATUM;

	private int jahr;
	private SchichtplanStatus status;
	private Quartalszahl quartalszahl;
	private List<Tag> tage = new ArrayList<>();
	
	//Konstruktor
	public Schichtplan(int jahr, Quartalszahl quartalszahl) {
		this.jahr = jahr;
		this.quartalszahl = quartalszahl;
		status = SchichtplanStatus.UNGENEHMIGT;
		
		fuelleTage(jahr, quartalszahl);
	}
		
	//Map wird gefuellt
	static {
		START_DATUM = new HashMap<>();
		START_DATUM.put(Quartalszahl.EINS, Month.JANUARY);
		START_DATUM.put(Quartalszahl.ZWEI, Month.APRIL);
		START_DATUM.put(Quartalszahl.DREI, Month.JULY);
		START_DATUM.put(Quartalszahl.VIER, Month.OCTOBER);
		
		END_DATUM = new HashMap<>();
		END_DATUM.put(Quartalszahl.EINS, Month.APRIL);
		END_DATUM.put(Quartalszahl.ZWEI, Month.JULY);
		END_DATUM.put(Quartalszahl.DREI, Month.OCTOBER);
		END_DATUM.put(Quartalszahl.VIER, Month.JANUARY);	
	}	
	
	//Liste tageImQuartal kann als Iterable (nicht veraenderbar) ausgegeben werden
	public Iterable<Tag> getTage() {
		return tage;
	}

	public Quartalszahl getQuartalszahl() {
		return quartalszahl;
	}
	
	public int getJahr(){
		return jahr;
	}
	
	public void setStatus(SchichtplanStatus status){
		this.status = status;
	}
	
	public SchichtplanStatus getStatus(){
		return this.status;
	}
	
	private void fuelleTage(int jahr, Quartalszahl quartalszahl) {
		//Wir holen uns den numerischen Wert des START_ und END_DATUM
		int startMonat = START_DATUM.get(quartalszahl).getValue();
		int endMonat = END_DATUM.get(quartalszahl).getValue();
		
		//Wir bauen ein Datum fuer den Anfang und das Ende des Quartals
		LocalDate startDatum = LocalDate.of(jahr, startMonat, 1);
		LocalDate endDatum = LocalDate.of(jahr, endMonat, 1);
		
		//In einer SChleife fuege ich jeden Tag im Quartal zur Liste tageImQuartal hinzu
		while (!(startDatum.getMonth().equals(endDatum.getMonth()))){
			tage.add(new Tag(this, startDatum));
			
			startDatum = startDatum.plusDays(1);
		}
	}
}

