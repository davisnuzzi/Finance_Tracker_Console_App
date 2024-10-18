import java.sql.*;
import java.util.*;

/**
 * 
 * @author Davis Nuzzi
 * @version 2.0
 *
 */

public class JDBCInitialization
{
    // Scanner to read in user input
	public static Scanner keyboard = new Scanner(System.in);
    
    // Database URL, username, and password
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/user_finances"; 
    public static String JDBC_USER = "";
    public static String JDBC_PASSWORD = "";


    /**
     * 
     * Initialize the username and password of database 
     * and ensure successful connection for further program use
     * 
     */
    public static void initialize()
    {
        // Retrieve user inputs for database username and password (more for personal and security)
        System.out.println("Enter MySQL database username:");
        JDBC_USER = keyboard.next();
        System.out.println("\n");

        System.out.println("Enter MySQL database password:");
        JDBC_PASSWORD = keyboard.next();
        System.out.println("\n");

        // initalize a null database connection
        Connection connection = null;

        try 
        {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Connected to the MySQL database successfully!");

        } 
        catch (SQLException e) 
        {
            // Handle SQL connection errors
            e.printStackTrace();
            System.out.println("Failed to connect to the database!");

        } 
        catch (ClassNotFoundException e) 
        {
            // Handle JDBC driver loading error
            e.printStackTrace();
            System.out.println("MySQL JDBC Driver not found!");

        } 
        finally 
        {
            // Ensure connection is closed properly
            if (connection != null) 
            {
                try 
                {
                    connection.close();
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }

}