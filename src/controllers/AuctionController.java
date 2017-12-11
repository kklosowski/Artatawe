package controllers;

import artatawe.Auction;
import artatawe.Sculpture;
import dataAccessObjects.AuctionDao;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class AuctionController {
    @FXML
    private Text title;
    @FXML
    private Text type;
    @FXML
    private Text currentBid;
    @FXML
    private Text remainingBids;
    @FXML
    private Text size;
    @FXML
    private Text description;

    @FXML
    public void initialize() {
        String auctionId = (String) SessionStorage.sessionData.get("currentAuctionId");
        AuctionDao ad = new AuctionDao();
        try {
            Auction a = ad.getAuction(Integer.parseInt(auctionId));
            title.setText(a.getArtwork().getTitle());
            type.setText(a.getArtwork().getType());
            currentBid.setText(String.valueOf(a.getCurrentPrice()));
            remainingBids.setText(String.valueOf(a.bidsLeft()));
            size.setText(String.valueOf(((Sculpture) a.getArtwork()).getWidth()) + "cm x " + String.valueOf(((Sculpture) a.getArtwork()).getHeight()) + "cm");
            description.setText(a.getArtwork().getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
