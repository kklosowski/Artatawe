package controllers;

public class AuctionController extends ViewController {

    private final String LAYOUT_FXML_URL = "/views/_layout.fxml";
    private final String CONTENT_FXML_URL = "/views/auction.fxml";

    public AuctionController() {
        loadViewController(CONTENT_FXML_URL, LAYOUT_FXML_URL);
    }


}
