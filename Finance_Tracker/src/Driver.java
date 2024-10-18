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
		JDBCInitialization.initialize();
		ConsoleUI.startScreen();
	}

}
