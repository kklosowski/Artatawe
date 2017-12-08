import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class AuctionPane extends Pane {
    private Text title;
    private Text description;
    private Text currentPrice;
    private Text bidsLeft;
    private ImageView thumbnail;

    public AuctionPane(Pane targetPane, String title, String description, Double currentPrice, Integer bidsLeft, String thumbnailPath) throws IllegalArgumentException{
        bindPaneObjects(targetPane);
        this.title.setText(title);
        this.currentPrice.setText(currentPrice.toString());
        this.bidsLeft.setText(bidsLeft.toString());
        this.thumbnail.setImage(new Image("/" + thumbnailPath));
    }

    private void bindPaneObjects(Pane p) throws IllegalArgumentException{
        try{
            this.title = (Text) p.lookup("#title");
            this.description = (Text) p.lookup("#description");
            this.currentPrice = (Text) p.lookup("#current-price");
            this.bidsLeft = (Text) p.lookup("#bids-left");
            this.thumbnail = (ImageView) p.lookup("#thumbnail");
            if(this.title == null || this.description == null || this.currentPrice == null || this.bidsLeft == null || this.thumbnail == null){
                throw new NullPointerException();
            }
        }catch(NullPointerException e){
            throw new IllegalArgumentException("The auction pane does not contain all required elements to display auction");
        }
    }
}
