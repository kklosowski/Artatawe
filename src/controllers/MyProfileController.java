package controllers;

import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MyProfileController {

    @FXML
    private Label username;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label mobile;

    @FXML
    private Label address;

    @FXML
    private Label postcode;

    @FXML
    private ImageView avatar;

    @FXML
    public void initialize(){

        User user = (User) SessionStorage.sessionData.get("loggedUser");
//        avatar.setImage(new Image(getClass().getResource( user.getProfilePicture()).toExternalForm()));
//        Image image = new Image("file:123.jpg");
//        avatar.setImage(image);
        username.setText(user.getUserName());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        mobile.setText(user.getMobileNo());
        address.setText(user.getAddress().toString());
        postcode.setText(user.getAddress().getPostcode());
    }
}
