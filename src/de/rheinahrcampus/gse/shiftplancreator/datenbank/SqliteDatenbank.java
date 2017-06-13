package de.rheinahrcampus.gse.shiftplancreator.datenbank;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.AnlegenMitarbeiterBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.AnzeigenLassenGesamtansichtBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.AusdruckenSchichtplaeneStationBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.AusdruckenSchichtplaeneStationenBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.BearbeitenMitarbeiterBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.BereitstellenSchichtplanBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.EinsehenSchichtplaeneStationBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.EinsehenSchichtplaeneStationenBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.ErstellenSchichtplanBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.FestlegenZeitspanneBerechtigung;
import de.rheinahrcampus.gse.shiftplancreator.berechtigung.abstrakt.GenehmigenSchichtplanBerechtigung;

public class SqliteDatenbank {

    protected final Connection verbindung;

    public SqliteDatenbank() {
        try {
            Class.forName("org.sqlite.JDBC");

            String heimatVerzeichnis = System.getProperty("user.home");
            String datenbankPfad = Paths.get(heimatVerzeichnis, "Schichtplan.sqlite").toString();

            erstelleDatenbankFallsNichtVorhanden(datenbankPfad);
            verbindung = DriverManager.getConnection("jdbc:sqlite:" + datenbankPfad);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static final String MITARBEITER_TABELLE = 
    		"CREATE TABLE IF NOT EXISTS Mitarbeiter("
    	            + "Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
    	            + "Nachname VARCHAR(35),"
    	            + "Vorname VARCHAR(35),"
    	            + "Passwort VARCHAR(35),"
    	            + "Beruf VARCHAR(25),"
    	            + "Arbeitspensum INTEGER," 
    	            + "ErstellenSchichtplanBerechtigung boolean,"
    	            + "BereitstellenSchichtplanBerechtigung boolean,"
    	            + "VeroeffentlichenSchichtplanBerechtigung boolean,"
    	            + "FestlegenZeitspanneBerechtigung boolean,"
    	            + "AnlegenMitarbeiterBerechtigung boolean,"
    	            + "BearbeitenMitarbeiterBerechtigung boolean,"
    	            + "EinsehenSchichtplaeneStationBerechtigung boolean,"
    	            + "AusdruckenSchichtplaeneStationBerechtigung boolean,"
    	            + "EinsehenSchichtplaeneStationenBerechtigung boolean,"
    	            + "AusdruckenSchichtplaeneStationenBerechtigung boolean,"
    	            + "GenehmigenSchichtplanBerechtigung boolean,"
    	            + "AnzeigenLassenGesamtansichtBerechtigung boolean"
    	            + ")";
    
    private static final String SCHICHTPLAN_TABELLE = 
    		"CREATE TABLE IF NOT EXISTS Schichtplan("
    	            + "Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
    	            + "Jahr INTEGER,"
    	            + "Quartal INTEGER,"
    	            + "SchichtplanStatus INTEGER"
    	            + ")";
    
    private static final String SCHICHT_TABELLE = 
    		"CREATE TABLE IF NOT EXISTS Mitarbeiter("
    	            + "Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
    	            + "Datum DATE,"
    	            + "SchichtplanID INTEGER,"
    	            + "Schichtart INTEGER"
    	            + ")";
    
    private static final String MITARBEITER_IN_SCHICHT_TABELLE = 
    		"CREATE TABLE IF NOT EXISTS MitarbeiterInSchicht("
    	            + "MitarbeiterID INTEGER,"
    	            + "SchichtID INTEGER"
    	            + ")";
    
    private static final String KOMMENTARE_TABELLE = 
    		"CREATE TABLE IF NOT EXISTS Kommentare("
    	            + "MitarbeiterID INTEGER,"
    	            + "SchichtID INTEGER,"
    	            + "Kommentar varchar(255)"
    	            + ")";
    
    private static final String DATENBANK_ERSTELL_SKRIPT = 
    		MITARBEITER_TABELLE + 
    		SCHICHTPLAN_TABELLE +
    		SCHICHT_TABELLE +
    		MITARBEITER_IN_SCHICHT_TABELLE +
    		KOMMENTARE_TABELLE;
    
    private void erstelleDatenbankFallsNichtVorhanden(String datenbankPfad) {
        if (Files.exists(Paths.get(datenbankPfad))) {
            return;
        }

        try {
            Connection temporaereVerbindung = DriverManager.getConnection("jdbc:sqlite:" + datenbankPfad);
            java.sql.Statement statement = temporaereVerbindung.createStatement();
            statement.execute(DATENBANK_ERSTELL_SKRIPT);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}