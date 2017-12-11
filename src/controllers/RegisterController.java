package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController{

    @FXML private Button continueButton;
    @FXML private Button loginButton;
    @FXML private TextField usernameTextField;
    @FXML private TextField firstnameTextField;
    @FXML private TextField lastnameTextField;
    @FXML private TextField mobileTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField postcodeTextField;

    @FXML
    public void login(){
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.LOGIN_URL);
        Stage s = (Stage) this.continueButton.getScene().getWindow();
        s.setScene(l.getView());
    }

    @FXML
    public void attemptContinue(){
        if(validateFields()){
            //create user
            //store user id somewhere or pass

            ViewLoader l = new ViewLoader();
            l.loadViewController(ViewLoader.REGISTER2_URL);
            Stage s = (Stage) this.continueButton.getScene().getWindow();
            s.setScene(l.getView());
        }else{
            //?
        }
    }

    private boolean validateFields(){

        return true;
    }
}
