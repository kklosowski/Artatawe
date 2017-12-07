import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class UITester extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the main scene.
            Parent layoutFXML = FXMLLoader.load(getClass().getResource("/views/_layout.fxml"));
            Parent auctionFXML = FXMLLoader.load(getClass().getResource("/views/auction.fxml"));
            UIDisplayController dc;
            try{
                dc = new UIDisplayController((Pane) layoutFXML, (Pane) auctionFXML);
                Scene s = dc.getView();
                primaryStage.setScene(s);
                primaryStage.setTitle("DEMO");
                primaryStage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        launch(args);
    }
}
