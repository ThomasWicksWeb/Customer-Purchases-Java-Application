/**
 * Combines with Product class with a quantity member variable
 */
package wicks.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Contains the Purchase class
 * 
 * @author TJ
 * @version 1.0.0
 * @since 10/12/2019
 */
public class Purchase {

	// Declare member variables
	private Product myProd;
	private int quantity;
		
	// default constructor
	/**
	 * Default constructor for a Purchase
	 */
	public Purchase()
	{
		this.myProd = new Product();
		this.quantity = 0;
	}
	
	// Constructor
	/**
	 * Constructor for the Purchase class
	 * @param p -- Product Obj
	 * @param q -- Quantity
	 */
	public Purchase(Product p, int q)
	{
		this.myProd = p;
		this.quantity = q;
	}
	
	// Setters
	// Set new instance of Product class
	/**
	 * Takes in a Product object and assigns it to the current instance
	 * @param p -- Product obj
	 */
	public void setProduct(Product p)
	{
		this.myProd = p;
	}
	
	// Set new quantity
	/**
	 * Takes in a quantity and assigns it to the current instance
	 * @param q -- Quantity
	 */
	public void setQuantity(int q)
	{
		this.quantity = q;
	}
	
	// Getters
	// Get Product
	/**
	 * Returns the Product object for the current instance
	 * @return -- Current Product instance
	 */
	public Product getProduct()
	{
		return this.myProd;
	}
	
	// Get quantity
	/**
	 * Returns the quantity for the current instance
	 * @return -- The current instance of quantity
	 */
	public int getQuantity()
	{
		return this.quantity;
	}
	
	// Write method -- prints member variables to the given instance of PrintStream
	/**
	 * Prints all member variables of the current instance of the class to the instance of PrintStream
	 * @param ps -- Instance of PrintStream
	 */
	public void Write(PrintStream ps)
	{
		ps.println(this.myProd.getDescription());
		ps.println(this.myProd.getPrice());
		ps.println(this.quantity);
	}
	
	// Read data from the given instance of Scanner
	/**
	 * Takes in an instance of Scanner and creates a new instance of Purchase
	 * @param s -- Instance of Scanner
	 */
	public void Read(Scanner s)
	{
		String x = s.nextLine();
		this.myProd.setDescription(x);
		double y = s.nextDouble();
		this.myProd.setPrice(y);
		int z = s.nextInt();
		this.quantity = z;
	}
	
	// Write the member variables of the given instance to PrintStream ps
	/**
	 * Outputs the current instance of Purchase in JSON format to the given PrintStream
	 * @param ps -- Given instance of PrintStream
	 */
	public void WriteJSON(PrintStream ps)
	{
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		String jsonString = gson.toJson(this);
		ps.println(jsonString);
	}
		
	// Read a JSON-formatted file 
	/**
	 * Reads a JSON-formatted file and creates a new instance of Purchase
	 * @param fr -- Instance of FileReader to read in a JSON-formatted file
	 */
	public void ReadJSON(FileReader fr)
	{	
		Gson gson = new Gson();
		Purchase newPur = gson.fromJson(fr, Purchase.class);
		
		this.quantity = newPur.getQuantity();
		this.myProd = newPur.getProduct();
		
		newPur = new Purchase(myProd, quantity);
	}
	
	// toString override
	@Override
	public
	String toString()
	/**
	 * Overrides the default toString() method from the Object object and replaces it with this custom chaos
	 */
	{
		return this.quantity + ", " + this.myProd.getDescription() + ", " +
				this.myProd.getPrice();
	}
	
}
