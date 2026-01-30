package application;
	
/*
 * Author: Bryan Coss Y Leon Orteg
 * Date: 01/05/2025
 * 
 * Create a user interface that has a top bar that includes a menu. The menu should have four items.
 * When the user selects the first menu option, then the date and time should be printed in a text box.
 * When the user selects the second menu option, then the text box contents should be written to a text file named "log.txt."
 * When the user selects the third menu item then the frame background color changes to random color hue of the color green. 
 * 		The menu option should display the initial random hue each time selected for a single execution of the program. 
 * 		See https://www.w3schools.com/colors/colors_picker.aspLinks to an external site.
 * When the user selects the fourth menu option then the program exits.
 * 
 * */

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;





public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			
			BorderPane bPane = new BorderPane();	// Positions components within scene
			GridPane gPane = new GridPane();		//
			Menu menu = new Menu("_Menu button");	// Creates a menu
			MenuBar menuBar = new MenuBar();
			/*
			 * Create the menu items needed
			 * */
			MenuItem m1 = new MenuItem("Date and Time");
			MenuItem m2 = new MenuItem("TextBox to file");
			MenuItem m3 = new MenuItem("Random Green");
			MenuItem m4 = new MenuItem("Exit");
			
			/*
			 * Add menu items to the program
			 * */
			menu.getItems().add(m1);
			menu.getItems().add(m2);
			menu.getItems().add(m3);
			menu.getItems().add(new SeparatorMenuItem());
			menu.getItems().add(m4);
			
			/*
			 * THis shows there is text in the box, and does not only return and empty shell
			 * */
			Text label = new Text(" Welcome to my project!");
			gPane.add(label, 0, 0);
			
			/*
			 * This adds the menus to the pane. 
			 * */
			menuBar.getMenus().add(menu);
			bPane.setTop(menuBar);
			Scene scene = new Scene(bPane, 400, 400);
			
			/*
			 * This will describe the actions for each menu that was touched. 
			 * I am using a lamda as it is simpler, each should have their own menu and will continue until close is hit
			 * 
			 * */
			m1.setOnAction(e -> dateAndTime(label));
			m2.setOnAction(e -> TextBoxToFile(gPane));
			m3.setOnAction(e -> randomGreen(bPane));
			m4.setOnAction(e -> Platform.exit());
			
			/*
			 * This will add gridpane to the borderpane and the scene to the stage
			 * I have set title and for the stage to show
			 * */
			bPane.setCenter(gPane);
			stage.setScene(scene);
			stage.setTitle("Bryan's Project");
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This function will be used when m2 is clicked. A text box will appear and then there we will can start
	 * the text box will then be saved to a text file, log.txt, and each new time it is entered, the file will update with the new information
	 * */
	
	private Object TextBoxToFile(GridPane gPane) {
		TextField text = new TextField();
		text.setPrefSize(500, 100);
	    javafx.scene.control.Button button = new javafx.scene.control.Button("Save to file");
		gPane.add(text,0,0);
		gPane.add(button,0,1);
		
		
		button.setOnAction(e -> {
			
			String userInput = text.getText();
			try (FileWriter writer = new FileWriter("log.txt")) {
				//FileWriter writer = new FileWriter("log.txt");
				writer.write(userInput);
				text.clear();
				System.out.println("Text saved to file: " + userInput);
			} catch (java.io.IOException ex) {
				ex.printStackTrace();
			}
		});
		
		return null;
	}
	
	/*
	 * The method will change the background to a new color of green. 
	 * I have mild color vision deficiency so i believe every instance is a type of green
	 * */
	private Object randomGreen(BorderPane bPane) {
		
		Random ran = new Random();
		Color color = null;
		double red = ran.nextDouble()  ;
		double blue = ran.nextDouble()  ;
		color = new Color(red, 1.0, blue, 1.0);
		//System.out.println("Red: " + red + "\nBlue: " + blue);
		bPane.setBackground(new Background(new BackgroundFill(color, null, null)));
		
		return null;
	}

	/*
	 * This method will return the current date and time in MM/dd/yyyy HH:mm:ss format
	 * */
	private EventHandler<ActionEvent> dateAndTime(Text label) {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		 LocalDateTime now = LocalDateTime.now();
		 label.setText("Current date and time: " + dtf.format(now));
		return null;
	}

	/*
	 * Starts program.
	 * */
	public static void main(String[] args) {
		launch(args);
	}
}
