//import org.sqlite.core.DB;

import java.sql.*;

//TODO: Refactor, comment and import the library

/**
 * Created by Eter on 31/10/2017.
 */
public final class SQLiteSingleton {

    private final static String DB_URL = "";
    private Connection conn;
    private Statement statement;
    public static SQLiteSingleton db;

    private SQLiteSingleton(){

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static SQLiteSingleton getConnection(){
        if (db == null){
            db = new SQLiteSingleton();
        }

        return db;
    }


    public int insert(String query) throws SQLException {
        statement = conn.createStatement();
        return statement.executeUpdate(query);
    }

    public ResultSet query(String query) throws SQLException {
            statement = conn.createStatement();
        return statement.executeQuery(query);
    }

}
