package controllers;

import artatawe.Artwork;
import artatawe.Auction;
import artatawe.Sculpture;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.awt.*;

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
    private Button createButton;


    public void createAuction(){
//        Artwork artwork = new Sculpture()
//        Auction auction = new Auction(
//                SessionStorage.sessionData.get("loggedUser"),
//                0,
//                Double.parseDouble(reservedPrice.getText()),
//                Integer.parseInt(bidsAllowed.getText()),
//        )
    }

}
