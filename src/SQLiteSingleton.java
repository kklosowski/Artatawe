import java.sql.*;

/**
 * Singleton class for handling the database connection
 * @author  Kamil Klosowski
 * @since   31/10/2017
 */

public final class SQLiteSingleton {

    /**
     * Database path
     */
    private final static String DB_URL = "jdbc:sqlite:Artatawe.db";
    /**
     * Database connection
     */
    private Connection conn;
    /**
     * Statement holding the query to be executed
     */
    private Statement statement;
    /**
     * Instance of itself
     */
    public static SQLiteSingleton db;

    /**
     * Private constructor used by getConnection method
     */
    private SQLiteSingleton(){

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns and ensures that there is only one instance of the class
     * @return Instance of the SingletonClass
     */
    public static SQLiteSingleton getConnection(){
        if (db == null){
            db = new SQLiteSingleton();
        }
        return db;
    }


    /**
     * Method responsible for executing queries and returning the result of execution
     * @param query Query to be executed
     * @return Result of the operation
     * @throws SQLException
     */
    public int insert(String query) throws SQLException {
        statement = conn.createStatement();
        return statement.executeUpdate(query);
    }

    /**
     * Method responsible for executing queries and returning selected data
     * @param query Select query to be executed
     * @return ResultSet containing selected data
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException {
            statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    /**
     * Closes the database connection
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        conn.close();
    }

}
