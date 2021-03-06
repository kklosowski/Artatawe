package controllers;

import artatawe.Auction;
import artatawe.User;
import dataAccessObjects.AuctionDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller for Wish List
 */
public class WishListController {

    @FXML
    private VBox wished;

    @FXML
    private void initialize() {
        getWishedAuctions();
    }


    /**
     * Loads the auctions tha user added to his wish-list
     */
    @FXML
    private void getWishedAuctions() {
        ViewLoader l = new ViewLoader();
        AuctionDao ad = new AuctionDao();

        try {
            User currentUser = (User) SessionStorage.sessionData.get("loggedUser");

            List<Auction> fetchedAuctions = ad.getAuctionsWishedByUser((currentUser.getUserId()));
            for (Auction auction : fetchedAuctions) {
                Pane p = l.loadPane(ViewLoader.AUCTION_PANE_URL);
                p.applyCss();

                String pictureName = auction.getArtwork().getPrimaryPicture();
                if (pictureName.length() > 0) {
                    URL urlToImage = this.getClass().getResource("/views/images/" + pictureName);
                    ((ImageView) p.lookup("#thumbnail")).setImage(new Image(urlToImage.toString()));
                }
                ((Text) p.lookup("#title")).setText(auction.getArtwork().getTitle());
                ((Text) p.lookup("#currentPrice")).setText(String.valueOf(auction.getCurrentPrice()));
                ((Text) p.lookup("#type")).setText(auction.getArtwork().getType());
                ((Text) p.lookup("#bidsLeft")).setText(String.valueOf(Math.abs(auction.bidsLeft())));
                ((Text) p.lookup("#description")).setText(auction.getArtwork().getDescription());
                ((Text) p.lookup("#currentAuctionId")).setText(String.valueOf(auction.getAuctionId()));

                Button removeWish = (Button) p.lookup("#removeBtn");
                removeWish.setVisible(true);
                removeWish.setOnMouseClicked(event -> {
                    try {
                        ad.updateWished(currentUser.getUserId(),
                                Integer.valueOf(((Text) p.lookup("#currentAuctionId")).getText()),
                                false);
                        wished.getChildren().remove(p);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });

                wished.getChildren().add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
