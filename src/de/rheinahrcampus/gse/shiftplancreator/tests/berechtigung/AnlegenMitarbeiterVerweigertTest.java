package de.rheinahrcampus.gse.shiftplancreator.tests.berechtigung;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AnlegenMitarbeiterVerweigert;
import de.rheinahrcampus.gse.shiftplancreator.logik.Beruf;
import de.rheinahrcampus.gse.shiftplancreator.logik.Mitarbeiter;

public class AnlegenMitarbeiterVerweigertTest {
	
	@Test
	public void istNichtBerechtigt() {
		Mitarbeiter mitarbeiter = new Mitarbeiter("Nachname", "Vorname", Beruf.EXAMINIERTE_PFLEGEKRAFT, "123");
		mitarbeiter.setAnlegenMitarbeiterBerechtigung(new AnlegenMitarbeiterVerweigert());
		assertEquals(false, mitarbeiter.getAnlegenMitarbeiterBerechtigung().istBerechtigt());
	}

}
