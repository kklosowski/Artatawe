package controllers;

import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.SessionData;

import java.sql.SQLException;

public class LoginController extends ViewController {

    private final String CONTENT_FXML_URL = "/views/login.fxml";
    private SessionData sd;
    private User user;

    @FXML
    private TextField username;

    @FXML
    private Button login;

    @FXML
    private Button register;

    public LoginController(SessionData sd) {
        this.sd = sd;
        loadViewController(CONTENT_FXML_URL);

        login.setOnAction(e -> {
            verifyUser();
        });
    }

    private String getUsername(){
        return username.getText();
    }

    public void verifyUser(){
        InputValidator iv = new InputValidator();
        String username = getUsername();
        System.out.println("Got username: " + username);
        if(!iv.validUsername(username)){
            showError("The username is not valid");
        }else{
            if(validateUser(username)){
                login(this.user);
            }else{
                showError("The user with this username does not exist.");
            }

        }
    }

    private boolean validateUser(String username) throws SQLException {
        UserDao userDao = new UserDao();
        user = userDao.getUserByUsername(username);
        return user != null;
    private void showError(String message){

    }
    }

    private void login(User u){
        if(this.user != null){

        }else{
            showError("Something went wrong...");
        }
    }

}
