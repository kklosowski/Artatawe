//package controllers;
//
//import artatawe.User;
//import dataAccessObjects.UserDao;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import models.SessionData;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//public class LoginController{
//
//    private final String CONTENT_FXML_URL = "/views/login.fxml";
//    private SessionData sd;
//    private content
//
//    private TextField username;
//
//    private Button login;
//
//    private Button register;
//
//
//    public LoginController() {
//        //loadViewController(CONTENT_FXML_URL);
//        initialise();
//    }
//
//
//    @FXML
//    public void initialise(){
//        try {
//            this.content = FXMLLoader.load(getClass().getResource(CONTENT_FXML_URL));
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private String getUsername(){
//        return username.getText();
//    }
//
//    public void verifyUser(){
//        InputValidator iv = new InputValidator();
//        String username = getUsername();
//        System.out.println("Got username: " + username);
//        if(!iv.validUsername(username)){
//            showError("The username is not valid");
//        }else{
//            if(validateUser(username)){
//                login();
//            }else{
//                showError("The user with this username does not exist.");
//            }
//        }
//    }
//
//    private boolean validateUser(String username) {
//        try{
//            UserDao userDao = new UserDao();
//            this.sd.setUser(userDao.getUserByUsername(username));
//            return true;
//        }catch(SQLException e){
//            return false;
//        }
//    }
//
//    private void showError(String message){
//        System.out.println("Error: " + message);
//    }
//
//    private void login(){
//        if(this.sd.getUser() != null){
//            BrowseAuctionsController bac = new BrowseAuctionsController();
//            Stage currentStage = getCurrentStage();
//            currentStage.setScene(bac.getView());
//        }else{
//            showError("Something went wrong...");
//        }
//    }
//
//}

package controllers;

import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.SessionData;

import java.sql.SQLException;

public class LoginController{

    private User user;

    @FXML private Button login;
    @FXML private Button register;
    @FXML private TextField username;

    private String getUsername(){
        return username.getText();
    }

    @FXML
    public void verifyUser(){
        InputValidator iv = new InputValidator();
        String username = getUsername();
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
            this.user = userDao.getUserByUsername(username);
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    private void showError(String message){
        System.out.println("Error: " + message);
    }

    private void login(){
        if(this.user != null){
            BrowseAuctionsController bac = new BrowseAuctionsController();
            Stage currentStage = (Stage) login.getScene().getWindow();
            currentStage.setScene(bac.getView());
        }else{
            showError("Something went wrong...");
        }
    }
}


