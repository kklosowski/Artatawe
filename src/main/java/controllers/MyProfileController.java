package controllers;

import artatawe.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Kamil Klosowski
 */
//TODO: Load profile pic
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
    private Image targetImg;

    /**
     * Handle the content binding with the spaces on the layout
     */
    @FXML
    public void initialize() {


        User user = (User) SessionStorage.sessionData.get("loggedUser");
        username.setText(user.getUserName());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        mobile.setText(user.getMobileNo());
        address.setText(user.getAddress().toString());
        postcode.setText(user.getAddress().getPostcode());
    }
}
