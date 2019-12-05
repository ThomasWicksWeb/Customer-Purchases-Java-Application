/**
 * Contains the Customer class within the Business package
 */
package wicks.bcs345.hwk.purchases.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Contains the Customer class
 * 
 * @author Thomas Wicks
 * @version 1.0.0
 * @since 10/12/2019
 */
public class Customer {
	
	private String firstName;
	private String lastName;
	private Address myAdr;
	
	// Default constructor
	/**
	 * Default constructor for the Customer
	 */
	public Customer()
	{
		this.firstName = "noFirstNameSet";
		this.lastName = "noLastNameSet";
		this.myAdr = new Address("50", "Smith Lane", "Smithtown", "NY", "11784");
	}
	
	// Constructor
	/**
	 * Constructor for Customer
	 * @param fn -- First name
	 * @param ln -- Last name
	 * @param ad -- Address object
	 */
	public Customer(String fn, String ln, Address ad)
	{
		this.firstName = fn;
		this.lastName = ln;
		this.myAdr = ad;
	}
	
	// Setters
	// Set first name
	/**
	 * Set the first name for the current instance
	 * @param fn -- New first name
	 */
	public void setFirstName(String fn)
	{
		this.firstName = fn;
	}
	
	// Set last name
	/**
	 * Set the last name for the current instance
	 * @param ln -- New last name
	 */
	public void setLastName(String ln)
	{
		this.lastName = ln;
	}
	
	// Set Address
	/**
	 * Set the Address for the current instance
	 * @param ad -- New Address object
	 */
	public void setAddress(Address ad)
	{
		this.myAdr = ad;
	}
	
	// Get first name
	/**
	 * Get the first name for the current instance
	 * @return -- First name
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/**
	 * Get the last name for the current instance
	 * @return -- Last name
	 */
	public String getLastName()
	{
		return this.lastName;
	}
	
	/**
	 * Returns the current instance of the Address obj
	 * @return -- Address obj
	 */
	public Address getAddress()
	{
		return this.myAdr;	
	}
	
	// Write method
	/**
	 * Write out all member variables to the given instance of PrintStream
	 * @param ps -- PrintStream
	 */
	public void Write(PrintStream ps)
	{
		ps.println(this.firstName);
		ps.println(this.lastName);
		ps.println(this.myAdr.getStreet());
		ps.println(this.myAdr.getNumber());
		ps.println(this.myAdr.getCity());
		ps.println(this.myAdr.getState());
		ps.println(this.myAdr.getZip());
	}
	
	// Read data from the given instance of Scanner
	/**
	 * Read a given file and assign the data in that file to a new instance of the Customer class
	 * @param s -- Scanner
	 */
	public void Read(Scanner s)
	{
		this.firstName = s.nextLine();
		this.lastName = s.nextLine();
		String x = s.nextLine();
		this.myAdr.setNumber(x);
		x = s.nextLine();
		this.myAdr.setStreet(x);
		x = s.nextLine();
		this.myAdr.setCity(x);
		x = s.nextLine();
		this.myAdr.setState(x);
		x = s.nextLine();
		this.myAdr.setZip(x);
	}
	
	// Write the member variables of the given instance to PrintStream ps
	/**
	 * Write the member variables of the given instance to a file in JSON format
	 * @param ps -- PrintStream to output to
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
	 * Read in a JSON-formatted file and assign the data in the file to the given instanec of the Customer object
	 * @param fr -- FileReader
	 */
	public void ReadJSON(FileReader fr)
	{	
		Gson gson = new Gson();
		Customer newCust = gson.fromJson(fr, Customer.class);
		
		this.firstName = newCust.getFirstName();
		this.lastName = newCust.getLastName();
		this.myAdr = newCust.getAddress();
		
		newCust = new Customer(firstName, lastName, myAdr);
	}
	
	// toString override
	@Override
	public
	String toString()
	/**
	 * Overrides the default toString() method from the Object object and replaces it with this custom chaos
	 */
	{
		return this.firstName + " " + this.lastName + "\n" + 
				this.myAdr.getNumber() + " " + this.myAdr.getStreet() + "\n" + 
				this.myAdr.getCity() + ", " + this.myAdr.getState() + " " + this.myAdr.getZip();
	}
	
	
}
