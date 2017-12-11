package controllers;

import dataAccessObjects.UserDao;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.EventListener;

public class Register2Controller {

    @FXML
    private Pane rootPane;

    @FXML
    private GridPane avatarGrid;

    @FXML
    public void initialize(){
    }

    @FXML
    public void setSelectedAvatar(Event event){
        ImageView avatar = (ImageView) event.getSource();
        String url = avatar.getImage().getUrl();
        SessionStorage.loggedUser.setProfilePicture(url.substring(url.lastIndexOf('/' + 1)));
        System.out.println(SessionStorage.loggedUser.toString());
    }
//
//    @FXML
//    public void highlight(){
//        avatarGrid.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                GridPane gridPane = (GridPane) event.getSource();
//                gridPane.getChildren().
//                event.consume();
//            }
//        });
//    }

    @FXML
    public void login(){
        UserDao userDao = new UserDao();
        try {
            userDao.insertUser(SessionStorage.loggedUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.LOGIN_URL);
        Stage s = (Stage) rootPane.getScene().getWindow();
        s.setScene(l.getView());
    }

    @FXML
    public void addNewAvatar() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.CUSTOM_AVATAR_ULR);
        Stage s = (Stage) rootPane.getScene().getWindow();
        s.setScene(l.getView());
    }

}
