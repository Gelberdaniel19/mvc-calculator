package land.spooky.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Daniel Gelber
 * @version 1.0
 * Created       - July 12, 2018
 * Last Modified - July 12, 2018
 * 
 * The main class for the Calculator app.
 */
public class App extends Application {

    /**
     * Loads the interface from fxml and sets it as the scene
     *
     * @param primaryStage The window with the scene
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

	Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

	primaryStage.setScene(new Scene(root));
	primaryStage.show();

    }

    /**
     * Exits gracefully
     */
    @Override
    public void stop() {

	System.exit(0);

    }

    /**
     * Launches the application when the program is run
     *
     * @param args starting arguments (ignored)
     */
    public static void main(String[] args) {

	launch(args);
	
    }
    
}
