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

    private Auction auction;
    private User user;


    @FXML
    public void initialize() {
        System.out.println(SessionStorage.sessionData.toString());
        String auctionId = (String) SessionStorage.sessionData.get("currentAuctionId");
        AuctionDao ad = new AuctionDao();
        try {
            this.auction = ad.getAuction(Integer.parseInt(auctionId));
            System.out.println(auction.toString());
            this.user = (User)SessionStorage.sessionData.get("loggedUser");
            title.setText(auction.getArtwork().getTitle());
            type.setText(auction.getArtwork().getType());
            currentPrice.setText(String.valueOf(auction.getCurrentPrice()));
            bidsLeft.setText(String.valueOf(auction.bidsLeft()));
            if (auction.getArtwork() instanceof Sculpture){
                Sculpture s = (Sculpture) auction.getArtwork();
                size.setText(String.valueOf((s.getWidth()) + "cm x " + String.valueOf(s.getHeight()) + "cm x " + String.valueOf(s.getDepth())));
            } else if( auction.getArtwork() instanceof Painting){
                Painting p = (Painting) auction.getArtwork();
                size.setText(String.valueOf((p.getWidth()) + "cm x " + String.valueOf(p.getHeight()) + "cm"));
            }
            description.setText(auction.getArtwork().getDescription());
            mainPicture.setImage(new Image(getClass().getResourceAsStream("../views/images/" + auction.getArtwork().getPrimaryPicture())));
            username.setText(((User)SessionStorage.sessionData.get("loggedUser")).getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void placeBid(){
        //TODO: Validation
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
