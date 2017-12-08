import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class UITester extends Application {
    private final double WINDOW_WIDTH = 800;
    private final double WINDOW_HEIGHT = 650;
    private final boolean MAXIMISED = false;
    private final boolean FULLSCREEN = false;

    @Override
    public void start(Stage primaryStage) {
        /*
        try {
            // Load the main scene.
            Parent layoutFXML = FXMLLoader.load(getClass().getResource("/views/_layout.fxml"));
            Parent auctionFXML = FXMLLoader.load(getClass().getResource("/views/auction.fxml"));
            LayoutDisplayController dc;
            try{
                dc = new LayoutDisplayController((Pane) layoutFXML, (Pane) auctionFXML);
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
        primaryStage.setTitle("DEMO");

        Parent layoutFXML = null;
        Parent browsingAuctionsFXML = null;
        try {
            layoutFXML = FXMLLoader.load(getClass().getResource("/views/_layout.fxml"));
            browsingAuctionsFXML = FXMLLoader.load(getClass().getResource("/views/browsing_auctions.fxml"));
        }catch(Exception e) {
            e.printStackTrace();
        }

        BrowseAuctionsController browseAuctionsController = new BrowseAuctionsController((Pane) layoutFXML, (Pane) browsingAuctionsFXML);
        Scene s = browseAuctionsController.getAllAuctions();
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}
