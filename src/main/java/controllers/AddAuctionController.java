package controllers;

import artatawe.*;
import dataAccessObjects.ArtworkDao;
import dataAccessObjects.AuctionDao;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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
    private HBox additionalGallery;
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
        int id = new Random().nextInt();

        if (paintingRadioButton.isSelected()) {
            artwork = new Painting(
                    id,
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
                    id,
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


    public void saveSelectedPicture(File picture){
        Path currentRelativePath = Paths.get("");
        String pathToSave = currentRelativePath.toAbsolutePath().toString()
                + "\\src\\views\\images\\"
                + ((User)SessionStorage.sessionData.get("loggedUser")).getUserName() + "\\"
                + picture.getName();
        try {
            Files.createDirectories(Paths.get(pathToSave).getParent());
            Files.copy(picture.toPath(), Paths.get(pathToSave), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
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
        saveSelectedPicture(photo);
        primaryPicture = ((User)SessionStorage.sessionData.get("loggedUser")).getUserName() + "\\" + photo.getName();
    }

    public void addAdditionalPhotos() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
        fileChooser.setTitle("Select Additional Photos");
        List<File> photo = fileChooser.showOpenMultipleDialog(title.getScene().getWindow());

        photo.forEach( x -> {
            ImageView image = new ImageView(x.toURI().toString());
            image.setFitWidth(110);
            image.setFitHeight(110);
            additionalGallery.getChildren().add(image);
            saveSelectedPicture(x);
            additionalPictures.add(((User)SessionStorage.sessionData.get("loggedUser")).getUserName() + "\\" + x.getName());
        });
    }
}
