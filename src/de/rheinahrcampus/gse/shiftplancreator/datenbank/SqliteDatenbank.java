package de.rheinahrcampus.gse.shiftplancreator.datenbank;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class SqliteDatenbank {

    protected final Connection verbindung;

    public SqliteDatenbank() {
        try {
            Class.forName("org.sqlite.JDBC");

            String heimatVerzeichnis = System.getProperty("user.home");
            String datenbankPfad = Paths.get(heimatVerzeichnis, "Schichtplan2.sqlite").toString();
            
            
            erstelleDatenbankFallsNichtVorhanden(datenbankPfad);
            verbindung = DriverManager.getConnection("jdbc:sqlite:" + datenbankPfad );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    private void erstelleDatenbankFallsNichtVorhanden(String datenbankPfad) throws IOException {
        if (Files.exists(Paths.get(datenbankPfad))) {
        	System.out.println("hi");
            return;
        }

        try {
            Connection temporaereVerbindung = DriverManager.getConnection("jdbc:sqlite:" + datenbankPfad);
            java.sql.Statement statement = temporaereVerbindung.createStatement();
            
            //Lade sqlQueries.sql Datei
            URL url = Resources.getResource("sqlQueries.sql");
            String text = Resources.toString(url, Charsets.UTF_8); //Datei in String 
            
            String[] queries = text.split(";"); //Splitte alle Queries auf beim Semikolon
            
            for (String s : queries) { //Execute query für jeden split
            	statement.execute(s);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}