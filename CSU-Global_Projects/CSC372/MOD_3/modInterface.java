package CSC372.MOD_3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;


public class modInterface extends Application{
    @Override

    public void modInterface(Stage applicationStage){
        setTitle("Menu screen");
        setSize(600,400);
		setLayout(new GridBagLayout());

        setVisible(true);
    }
    

}
