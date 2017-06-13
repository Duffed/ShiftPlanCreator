CREATE TABLE IF NOT EXISTS Mitarbeiter(
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nachname VARCHAR(35),
    Vorname VARCHAR(35),
    Passwort VARCHAR(35),
    Beruf VARCHAR(25),
    Arbeitspensum INTEGER, 
    ErstellenSchichtplanBerechtigung BOOLEAN,
    BereitstellenSchichtplanBerechtigung BOOLEAN,
    VeroeffentlichenSchichtplanBerechtigung BOOLEAN,
    FestlegenZeitspanneBerechtigung BOOLEAN,
    AnlegenMitarbeiterBerechtigung BOOLEAN,
    BearbeitenMitarbeiterBerechtigung BOOLEAN,
    EinsehenSchichtplaeneStationBerechtigung BOOLEAN,
    AusdruckenSchichtplaeneStationBerechtigung BOOLEAN,
    EinsehenSchichtplaeneStationenBerechtigung BOOLEAN,
    AusdruckenSchichtplaeneStationenBerechtigung BOOLEAN,
    GenehmigenSchichtplanBerechtigung BOOLEAN,
    AnzeigenLassenGesamtansichtBerechtigung BOOLEAN);

CREATE TABLE IF NOT EXISTS Schichtplan(
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Jahr INTEGER,
    Quartal INTEGER,
    SchichtplanStatus INTEGER);

CREATE TABLE IF NOT EXISTS Mitarbeiter(
    Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Datum DATE,
    SchichtplanID INTEGER,
    Schichtart INTEGER);

CREATE TABLE IF NOT EXISTS MitarbeiterInSchicht(
    MitarbeiterID INTEGER,
    SchichtID INTEGER);

CREATE TABLE IF NOT EXISTS Kommentare(
    MitarbeiterID INTEGER,
    SchichtID INTEGER,
    Kommentar VARCHAR(255));