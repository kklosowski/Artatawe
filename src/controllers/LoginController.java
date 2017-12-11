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

/**
 * Class for handling the GUI for Login.
 *
 * @author Marceli Wac
 * @version 1.0
 */

public class LoginController {

    /**
     * User object.
     */
    private User user;

    /**
     * Login button.
     */
    @FXML
    private Button loginButton;

    /**
     * Registration button.
     */
    @FXML
    private Button registerButton;

    /**
     * Text for error message.
     */
    @FXML
    private Text errorText;

    /**
     * Text field for a user's username.
     */
    @FXML
    private TextField usernameTextField;

    /**
     * Gets the username.
     *
     * @return The username of a user.
     */
    private String getUsername() {
        return usernameTextField.getText();
    }

    /**
     * Method verifying the user.
     */
    @FXML
    public void verifyUser() {
        InputValidator iv = new InputValidator();
        String username = getUsername();
        if (!iv.validUsername(username)) {
            showError("The username is not valid");
        } else {
            if (validateUser(username)) {
                UserDao userDao = new UserDao();
                User user = null;
                try {
                    user = userDao.getUserByUsername(usernameTextField.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                SessionStorage.sessionData.put("loggedUser", user);
                login();
            } else {
                showError("The user with this username does not exist.");
            }
        }
    }


    /**
     * Method to validate a user
     *
     * @param username The user's username
     */
    private boolean validateUser(String username) {
        try {
            UserDao userDao = new UserDao();
            User u = userDao.getUserByUsername(username);
            if (u != null) {
                this.user = u;
                return true;
            }
            return false;
        } catch (SQLException e) {
            showError("Could not establish database up-link, Cap!\nAborting...");
            return false;
        }
    }

    /**
     * Method for loading the scene.
     */
    private void login() {
        if (this.user != null) {
            ViewLoader l = new ViewLoader();
            l.loadViewController(ViewLoader.BROWSE_AUCTIONS_URL, ViewLoader.LAYOUT_URL);
            Stage s = (Stage) this.loginButton.getScene().getWindow();
            s.setScene(l.getView());
        } else {
            showError("Something went wrong...");
        }
    }

    /**
     * Method for showing a message with the error.
     *
     * @param message The message being displayed.
     */
    private void showError(String message) {
        this.errorText.setText(message);
    }


    /**
     * Method for loading the Registration Viem.
     */
    @FXML
    public void register() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.REGISTER1_URL);
        Stage s = (Stage) this.loginButton.getScene().getWindow();
        s.setScene(l.getView());
    }
}


