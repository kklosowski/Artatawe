package controllers;

import artatawe.*;
import dataAccessObjects.AuctionDao;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Kamil Klosowski, Marceli Wac
 */


public class AddAuctionController {

    @FXML
    private TextField w, h, d;
    @FXML
    private Text depthLabel;
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
    private TextField material;
    @FXML
    private TextArea description;
    @FXML
    private Button createButton;
    @FXML
    private ImageView mainPhoto;
    @FXML
    private GridPane additionalGallery;
    @FXML
    private Button optionalPhotosButton;
    @FXML
    private RadioButton sculptureRadioButton;
    @FXML
    private RadioButton paintingRadioButton;

    private String primaryPicture = "";

    private List<String> additionalPictures = new ArrayList<>();

    public void createAuction() {
        Artwork artwork;

        if (getArtworkType() == 'P') {
            artwork = new Painting(
                    title.getText(),
                    description.getText(),
                    artist.getText(),
                    primaryPicture,
                    Date.valueOf(creationDate.getValue()).getYear(),
                    Double.parseDouble(w.getText()),
                    Double.parseDouble(h.getText())
            );

        } else {
            artwork = new Sculpture(
                    title.getText(),
                    description.getText(),
                    artist.getText(),
                    primaryPicture,
                    Date.valueOf(creationDate.getValue()).getYear(),
                    material.getText(),
                    Double.parseDouble(w.getText()),
                    Double.parseDouble(h.getText()),
                    Double.parseDouble(d.getText()),
                    additionalPictures
            );
        }


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

    public void changeType(){
        if (paintingRadioButton.isSelected()){
            material.setVisible(false);
            d.setVisible(false);
            additionalGallery.setVisible(false);
            optionalPhotosButton.setVisible(false);
            depthLabel.setVisible(false);
        }
        if (sculptureRadioButton.isSelected()){
            material.setVisible(true);
            d.setVisible(true);
            additionalGallery.setVisible(true);
            optionalPhotosButton.setVisible(true);
            depthLabel.setVisible(true);
        }
    }

    public char getArtworkType() {
        if (paintingRadioButton.isSelected()){
            return 'P';
        } else if (sculptureRadioButton.isSelected()){
            return 'S';
        } else {
            return 0;
        }
    }

    public void setMainPhoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Main Photo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
        File photo = fileChooser.showOpenDialog(title.getScene().getWindow());
        mainPhoto.setImage(new Image(photo.toURI().toString()));
        System.out.println(photo.toURI().toString());
    }

    public void addAdditionalPhotos() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
        fileChooser.setTitle("Select Additional Photos");
        List<File> photo = fileChooser.showOpenMultipleDialog(title.getScene().getWindow());
    }
}
