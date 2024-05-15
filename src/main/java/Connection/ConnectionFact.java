package Connection;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Creates the connection to the database
 */
public class ConnectionFact {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFact.class.getName());
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DBURL = "jdbc:postgresql://localhost:5432/proiect";
    private static final String USER = "postgres";
    private static final String PASS = "cenago11";

    private static ConnectionFact singleInstance = new ConnectionFact();
    private ConnectionFact(){
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Creates a connection to the databases
     * @return the connection to the database
     */
    private Connection createConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL,USER,PASS);
        } catch (SQLException e){
            LOGGER.log(Level.WARNING, "An error occured while connecting");
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Closes the connection to the database
     * @param connection the database conection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    /**
     * Closes the statement
     * @param statement the declared statement
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    /**
     * Closes the resultSet
     * @param resultSet the declared resultSet
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }

}
