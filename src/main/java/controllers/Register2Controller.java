package controllers;

import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * @author Kamil Klosowski
 */


public class Register2Controller {

    @FXML
    private Pane rootPane;

    @FXML
    private GridPane avatarGrid;

    /**
     * Allows user to select the avater
     * @param event
     */
    @FXML
    public void setSelectedAvatar(Event event) {
        ImageView avatar = (ImageView) event.getSource();
        String url = avatar.getImage().impl_getUrl();
        ((User) SessionStorage.sessionData.get("loggedUser")).setProfilePicture(url.substring(url.lastIndexOf('/' + 1)));
    }

    /**
     * proceeds with the validation of the user and transports them to the browsing page
     */
    @FXML
    public void login() {
        UserDao userDao = new UserDao();
        try {
            userDao.insertUser((User) SessionStorage.sessionData.get("loggedUser"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.BROWSE_AUCTIONS_URL, ViewLoader.LAYOUT_URL);
        Stage s = (Stage) rootPane.getScene().getWindow();
        s.setScene(l.getView());
    }

    /**
     * Open the custom drowing page
     */
    @FXML
    public void addNewAvatar() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.CUSTOM_AVATAR_ULR);
        Stage s = (Stage) rootPane.getScene().getWindow();
        s.setScene(l.getView());
    }

}
