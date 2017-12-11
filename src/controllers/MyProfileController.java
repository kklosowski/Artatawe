package controllers;

import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
    public void initialize(){

        User user = (User) SessionStorage.sessionData.get("loggedUser");

    }
}
