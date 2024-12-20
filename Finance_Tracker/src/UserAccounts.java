import java.sql.*;
import java.util.*;

/**
 * 
 * @author Davis Nuzzi
 * @version 2.0
 *
 */

public class UserAccounts 
{
        // Get the account names from the user accounts table and store them into
        public static ArrayList<String> retreiveTableData(String tableName)
        {
                ArrayList<String> dataList = new ArrayList<>();
                Connection connection = null;

                try {
                        // Establish connection
                        connection = DriverManager.getConnection(JDBCInitialization.JDBC_URL, JDBCInitialization.JDBC_USER, JDBCInitialization.JDBC_PASSWORD);
                        String sql = "SELECT * FROM `" + tableName + "`";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        // Process the ResultSet
                        while (resultSet.next()) 
                        {
                                String data = resultSet.getString(1).replaceAll("_", " ");
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
                PreparedStatement createTableStatement = null;

                try 
                {
                        // Establish connection
                        connection = DriverManager.getConnection(JDBCInitialization.JDBC_URL, JDBCInitialization.JDBC_USER, JDBCInitialization.JDBC_PASSWORD);
                        // SQL query to create the table using StringBuilder for efficient string concatenation
                        StringBuilder createTableSQL = new StringBuilder();
                        createTableSQL.append("CREATE TABLE IF NOT EXISTS `").append(data).append("` (")
                                   .append("Transaction_ID INT AUTO_INCREMENT PRIMARY KEY, ")
                                   .append("transaction_date DATE, ")
                                   .append("transaction_time TIME, ")
                                   .append("amount DECIMAL(10, 2), ")
                                   .append("reason VARCHAR(20), ")
                                   .append("total DECIMAL(10, 2)")
                                   .append(")");
                        
                        createTableStatement = connection.prepareStatement(createTableSQL.toString());
                        createTableStatement.executeUpdate();
                }
                catch (SQLException e) 
                {
                        e.printStackTrace(); // Handle SQL exceptions
                } 
                finally 
                {
                        // Ensure resources are closed properly
                        try 
                        {
                                if (createTableStatement != null) createTableStatement.close();
                                if (connection != null) connection.close();
                        } 
                        catch (SQLException e) 
                        {
                                e.printStackTrace();
                        }
                }
        }
 }
