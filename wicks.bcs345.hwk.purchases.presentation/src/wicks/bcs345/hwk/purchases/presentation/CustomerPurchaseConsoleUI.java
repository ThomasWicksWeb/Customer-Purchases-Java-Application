/**
 * Contains the class to output the UI and handle user inputs
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
/**
 * 
 * Contains all handling for the input/output for the main program.
 * Prints the menu and handles the user input, as well as file i/o based on what the user does
 * 
 * @author Thomas Wicks
 * @version 1.0.0
 * @since 10/08/2019
 *
 */
public class CustomerPurchaseConsoleUI 
{
	/**
	 * This function prints the UI text to the console
	 */
	private static void ShowMenu()
	{
		// Outputting the user interface
		System.out.println("Customer Purchase UI");
		System.out.println("--------------------");
		System.out.println("1  - Read customer from file");
		System.out.println("2  - Read customer from file as JSON");
		System.out.println("3  - Write customer to file");
		System.out.println("4  - Write customer to file as JSON");
		System.out.println("5  - Show customer info on screen");
		System.out.println("6  - Read purchase from file");
		System.out.println("7  - Read purchase from file as JSON");
		System.out.println("8  - Write purchase to file");
		System.out.println("9  - Write purchase to file as JSON");
		System.out.println("10 - Show purchase info on screen");
		System.out.println("11 - Exit");
		System.out.println("Enter Choice:");
	}
	
	/**
	 * This method initializes a local instance of Customer and Purchase, then perform actions based on the input of the user
	 */
	public static void ShowUI()
	{	
		// Creating instance of Customer
		Customer myCus = new Customer("fName", "lName", new Address("1", "Default Street", "Defaulttown", "NY", "11747"));
		
		// Creating instance of Purchase
		Purchase myPur = new Purchase(new Product("iPhone 11", 799.00), 2);
		
		// Shows UI menu
		ShowMenu();
		
		// Creating Scanner for user's input
		Scanner keyboardInput = new Scanner(System.in);
		int input = keyboardInput.nextInt();
		
				
		// Keeps looping through the UI and user input while user input != 11 (11 finishes the program)
		do
		{ 
			// Read customer data from file
			if (input == 1) {
				try 
				{
					// User inputs files name to read from, that file's data is read into the local instance of the object
					System.out.println("Enter filename:");
					Scanner keyboardInputOne = new Scanner(System.in);
					String filename = keyboardInputOne.nextLine();
					Scanner s = new Scanner(new FileReader(filename));
					myCus.Read(s);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready to receive user input again
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			// Read customer data from JSON file
			} else if (input == 2)
			{
				try 
				{
					// User inputs files name to read from, that file's data is read into the local instance of the object
					System.out.println("Enter filename:");
					Scanner keyboardInputTwo = new Scanner(System.in);
					String filename = keyboardInputTwo.nextLine();
					FileReader fr = new FileReader(filename);
					myCus.ReadJSON(fr);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready to read next input from the user
					input = keyboardInput.nextInt();
						
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 3)
			{
				try 
				{
					// User inputs files name to output to, the instance of the object's data is output
					System.out.println("Enter Output filename:");
					Scanner keyboardInputThree = new Scanner(System.in);
					String filename = keyboardInputThree.nextLine();
					PrintStream ps = new PrintStream(filename);
					myCus.Write(ps);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready to read user's next input
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 4)
			{
				try 
				{
					// User inputs file's name to output to, the instance of the object's data is output in JSON format
					System.out.println("Enter Output filename:");
					Scanner keyboardInputFour = new Scanner(System.in);
					String filename = keyboardInputFour.nextLine();
					PrintStream ps = new PrintStream(filename);
					myCus.WriteJSON(ps);
					
					// Outputting the user interface
					ShowMenu();
					
					
					// Ready to read user's next input
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 5)
			{
				// Prints the current Customer instance to the console
				PrintStream ps = new PrintStream(System.out);
				myCus.Write(ps);
				
				// Outputting the user interface
				ShowMenu();
				
				// Ready for user's next input
				input = keyboardInput.nextInt();
				
			} else if (input == 6)
			{
				try 
				{
					// User inputs file's name to read from, that file's data is read into the local instance of the object
					System.out.println("Enter filename:");
					Scanner keyboardInputSix = new Scanner(System.in);
					String filename = keyboardInputSix.nextLine();
					Scanner s = new Scanner(new FileReader(filename));
					myPur.Read(s);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready for user's next input
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 7)
			{
				try 
				{
					// User inputs file's name to read from in JSON format, that file's data is read into the local instance of the object
					System.out.println("Enter filename:");
					Scanner keyboardInputSeven = new Scanner(System.in);
					String filename = keyboardInputSeven.nextLine();
					FileReader fr = new FileReader(filename);
					myPur.ReadJSON(fr);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready for user's input
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 8)
			{
				try 
				{
					// User inputs file's name to output to, outputs the current Purchase to the given PrintStream
					System.out.println("Enter filename:");
					Scanner keyboardInputEight = new Scanner(System.in);
					String filename = keyboardInputEight.nextLine();
					PrintStream ps = new PrintStream(filename);
					myPur.Write(ps);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready for user input
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 9)
			{
				try 
				{
					// User inputs file's name to output to in JSON format, outputs the current Purchase to the given PrintStream
					System.out.println("Enter filename:");
					Scanner keyboardInputNine = new Scanner(System.in);
					String filename = keyboardInputNine.nextLine();
					PrintStream ps = new PrintStream(filename);
					myPur.WriteJSON(ps);
					
					// Outputting the user interface
					ShowMenu();
					
					// Ready for user input
					input = keyboardInput.nextInt();
					
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			} else if (input == 10)
			{
				// Prints the current instance of the Purchase to the console
				PrintStream ps = new PrintStream(System.out);
				myPur.Write(ps);
				
				// Outputting the user interface
				ShowMenu();
				
				// Ready for next user input
				input = keyboardInput.nextInt();
			} else if(input == 11)
			{
				break;
			}
			// Repeat this loop while the user input is not '11'.
		} while (input != 12);
		
		
	}
	
}
