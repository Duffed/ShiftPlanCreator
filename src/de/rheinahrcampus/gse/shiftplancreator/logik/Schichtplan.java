package de.rheinahrcampus.gse.shiftplancreator.logik;

import java.time.LocalDate;
import java.util.List;

public class Schichtplan {
	private Quartal quartal;
	private int jahr;
	private SchichtplanStatus status;
	private Quartalszahl quartalszahl;
	
	public Schichtplan(int jahr, Quartalszahl quartalszahl) {
		this.jahr = jahr;
		this.quartalszahl = quartalszahl;
		quartal = new Quartal(jahr, quartalszahl);
		status = SchichtplanStatus.UNGENEHMIGT;
	}
	
	public Quartalszahl getQuartalszahl() {
		return quartalszahl;
	}

	public Quartal getQuartal(){
		return quartal;
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
}

