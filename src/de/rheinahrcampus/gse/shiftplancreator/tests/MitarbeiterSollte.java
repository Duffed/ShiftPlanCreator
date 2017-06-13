package de.rheinahrcampus.gse.shiftplancreator.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret.ErstellenSchichtplan;
import de.rheinahrcampus.gse.shiftplancreator.logik.Arbeitspensum;
import de.rheinahrcampus.gse.shiftplancreator.logik.Beruf;
import de.rheinahrcampus.gse.shiftplancreator.logik.Mitarbeiter;

public class MitarbeiterSollte {

	@Test
	public void hundertProzentArbeitspensumHaben() {
		Mitarbeiter ma = new Mitarbeiter("Nachname", "Vorname", Beruf.EXAMINIERTE_PFLEGEKRAFT, "123");
		assertEquals(Arbeitspensum.HUNDERT, ma.getArbeitspensum());
	}
	
	@Test
	public void arbeitspensumImKonstruktorGesetztBekommenKoennen() {
		Mitarbeiter ma = new Mitarbeiter("Nachname", "Vorname", Beruf.EXAMINIERTE_PFLEGEKRAFT, "123", Arbeitspensum.FUENFZIG);
		assertEquals(Arbeitspensum.FUENFZIG, ma.getArbeitspensum());
	}
	
	@Test
	public void alsStationsLeitungBestimmteBerechtigungenBesitzen(){
		Mitarbeiter ma = new Mitarbeiter("Nachname", "Vorname", Beruf.STATIONSLEITUNG, "123");
		assertTrue(ma.getErstellenSchichtplanBerechtigung().istBerechtigt());
		assertTrue(ma.getBereitstellenSchichtplanBerechtigung().istBerechtigt());
		assertTrue(ma.getVeroeffentlichenSchichtplanBerechtigung().istBerechtigt());
		assertTrue(ma.getFestlegenZeitspanneBerechtigung().istBerechtigt());
		assertTrue(ma.getAnlegenMitarbeiterBerechtigung().istBerechtigt());
		assertTrue(ma.getBearbeitenMitarbeiterBerechtigung().istBerechtigt());
		assertTrue(ma.getEinsehenSchichtplaeneStationBerechtigung().istBerechtigt());
		assertTrue(ma.getAusdruckenSchichtplaeneStationBerechtigung().istBerechtigt());
	}

	@Test
	public void alsNichtSlUndNichtPdlKeineExtraBerechtigungenBesitzen(){
		Mitarbeiter ma = new Mitarbeiter("Nachname", "Vorname", Beruf.PFLEGEKRAFT, "123");
		assertFalse(ma.getErstellenSchichtplanBerechtigung().istBerechtigt());
		assertFalse(ma.getBereitstellenSchichtplanBerechtigung().istBerechtigt());
		assertFalse(ma.getVeroeffentlichenSchichtplanBerechtigung().istBerechtigt());
		assertFalse(ma.getFestlegenZeitspanneBerechtigung().istBerechtigt());
		assertFalse(ma.getAnlegenMitarbeiterBerechtigung().istBerechtigt());
		assertFalse(ma.getBearbeitenMitarbeiterBerechtigung().istBerechtigt());
		assertFalse(ma.getEinsehenSchichtplaeneStationBerechtigung().istBerechtigt());
		assertFalse(ma.getAusdruckenSchichtplaeneStationBerechtigung().istBerechtigt());
	}
	
	@Test
	public void dasPasswortAendernKoennen(){
		Mitarbeiter ma = new Mitarbeiter("Nachname", "Vorname", Beruf.PFLEGEKRAFT, "123");
		assertEquals("123", ma.getPasswort());
		ma.setPasswort("asd");
		assertEquals("asd", ma.getPasswort());
	}
	
	@Test
	public void denBerufwechselnKoennen(){
		Mitarbeiter ma = new Mitarbeiter("Nachname", "Vorname", Beruf.PFLEGEKRAFT, "123");
		assertEquals(Beruf.PFLEGEKRAFT, ma.getBeruf());
		ma.setBeruf(Beruf.EXAMINIERTE_PFLEGEKRAFT);
		assertEquals(Beruf.EXAMINIERTE_PFLEGEKRAFT, ma.getBeruf());
	}
	
	@Test
	public void aendernVonBerechtigungenKoennen(){
		Mitarbeiter ma = new Mitarbeiter("Nachname", "Vorname", Beruf.PFLEGEKRAFT, "123");
		assertFalse(ma.getErstellenSchichtplanBerechtigung().istBerechtigt());
		ma.setErstellenSchichtplanBerechtigung(new ErstellenSchichtplan());
		assertTrue(ma.getErstellenSchichtplanBerechtigung().istBerechtigt());
	}
	
}
