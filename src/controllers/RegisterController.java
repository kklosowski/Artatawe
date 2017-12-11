package controllers;

import artatawe.Address;
import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private Text errorText;
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
    private TextField address1TextField;
    @FXML
    private TextField address2TextField;
    @FXML
    private TextField address3TextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField countryTextField;
    @FXML
    private TextField postcodeTextField;



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
            Address a = new Address(address1TextField.getText(),
                    address2TextField.getText(),
                    address3TextField.getText(),
                    cityTextField.getText(),
                    postcodeTextField.getText().toUpperCase(),
                    countryTextField.getText());

            User u = new User(firstnameTextField.getText(),
                    lastnameTextField.getText(),
                    usernameTextField.getText(),
                    mobileTextField.getText(), a);

            SessionStorage.loggedUser = u;

            ViewLoader l = new ViewLoader();
            l.loadViewController(ViewLoader.REGISTER2_URL);
            Stage s = (Stage) this.continueButton.getScene().getWindow();
            s.setScene(l.getView());
        } else {

        }
    }

    private void showError(String message){
        this.errorText.setText(message);
    }

    private boolean validateFields() {
        if (!InputValidator.validUsername(usernameTextField.getText())) {
            showError("Username invalid");
            return false;
        }
        if (!InputValidator.validName(firstnameTextField.getText())) {
            showError("First name invalid");
            return false;
        }
        if (!InputValidator.validName(lastnameTextField.getText())) {
            showError("Last name invalid");
            return false;
        }
        if (!InputValidator.validMobile(mobileTextField.getText())) {
            showError("Mobile number invalid");
            return false;
        }
        if (!InputValidator.validAddress(address1TextField.getText())) {
            showError("Address line 1 invalid");

            return false;
        }
        if (!InputValidator.validText(address2TextField.getText())) {
            showError("Address line 2 invalid");

            return false;
        }
        if (!InputValidator.validText(address3TextField.getText())) {
            showError("Address line 3 invalid");

            return false;
        }
        if (!InputValidator.validCity(cityTextField.getText())) {
            showError("City invalid");
            return false;
        }
        if (!InputValidator.validCountry(countryTextField.getText())) {
            showError("Country invalid");
            return false;
        }
        if (!InputValidator.validPostcode(postcodeTextField.getText().toUpperCase())) {
            showError("Postcode invalid");
            return false;
        }
        return true;
    }
}
