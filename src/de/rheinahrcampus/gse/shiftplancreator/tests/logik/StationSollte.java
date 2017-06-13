package de.rheinahrcampus.gse.shiftplancreator.tests.logik;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.rheinahrcampus.gse.shiftplancreator.logik.Beruf;
import de.rheinahrcampus.gse.shiftplancreator.logik.Mitarbeiter;
import de.rheinahrcampus.gse.shiftplancreator.logik.Quartalszahl;
import de.rheinahrcampus.gse.shiftplancreator.logik.Schichtplan;
import de.rheinahrcampus.gse.shiftplancreator.logik.Station;

public class StationSollte {

	@Test
	public void einenMitarbeiterHinzufuegenKoennen() {
		Mitarbeiter ma = new Mitarbeiter("Nach", "Vor", Beruf.EXAMINIERTE_PFLEGEKRAFT, "222");
		assertEquals(0, Station.getChirugie().getMitarbeiter().size());
		Station.getChirugie().fuegeMitarbeiterHinzu(ma);
		assertEquals(1, Station.getChirugie().getMitarbeiter().size());
		assertThat(Station.getChirugie().getMitarbeiter(), hasItem(ma));
	}

	@Test
	public void einenSchichtplanHinzufuegenKoennen() {
		Schichtplan sp = new Schichtplan(2000, Quartalszahl.DREI);
		assertEquals(0, Station.getGastroenterologie().getSchichtplaene().size());
		Station.getGastroenterologie().fuegeSchichtplanHinzu(sp);
		assertEquals(1, Station.getGastroenterologie().getSchichtplaene().size());
		assertThat(Station.getGastroenterologie().getSchichtplaene(), hasItem(sp));
	}
}
