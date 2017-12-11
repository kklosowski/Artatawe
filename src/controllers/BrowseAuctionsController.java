package controllers;

import artatawe.Auction;
import dataAccessObjects.AuctionDao;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.List;

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
    private void paintingsFilter(){
        this.type = "paintings";
        this.paintingsFilterButton.setStyle(activeStyle);
        this.sculpturesFilterButton.setStyle(inactiveStyle);
        this.allFilterButton.setStyle(inactiveStyle);
    }

    @FXML
    private void sculpturesFilter(){
        this.type = "sculptures";
        this.paintingsFilterButton.setStyle(inactiveStyle);
        this.sculpturesFilterButton.setStyle(activeStyle);
        this.allFilterButton.setStyle(inactiveStyle);

    }

    @FXML
    private void allFilter(){
        this.type = "all";
        this.paintingsFilterButton.setStyle(inactiveStyle);
        this.sculpturesFilterButton.setStyle(inactiveStyle);
        this.allFilterButton.setStyle(activeStyle);
    }

    @FXML
    private void onlyMine(){
        getAuctions();
    }

    @FXML
    private void getAuctions(){
        boolean onlyMine = this.onlyMineCheckbox.isSelected();
        ViewLoader l = new ViewLoader();
        AuctionDao ad = new AuctionDao();

        try {
            List<Auction> fetchedAuctions = ad.getAllAuctions();
            for (Auction auction:fetchedAuctions){
                Pane p = l.loadPane(ViewLoader.AUCTION_PANE_URL);
                p.applyCss();

                //Set Image
                //((ImageView) p.lookup("#vbox").lookup("#gPane").lookup("#thumbnail")).setImage();
                ((Text) p.lookup("#vbox").lookup("#hbox1").lookup("#title")).setText(auction.getArtwork().getTitle());
                ((Text) p.lookup("#vbox").lookup("#hbox1").lookup("#currentPrice")).setText(String.valueOf(auction.getCurrentPrice()));
                ((Text) p.lookup("#vbox").lookup("#hbox2").lookup("#type")).setText(auction.getArtwork().getType());
                ((Text) p.lookup("#vbox").lookup("#hbox2").lookup("#bidsLeft")).setText(String.valueOf(Math.abs(auction.bidsLeft())));
                ((Text) p.lookup("#vbox").lookup("#gPane").lookup("#description")).setText(auction.getArtwork().getDescription());
                auctions.getChildren().add(p);
                System.out.println("Added!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
