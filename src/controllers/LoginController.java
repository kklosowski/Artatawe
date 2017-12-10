package controllers;

import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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


//        login.setOnAction(e -> {
//            verifyUser();
//        });
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
                login();
            }else{
                showError("The user with this username does not exist.");
            }
        }
    }

    private boolean validateUser(String username) {
        try{
            UserDao userDao = new UserDao();
            this.sd.setUser(userDao.getUserByUsername(username));
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    private void showError(String message){
        System.out.println("Error: " + message);
    }

    private void login(){
        if(this.sd.getUser() != null){
            BrowseAuctionsController bac = new BrowseAuctionsController();
            Stage currentStage = getCurrentStage();
            currentStage.setScene(bac.getView());
        }else{
            showError("Something went wrong...");
        }
    }

}
