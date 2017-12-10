package controllers;

public class BrowseHistoryController extends ViewController {

    private final String CONTENT_FXML_URL = "/views/browse_history.fxml";
    private final String LAYOUT_FXML_URL = "/views/_layout.fxml";

    public BrowseHistoryController() {
        loadViewController(CONTENT_FXML_URL, LAYOUT_FXML_URL);
    }
}
