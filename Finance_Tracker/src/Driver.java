import java.io.IOException;
/**
 * 
 * @author Davis Nuzzi
 * @version 2.0
 *
 */

public class Driver {

    /**
     * 
     * Run the program in the console.
     * 
     * @param args
     * @throws IOException
     */
    
    public static void main(String[] args) throws IOException 
    {
        if (JDBCInitialization.initialize()) {
            ConsoleUI.startScreen();
        } else {
            System.out.println("\nrootDatabase connection failed. Application cannot start.");
            System.exit(1);
        }
    }

}
