package controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public  class ViewLoader {
    public static final String LAYOUT_FXML_URL = "/views/_layout.fxml";
    public static final String ADD_AUCTION_ULR = "/views/add_auction.fxml";
    public static final String LOGIN_URL = "/views/login.fxml";
    public static final String REGISTER1_URL = "/views/register.fxml";
    public static final String REGISTER2_URL = "/views/register2.fxml";
    public static final String MY_PROFILE_URL = "/views/my_profile.fxml";
    public static final String CUSTOM_AVATAR_ULR = "/views/custom_avatar.fxml";
    public static final String BROWSE_USERS_URL = "/views/browse_users.fxml";
    public static final String BROWSE_HISTORY_URL = "/views/browse_history.fxml";
    public static final String BROWSE_AUCTIONS_URL = "/views/browse_auctions.fxml";
    public static final String AUCTION_URL = "/views/auction.fxml";


    private Scene view;
    private Scene errorView;
    public Pane content;
    private Pane layout;


    public void loadViewController(String contentFxmlUrl) {
        this.errorView = null;
        this.loadContent(contentFxmlUrl);
    }

    public void loadViewController(String contentFxmlUrl, String layoutFxmlUrl) {
        this.errorView = null;
        this.loadContent(contentFxmlUrl);
        this.loadLayout(layoutFxmlUrl);
    }

    public Scene getView() {
        if (this.errorView == null) {
            this.buildView();
            return this.view;
        } else {
            return this.errorView;
        }
    }

    private void loadContent(String FxmlUrl) {
        try {
            this.content = FXMLLoader.load(getClass().getResource(FxmlUrl));
        } catch (IOException e){
            e.printStackTrace();
            //TODO implement ErrorController
            //ErrorController ec = new ErrorController(e);
            //this.errorView = ec.getView();
        }
    }

    private void loadLayout(String FxmlUrl) {
        try {
            this.layout = FXMLLoader.load(getClass().getResource(FxmlUrl));
        } catch (IOException e) {
            //ErrorController ec = new ErrorController(e);
            //this.errorView = ec.getView();
        }
    }

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

}