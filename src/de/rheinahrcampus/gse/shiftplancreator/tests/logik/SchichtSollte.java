package de.rheinahrcampus.gse.shiftplancreator.tests.logik;

import static org.junit.Assert.*;

import org.junit.Test;

import de.rheinahrcampus.gse.shiftplancreator.logik.Beruf;
import de.rheinahrcampus.gse.shiftplancreator.logik.Mitarbeiter;
import de.rheinahrcampus.gse.shiftplancreator.logik.Quartalszahl;
import de.rheinahrcampus.gse.shiftplancreator.logik.Schicht;
import de.rheinahrcampus.gse.shiftplancreator.logik.Schichtplan;

public class SchichtSollte {

	@Test
	public void einemMitarbeiterEinenKommanterHinzufuegenKoennen() {
		Mitarbeiter ma = new Mitarbeiter("Nachname", "Vorname", Beruf.PFLEGEKRAFT, "123");
		Schichtplan sp = new Schichtplan(2017, Quartalszahl.EINS);
		
		Schicht schicht = sp.getTage().iterator().next().getFruehschicht();
		
		schicht.fuegeMitarbeiterHinzu(ma);
		schicht.fuegeKommentarHinzu(ma, "Test");
		
		assertEquals("Test", schicht.getKommentar(ma));
	}
	
	@Test
	public void einerListeDerMitarbeiterAusgebenKoennen() {
		Mitarbeiter ma1 = new Mitarbeiter("Nachname1", "Vorname1", Beruf.PFLEGEKRAFT, "123");
		Mitarbeiter ma2 = new Mitarbeiter("Nachname2", "Vorname2", Beruf.PFLEGEKRAFT, "123");
		Schichtplan sp = new Schichtplan(2017, Quartalszahl.EINS);
		
		Schicht schicht = sp.getTage().iterator().next().getFruehschicht();
		
		assertEquals(0, schicht.getMitarbeiter().size());
		
		schicht.fuegeMitarbeiterHinzu(ma1);
		schicht.fuegeMitarbeiterHinzu(ma2);
		
		assertEquals(2, schicht.getMitarbeiter().size());
	}

}
