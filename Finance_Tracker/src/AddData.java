import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class AddData 
{
	// BufferedWriter used to add data to the existing files
	private static BufferedWriter writer;
	
	// Array for data to be added into
	static String[] inputs = new String[5];
	
	/**
	 * 
	 * Retrieve info from the user and add transactional data to the necessary file
	 * 
	 * @throws IOException
	 */
	
	public static void addInfo() throws IOException
	{
		
		// Establish the writer to be able to write within the file
		try {
			writer = new BufferedWriter(new FileWriter(Actions.filename, true));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
		
		// Filler line for better visual
		writer.newLine();
		
		// Retrieve user data
		retrieveData();
		
		// Have the user confirm that the info being added is correct
		System.out.println("Does this information look correct? (Y/N)\n" + Arrays.toString(inputs));
		
		
		// If the info is not correct, erase the added data and have the user input the data again
		do {
			// User confirmation input
			String userConfirm = ConsoleUI.keyboard.next();
			
			if(userConfirm.equalsIgnoreCase("Y"))
			{
				writer.newLine();
				writer.write(inputs[0]);
				
				for(int i = 1; i < inputs.length; i++)
				{
					writer.write(" " + inputs[i]);
				}
				
				break;
			}
			else if(userConfirm.equalsIgnoreCase("N"))
			{
				eraseLastLine(Actions.filename);
				addInfo();
			}
			else
			{
				System.out.println("Please input 'Y' for Yes, or 'N' for No.");
			}
		}while(true);
		
		// close the write to prevent leakage
		writer.close();
	}
	
	/**
	 * 
	 * Erases the last line of a given file
	 * 
	 * @param filename
	 */
	
	public static void eraseLastLine(String filename) {
        try (RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            long length = file.length();
            if (length == 0) {
                // File is empty, no need to erase anything
                return;
            }

            long pos = length - 1;
            file.seek(pos);
            while (file.readByte() != '\n') {
                pos--;
                if (pos == 0) {
                    // Reached the beginning of the file without finding a newline character
                    // So, erase the entire file content
                    file.setLength(0);
                    return;
                }
                file.seek(pos);
            }

            // Truncate the file at the position of the last newline character
            file.setLength(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void retrieveData() throws FileNotFoundException
	{
		// Retrieve and write out the local time and date from the user's machine
		inputs[0] = LocalDate.now().toString();
		inputs[1] = LocalTime.now().toString();
						
		// Retrieve and write out the amount being deposited/withdrawn
		double amount;
		if(Actions.actionNum == 3)
		{
			System.out.println("How much was deposited?");
			amount =  ConsoleUI.keyboard.nextDouble();
			System.out.println("Reason for deposit? (20 character max)");
					
		}
		else
		{
			System.out.println("How much was withdrawn?");
			amount = ConsoleUI.keyboard.nextDouble() * -1;
			System.out.println("Reason for withdraw? (20 character max)");
		}
		inputs[2] = String.format("$%.2f", amount);
			
		// Retrieve and write out the total amount of money the user has
		String[] accountInfo = FileInput.readFile(Actions.filename);
		String[] recentInfo = accountInfo[accountInfo.length - 1].split(" ");
		double total = Double.parseDouble(recentInfo[recentInfo.length - 1].replaceAll("\\$", ""));
		inputs[4] = String.format("Total: $%.2f", total + amount);
			
		// Retrieve and write out the reason for the money being deposited
		// Make sure the reason is no more than 20 characters than have user confirm data is correct
		String reason;
		do
		{
			reason = ConsoleUI.keyboard.next();
			if(reason.length() <= 20)
			{
				inputs[3] = "Reason: " + reason;
				
				
				break;
			}
		}while(true);
	}
}

	
