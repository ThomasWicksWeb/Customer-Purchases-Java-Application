package wicks.bcs345.hwk.purchases.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import wicks.bcs345.hwk.purchases.business.Address;
import wicks.bcs345.hwk.purchases.business.PurchaseCollection;

/**
 * Controller class wired up for the PurchasesGraphicalUI class
 * @author Thomas Wicks
 * @since 11/26/2019
 * @version 1.0
 */
public class PurchasesController 
{

    // PurchaseCollection member variable instance
    private PurchaseCollection PC;
    
    
    @FXML
    private AnchorPane anchorPane;
    
    // **********************
    // Tab Pane controls 
    // **********************

    // TabPane parent
    @FXML
    private TabPane tabPane;

    // Customer tab
    @FXML
    private Tab tabCustomer;

    // Purchases tab
    @FXML
    private Tab tabPurchases;


    // ******************************************************
    // FXML fields related to Customer tab from customer.fxml
    // ******************************************************
    
    // First name TextField
    @FXML
    private TextField firstNameField;

    
    // Last name TextField
    @FXML
    private TextField lastNameField;

    // Street number TextField
    @FXML
    private TextField numberField;

    // Street name TextField
    @FXML
    private TextField streetField;

    // City name TextField
    @FXML
    private TextField cityField;

    // State name TextField
    @FXML
    private TextField stateField;

    // Zip code TextField
    @FXML
    private TextField zipField;


    // ListView String collection
    @FXML
    private ListView < String > listViewItems;


    // **************************
    // Variables for top menu bar
    // **************************
    
    // "Open..." button to open file
    @FXML
    private MenuItem menuOpen;
    
    // "Open JSON..." button
    @FXML
    private MenuItem menuOpenJSON;

    // "Save as..." button to save file
    @FXML
    private MenuItem menuSaveAs;

    // "Save JSON as..." button to save file
    @FXML
    private MenuItem menuSaveAsJSON;
    
    // "Save report" button to save the file as a report
    @FXML
    private MenuItem menuSaveReport;

    // "Exit" button to terminate the program
    @FXML
    private MenuItem menuExit;

    
    // *************************
    // Methods to handle actions
    // *************************
    
    /**
     * Event handling for the "Open..." menu button.
     * Prompts the user with a FileChooser (Windows Explorer menu) to
     * select the file to import.
     * @param event
     */
    @FXML
    private void handleMenuOpen(ActionEvent event) 
    {
        try 
        {

            // ****************************************************
            // Create a new FileChooser which prompts the user with 
            // a Windows Explorer window in order to select a file.
            // The selected file is then read in via a Scanner
            // ****************************************************
        	
            FileChooser fileChooser = new FileChooser(); // Creating new FileChooser
            fileChooser.setTitle("Open Purchase Collection file"); // Setting title for the window
            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString(); // Opening the prompt to the current directory
            fileChooser.setInitialDirectory(new File(currentPath));
            File selectedFile = fileChooser.showOpenDialog(null);
            Scanner s = new Scanner(new FileReader(selectedFile));


            // Populating the Customer tab
            // ********************************************************
            // Creating a new PurchaseCollection object, and reading in
            // the data from the file and assigning the Customer values
            // to their respective TextFields
            // ********************************************************
            this.PC = new PurchaseCollection();
            this.PC.Read(s);
            this.firstNameField.setText(this.PC.getCustomer().getFirstName());
            this.lastNameField.setText(this.PC.getCustomer().getLastName());
            this.numberField.setText(this.PC.getCustomer().getAddress().getNumber());
            this.streetField.setText(this.PC.getCustomer().getAddress().getStreet());
            this.cityField.setText(this.PC.getCustomer().getAddress().getCity());
            this.stateField.setText(this.PC.getCustomer().getAddress().getState());
            this.zipField.setText(this.PC.getCustomer().getAddress().getZip());


            // Clearing the current ListView so there is no duplicate data if the user imports more than 1 file in a row
            listViewItems.getItems().clear();

            // Populating the ListView component with Purchases
            for (int i = 0; i < this.PC.getPurchases().length; i++) 
            {
                listViewItems.getItems().add(this.PC.GetByIndex(i).toString());
            }

        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (Exception e) 
        {
            System.out.println("Error reading data from the 'Open...' menu button");
        }
    }
    
    /**
     * Handler for opening a JSON file from the FileChooser
     * @param event
     */
    @FXML
    private void handleMenuOpenJSON(ActionEvent event) 
    {
        try 
        {

            // ****************************************************
            // Create a new FileChooser which prompts the user with 
            // a Windows Explorer window in order to select a file.
            // The selected file is then read in via a Scanner
            // ****************************************************
        	
            FileChooser fileChooser = new FileChooser(); // Creating new FileChooser
            fileChooser.setTitle("Open Purchase Collection file"); // Setting title for the window
            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString(); // Opening the prompt to the current directory
            fileChooser.setInitialDirectory(new File(currentPath));
            File selectedFile = fileChooser.showOpenDialog(null);
            FileReader fr = new FileReader(selectedFile);


            // Populating the Customer tab
            // ********************************************************
            // Creating a new PurchaseCollection object, and reading in
            // the data from the file and assigning the Customer values
            // to their respective TextFields
            // ********************************************************
            this.PC = new PurchaseCollection();
            this.PC.ReadJSON(fr);
            this.firstNameField.setText(this.PC.getCustomer().getFirstName());
            this.lastNameField.setText(this.PC.getCustomer().getLastName());
            this.numberField.setText(this.PC.getCustomer().getAddress().getNumber());
            this.streetField.setText(this.PC.getCustomer().getAddress().getStreet());
            this.cityField.setText(this.PC.getCustomer().getAddress().getCity());
            this.stateField.setText(this.PC.getCustomer().getAddress().getState());
            this.zipField.setText(this.PC.getCustomer().getAddress().getZip());


            // Clearing the current ListView so there is no duplicate data if the user imports more than 1 file in a row
            listViewItems.getItems().clear();

            // Populating the ListView component with Purchases
            for (int i = 0; i < this.PC.getPurchases().length; i++) 
            {
                listViewItems.getItems().add(this.PC.GetByIndex(i).toString());
            }

        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (Exception e) 
        {
            System.out.println("Error reading data from the 'Open...' menu button");
        }
    }

    /**
     * Event handling for the "Save as..." menu button.
     * Prompts the user with a FileChooser (Windows Explorer menu) to
     * select where they will save the file.
     * @param event
     */
    @FXML
    private void handleMenuSaveAs(ActionEvent event) 
    {
        // Getting the values from the text fields, and re-assigning it to member variables of the local PurchaseCollection instance
        this.PC.getCustomer().setFirstName(this.firstNameField.getText()); // Setting first name
        this.PC.getCustomer().setLastName(this.lastNameField.getText()); // Setting last name
        this.PC.getCustomer().setAddress(new Address(
            this.numberField.getText(), // Setting Address number
            this.streetField.getText(), // Setting Address street
            this.cityField.getText(), // Setting Address city
            this.stateField.getText(), // Setting Address state
            this.zipField.getText() // Setting Address ZIP
        ));
        
        try 
        {
        	// Initialize a new FileChooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Purchase Collection file as...");
            
            // Opening the prompt to the current directory
            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
            fileChooser.setInitialDirectory(new File(currentPath));
            
            // Opens the Windows Explorer window
            File selectedFile = fileChooser.showSaveDialog(null);
            // Setting up a PrintStream for output
            PrintStream ps = new PrintStream(selectedFile);
            // Writing the user data to the file
            PC.Write(ps);
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (Exception e)
        {
        	System.out.println("Error saving file... Please try again");
        }

    }
    
    /**
     * Function to handle saving the data in JSON format
     * @param event
     */
    @FXML
    private void handleMenuSaveAsJSON(ActionEvent event) 
    {
        // Getting the values from the text fields, and re-assigning it to member variables of the local PurchaseCollection instance
        this.PC.getCustomer().setFirstName(this.firstNameField.getText()); // Setting first name
        this.PC.getCustomer().setLastName(this.lastNameField.getText()); // Setting last name
        this.PC.getCustomer().setAddress(new Address(
            this.numberField.getText(), // Setting Address number
            this.streetField.getText(), // Setting Address street
            this.cityField.getText(), // Setting Address city
            this.stateField.getText(), // Setting Address state
            this.zipField.getText() // Setting Address ZIP
        ));
        
        try 
        {
        	// Initialize a new FileChooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Purchase Collection file as...");
            
            // Opening the prompt to the current directory
            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
            fileChooser.setInitialDirectory(new File(currentPath));
            
            // Opens the Windows Explorer window
            File selectedFile = fileChooser.showSaveDialog(null);
            // Setting up a PrintStream for output
            PrintStream ps = new PrintStream(selectedFile);
            // Writing the user data to the file
            PC.WriteJSON(ps);
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (Exception e)
        {
        	System.out.println("Error saving file... Please try again");
        }

    }

    /**
     * Event handling for the "Save report" menu button.
     * Prompts the user where they want to save the file
     * which will be formatted as a proper report.
     * @param event
     */
    @FXML
    private void handleMenuSaveReport(ActionEvent event)
    {
        try
        {
        	// Initialize an instance of a FileChooser for user output
            FileChooser fileChooser = new FileChooser();
            // Setting windows name when fileChooser is open
            fileChooser.setTitle("Save Purchase Collection report as...");
            // Prompts user where they want to save the file
            File selectedFile = fileChooser.showSaveDialog(null);
            // Create a PrintStream for file output
            PrintStream ps = new PrintStream(selectedFile);
            // Output the report to the PrintStream
            PC.Report(ps);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Event handling for the "Exit" menu button.
     * Closes program.
     * @param event
     */
    @FXML
    private void handleMenuExit(ActionEvent event)
    {
        System.exit(0);
    }
}