/**
 * MainForDrawing.java
 * @version 1.0
 * @author Tereza
 */

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainForDrawing extends Application {

	/**
	 * Loads the scene from the fxml file.
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader l = new FXMLLoader();
		Pane p = l.load(getClass().getResourceAsStream(File.separator + "views/canvas.fxml"));
		arg0.setScene(new Scene(p));
		arg0.show();
	}

	/**
	 * Launches the scene.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
