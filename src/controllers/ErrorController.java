package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
/*
public class ErrorController extends ViewController{

    private final String CONTENT_FXML_URL = "/views/error.fxml";

    public ErrorController(){
        loadViewController();
    }
}
*/

public class ErrorController {
    private Scene view;
    private String DEFAULT_ERROR_MESSAGE = "Unknown error";
    private String errorMessage;
    private Text errorTextTarget;

    public ErrorController(Exception e){
        this.printExceptionTraceToStream(e);
        this.loadView();
        if(e.getMessage() == null){
            this.errorMessage = DEFAULT_ERROR_MESSAGE;
        }else{
            this.errorMessage = e.getMessage();
        }
        this.errorMessage += "\n" + e.getClass().getCanonicalName();
        this.errorTextTarget = (Text) view.lookup("#error-info");
        errorTextTarget.setText(errorMessage);
    }

    public Scene getView(){
        return this.view;
    }

    private void loadView(){
        try {
            Pane errorView = FXMLLoader.load(getClass().getResource("/views/error.fxml"));
            this.view = new Scene(errorView);
        }catch(Exception e){
            System.out.println("Fatal error occurred while loading error message.");
            System.out.println("Previous error message to display: '" + this.errorMessage + "'");
        }
    }

    private void printExceptionTraceToStream(Exception e){
        System.out.println("========== Printing exception stack trace from controllers.ErrorController class ==========");
        e.printStackTrace();
        System.out.println("===============================================================================");
    }
}