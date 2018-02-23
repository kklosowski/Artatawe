package controllers;

import artatawe.Auction;
import artatawe.Painting;
import artatawe.Sculpture;
import dataAccessObjects.AuctionDao;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.awt.*;


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
    private ImageView mainPicture;

    private Auction auction;



    @FXML
    public void initialize() {
        System.out.println(SessionStorage.sessionData.toString());
        String auctionId = (String) SessionStorage.sessionData.get("currentAuctionId");
        AuctionDao ad = new AuctionDao();
        try {
            this.auction = ad.getAuction(Integer.parseInt(auctionId));
            title.setText(auction.getArtwork().getTitle());
            type.setText(auction.getArtwork().getType());
            currentPrice.setText(String.valueOf(auction.getCurrentPrice()));
            bidsLeft.setText(String.valueOf(auction.bidsLeft()));
            bidsLeft.setText(String.valueOf(auction.bidsLeft()));
            if (auction.getArtwork() instanceof Sculpture){
                Sculpture s = (Sculpture) auction.getArtwork();
                size.setText(String.valueOf((s.getWidth()) + "cm x " + String.valueOf(s.getHeight()) + "cm x " + String.valueOf(s.getDepth())));
            } else if( auction.getArtwork() instanceof Painting){
                Painting p = (Painting) auction.getArtwork();
                size.setText(String.valueOf((p.getWidth()) + "cm x " + String.valueOf(p.getHeight()) + "cm"));
            }
            description.setText(auction.getArtwork().getDescription());
            mainPicture.setImage(new Image(getClass().getResourceAsStream("../views/images/logo.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
