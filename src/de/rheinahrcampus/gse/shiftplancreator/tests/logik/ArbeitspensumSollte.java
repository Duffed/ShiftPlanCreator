package de.rheinahrcampus.gse.shiftplancreator.tests.logik;

import static org.junit.Assert.*;

import org.junit.Test;

import de.rheinahrcampus.gse.shiftplancreator.logik.Arbeitspensum;

public class ArbeitspensumSollte {

	@Test
	public void dieProzentZahlBerechnenKoennen() {
		assertEquals(100, Arbeitspensum.HUNDERT.getProzentZahl());
	}

}
