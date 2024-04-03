import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class FileInput {
	
	/**
	 * 
	 * Reads in a file and prints its contents into the console for the user to see.
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	
	public static void showFile(String filename) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File (filename));
		
		while(file.hasNextLine())
		{
			System.out.println(file.nextLine());
		}
		System.out.println();
	}
	
	/**
	 * 
	 * Reads in a file and stores contents in an array and returns it.
	 * 
	 * @param filename
	 * @return the array in which the contents of the file are stored
	 * @throws FileNotFoundException
	 */
	
	public static String[] readFile(String filename) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File (filename));
			
		int lines = 0;
			
		// initializes how many lines are in the file to set the array size to
		while (file.hasNextLine()) 
		{
			lines++;
			file.nextLine();
		}
			
		file.close();
			
		file = new Scanner(new File (filename));
		
		String[] accList = new String[lines];
		
		// stores the contents of the file into the array
		for (int i = 0; i < lines; ++i) 
		{
			accList[i] = file.nextLine(); 
		}	
			
		return accList;
				
	}
	
}
