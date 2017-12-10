package controllers;

public class RegisterController extends ViewController {

    private final String CONTENT_FXML_URL1 = "/views/register.fxml";
    private final String CONTENT_FXML_URL2 = "/views/register2.fxml";

    public RegisterController() {
        loadViewController(CONTENT_FXML_URL1);
    }

    public void nextStage() {
        loadViewController(CONTENT_FXML_URL2);
    }

}
