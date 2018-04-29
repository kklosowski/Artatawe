package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class usses view loader to redirect the user to apropriate views
 * @author Marceli Wac
 */


public class LayoutController {
    private final String activeStyle = "-fx-text-fill: #ffffff; -fx-background-color: #4285f4;";
    private final String inactiveStyle = "-fx-text-fill: #ffffff; -fx-background-color: #4285f4;";

    @FXML
    private Button browseAuctionsButton;

    @FXML
    private Button browseUsersButton;

    @FXML
    private Button myFavouritesButton;

    @FXML
    private Button myAuctionsButton;

    @FXML
    private Button sellArtworkButton;

    @FXML
    private Button historyButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private Button logoutButton;

    @FXML
    private void browseAuctions() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.BROWSE_AUCTIONS_URL, ViewLoader.LAYOUT_URL);
        Stage s = (Stage) logoutButton.getScene().getWindow();
        //TODO change the view
        s.setScene(l.getView());
    }

    @FXML
    private void browseUsers() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.BROWSE_USERS_URL, ViewLoader.LAYOUT_URL);
        Stage s = (Stage) logoutButton.getScene().getWindow();
        s.setScene(l.getView());
    }

    @FXML
    private void myFavourites() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.BROWSE_AUCTIONS_URL, ViewLoader.LAYOUT_URL);
        Stage s = (Stage) logoutButton.getScene().getWindow();
        //TODO change the view
        s.setScene(l.getView());
    }

    @FXML
    private void myAuctions() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.BROWSE_AUCTIONS_URL, ViewLoader.LAYOUT_URL);
        Stage s = (Stage) logoutButton.getScene().getWindow();
        //TODO change the view
        s.setScene(l.getView());
    }

    @FXML
    private void sellArtwork() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.ADD_AUCTION_ULR, ViewLoader.LAYOUT_URL);
        Stage s = (Stage) logoutButton.getScene().getWindow();
        s.setScene(l.getView());
    }

    @FXML
    private void history() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.BROWSE_HISTORY_URL, ViewLoader.LAYOUT_URL);
        Stage s = (Stage) logoutButton.getScene().getWindow();
        s.setScene(l.getView());
    }

    @FXML
    private void myProfile() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.MY_PROFILE_URL, ViewLoader.LAYOUT_URL);
        Stage s = (Stage) logoutButton.getScene().getWindow();
        s.setScene(l.getView());
    }

    @FXML
    private void logout() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.LOGIN_URL);
        Stage s = (Stage) logoutButton.getScene().getWindow();
        s.setScene(l.getView());
    }
}
