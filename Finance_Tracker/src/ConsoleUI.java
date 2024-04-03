import java.io.IOException;
import java.util.*;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class ConsoleUI 
{
	// Create scanner to read in user input
	public static Scanner keyboard = new Scanner(System.in);
	
	// create menu number for which account the user is trying to access
	static int accNum = 0;
	
	/**
	 * 
	 * Creates and executes the starting console application UI
	 * 
	 * @throws IOException
	 */
	
	public static void startScreen() throws IOException
	{
		System.out.println("Which account are you wanting to look at? (Input number corresponding to the account)\n" + 
							"1. Chase\n" + 
							"2. PayPal\n");
		
		// Gather and check the user enters a valid input value
		// If valid, execute further program methods, else, ask user for new input
		do 
		{
			try 
			{
				accNum = keyboard.nextInt();
				
				if(checkValidNumber(accNum, 1, 2))
				{
					Actions.startScreen();
					break;
				}
				else
				{
					System.out.println("That does not appear to be an option, please try again.");
				}
			} 
			catch (InputMismatchException e) 
			{
				
			}
			finally
			{
				keyboard.nextLine();
			}
			
			
		} while (true);
	}
	
	/**
	 * 
	 * Checks to see if the number selected is valid for the given parameter constraints.
	 * 
	 * @param num
	 * @return the boolean value of whether or not the account number is valid
	 */
	
	public static boolean checkValidNumber(int num, int low, int high)
	{
		if(String.valueOf(num).compareTo("z") >= 0 || num < low || num > high)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
}
