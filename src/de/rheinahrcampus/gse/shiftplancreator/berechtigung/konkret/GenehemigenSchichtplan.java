package de.rheinahrcampus.gse.shiftplancreator.berechtigung.konkret;

import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.GenehmigenSchichtplanBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.logik.Schichtplan;
import de.rheinahrcampus.gse.shiftplancreator.logik.SchichtplanStatus;

public class GenehemigenSchichtplan implements GenehmigenSchichtplanBerechtigung {

	@Override
	public boolean istBerechtigt() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void genehmigen(Schichtplan schichtplan, SchichtplanStatus schichtplanstatus) {
		// TODO Auto-generated method stub
		
	}


	
}
