import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SalaryLabelGuiFx extends Application {
   @Override
   public void start(Stage applicationStage) {
      int hourlyWage;
      int yearlySalary;
      Scene scene = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene
      Label wageLabel = null;     // Label for hourly salary
      Label salaryLabel = null;   // Label for yearly salary
      TextField salField = null;  // Displays yearly salary
      TextField wageField = null; // Displays hourly wage
      Insets gridPadding = null;

      gridPane = new GridPane();   // Create an empty pane
      scene = new Scene(gridPane); // Create scene containing the grid pane
      
      // Calculate yearly salary
      hourlyWage = 20;
      yearlySalary = hourlyWage * 40 * 50;

      // Set hourly and yearly salary
      wageLabel = new Label("Hourly wage:");
      salaryLabel = new Label("Yearly salary:");

      // Create wage and salary text fields
      wageField = new TextField();
      wageField.setPrefColumnCount(15);
      wageField.setEditable(false);
      wageField.setText(Integer.toString(hourlyWage));

      salField = new TextField();
      salField.setPrefColumnCount(15);
      salField.setEditable(false);
      salField.setText(Integer.toString(yearlySalary));

      gridPane.add(wageLabel, 0, 0);   // Add wage label to location (0, 0)
      gridPane.add(wageField, 1, 0);   // Add wage text field to location (1, 0)
      gridPane.add(salaryLabel, 0, 1); // Add salary label to location (0, 1)
      gridPane.add(salField, 1, 1);    // Add salary text field to location (1, 1)
      
      gridPadding = new Insets(10, 10, 10, 10); // Padding values for top, right, bottom, and left
      gridPane.setPadding(gridPadding);         // Set padding around  grid
      gridPane.setHgap(10);                     // Spacing between columns
      gridPane.setVgap(10);                     // Spacing between rows

      applicationStage.setScene(scene);    // Set window's scene  
      applicationStage.setTitle("Salary"); // Set window's title
      applicationStage.show();             // Display window
   }

   public static void main(String [] args) {
      launch(args); // Launch application
   }
}