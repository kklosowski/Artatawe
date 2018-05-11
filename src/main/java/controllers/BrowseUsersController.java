package controllers;

import artatawe.Auction;
import artatawe.User;
import dataAccessObjects.AuctionDao;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

/**
 * Manage the user browsing view
 */
public class BrowseUsersController {

    @FXML
    private VBox users;

    @FXML
    private void initialize() {
        getUsers();
    }

    @FXML
    private void getUsers() {
        ViewLoader l = new ViewLoader();
        UserDao ud = new UserDao();

        try {
            User currentUser = (User) SessionStorage.sessionData.get("loggedUser");

            List<User> fetchedUsers = ud.getAllUsers();
            users.getChildren().clear();

            for (User user : fetchedUsers) {
                Pane p = l.loadPane(ViewLoader.USER_PANE);
                p.applyCss();

                //Set Image
                String pictureName = user.getProfilePicture();
                if (pictureName.length() > 0) {
                    URL urlToImage = this.getClass().getResource("/views/images/" + pictureName);
                    ((ImageView) p.lookup("#thumbnail")).setImage(new Image(urlToImage.toString()));
                }
                ((Text) p.lookup("#fullname")).setText(user.getFullName());
                ((Text) p.lookup("#username")).setText(user.getUserName());
                ((Text) p.lookup("#userId")).setText(String.valueOf(user.getUserId()));
                ImageView starIcon = ((ImageView) p.lookup("#favIcon"));
                if (currentUser.isFavourite(user.getUserId())) {
                    starIcon.setImage(new Image(this.getClass().getResource("/views/images/star_filled.png").toString()));
                } else {
                    starIcon.setImage(new Image(this.getClass().getResource("/views/images/star_empty.png").toString()));
                }

                starIcon.setOnMouseClicked(event -> {
                    int clickedUserId = Integer.valueOf(((Text) p.lookup("#userId")).getText());
                    try {
                        if (currentUser.isFavourite(clickedUserId)) {
                            starIcon.setImage(new Image(this.getClass().getResource("/views/images/star_empty.png").toString()));
                            currentUser.removeFavourite(clickedUserId);
                            ud.removeFavourite(currentUser.getUserId(), clickedUserId);
                        } else {
                            starIcon.setImage(new Image(this.getClass().getResource("/views/images/star_filled.png").toString()));
                            currentUser.addFavourite(clickedUserId);
                            ud.insertFavourite(currentUser.getUserId(), clickedUserId);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });

                ImageView chatIcon = ((ImageView) p.lookup("#chatIcon"));
                chatIcon.setOnMouseClicked(event -> {
                    int clickedUserId = Integer.valueOf(((Text) p.lookup("#userId")).getText());
                    SessionStorage.sessionData.put("messagedUser", Integer.valueOf(clickedUserId));

                    ViewLoader viewLoader = new ViewLoader();
                    viewLoader.loadViewController(ViewLoader.CHAT_URL, ViewLoader.LAYOUT_URL);
                    Scene scene = (Scene) viewLoader.getView();
                    Stage ss = (Stage) users.getScene().getWindow();
                    ss.setScene(scene);

                });


                users.getChildren().add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
