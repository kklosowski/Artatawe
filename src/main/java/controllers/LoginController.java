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
 * @author Marceli Wac, Kamil Klosowski
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


