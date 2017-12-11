package controllers;

import artatawe.Address;
import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private Button continueButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField mobileTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField postcodeTextField;

    private String userName;
    private String firstName;
    private String lastName;
    private String mobile;
    private String address;
    private String postcode;


    @FXML
    public void login() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.LOGIN_URL);
        Stage s = (Stage) this.continueButton.getScene().getWindow();
        s.setScene(l.getView());
    }

    @FXML
    public void attemptContinue(){
        if(validateFields()){
            //Address a = new Address("address")
            User u = new User(firstName, lastName, userName, mobile, null, postcode);

            //store user id somewhere or pass

            ViewLoader l = new ViewLoader();
            l.loadViewController(ViewLoader.REGISTER2_URL);
            Stage s = (Stage) this.continueButton.getScene().getWindow();
            s.setScene(l.getView());
        } else {
            //?
        }
    }

    private boolean validateFields() {

        return InputValidator.validUsername(usernameTextField.getText()) &&
                InputValidator.validText(firstnameTextField.getText()) &&
                InputValidator.validText(lastnameTextField.getText()) &&
                InputValidator.validNumber(mobileTextField.getText()) &&
                InputValidator.validText(addressTextField.getText()) &&
                InputValidator.validPostcode(postcodeTextField.toString());

    }
}
