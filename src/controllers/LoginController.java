package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController extends ViewController {

    private final String CONTENT_FXML_URL = "/views/login.fxml";

    @FXML
    private TextField username;

    @FXML
    private Button login;

    @FXML
    private Button register;

    public LoginController() {
        loadViewController(CONTENT_FXML_URL);
    }

    public void verifyUser(){

    }

    private boolean validateUser(String username){

        return true;
    }

}
