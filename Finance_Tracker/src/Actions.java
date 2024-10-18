import java.io.IOException;
import java.util.InputMismatchException;

/**
 * 
 * @author Davis Nuzzi
 * @version 2.0
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
		account = ConsoleUI.accounts.get(ConsoleUI.accNum - 1);
		
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
				
				if (checkValidNumber(actionNum, 1, 4)) 
				{
					switch (actionNum) 
					{
						case 1:
							UserAccounts.retreiveTableData(account); // !!! CHANGE FILLER ACCOUNT NAME !!!
						case 2:
						case 3:
							
						case 4:
							ConsoleUI.startScreen();
							break;
						
						default:
							break;
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

	/**
	 * 
	 * Checks to see if the number selected is valid for the given parameter constraints.
	 * 
	 * @param num
	 * @return the boolean value of whether or not the account number is valid
	 */
	
	public static boolean checkValidNumber(int num, int low, int high)
	{
		return num < low || num > high ? false : true;
	}
	
}
