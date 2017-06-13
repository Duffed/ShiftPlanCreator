package de.rheinahrcampus.gse.shiftplancreator.tests.berechtigung;

import static org.junit.Assert.*;

import org.junit.Test;

import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.AnlegenMitarbeiter;
import de.rheinahrcampus.gse.shiftplancreator.logik.Beruf;
import de.rheinahrcampus.gse.shiftplancreator.logik.Mitarbeiter;

public class AnlegenMitarbeiterTest {
	
	@Test
	public void istTatsaechlichBerechtigt() {
		Mitarbeiter mitarbeiter = new Mitarbeiter("Nachname", "Vorname", Beruf.EXAMINIERTE_PFLEGEKRAFT, "123");
		mitarbeiter.setAnlegenMitarbeiterBerechtigung(new AnlegenMitarbeiter());
		assertEquals(true, mitarbeiter.getAnlegenMitarbeiterBerechtigung().istBerechtigt());
	}

}
