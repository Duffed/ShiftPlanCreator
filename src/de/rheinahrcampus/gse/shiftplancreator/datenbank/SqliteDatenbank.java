package de.rheinahrcampus.gse.shiftplancreator.datenbank;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    	            + "Arbeitspensum INTEGER" 
    	            + ")";
    
    private static final String SCHICHTPLAN_TABELLE = 
    		"CREATE TABLE IF NOT EXISTS Schichtplan("
    	            + "Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
    	            + "Jahr int,"
    	            + "Quartal int"
    	            + ")";
    
    private static final String SCHICHT_TABELLE = 
    		"CREATE TABLE IF NOT EXISTS Mitarbeiter("
    	            + "Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
    	            + "Datum date,"
    	            + "SchichtplanID int,"
    	            + "Schichtart int"
    	            + ")";
    
    private static final String MITARBEITER_IN_SCHICHT_TABELLE = 
    		"CREATE TABLE IF NOT EXISTS Mit("
    	            + "MitarbeiterID int,"
    	            + "SchichtID int"
    	            + ")";
    
    private static final String DATENBANK_ERSTELL_SKRIPT = 
    		MITARBEITER_TABELLE + 
    		SCHICHTPLAN_TABELLE +
    		SCHICHT_TABELLE +
    		MITARBEITER_IN_SCHICHT_TABELLE;
    
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