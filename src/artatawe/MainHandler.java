package artatawe;

import controllers.AuctionController;
import controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.SessionData;

import java.util.HashMap;

public class MainHandler extends Application {
    private final double WINDOW_WIDTH = 800;
    private final double WINDOW_HEIGHT = 650;
    private final boolean MAXIMISED = false;
    private final boolean FULLSCREEN = false;
    private final boolean RESIZABLE = false;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setMaximized(MAXIMISED);
        primaryStage.setFullScreen(FULLSCREEN);
        primaryStage.setResizable(RESIZABLE);
        primaryStage.setTitle("Artatawe bidding");
        SessionData sd = new SessionData();

        try {
            primaryStage.setScene(new Scene((Pane)FXMLLoader.load(getClass().getResource("/views/login.fxml"))));
        }catch(Exception e){
            e.printStackTrace();
        }

        primaryStage.show();

    }


}
