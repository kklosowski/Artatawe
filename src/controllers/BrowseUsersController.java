package controllers;

import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
                    System.out.println(urlToImage.toString());
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

                users.getChildren().add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
