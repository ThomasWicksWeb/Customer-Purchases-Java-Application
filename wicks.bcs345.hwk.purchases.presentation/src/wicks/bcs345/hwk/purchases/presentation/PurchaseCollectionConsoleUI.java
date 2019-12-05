/**
 * Contains the class to present and handle the Purchase Collection console UI & user inputs
 */
package wicks.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import wicks.bcs345.hwk.purchases.business.Address;
import wicks.bcs345.hwk.purchases.business.Customer;
import wicks.bcs345.hwk.purchases.business.Product;
import wicks.bcs345.hwk.purchases.business.Purchase;
import wicks.bcs345.hwk.purchases.business.PurchaseCollection;

/**
 * Class to present and handle the Purchase Collection Console UI & user inputs
 * @author Thomas Wicks
 * @since 10/23/2019
 * @version 1.0.0
 */
public class PurchaseCollectionConsoleUI 
{
	
	/**
	 * Prints the PCC menu to the console
	 */
	public static void ShowMenu()
	{
		// Outputting the user interface
		System.out.println("PurchaseCollection UI");
		System.out.println("--------------------");
		System.out.println("1  - Read PurchaseCollection from file");
		System.out.println("2  - Read PurchaseCollection from file as JSON");
		System.out.println("3  - Write PurchaseCollection to file");
		System.out.println("4  - Write PurchaseCollection to file as JSON");
		System.out.println("5  - Show purchase by index");
		System.out.println("6  - Show maximum purchase");
		System.out.println("7  - Show PurchaseCollection report on screen");
		System.out.println("8  - Show PurchaseCollection toString on screen");
		System.out.println("9 - Exit");
		System.out.println("Enter Choice:");
	}

	// Shows UI menu
	/**
	 * Create placeholder instance of a Purchase Collection,
	 * handles user input based on the ShowMenu() function
	 */
	public static void ShowUI()
	{
		// Creates a placeholder instance of a Purchase Collection
		Customer myCustomer = new Customer("Thomas", "Wicks", new Address("4", "Ruth Lane", "Selden", "NY", "11784"));
		Purchase[] myPurchases = new Purchase[3];
		myPurchases[0] = new Purchase(new Product("iPhone 8", 699), 1);
		myPurchases[1] = new Purchase(new Product("Sam's Cracked Galaxy S10", 1000), 1);
		myPurchases[2] = new Purchase(new Product("iPhone 10", 999), 1);
		PurchaseCollection PC = new PurchaseCollection(myCustomer, myPurchases);
		
		// Displays PCC menu
		ShowMenu();
		
		// Creating Scanner for user's input
		Scanner keyboardInput = new Scanner(System.in);
		int input = keyboardInput.nextInt();
		
		// Logic for processing the user input
		do
		{
			if(input == 1) // Read PurchaseCollection from file
			{
				try 
				{
					// User inputs files name to read from, that file's data is read into the local instance of the object
					System.out.println("Enter filename:");
					Scanner keyboardInputOne = new Scanner(System.in);
					String filename = keyboardInputOne.nextLine();
					Scanner s = new Scanner(new FileReader(filename));
					PC.Read(s);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready to receive user input again
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 2) // Read PurchaseCollection from File as JSON
			{
				try 
				{
					// User inputs files name to read from, that file's data is read into the local instance of the object
					System.out.println("Enter filename:");
					Scanner keyboardInputTwo = new Scanner(System.in);
					String filename = keyboardInputTwo.nextLine();
					FileReader fr = new FileReader(filename);
					PC.ReadJSON(fr);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready to read next input from the user
					input = keyboardInput.nextInt();
						
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
			else if (input == 3) // Write PurchaseCollection to file
			{
				try 
				{
					// User inputs files name to output to, the instance of the object's data is output
					System.out.println("Enter Output filename:");
					Scanner keyboardInputThree = new Scanner(System.in);
					String filename = keyboardInputThree.nextLine();
					PrintStream ps = new PrintStream(filename);
					PC.Write(ps);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready to read user's next input
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 4) // Write PurchaseCollection to file as JSON
			{
				try 
				{
					// User inputs file's name to output to, the instance of the object's data is output in JSON format
					System.out.println("Enter Output filename:");
					Scanner keyboardInputFour = new Scanner(System.in);
					String filename = keyboardInputFour.nextLine();
					PrintStream ps = new PrintStream(filename);
					PC.WriteJSON(ps);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready to read user's next input
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 5) // Show purchase by index
			{
				// User inputs the index of the array they want returned
				System.out.println("Enter array index:");
				Scanner keyboardInputFive = new Scanner(System.in);
				int indexPos = keyboardInputFive.nextInt();
				
				// Try to get that position in the array, else throws exception
				try {
					System.out.println(PC.GetByIndex(indexPos));
				} catch(ArrayIndexOutOfBoundsException e){
					System.out.println("That position in the array does not exist.");
				}
				
				// Outputting the user interface
				ShowMenu();
				
				// Ready to read user's next input
				input = keyboardInput.nextInt();
				
			} else if (input == 6) // Show maximum purchase
			{
				// Show the greatest purchase in the Purchase array
				System.out.println(PC.GetMaxPurchase());
				
				// Outputting the user interface
				ShowMenu();
				
				// Ready to read user's next input
				input = keyboardInput.nextInt();
			} else if (input == 7) // Show PurchaseCollection report on screen
			{
				// Prints a formatted report on the screen
				PrintStream ps = new PrintStream(System.out);
				PC.Report(ps);
				
				// Outputting the user interface
				ShowMenu();
				
				// Ready to read user's next input
				input = keyboardInput.nextInt();
			} else if (input == 8) // Show PurchaseCollection toString method on screen
			{
				// 'Stringifies' the Purchase Collection
				System.out.println(PC.toString());
				
				// Outputting the user interface
				ShowMenu();
				
				// Ready to read user's next input
				input = keyboardInput.nextInt();
			} else if (input == 9)
			{
				break;
			}
		} while (input > 0 && input <= 10);
	}
}
