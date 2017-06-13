package de.rheinahrcampus.gse.shiftplancreator.konsole;

import java.util.Scanner;

import de.rheinahrcampus.gse.shiftplancreator.datenbank.MitarbeiterRepository;
import de.rheinahrcampus.gse.shiftplancreator.datenbank.SqliteDatenbank;
import de.rheinahrcampus.gse.shiftplancreator.datenbank.UngueltigerLoginException;
import de.rheinahrcampus.gse.shiftplancreator.logik.Arbeitspensum;
import de.rheinahrcampus.gse.shiftplancreator.logik.Beruf;
import de.rheinahrcampus.gse.shiftplancreator.logik.Mitarbeiter;

public class Main {

	public static void main(String[] args) throws UngueltigerLoginException {
		
		Mitarbeiter test1 = new Mitarbeiter("Vor", "Nach", Beruf.EXAMINIERTE_PFLEGEKRAFT, "123");
		System.out.println(test1.getArbeitspensum());
		Mitarbeiter test2 = new Mitarbeiter("Vor", "Nach", Beruf.EXAMINIERTE_PFLEGEKRAFT, "123", Arbeitspensum.FUENFUNDSIEBZIG);
		System.out.println(test2.getArbeitspensum());

//		System.out.println(test1.getErstellenSchichtplanBerechtigung().hatBerechtigung());
		
		SqliteDatenbank db = new SqliteDatenbank();

		Scanner scanner = new Scanner(System.in);
		MitarbeiterRepository mitarbeiterRepository = new MitarbeiterRepository();

		System.out.println("Bitte Benutzername eingeben (z.B. 1): ");
		String username = scanner.nextLine();

		System.out.println("Bitte Passwort eingeben (z.B. 1): ");
		String passwort = scanner.nextLine();

	}

}
