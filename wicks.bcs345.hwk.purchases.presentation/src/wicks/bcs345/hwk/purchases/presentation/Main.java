/**
 * Contains the Main class to run all code
 */
package wicks.bcs345.hwk.purchases.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javafx.application.Application;
import wicks.bcs345.hwk.purchases.business.Product;
import wicks.bcs345.hwk.purchases.business.Purchase;
import wicks.bcs345.hwk.purchases.business.PurchaseCollection;

/**
 * Contains the main program code. This class currently calls CustomerPurchaseConsoleUI.
 * @author TJ
 * @version 3.0.0
 * @since 10/12/2019
 */
public class Main 
{
	/**
	 * The driver of the entire program
	 * @param args 
	 */
	public static void main(String[] args) 
	{	
		// Output the UI to the user
		showMainMenu();
		
		// Create a Scanner for the user input
		Scanner s = new Scanner(System.in);
		int userChoice = s.nextInt();
		
		// Listening for user input for either Customer Purchase Console UI || Purchase Collection Console UI 
		do
		{
			if(userChoice == 1)
			{
				// Show customer Purchase Console UI menu
				CustomerPurchaseConsoleUI.ShowUI();
				
				// Show the main menu after the user is finished with the Customer Purchase Console UI
				showMainMenu();
				
				s = new Scanner(System.in);
				userChoice = s.nextInt();
				
			} else if (userChoice == 2)
			{
				// Take user to the PCC UI
				PurchaseCollectionConsoleUI.ShowUI();
				 
				// Show the main menu after the user is done with the Purchase Collection Console UI
				showMainMenu();
				
				// Get ready for next user input
				s = new Scanner(System.in);
				userChoice = s.nextInt();
				
			} else if (userChoice == 3) 
			{
				// Run the application GUI
				PurchasesGraphicalUI.ShowUI();
				
				// Show the main menu after the user is done with the Purchase Collection Console UI
				showMainMenu();
				
				// Get ready for next user input
				s = new Scanner(System.in);
				userChoice = s.nextInt();
			}
			// If the user choice is not one of the possible options, program finishes execution
		} while (userChoice != 4);
				
	}	
	
	// Output the UI to the user
	public static void showMainMenu() {
		System.out.println("Choose UI");
		System.out.println("---------");
		System.out.println("1 - Customer Purchase Console UI");
		System.out.println("2 - Purchase Collection Console UI");
		System.out.println("3 - PurchasesGraphicalUI");
		System.out.println("4 - Exit");
		System.out.println("Enter Choice:");
	}
}
