package com.komponente.skladista;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Skladiste {


    /**
     Proverava da li postoji korisnik sa unetim username-om i password-om i ako postoji prijavljuje ga na skladiste
     * @param username - korisnicko ime korisnika koji se konektuje na skladiste
     * @param password - loznika korisnika koji se konektuje na skladiste
     * @return true ako je login uspeo, false ako nije
     */

    public boolean login(String username, String password) throws IOException;


    /**
     * Odjavljuje korisnika
     */

    public void logout();

    /**
     * Dodaje novog korisnika na skladiste
     * @param username - korisnicko ime novog korisnika
     * @param password - lozinka novog korisnika
     * @param tip - tip privilegija koje ima korisnik za operacije nad skladistem
     * @return true ako je dodavanje korisnika uspelo, false ako nije
     * @throws IOException - ukoliko dodje do greske sa upisivanjem u json fajl
     */

    public boolean addUser(String username, String password, Korisnici tip) throws IOException;


    /**
     * Proverava konfiguraciju skladista
     * @param file - fajl koji se kreira i za koji se proverava da li odgovara konfiguraciji skladista
     * @return - true ili false, u zavisnosti da li fajl odgovara konfiguraciji skladista ili ne
     */

    public boolean checkStorageConfig(File file) throws IOException;

    /**
     * Konfigurise skladiste
     */

    public void configureStorage();

    /**
     * Kreira direktorijum na zadatoj putanji
     * @param path - putanja na kojoj se kreira novi direktorijum
     */

    public void createDirectory(String path) throws IOException;

    /**
     * Kreira fajl na zadatoj putanji
     * @param path - putanja na kojoj se kreira novi fajl
     */

    public void createFile(String path) throws IOException;

    /**
     * Premesta fajl sa jedne lokaciju na drugu
     * @param path1 - putanja do fajla koji se premesta
     * @param path2 - putanja na koju se premesta fajl
     */

    public void moveFile(String path1, String path2) throws IOException;

    /**
     * Brise fajl
     * @param path - putanja do fajla koji se brise
     */

    public void deleteFile(String path) throws IOException;

    /**
     * Brise direktorijum
     * @param path - putanja do direktorijuma koji se brise
     */

    public void deleteDirectory(String path) throws IOException;

    /**
     * Preuzima fajl sa skladista
     * @param src - putanja na kojoj se nalazi fajl na skladistu
     * @param dest - putanja van skladista na kojoj se cuva fajl
     */

    public void downloadFile(String src, String dest) throws IOException;

    /**
     * Vraca nazive svih fajlova u odredjenom direktorijumu
     * @param path -  putanja do direktorijuma koji se pretrazuje
     * @return - niz stringova, nazivi svih fajlova u  prosledjenom direktorijumu
     */

    public String [] getAllFilesFromDirectory(String path);

    /**
     * Vraca nazive svih direktorijuma u nekom direktorijumu
     * @param path - putanja do direktorijuma koji se pretrazuje
     * @return - niz stringova, nazivi svih direktorijuma u prosledjenom direktorijumu
     */

    public String [] getAllDirectoriesFromDirectory(String path);

    /**
     * Vraca nazive svih fajlova u direktorijumu i njegovim poddirektorijumima
     * @param directoryName - naziv direktorijuma koji se pretrazuje
     * @param files - lista svih fajlova koji su deca prosledjenog direktorijuma
     * @return - niz stringova, nazivi svih fajlova koji su deca prosledjenog direktorijuma
     */

    public String[] getAllChildren(String directoryName, List<Object> files);

    /**
     * Vraca nazive svih fajlova sa odredjenom ekstenzijom u skladistu
     * @param extension - ekstenzija fajlova koji se traze
     * @return - niz stringova, nazivi svih fajlova sa prosledjenom ekstenzijom u skladistu
     */

    public String [] getFilesByExtension(String extension);

    /**
     * Vraca nazive svih fajlova u skladistu sortirano po nazivu rastuce
     * @return - niz stringova, nazivi svih fajlova u skladistu sortirani po nazivu u rastucem redosledu
     */

    public String [] getFilesSortedByNameAsc();

    /**
     * Vraca nazive svih fajlova u skladistu sortirano po nazivu opadajuce
     * @return - niz stringova, nazivi svih fajlova u skladistu sortirani po nazivu u opadajucem redosledu
     */
    public String [] getFilesSortedByNameDesc();

    /**
     * Vraca nazive svih fajlova u skladistu sortirano po datumu kreiranja ili modifikacije rastuce
     * @return - niz stringova, nazivi svih fajlova u skladistu sortirani po datumu kreiranja ili modifikacije
     * u rastucem redosledu
     */

    public String [] getFilesSortedByDateAsc();

    /**
     * Vraca nazive svih fajlova u skladistu sortirano po datumu kreiranja ili poslednje modifikacije opadajuce
     * @return - niz stringova, nazivi svih fajlova u skladistu sortirani po datumu kreiranja ili modifikacije
     * u opadajucem redosledu
     */

    public String [] getFilesSortedByDateDesc();

    /**
     * Vraca nazive svih fajlova koji su kreirani ili modifikovani u nekom periodu u skladistu
     * @param date1 - najstariji datum
     * @param date2 - najnoviji datum
     * @return - niz stingova, nazivi svih fajlova  u skladistu koji su kreirani ili modifikovani
     * izmedju 2 prosledjena datuma, ukuljucujuci i fajlove kreirane ili modifikovane na prosledjene datume
     */

    public String [] getAllFilesInPeriod(long date1, long date2);

    /**
     * Vraca nazive svih fajlova koji su kreirani ili modifikovani u nekom periodu u nekom direktorijumu
     * @param date1 - najstariji datum
     * @param date2 - najnoviji datum
     * @param path - putanja do direktotijuma koji se pretrazuje
     * @return - niz stringova, nazivi svih fajlova u prosledjenom direktorijumu koji su kreirani ili modifikovani
     * izmedju 2 prosledjena datuma, ukljucujuci i fajlove kreirane ili modifikovane na prosledjene datume
     */

    public String [] getAllFilesInPeriodInDirectory(long date1, long date2, String path);
}
