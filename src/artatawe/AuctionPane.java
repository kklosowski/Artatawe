package artatawe;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
*AuctionPane is class for creating the pane for auctions.
*
* @author Marceli Wac
* @version 1.0
*/
public class AuctionPane extends Pane {
    
    /**
    *Text field displaying the title of an auction.
    */
    @FXML
    private Text title;
    /**
    *Text field displaying the description of an auction.
    */
    @FXML
    private Text description;
    /**
    *Text field displaying the current price of an artwork being auctioned.
    */
    @FXML
    private Text currentPrice;
    /**
    *Text field displaying the bids left on an auction.
    */
    @FXML
    private Text bidsLeft;
    /**
    *ImageView displaying the main pricture of an auction.
    */
    @FXML
    private ImageView thumbnail;
    
    /**
    *Method setting the attributes of an auction.
    * @param title The title of the auction.
    * @param description The description of an auction.
    * @param currentPrice The current price of the artwork being auctioned.
    * @param bidsLeft The bids left on an auction.
    * @param thumbnailPath The path to the main picture of the auction.
    */
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
