package controllers;

import artatawe.Auction;
import artatawe.User;
import dataAccessObjects.AuctionDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Kamil Klosowski, Marceli Wac
 */

public class BrowseAuctionsController {
    private String type = "all";
    private final String activeStyle = "-fx-text-fill: #ffffff; -fx-background-color: #4285f4;";
    private final String inactiveStyle = null;

    @FXML
    private Button paintingsFilterButton;

    @FXML
    private Button sculpturesFilterButton;

    @FXML
    private Button allFilterButton;

    @FXML
    private CheckBox onlyMineCheckbox;

    @FXML
    private VBox auctions;

    @FXML
    private void initialize(){
        getAuctions();
    }

    @FXML
    private void paintingsFilter() {
        this.type = "painting";
        this.paintingsFilterButton.setStyle(activeStyle);
        this.sculpturesFilterButton.setStyle(inactiveStyle);
        this.allFilterButton.setStyle(inactiveStyle);
        clearAuctions();
        getAuctions();
    }

    @FXML
    private void sculpturesFilter() {
        this.type = "sculpture";
        this.paintingsFilterButton.setStyle(inactiveStyle);
        this.sculpturesFilterButton.setStyle(activeStyle);
        this.allFilterButton.setStyle(inactiveStyle);
        clearAuctions();
        getAuctions();

    }

    @FXML
    private void allFilter() {
        this.type = "all";
        this.paintingsFilterButton.setStyle(inactiveStyle);
        this.sculpturesFilterButton.setStyle(inactiveStyle);
        this.allFilterButton.setStyle(activeStyle);
        clearAuctions();
        getAuctions();
    }

    @FXML
    private void onlyMine() {
        clearAuctions();
        getAuctions();
    }

    private void clearAuctions() {
        auctions.getChildren().setAll();
    }


    @FXML
    private void getAuctions() {
        boolean onlyMine = this.onlyMineCheckbox.isSelected();
        ViewLoader l = new ViewLoader();
        AuctionDao ad = new AuctionDao();

        try {
            User currentUser = (User) SessionStorage.sessionData.get("loggedUser");

            List<Auction> fetchedAuctions = ad.getAllAuctions(this.type, onlyMine, ((currentUser.getUserId())));
            for (Auction auction : fetchedAuctions) {
                Pane p = l.loadPane(ViewLoader.AUCTION_PANE_URL);
                p.applyCss();

                //Set Image
                String pictureName = auction.getArtwork().getPrimaryPicture();
                if (pictureName.length() > 0){
                    URL urlToImage = this.getClass().getResource("/views/images/" + pictureName);
                    ((ImageView) p.lookup("#thumbnail")).setImage(new Image(urlToImage.toString()));
                }
                ((Text) p.lookup("#title")).setText(auction.getArtwork().getTitle());
                ((Text) p.lookup("#currentPrice")).setText(String.valueOf(auction.getCurrentPrice()));
                ((Text) p.lookup("#type")).setText(auction.getArtwork().getType());
                ((Text) p.lookup("#bidsLeft")).setText(String.valueOf(Math.abs(auction.bidsLeft())));
                ((Text) p.lookup("#description")).setText(auction.getArtwork().getDescription());
                ((Text) p.lookup("#currentAuctionId")).setText(String.valueOf(auction.getAuctionId()));
                auctions.getChildren().add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
