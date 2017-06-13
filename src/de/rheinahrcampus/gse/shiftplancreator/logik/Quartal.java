package de.rheinahrcampus.gse.shiftplancreator.logik;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quartal {
	
	private static final Map<Quartalszahl, Month> START_DATUM;
	private static final Map<Quartalszahl, Month> END_DATUM;
	private List<LocalDate> tageImQuartal = new ArrayList<>();
	
	//Map wird gef�llt
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
	
	public Quartal(int jahr, Quartalszahl quartalszahl) {
		//Wir holen uns den numerischen Wert des START_ und END_DATUM
		int startMonat = START_DATUM.get(quartalszahl).getValue();
		int endMonat = END_DATUM.get(quartalszahl).getValue();

		//Wir bauen ein Datum f�r den Anfang und das Ende des Quartals
		LocalDate startDatum = LocalDate.of(jahr, startMonat, 1);
		LocalDate endDatum = LocalDate.of(jahr, endMonat, 1);
		
		//In einer SChleife f�ge ich jeden Tag im Quartal zur Liste tageImQuartal hinzu
		while (!(startDatum.getMonth().equals(endDatum.getMonth()))){
			tageImQuartal.add(startDatum);
			
			startDatum = startDatum.plusDays(1);
		}
	}
	
	//Liste tageImQuartal kann als Iterable (nicht ver�nderbar) ausgegeben werden
	public Iterable<LocalDate> getTage() {
		return tageImQuartal;
	}

}
