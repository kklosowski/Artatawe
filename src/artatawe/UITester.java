package artatawe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class UITester extends Application {
    private final double WINDOW_WIDTH = 800;
    private final double WINDOW_HEIGHT = 650;
    private final boolean MAXIMISED = false;
    private final boolean FULLSCREEN = false;
    private final boolean RESIZABLE = false;

    @Override
    public void start(Stage primaryStage) {
        /*
        try {
            // Load the main scene.
            Parent layoutFXML = FXMLLoader.load(getClass().getResource("/views/_layout.fxml"));
            Parent auctionFXML = FXMLLoader.load(getClass().getResource("/views/auction.fxml"));
            controllers.LayoutDisplayController dc;
            try{
                dc = new controllers.LayoutDisplayController((Pane) layoutFXML, (Pane) auctionFXML);
                Scene s = dc.getView();
                primaryStage.setWidth(WINDOW_WIDTH);
                primaryStage.setHeight(WINDOW_HEIGHT);
                primaryStage.setMaximized(MAXIMISED);
                primaryStage.setFullScreen(FULLSCREEN);
                primaryStage.setScene(s);
                primaryStage.setTitle("DEMO");
                primaryStage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        */

        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setMaximized(MAXIMISED);
        primaryStage.setFullScreen(FULLSCREEN);
        primaryStage.setResizable(RESIZABLE);
        primaryStage.setTitle("DEMO");

        Parent layoutFXML = null;
        Parent browsingAuctionsFXML = null;
        try {
            layoutFXML = FXMLLoader.load(getClass().getResource("/views/_layout.fxml"));
            browsingAuctionsFXML = FXMLLoader.load(getClass().getResource("/views/browse_auctions.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}
