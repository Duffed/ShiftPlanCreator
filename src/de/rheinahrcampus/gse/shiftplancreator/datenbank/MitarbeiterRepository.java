package de.rheinahrcampus.gse.shiftplancreator.datenbank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import de.rheinahrcampus.gse.shiftplancreator.logik.Beruf;
import de.rheinahrcampus.gse.shiftplancreator.logik.Mitarbeiter;

public class MitarbeiterRepository extends SqliteDatenbank {


    public Mitarbeiter ermittleMitarbeiterZuLogin(String username, String passwort) throws UngueltigerLoginException {
        try {
            String query = "select * from MitarbeiterInfo where Benutzername=? and Passwort=?";
            PreparedStatement pst = verbindung.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, passwort);

            ResultSet result = pst.executeQuery();

            Mitarbeiter gefundenerMitarbeiter = null;
            while (result.next()) {
                gefundenerMitarbeiter = new Mitarbeiter(result.getString("Vorname"), result.getString("Nachname"),
                        Beruf.ausKuerzel(result.getString("Beruf")), null);
            }

            if (gefundenerMitarbeiter == null) {
                throw new UngueltigerLoginException();
            }

            return gefundenerMitarbeiter;
        } catch (UngueltigerLoginException e) {
            throw e;
        } catch (Exception e) {
            throw new UngueltigerLoginException(e);
        }
    }

}