package controllers;

import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginController extends ViewController {

    private final String CONTENT_FXML_URL = "/views/login.fxml";

    @FXML
    private TextField username;

    @FXML
    private Button login;

    @FXML
    private Button register;

    private User user;

    public LoginController() {
        loadViewController(CONTENT_FXML_URL);
    }

    public void verifyUser(){

    }

    private boolean validateUser(String username) throws SQLException {
        UserDao userDao = new UserDao();
        user = userDao.getUserByUsername(username);
        return user != null;
    }

}
