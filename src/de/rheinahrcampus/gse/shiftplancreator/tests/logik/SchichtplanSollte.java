package de.rheinahrcampus.gse.shiftplancreator.tests.logik;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.rheinahrcampus.gse.shiftplancreator.logik.Quartalszahl;
import de.rheinahrcampus.gse.shiftplancreator.logik.Schichtplan;
import de.rheinahrcampus.gse.shiftplancreator.logik.Tag;

public class SchichtplanSollte {

	@Test
	public void eineListeAllerTageImQuartalEnthalten() {
		Schichtplan sp = new Schichtplan(2017, Quartalszahl.EINS);
		List<LocalDate> datumsListe = new ArrayList<>();
		for (Tag t : sp.getTage()){
			datumsListe.add(t.getDatum());
		}
		
		//Stichproben
		assertThat(datumsListe, hasItem(LocalDate.of(2017, 1, 1)));
		assertThat(datumsListe, hasItem(LocalDate.of(2017, 2, 1)));
	}
	
	@Test
	public void auchDasSchaltJahrBeachten() {
		Schichtplan keinSchaltjahr = new Schichtplan(2017, Quartalszahl.EINS);
		List<LocalDate> datumsListeKeinSchaltjahr = new ArrayList<>();
		for (Tag t : keinSchaltjahr.getTage()){
			datumsListeKeinSchaltjahr.add(t.getDatum());
		}
		
		Schichtplan schaltjahr = new Schichtplan(2016, Quartalszahl.EINS);
		List<LocalDate> datumsListeSchaltjahr = new ArrayList<>();
		for (Tag t : schaltjahr.getTage()){
			datumsListeSchaltjahr.add(t.getDatum());
		}
		
		//Stichproben
		assertThat(datumsListeSchaltjahr, hasItem(LocalDate.of(2016, 2, 29)));
//		assertThat(datumsListeSchaltjahr).excludes(LocalDate.of(2017, 2, 29));
	}

}
