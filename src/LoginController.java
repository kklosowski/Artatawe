import javafx.scene.layout.Pane;

public class LoginController extends ViewController{

    private final String CONTENT_FXML_URL = "/views/login.fxml";

    public LoginController(){
        loadViewController(CONTENT_FXML_URL);
    }

}
