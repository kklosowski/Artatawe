package controllers;

public class MyProfileController extends ViewController {

    private final String CONTENT_UXML_URL = "/views/my_profile.fxml";

    public MyProfileController() {
        loadViewController(CONTENT_UXML_URL);
    }
}
