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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;

public class LoginController{

    private User user;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Text errorText;

    @FXML
    private TextField usernameTextField;

    private String getUsername(){
        return usernameTextField.getText();
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
            User u = userDao.getUserByUsername(username);
            if(u != null){
                this.user = u;
                return true;
            }
            return false;
        }catch(SQLException e){
            showError("Could not establish database up-link, Cap!\nAborting...");
            return false;
        }
    }

    private void login(){
        if(this.user != null){
            ViewLoader l = new ViewLoader();
            l.loadViewController(ViewLoader.BROWSE_AUCTIONS_URL, ViewLoader.LAYOUT_URL);
            Stage s = (Stage) this.loginButton.getScene().getWindow();
            s.setScene(l.getView());
        }else{
            showError("Something went wrong...");
        }
    }

    private void showError(String message){
        this.errorText.setText(message);
    }

    @FXML
    public void register(){
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.REGISTER1_URL);
        Stage s = (Stage) this.loginButton.getScene().getWindow();
        s.setScene(l.getView());
    }
}


