import java.io.IOException;
import java.util.InputMismatchException;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class Actions 
{
	public static String account;
	public static String filename;
	public static int actionNum;
	
	/**
	 * 
	 * Creates and executes the actions into the console
	 * @throws IOException 
	 */
	
	public static void startScreen() throws IOException
	{
		account = (ConsoleUI.accNum == 1) ? "Chase" : "PayPal";

		filename = account + ".txt";
		
		System.out.println("We are currently looking at your " + account + 
							" account.\n"
							+ "What are you trying to do today? (Input number corresponding to the action)\n" 
							+ "1. Show account history\n"
							+ "2. Withdraw\n"
							+ "3. Deposit\n"
							+ "4. Choose another account\n");
		do 
		{
			try
			{
				actionNum = ConsoleUI.keyboard.nextInt();
				
				if (ConsoleUI.checkValidNumber(actionNum, 1, 4)) 
				{
					switch (actionNum) 
					{
						
					}
					
					startScreen();
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please input a valid number.");
			}
		} while(true);
	}
	
}
