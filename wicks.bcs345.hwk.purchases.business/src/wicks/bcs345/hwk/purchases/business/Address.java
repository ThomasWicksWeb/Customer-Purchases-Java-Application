// ADDRESS
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
 * Contains the Address class and all setters/getters, constructors, and variables for the class
 * @author TJ
 * @version 1.0.0
 * @since 9/21/2019
 */
public class Address 
{
	// Declaring initial variables
	private String number;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	// Default constructor
	/**
	 * Default constructor for the class
	 */
	public Address()
	{
		this.number = "noSetNumber";
		this.street = "noSetStreet";
		this.city = "noSetCity";
		this.state = "noSetState";
		this.zip = "noSetZip";
	}
	
	// Address class constructor
	/**
	 * Constructor for the Address class
	 * @param conStreet New street
	 * @param conNumber New number
	 * @param conCity New city
	 * @param conState New state
	 * @param conZip New ZIP
	 */
	public Address(String conNumber, String conStreet, String conCity, String conState, String conZip)
	{
		this.number = conNumber;
		this.street = conStreet;
		this.city = conCity;
		this.state = conState;
		this.zip = conZip;
	}
	
	// Setters
	// Set street
	/**
	 * This method takes in a new String for the street and sets it for that instance of the object
	 * @param newStreet New street to set
	 */
	public void setStreet(String newStreet) { this.street = newStreet; }
	
	// Set number
	/**
	 * This method takes in a new String for the number and sets it for that instance of the object
	 * @param newNumber New number to set
	 */
	public void setNumber(String newNumber) { this.number = newNumber; }
	
	// Set city
	/**
	 * This method takes in a new String for the city and sets it for that instance of the object
	 * @param newCity New city to set
	 */
	public void setCity(String newCity) { this.city = newCity; }
	
	// Set state
	/**
	 * This method takes in a new String for the state and sets it for that instance of the object
	 * @param newState New state to set
	 */
	public void setState(String newState) { this.state = newState; }
	
	// Set ZIP code
	/**
	 * This method takes in a new String for the ZIP and sets it for that instance of the object
	 * @param newZip New ZIP code to set
	 */
	public void setZip(String newZip) { this.zip = newZip; }
	
	
	// GETTERS
	// Get/return street
	/**
	 * returns the street variable for the given object
	 * @return the street variable
	 */
	public String getStreet() { return this.street; }
	
	// Get/return number
	/**
	 * returns the number variable for the given object
	 * @return the street variable 
	 */
	public String getNumber() { return this.number; }
	
	// Get/return city
	/**
	 * returns the street variable for the given object
	 * @return returns the city variable
	 */
	public String getCity() { return this.city; }
	
	// Get/return state
	/**
	 * returns the state variable for the given object
	 * @return the street variable 
	 */
	public String getState() { return this.state; }
	
	// Get/return ZIP code
	/**
	 * returns the ZIP variable for the given object
	 * @return the ZIP variable 
	 */
	public String getZip() { return this.zip; }
	
	
	// Method to print ONLY values (no descriptive text) && assumes PrintStream is already open
	/**
	 * Takes all the variables for the given object and prints them all to the given PrintStream
	 * @param ps Instance of PrintSteam
	 */
	public void Write(PrintStream ps)
	{
		ps.println(this.street);
		ps.println(this.number);
		ps.println(this.city);
		ps.println(this.state);
		ps.println(this.zip);
	}
	
	// Method to read data from all member variables in a file
	// Assume: scanner is already open && variables are on separate lines
	/**
	 * Takes in Scanner s and loops through it taking in data from a file, prints each line out to the console
	 * @param s Instance of Scanner
	 */
	public void Read(Scanner s)
	{
		this.street = s.nextLine();
		this.number = s.nextLine();
		this.city = s.nextLine();
		this.state = s.nextLine();
		this.zip = s.nextLine();
//		String[] customerInfo = new String[5];
//		for(int i = 0; i < 5; i++)
//		{
//			customerInfo[i] = s.nextLine();
//			System.out.println("Testing read() method in Address class -- " + customerInfo[i]);
//		}
	}
	
	
	
	// *******************************************
	// Method to print member variables to a given PrintStream.
	// WriteJSON() method to take in an already existing PrintStream.
	// It then sets up all the code for GSON.
	// Pushes the object it took in to the variable 'jsonString'
	// *******************************************
	/**
	 * Takes all varibles for the given instance of an object, and converts it to JSON format, and prints it out to the given PrintStream
	 * @param ps Instance of PrinstStream
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
	* @param fr Given FileReader for the file
	*/
	public void ReadJSON(FileReader fr)
	{	
		
		Gson gson = new Gson();
		Address adr3 = gson.fromJson(fr, Address.class);
		
		this.number = adr3.getNumber();
		this.street = adr3.getStreet();
		this.city = adr3.getStreet();
		this.state = adr3.getState();
		this.zip = adr3.getZip();
		
		adr3 = new Address(number, street, city, state, zip);

		System.out.println(adr3.getState());
	}
	
	@Override
	public
	String toString()
	/**
	 * Override for the toString method
	 */
	{
		return this.number + " " + this.street + ", " + this.city + ", " + this.state + " " + this.zip;
	}
	
	
}
