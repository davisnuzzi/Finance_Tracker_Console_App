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
	 * 
	 */
	
	public static void startScreen() throws IOException
	{
		ArrayList<String> accounts = UserAccounts.getAccounts();
		
		String chooseAccount = "Which account are you wanting to look at? (Input number corresponding to the account)\n";
		
		for(int i = 0; i < accounts.size(); i++)
		{
			chooseAccount = chooseAccount + (i+1) + ". " + accounts.get(i) + "\n";
		}

		chooseAccount = chooseAccount + (accounts.size()+1) + ". Add Account\n";
		
		System.out.println(chooseAccount);
		
		// Gather and check the user enters a valid input value
		// If valid, execute further program methods, else, ask user for new input
		do 
		{
			try 
			{
				accNum = keyboard.nextInt();
				
				if(accNum < accounts.size())
				{
					Actions.startScreen();
					break;
				}
				else if(accNum == accounts.size() + 1)
				{
					System.out.println("Name the account you want to add. (Ex: Chase savings, Paypal checking)");
					keyboard.nextLine();
					String accountName = keyboard.nextLine();
					accountName = accountName.replaceAll(" ", "_");
					UserAccounts.addAccount(accountName);
					System.out.println("\n");
					startScreen();
				}
				else
				{
					System.out.println("That does not appear to be an option, please try again.");
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("Please input a valid number.");
			}
			finally
			{
				keyboard.nextLine();
			}
			
		} while (true);
	}
	
}
