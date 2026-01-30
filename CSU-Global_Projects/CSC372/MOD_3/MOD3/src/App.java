import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class App extends Application{
    @Override
    public void start(Stage applicationStage){
        int hourlyWage;
        int yrSalary;
        Scene scene = null;
        GridPane gridPane = null;
        Label wageLabel = null;
        Label salaryLabel = null;
        TextField salField = null;
        TextField yrField = null;
        Insets gridPadding = null;

        gridPane = new GridPane();
        scene = new Scene(gridPane);

        hourlyWage = 20;
        yrSalary = hourlyWage * 40 * 50;

        wageLabel = new Label("Hourly Wage:");
        salaryLabel = new Label(" Yearly salary:");

        yrField = new TextField();
        yrField.setPrefColumnCount(15);
        yrField.setEditable(false);
        yrField.setText(Integer.toString(hourlyWage));

        salField = new TextField();
        salField.setPrefColumnCount(15);
        salField.setEditable(false);
        salField.setText(Integer.toString(yrSalary));

        gridPane.add(wageLabel, 0, 0);
        gridPane.add(yrField, 1, 0);
        gridPane.add(salaryLabel, 0, 1);
        gridPane.add(salField, 1, 1);

        gridPadding = new Insets(10,10,10,10);
        gridPane.setPadding(gridPadding);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        applicationStage.setScene(scene);
        applicationStage.setTitle("Salary");
        applicationStage.show();



        

        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
