package id.ac.ukdw.fti.notfound.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    final private String url = "jdbc:sqlite:vizbible.db";
    private Connection connection = null;
    public static Database instance = new Database();

    public Database(){
        try {
            connection = DriverManager.getConnection(url);

        } catch (Exception e) {
            //TODO: handle exception

            System.out.println(e.getMessage());
        }
    }
}
