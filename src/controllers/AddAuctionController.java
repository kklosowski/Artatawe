package controllers;

import artatawe.Artwork;
import artatawe.Auction;
import artatawe.Sculpture;
import artatawe.User;
import dataAccessObjects.AuctionDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Date;

public class AddAuctionController{

    @FXML
    private TextField title;

    @FXML
    private TextField artist;

    @FXML
    private DatePicker creationDate;

    @FXML
    private TextField reservedPrice;

    @FXML
    private TextField bidsAllowed;

    @FXML
    private TextArea description;

    @FXML
    TextField w,h,d;

    @FXML
    private Button createButton;


    public void createAuction(){
        Artwork artwork = new Sculpture(
                title.getText(),
                description.getText(),
                artist.getText(),
                "",
                1999,
                "",
                Double.parseDouble(w.getText()),
                Double.parseDouble(h.getText()),
                Double.parseDouble(d.getText()),
                null
        );
        Auction auction = new Auction(
                (User) SessionStorage.sessionData.get("loggedUser"),
                0,
                Double.parseDouble(reservedPrice.getText()),
                Integer.parseInt(bidsAllowed.getText()),
                artwork
        );

        AuctionDao auctionDao = new AuctionDao();
        try {
            auctionDao.insertAuction(auction);

            ViewLoader l = new ViewLoader();
            l.loadViewController(ViewLoader.BROWSE_AUCTIONS_URL, ViewLoader.LAYOUT_URL);
            Stage s = (Stage) creationDate.getScene().getWindow();
            s.setScene(l.getView());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
