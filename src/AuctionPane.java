import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class AuctionPane extends Pane {
    @FXML
    private Text name;
    @FXML
    private Text currentPrice;
    @FXML
    private Text bidsLeft;
    @FXML
    private Image thumbnail;

    public AuctionPane(String name, Double currentPrice, Integer bidsLeft, String thumbnailPath){
        this.name.setText(name);
        this.currentPrice.setText(currentPrice.toString());
        this.bidsLeft.setText(bidsLeft.toString());
        this.thumbnail = new Image(thumbnailPath);
    }
}
