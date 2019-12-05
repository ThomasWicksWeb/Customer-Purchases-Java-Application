/**
 * PurchaseCollection class in the business package
 */
package wicks.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author TJ
 * @version 1.0.0 
 * @since 10/21/2019
 * 
 */
public class PurchaseCollection {

	// Declaring local member variables // ONE instance of customer && an ARRAY of purchases
	private Customer m_myCus;
	private Purchase[] m_Purchase;
	
	// Default constructor
	/**
	 * Default constructor 
	 */
	public PurchaseCollection()
	{
		this.m_myCus = new Customer();
		this.m_Purchase = new Purchase[3];
		m_Purchase[0] = new Purchase(new Product("iPhone 8", 699), 1);
		m_Purchase[1] = new Purchase(new Product("iPhone 9", 799), 2);
		m_Purchase[2] = new Purchase(new Product("iPhone 10", 999), 1);
	}
	
	/**
	 * Returns the current Purchase[] array (for use in the PurchasesController class)
	 * @return the current Purchase[] array
	 */
	public Purchase[] getPurchases()
	{
		return this.m_Purchase;
	}
	
	// Constructor
	/**
	 * Class constructor
	 * @param newCus - Instance of Customer
	 * @param newPurchase - Array of Purchases
	 */
	public PurchaseCollection(Customer newCus, Purchase[] newPurchase)
	{
		this.m_myCus = newCus;
		this.m_Purchase = newPurchase;
	}
	
	// Setting the Customer
	/**
	 * Set member variable for the Customer
	 * @param newCus - Customer object
	 */
	public void setCustomer(Customer newCus)
	{
		this.m_myCus = newCus;
	}
	
	// Returning the current instance of Customer
	/**
	 * Get Customer object
	 * @return - The current instance of Customer
	 */
	public Customer getCustomer()
	{
		return this.m_myCus;
	}
	
	// Cycles through the array of purchases for the instance, returns the purchase OBJECT with the highest total price
	/**
	 * Get max purchase
	 * @return - The entire Purchase object which has the highest total
	 */
	public Purchase GetMaxPurchase()
	{
		// Variables to track the highest price, and the array position of that object
		double price = 0;
		double max = 0;
		int arrPosition = 0;
		
		// Begin looping through the Purchase array
		for(int i = 0; i < this.m_Purchase.length; i++)
		{
			// Get the price for the current object
			price = this.m_Purchase[i].getQuantity() * this.m_Purchase[i].getProduct().getPrice();
			
			// If the price of the current object is greater than the current max, assign price to max,
			// and also assign the current position of the object to arrPosition
			if(price > max)
			{
				max = price;
				arrPosition = i;
			}
		}
		
		// If there is no max, return null, else return the greatest purchase object
		if (max == 0)
		{
			return null;
		} else 
		{
			return m_Purchase[arrPosition]; 
		}
	}
	
	
	// Takes in the index position for the given Purchase[] array, if that index exists, return that purchase 
	/**
	 * Return a specific Purchase object in the array
	 * @param index -- Desired position in the array
	 * @return -- The desired Purchase object
	 */
	public Purchase GetByIndex(int index)
	{
		// Checks if the index exists, and returns it
		if(index > (this.m_Purchase.length - 1) || index < 0)
		{
			throw new ArrayIndexOutOfBoundsException("This position in the array does not exist.");		
		} else 
		{
			return this.m_Purchase[index];			
		}
	}
	
	// Generate a formatted report for the current instance
	/**
	 * Print a formatted report for the given instance of the object to the given PrintStream
	 * @param ps -- Output for the report to be sent to
	 */
	public void Report(PrintStream ps)
	{
		// Prints the header of the report with the customer's personal information
		ps.println("Purchase Report");
		ps.println("---------------");
		ps.printf("%s %s\n", this.m_myCus.getFirstName(), this.m_myCus.getLastName());
		ps.printf("%s %s\n", this.m_myCus.getAddress().getNumber(), this.m_myCus.getAddress().getStreet());
		ps.printf("%s, %s %s\n\n", this.m_myCus.getAddress().getCity(), this.m_myCus.getAddress().getState(), this.m_myCus.getAddress().getZip());
		ps.printf("%-30s %20s %20s %20s\n", "Description", "Price", "Quantity", "total");
		ps.printf("%-30s %20s %20s %20s\n", "-----------", "-----", "---------", "-----");
		
		// Initialize variables for totals
		double globalTotal = 0;
		double globalQuantity = 0;
		
		// Formats and prints each purchase in the Purchase[] array
		for(int i = 0; i < this.m_Purchase.length; i++)
		{
			// Get the cost of the current object
			double costTotal = this.m_Purchase[i].getProduct().getPrice() * this.m_Purchase[i].getQuantity();
			
			// Prints the product description, price, and quantity
			ps.printf("%-30s %20s %20s %20.2f\n", this.m_Purchase[i].getProduct().getDescription(), this.m_Purchase[i].getProduct().getPrice(),
					this.m_Purchase[i].getQuantity(), costTotal);
			
			// Keeps track of the 'global' cost and quantity
			globalTotal += costTotal;
			globalQuantity += this.m_Purchase[i].getQuantity();
		}
		
		// Prints divider lines, then quantity total and cost total
		ps.printf("%-30s %20s %20s %20s\n", "-----------", "-----", "---------", "-----");
		ps.printf("%-30s %41.0f %20.2f\n", "Total", globalQuantity, globalTotal);
	}
	
	
	// Outputting the data from the passed-through-instance to the given instance of PrintStream
	/**
	 * Output the information for the current instance to the given PrintStream
	 * @param ps -- Output destination
	 */
	public void Write(PrintStream ps)
	{
		// Printing the 'basic' information 
		ps.println(this.m_myCus.getFirstName());
		ps.println(this.m_myCus.getLastName());
		ps.println(this.m_myCus.getAddress().getNumber());
		ps.println(this.m_myCus.getAddress().getStreet());
		ps.println(this.m_myCus.getAddress().getCity());
		ps.println(this.m_myCus.getAddress().getState());
		ps.println(this.m_myCus.getAddress().getZip());
		
		// print the length of the Purchases array
		ps.println(this.m_Purchase.length);
		
		// Loop through each Purchase object in the array and print that information
		for(int i = 0; i < this.m_Purchase.length; i++)
		{
			ps.println(this.m_Purchase[i].getProduct().getDescription());
			ps.println(this.m_Purchase[i].getProduct().getPrice());
			ps.println(this.m_Purchase[i].getQuantity());
		}
		
	}
	
	// Reading in the data from a formatted file and creating a new instance from it
	/**
	 * Read in the data from a file and set it to a new instance of the object
	 * @param s -- Destination where the file comes from
	 */
	public void Read(Scanner s)
	{
		this.m_myCus.setFirstName(s.nextLine());
		this.m_myCus.setLastName(s.nextLine());
		this.m_myCus.getAddress().setNumber(s.nextLine());
		this.m_myCus.getAddress().setStreet(s.nextLine());
		this.m_myCus.getAddress().setCity(s.nextLine());
		this.m_myCus.getAddress().setState(s.nextLine());
		this.m_myCus.getAddress().setZip(s.nextLine());
		
		// Get purchase count to know how large how to make the array
		int purchaseCount = s.nextInt();
		
		// Burn the end of the line after getting the next int
		s.nextLine();
		
		// Allocate a new array for the local instance 
		this.m_Purchase = new Purchase[purchaseCount];
				
		// While there's another line in the file, assign each line to the the respective member variables of that index
		while(s.hasNextLine())
		{
			for(int i = 0; i < m_Purchase.length; i++)
			{
				this.m_Purchase[i] = new Purchase();
				this.m_Purchase[i].getProduct().setDescription(s.nextLine());
				this.m_Purchase[i].getProduct().setPrice(s.nextDouble());
				this.m_Purchase[i].setQuantity(s.nextInt());
				s.nextLine(); // Burning \n char
			}
		}
	}
	
	
	// WriteJSON() method
	/**
	 * Output the given instance of the object to a PrintStream in JSON format
	 * @param ps -- Output destination
	 */
	public void WriteJSON(PrintStream ps)
	{
		// GSON stuff
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		// Passing the current instance of the object and outputting it to the current instance of the PrintStream
		String jsonString = gson.toJson(this);
		ps.println(jsonString);
	}
	
	
	// Read a JSON formatted file and assign it to a new object
	/**
	 * Read in a JSON-formatted file and created a new object from it
	 * @param fr -- FileReader for the JSON-formatted file
	 */
	public void ReadJSON(FileReader fr)
	{
		// That GSON stuff
		Gson gson = new Gson();
		PurchaseCollection newColl = gson.fromJson(fr, PurchaseCollection.class);

		// Getting all the non-array data and assigning it to the member variables
		this.m_myCus.setFirstName(newColl.getCustomer().getFirstName());
		this.m_myCus.setLastName(newColl.getCustomer().getLastName());
		this.m_myCus.getAddress().setNumber(newColl.getCustomer().getAddress().getNumber());
		this.m_myCus.getAddress().setStreet(newColl.getCustomer().getAddress().getStreet());
		this.m_myCus.getAddress().setCity(newColl.getCustomer().getAddress().getCity());
		this.m_myCus.getAddress().setState(newColl.getCustomer().getAddress().getState());
		this.m_myCus.getAddress().setZip(newColl.getCustomer().getAddress().getZip());
		
		// Initializing a new Purchase array with the new length
		this.m_Purchase = new Purchase[newColl.m_Purchase.length];
		
		// Looping through the Purchase[] array and creating a new Purchase for each one
		for(int i = 0; i < m_Purchase.length; i++)
		{
			this.m_Purchase[i] = new Purchase();
			this.m_Purchase[i].getProduct().setDescription(newColl.m_Purchase[i].getProduct().getDescription());
			this.m_Purchase[i].getProduct().setPrice(newColl.m_Purchase[i].getProduct().getPrice());
			this.m_Purchase[i].setQuantity(newColl.m_Purchase[i].getQuantity());
		}
	}
	
	
	@Override
	public
	String toString()
	/**
	 * Overrides the default toString() method and outputs the instance in a new format
	 */
	{
		// String placeholder for when the purchase array needs to be looped through
		String x = "";
		
		// **********************************************************
		//
		// Loops through the purchases in the array,
		// concatenates each one so that each index in the array.
		// Creates one long string with \n characters at the end
		// 
		// **********************************************************
		for(int i = 0; i < this.m_Purchase.length; i++)
		{
			x += this.m_Purchase[i].getQuantity() + ", " + this.m_Purchase[i].getProduct().getDescription() + ", " + 
					this.m_Purchase[i].getProduct().getPrice() + "\n";
		};
		
		// Return all method variables as a formatted string
		return this.m_myCus.toString() + "\n" + x;
	}
}
