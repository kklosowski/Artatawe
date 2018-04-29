package artatawe;

import controllers.ViewLoader;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Loads default login view.
 *
 * @author Marceli Wac
 * @version 1.0
 * @since 10-12-17
 */
public class MainHandler extends Application {
    private final double WINDOW_WIDTH = 800;
    private final double WINDOW_HEIGHT = 650;
    private final boolean MAXIMISED = false;
    private final boolean FULLSCREEN = false;
    private final boolean RESIZABLE = false;


    /**
     * Launches the main application
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setMaximized(MAXIMISED);
        primaryStage.setFullScreen(FULLSCREEN);
        primaryStage.setResizable(RESIZABLE);
        primaryStage.setTitle("Artatawe bidding system");

        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.LOGIN_URL);
        primaryStage.setScene(l.getView());
        primaryStage.show();

    }


}
