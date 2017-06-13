package de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt;

import de.rheinahrcampus.gse.shiftplancreator.logik.Schichtplan;
import de.rheinahrcampus.gse.shiftplancreator.logik.SchichtplanStatus;

public interface GenehmigenSchichtplanBerechtigung {
	
	public abstract boolean istBerechtigt();
	public abstract void genehmigen(Schichtplan schichtplan, SchichtplanStatus schichtplanstatus);
	
}
