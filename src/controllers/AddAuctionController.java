package controllers;

public class AddAuctionController extends ViewController {

    private final String CONTENT_FXML_ULR = "/views/add_auction.fxml";

    public AddAuctionController(){
        loadViewController(CONTENT_FXML_ULR);
    }
}
