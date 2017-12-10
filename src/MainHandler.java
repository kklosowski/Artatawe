import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;

public class MainHandler extends Application{
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
        HashMap<String, Object> sessionData = new HashMap<String, Object>();

        AuctionController a = new AuctionController();
        primaryStage.setScene(a.getView());

        primaryStage.show();

    }




}
