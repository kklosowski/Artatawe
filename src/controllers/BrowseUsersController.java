package controllers;

public class BrowseUsersController extends ViewController {

    private final String CONTENT_FXML_URL = "/views/browse_users.fxml";
    private final String LAYOUT_FXML_URL = "/views/_layout.fxml";

    public BrowseUsersController() {
        loadViewController(CONTENT_FXML_URL, LAYOUT_FXML_URL);
    }
}
