package wicks.bcs345.hwk.purchases.presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Contains the Purchases Application class for the GUI application component of the program.
 * @author Thomas Wicks
 * @since 11/29/2019
 * @version 1.0
 */
public class PurchasesApplication extends Application 
{
	/**
	 * Starts up the GUI application itself
	 */
    @Override
    public void start(Stage primaryStage) 
    {
        Parent root = null;
        Scene scene = null;
        try 
        {
        	// Pulls FXML from main.fxml to display the application
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            root = loader.load();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        // Put the root containing the FXML into the scene
        scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Purchase Collection Application");
        primaryStage.show();
        
        
    }
}