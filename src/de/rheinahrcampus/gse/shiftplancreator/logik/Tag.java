package de.rheinahrcampus.gse.shiftplancreator.logik;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Tag {
	private LocalDate datum;
	private Schichtplan schichtplan;
	
	private final List<Schicht> schichten = new LinkedList<Schicht>() {{
		add(new Schicht(schichtplan, datum, Schichtart.FRUEH));
		add(new Schicht(schichtplan, datum, Schichtart.SPAET));
		add(new Schicht(schichtplan, datum, Schichtart.NACHT));
	}};
	
	public Tag(Schichtplan schichtplan, LocalDate datum){
		this.datum = datum;
		this.schichtplan = schichtplan;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public Schichtplan getSchichtplan() {
		return schichtplan;
	}

	public List<Schicht> getSchichten() {
		return schichten;
	}
	
	public Schicht getFruehschicht(){
		return schichten.get(0);
	}
	
	public Schicht getSpaetschicht(){
		return schichten.get(1);
	}
	
	public Schicht getNachtschicht(){
		return schichten.get(2);
	}
	
}
