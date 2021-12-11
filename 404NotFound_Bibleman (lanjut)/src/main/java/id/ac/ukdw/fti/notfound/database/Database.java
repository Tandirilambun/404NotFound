package id.ac.ukdw.fti.notfound.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import id.ac.ukdw.fti.notfound.modal.Event;
import id.ac.ukdw.fti.notfound.modal.Verses;
import id.ac.ukdw.fti.notfound.modal.VisualMethod;
import id.ac.ukdw.fti.notfound.modal.tampil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    
    final private String url = "jdbc:sqlite:vizbible.db";
    // final private String queryPlaces = "SELECT displayTitle FROM places";
    private Connection connection = null;
    public static Database instance = new Database();

    public Database(){
        try {
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection opeConnection(){
        return connection;
    }

    public ArrayList getAllVerses(){
        ArrayList<Verses> verses = new ArrayList<Verses>();
        String querySelect = "SELECT osisRef, verseText FROM verses";
        try {
            Statement statement  = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()) {
                verses.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
            }
            return verses;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return verses;
    }

    public ArrayList getBook(){
        String queryBook = "SELECT DISTINCT(book) from verses";
        ArrayList<String> book = new ArrayList<String>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryBook);
        
            while(result.next()){
                book.add(result.getString("book"));
                
            }
            return book;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    public ArrayList getChapter(String kitab){
        String queryChapter = "SELECT DISTINCT(chapter) from verses WHERE book = '"+ kitab+"'";
        ArrayList<String> chapter = new ArrayList<String>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryChapter);
        
            while(result.next()){
                chapter.add(result.getString("chapter"));
                
            }
            return chapter;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return chapter;
    }

    public ArrayList getVerseNum(String pasal){
        String queryNum = "SELECT (verseNum) from verses WHERE chapter = '"+ pasal +"'";
        ArrayList<Integer> verseNum = new ArrayList<Integer>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryNum);
        
            while(result.next()){
                verseNum.add(result.getInt("verseNum"));
                
            }
            return verseNum;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return verseNum;
    }
    public ArrayList getAyat(String kitab, String pasal, int ayat){
        String query = "SELECT osisRef, verseText, verseNum FROM verses WHERE book = '"+ kitab +"' AND chapter ='"+ pasal +"'";
        // System.out.println(query);
        ArrayList <tampil> hasil = new ArrayList<tampil>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
        
            while(result.next()){
                if (result.getInt("verseNum") >= ayat){
                    // System.out.println(result.getInt("verseNum"));
                    hasil.add(new tampil(result.getString("osisRef"), result.getString("verseText"), result.getInt("verseNum")));
                }
            }
            return hasil;
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
            return hasil;
        }
    }

    // public ArrayList viewPlaces(String cari){
    //     String query = "SELECT verses, verseCount FROM places WHERE displayTitle = '"+cari+"'";
    //     // System.out.println(query);
    //     ArrayList<VisualMethod> hasil = new ArrayList<VisualMethod>();
    //     try {
    //         Statement statement = connection.createStatement();
    //         ResultSet result = statement.executeQuery(query);

    //         while(result.next()){
    //             hasil.add(new Verses(result.getString("verses"), result.getInt("verseCount")));
    //         }
    //         return hasil;
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         return hasil;
    //     } 
        
    // }

    public ArrayList searchEvent(String cari){
        String query = "SELECT osisRef, verseText FROM verses WHERE eventsDescribed LIKE '%"+cari+"%'";
        // System.out.println(query);
        ArrayList<Verses> hasil = new ArrayList<Verses>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                hasil.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
            }
            return hasil;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return hasil;
        } 
    }
    public ArrayList searchPlaces(String cari){
        String query = "SELECT osisRef, verseText FROM verses WHERE places LIKE '%"+cari+"%'";
        // System.out.println(query);
        ArrayList<Verses> hasil = new ArrayList<Verses>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                hasil.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
            }
            return hasil;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return hasil;
        } 
    }
    public ArrayList homeSearch(String cari){
        String query = "SELECT osisRef, verseText FROM verses WHERE places LIKE '%"+cari+"%' OR eventsDescribed LIKE '%"+cari+"%'";
        // System.out.println(query);
        ArrayList<Verses> hasil = new ArrayList<Verses>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                hasil.add(new Verses(result.getString("osisRef"), result.getString("verseText")));
            }
            return hasil;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return hasil;
        } 
    }
    public VisualMethod visualData(String cari){
        String query = "SELECT people, peopleCount,places,placesCount FROM verses WHERE osisRef = '"+cari+"'";
        // System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            return (new VisualMethod(result.getString("people"), result.getInt("peopleCount"), result.getString("places"), result.getInt("placesCount")));
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String ambilNamaPeople(String id){
        String query = "SELECT displayTitle FROM people WHERE personLookup = '"+id+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                return result.getString("displayTitle");
            }
            return result.getString("displayTitle");
        } catch (Exception e) {
            return (e.getMessage());
        }
        
        
    }

    public String ambilNamaPlaces(String id){
        String query = "SELECT displayTitle FROM places WHERE placeLookup = '"+id+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                 return result.getString("displayTitle");
            }
            return result.getString("displayTitle");
        } catch (Exception e) {
            return (e.getMessage());
        }
        
    }

    ObservableList<Event>events = FXCollections.observableArrayList();
    public ObservableList<Event> visEvent(){
        String query = "SELECT verses, title, locations FROM events";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                Event event = new Event();
                event.setVerses(result.getString("verses"));
                event.setTitle(result.getString("title"));
                event.setPlaces(result.getString("locations"));
                // System.out.println(result.getString("locations"));
                // hasil.add(result.getString("locations"));
                // event.setPlaces(hasil.size());
                events.add(event);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return events;
        
    }
}
