package controllers;

import artatawe.Message;
import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class ChatController {


    @FXML
    private VBox chatVBox;

    @FXML
    private TextField message;

    @FXML
    private void initialize() {
        loadMessages();
    }


    /**
     * Loads messages between two users
     */
    @FXML
    private void loadMessages() {
        UserDao userDao = new UserDao();

        int currentUserID = ((User) SessionStorage.sessionData.get("loggedUser")).getUserId();
        int messagedUserID = (int) SessionStorage.sessionData.get("messagedUser");

        try {
            userDao.getUserMessages(currentUserID, messagedUserID)
                    .stream()
                    .sorted(Comparator.comparing(Message::getTimestamp))
                    .forEach(x -> {
                        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                                .format(new java.util.Date (x.getTimestamp()));

                        Label m = new Label(x.getFromUser().getUserName()
                                + " ("+date+")"
                                + " :  " + x.getContent());
                        m.setFont(new Font("Calibri", 16));

                        chatVBox.getChildren().add(m);
                    });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a message form one user to another
     */
    @FXML
    private void sendMessage() {
        UserDao userDao = new UserDao();


        try {
            int currentUserID = ((User) SessionStorage.sessionData.get("loggedUser")).getUserId();
            int messagedUserID = (int) SessionStorage.sessionData.get("messagedUser");
            User currentUser = (User)SessionStorage.sessionData.get("loggedUser");
            User messagedUser = userDao.getUser(messagedUserID);

            userDao.sendUserMessage(currentUserID, messagedUserID, message.getText());

            String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                    .format(new java.util.Date (System.currentTimeMillis()));

            Label m = new Label(currentUser.getUserName()
                    + " ("+date+")"
                    + " : " + message.getText());
            m.setFont(new Font("Calibri", 16));

            message.setText("");
            chatVBox.getChildren().add(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
