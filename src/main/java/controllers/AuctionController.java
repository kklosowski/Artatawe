package controllers;

import artatawe.*;
import dataAccessObjects.AuctionDao;
import dataAccessObjects.BidDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


import java.sql.SQLException;
import java.sql.Timestamp;


/**
 * @author Kamil Klosowski, Marceli Wac
 */


public class AuctionController {
    @FXML
    private Text title;
    @FXML
    private Text type;
    @FXML
    private Text currentPrice;
    @FXML
    private Text bidsLeft;
    @FXML
    private Text size;
    @FXML
    private Text description;
    @FXML
    private Text username;
    @FXML
    private ImageView mainPicture;
    @FXML
    private TextField bidAmount;
    @FXML
    private Button wishButton;

    private Auction auction;
    private User user;

    //TODO: Comments

    /**
     * Initializes the auction view with data of selected auction
     */
    @FXML
    public void initialize() {
        String auctionId = (String) SessionStorage.sessionData.get("currentAuctionId");
        AuctionDao ad = new AuctionDao();
        try {
            this.auction = ad.getAuction(Integer.parseInt(auctionId));
            this.user = (User) SessionStorage.sessionData.get("loggedUser");
            title.setText(auction.getArtwork().getTitle());
            type.setText(auction.getArtwork().getType());
            currentPrice.setText(String.valueOf(auction.getCurrentPrice()));
            bidsLeft.setText(String.valueOf(auction.bidsLeft()));
            if (auction.getArtwork() instanceof Sculpture) {
                Sculpture s = (Sculpture) auction.getArtwork();
                size.setText(String.valueOf((s.getWidth()) + "cm x " + String.valueOf(s.getHeight()) + "cm x " + String.valueOf(s.getDepth())));
            } else if (auction.getArtwork() instanceof Painting) {
                Painting p = (Painting) auction.getArtwork();
                size.setText(String.valueOf((p.getWidth()) + "cm x " + String.valueOf(p.getHeight()) + "cm"));
            }
            if (ad.isWished(user.getUserId(), Integer.valueOf(auctionId))) {
                wishButton.setText("Remove from wish list");
            } else {
                wishButton.setText("Add to wish list");
            }
            description.setText(auction.getArtwork().getDescription());
            mainPicture.setImage(new Image(getClass().getResourceAsStream("../views/images/" + auction.getArtwork().getPrimaryPicture())));
            username.setText(user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Allows the user to add or remove an auction from his wish list
     */
    @FXML
    public void wishToggle() {
        AuctionDao ad = new AuctionDao();
        try {
             if (wishButton.getText().contains("Add")) {
                wishButton.setText("Remove from wish list");
                ad.updateWished(user.getUserId(), auction.getAuctionId(), true);

            } else {
                wishButton.setText("Add to wish list");
                 ad.updateWished(user.getUserId(), auction.getAuctionId(), false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Places a bit in a given auction
     */
    public void placeBid() {
        BidDao bidDao = new BidDao();
        try {
            bidDao.insertBid(
                    new Bid(user.getUserId(),
                            Double.valueOf(bidAmount.getText()),
                            new Timestamp(System.currentTimeMillis())), auction);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
