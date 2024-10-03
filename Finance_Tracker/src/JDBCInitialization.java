import java.sql.*;
import java.util.*;

public class JDBCInitialization
{
    // Scanner to read in user input
	public static Scanner keyboard = new Scanner(System.in);
    
    // Database URL, username, and password
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/testDB"; // !!! replace 'testdb' with actual db name !!! 
    private static String JDBC_USER = "";
    private static String JDBC_PASSWORD = "";

    public static void initialize()
    {
        // User inputs database username and password (more for personal use)
        System.out.println("Enter MySQL database username:");
        JDBC_USER = keyboard.next();
        System.out.println("\n");

        System.out.println("Enter MySQL database password:");
        JDBC_PASSWORD = keyboard.next();
        System.out.println("\n");

        Connection connection = null;

        try 
        {
            // Load MySQL JDBC driver (optional for most modern JDBC setups)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
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
                    System.out.println("Database connection closed.");
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }

}