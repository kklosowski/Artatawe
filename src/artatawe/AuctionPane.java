package artatawe;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
//TODO: add javadocs
public class AuctionPane extends Pane {

    @FXML
    private Text title;
    @FXML
    private Text description;
    @FXML
    private Text currentPrice;
    @FXML
    private Text bidsLeft;
    @FXML
    private ImageView thumbnail;

    public void setAttributes(String title, String description, Double currentPrice, Integer bidsLeft, String thumbnailPath) throws IllegalArgumentException {
        if (this.title == null || this.description == null || this.currentPrice == null || this.bidsLeft == null || this.thumbnail == null) {
            throw new IllegalArgumentException("The auction pane does not contain all required elements to display auction");
        }
        this.title.setText(title);
        this.description.setText(description);
        this.currentPrice.setText(currentPrice.toString());
        this.bidsLeft.setText(bidsLeft.toString());
        this.thumbnail.setImage(new Image("/" + thumbnailPath));
    }
}
