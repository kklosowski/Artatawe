package controllers;

public class CustomAvatarController extends ViewController {

    private final String CONTENT_FXML_ULR = "/views/custom_avatar.fxml";

    public CustomAvatarController() {
        loadViewController(CONTENT_FXML_ULR);
    }
}
