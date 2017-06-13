package de.rheinahrcampus.gse.shiftplancreator.logik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schicht {
	private List<Mitarbeiter_old> mitarbeiter = new ArrayList<>();
	private Schichtart schichtart;
	private Map<Mitarbeiter_old, String> kommentare = new HashMap<>();
	private Schichtplan schichtplan;
	private LocalDate datum;
	
	public Schicht(Schichtplan schichtplan, LocalDate datum, Schichtart schichtart) {
		this.setSchichtart(schichtart);
		this.setSchichtart(schichtart);
		this.datum = datum;
	}
	
	public void fuegeKommentarHinzu(Mitarbeiter_old mitarbeiter, String kommentar){
		kommentare.put(mitarbeiter, kommentar);
	}
	
	public String getKommentar(Mitarbeiter_old ma){
		String kommentar = "";
		if (kommentare.get(ma) == null) return kommentar;
		return kommentare.get(ma);
	}
	
	public void fuegeMitarbeiterHinzu(Mitarbeiter_old mitarbeiter){ //Object?
		this.mitarbeiter.add(mitarbeiter);
	}
	
	public List<Mitarbeiter_old> getMitarbeiter(){
		return mitarbeiter;
	}

	public Schichtart getSchichtart() {
		return schichtart;
	}

	public void setSchichtart(Schichtart schichtart) {
		this.schichtart = schichtart;
	}

}
