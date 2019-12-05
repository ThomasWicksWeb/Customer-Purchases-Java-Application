// PRODUCT
/**
 * Contains an Address class and Product class for use in the Presentation Package
 */
package wicks.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 
 * Containers the Product class
 * 
 * @author Thomas Wicks
 * @version 1.0.0
 * @since 9/21/2019
 * 
 *
 */
public class Product
{
	
	// Declaring initial variables
	private String description;
	private double price;
	
	// Default constructor
	/**
	 * Default constructor
	 */
	public Product()
	{
		this.description = "noDescSet";
		this.price = 0;
	}
	
	// Normal constructor
	/**
	 * This method is the constructor for the Product
	 * @param conDesc will be set as the new description
	 * @param conPrice will be set as the new price
	 */
	public Product(String conDesc, double conPrice)
	{
		this.description = conDesc;
		this.price = conPrice;
	}
	
	// SETTERS
	// Set description
	/**
	 * This method takes in a new String for the description and sets it for that instance of the object
	 * @param newDesc will be set as the new description
	 */
	public void setDescription(String newDesc) { this.description = newDesc; }
	
	// Set price
	/**
	 * This method takes in a double for the price and sets it for that instance of the object
	 * @param newPrice -- new price
	 */
	public void setPrice(double newPrice) { this.price = newPrice; }
	
	// GETTERS
	// Get/return description
	/**
	 * Return the description String for the given object
	 * @return The description for the given object
	 */
	public String getDescription() { return this.description; }
	
	// Get/return price
	/**
	 * Returns the current price for the given object
	 * @return The current price for the given object
	 */
	public double getPrice() { return this.price; }
	
	
	
	// Method to print ONLY values (no descriptive text) && assumes PrintStream is already open
	/**
	 * Writes both variables for the given object to the console
	 * @param ps Given PrintStream 
	 */
	public void Write(PrintStream ps)
	{
		ps.println(this.description);
		ps.println(this.price);
	}
	
	// Method which takes in Scanner s, and reads data from a pre-formatted file
	/**
	 * Takes in a Scanner variable and reads the data from it
	 * @param s Given Scanner
	 */
	public void Read(Scanner s)
	{
		this.description = s.nextLine();
		this.price = s.nextDouble();
	}
	
	
	// Method to print an object into JSON format in a file
	/**
	 * Prints the given object to a file in JSON format
	 * @param ps Given PrintStream to output to
	 */
	public void WriteJSON(PrintStream ps)
	{
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		String jsonString = gson.toJson(this);
		ps.println(jsonString);
	}
	
	
	// Read the contents of all member variables from the given instance of Scanner as JSON
	// Assume Scanner is already open && member variables are stored in JSON format
	/**
	 * Takes in a Scanner object with a filename in it (in main), 
	 * creates an empty String named jsonString and converts each key/value pair in the JSON file into local 
	 * member variables.
	 * @param fr Given Scanner for the file
	 */
	public void ReadJSON(FileReader fr)
	{	
		
		Gson gson = new Gson();
		Product prod3 = gson.fromJson(fr, Product.class);
		
		this.description = prod3.getDescription();
		this.price = prod3.getPrice();
		
		prod3 = new Product(description, price);

		System.out.println(prod3.getDescription());
		System.out.println(this);
	}
		
	
	
	@Override
	public
	String toString()
	/**
	 * Overrides the default toString() method from the Object object
	 */
	{
		return this.description + ", " + String.format("$%.2f", this.price);
	}
	
	
}