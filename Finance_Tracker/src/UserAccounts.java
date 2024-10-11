import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserAccounts 
{
        public static ArrayList<String> accounts = new ArrayList<>();

        // Get the account names from the user accounts table and store them into
        public static ArrayList<String> getAccounts()
        {
                ArrayList<String> dataList = new ArrayList<>();
                Connection connection = null;

                try {
                        // Establish connection
                        connection = DriverManager.getConnection(JDBCInitialization.JDBC_URL, JDBCInitialization.JDBC_USER, JDBCInitialization.JDBC_PASSWORD);
                        String sql = "SELECT * FROM accounts";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        // Process the ResultSet
                        while (resultSet.next()) 
                        {
                                String data = resultSet.getString(1);
                                dataList.add(data);
                        }

                        // Close resources
                        resultSet.close();
                        preparedStatement.close();

                } 
                catch (SQLException e) 
                {
                        e.printStackTrace(); // Handle SQL exceptions
                } 
                finally 
                {
                        // Ensure connection is closed properly
                        if (connection != null) 
                        {
                                try 
                                {
                                        connection.close();
                                        // System.out.println("Database connection closed.");
                                } 
                                catch (SQLException e) 
                                {
                                        e.printStackTrace();
                                }
                        }
                }

                return dataList;
        }

        public static void addAccount(String data)
        {
                Connection connection = null;

                try 
                {
                        // Establish connection
                        connection = DriverManager.getConnection(JDBCInitialization.JDBC_URL, JDBCInitialization.JDBC_USER, JDBCInitialization.JDBC_PASSWORD);
                        
                        // Create table if it doesn't exist
                        String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (acc_name VARCHAR(255));"; // Replace with your table and column names
                        PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL);
                        createTableStatement.executeUpdate();
                        // System.out.println("Table created if it didn't exist.");

                        // Insert data into the table
                        String insertSQL = "INSERT INTO accounts (acc_name) VALUES (?);"; // Replace with your table and column names
                        PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
                        insertStatement.setString(1, data); // Set the value for the first (and only) column
                        insertStatement.executeUpdate();
                        // System.out.println("Data added to the table.");

                        createAccountTable(data);

                        // Close resources
                        createTableStatement.close();
                        insertStatement.close();

                } 
                catch (SQLException e) 
                {
                        e.printStackTrace(); // Handle SQL exceptions
                } 
                finally 
                {
                        // Ensure connection is closed properly
                        if (connection != null) 
                        {
                        try 
                        {
                                connection.close();
                                // System.out.println("Database connection closed.");
                        } 
                        catch (SQLException e) 
                        {
                                e.printStackTrace();
                        }
                        }
                }
        }

        public static void createAccountTable(String data)
        {
                Connection connection = null;

                try 
                {
                        // Establish connection
                        connection = DriverManager.getConnection(JDBCInitialization.JDBC_URL, JDBCInitialization.JDBC_USER, JDBCInitialization.JDBC_PASSWORD);
                        // SQL query to create the table
                        String createTableSQL = "CREATE TABLE IF NOT EXISTS `" + data + "` ("
                        + "Transaction_ID INT AUTO_INCREMENT PRIMARY KEY, "
                        + "transaction_date DATE, "  
                        + "transaction_time TIME, " 
                        + "amount DECIMAL(10, 2), "
                        + "reason VARCHAR(20), "
                        + "total DECIMAL(10, 2)"
                        + ")";
                        
                        PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL);
                        createTableStatement.executeUpdate();
                        // System.out.println(data + " Table created");


                }
                catch (SQLException e) 
                {
                        e.printStackTrace(); // Handle SQL exceptions
                } 
                finally 
                {
                        // Ensure connection is closed properly
                        if (connection != null) 
                        {
                        try 
                        {
                                connection.close();
                                // System.out.println("Database connection closed.");
                        } 
                        catch (SQLException e) 
                        {
                                e.printStackTrace();
                        }
                        }
                }
        }
 }
