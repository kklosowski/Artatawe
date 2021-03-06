package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Handles the loading of the views and requesting them. It supports the layout based views
 * @author Marceli Wac
 */

public class ViewLoader {
    public static final String LAYOUT_URL = "/views/_layout.fxml";
    public static final String ADD_AUCTION_ULR = "/views/add_auction.fxml";
    public static final String LOGIN_URL = "/views/login.fxml";
    public static final String REGISTER1_URL = "/views/register.fxml";
    public static final String REGISTER2_URL = "/views/register2.fxml";
    public static final String MY_PROFILE_URL = "/views/my_profile.fxml";
    public static final String CUSTOM_AVATAR_ULR = "/views/custom_avatar.fxml";
    public static final String BROWSE_USERS_URL = "/views/browse_users.fxml";
    public static final String BROWSE_HISTORY_URL = "/views/browse_history.fxml";
    public static final String BROWSE_AUCTIONS_URL = "/views/browse_auctions.fxml";
    public static final String AUCTION_PANE_URL = "/views/auction_pane.fxml";
    public static final String HISTORY_BID_PANE = "/views/history_bid_pane.fxml";
    public static final String HISTORY_FINISHED_AUCTION_PANE = "/views/history_finished_auction_pane.fxml";
    public static final String USER_PANE = "/views/user_pane.fxml";
    public static final String AUCTION_URL = "/views/auction.fxml";
    public static final String WISH_LIST_URL = "/views/wish_list.fxml";
    public static final String CHAT_URL = "/views/chat.fxml";


    private Scene view;
    public Pane content;
    private Pane layout;

    /**
     * Load view without the layout
     * @param contentFxmlUrl
     */
    public void loadViewController(String contentFxmlUrl) {
        this.loadContent(contentFxmlUrl);
    }

    /**
     * Load view with the layout
     * @param contentFxmlUrl
     * @param layoutFxmlUrl
     */
    public void loadViewController(String contentFxmlUrl, String layoutFxmlUrl) {
        this.loadContent(contentFxmlUrl);
        this.loadLayout(layoutFxmlUrl);
    }

    /**
     * Return the combined view or just the content
     * @return
     */
    public Scene getView() {
        this.buildView();
        return this.view;
    }

    /**
     * plots the content from the file
     * @param FxmlUrl
     */
    private void loadContent(String FxmlUrl) {
        try {
            this.content = FXMLLoader.load(getClass().getResource(FxmlUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Plots the layout from the file
     * @param FxmlUrl
     */
    private void loadLayout(String FxmlUrl) {
        try {
            this.layout = FXMLLoader.load(getClass().getResource(FxmlUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * handles loading of the panes that are returned straight to the calling method
     * @param FxmlUrl
     * @return
     */
    public Pane loadPane(String FxmlUrl) {
        try {
            return FXMLLoader.load(getClass().getResource(FxmlUrl));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * combines the layout with content views
     */
    private void buildView() {
        if (this.content == null) {
            throw new IllegalStateException("The content of the current view is not set");
        }
        if (this.layout == null) {
            this.view = new Scene(content);
        } else {
            LayoutDisplayController ldc = new LayoutDisplayController(this.content, this.layout);
            this.view = ldc.getView();
        }
    }

    /**
     * Provides the rew content pane
     * @return
     */
    public Pane getContent() {
        return content;
    }
}
