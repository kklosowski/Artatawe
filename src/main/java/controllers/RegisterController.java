package controllers;

import artatawe.Address;
import artatawe.User;
import dataAccessObjects.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

 /**
  *Class for handling the Registration View.
  * @author Marceli Wac
  * @version 1.0
  */
public class RegisterController {

    /**
     *Text for error message.
     */
    @FXML
    private Text errorText;
    
     /**
     *A "Continue" button.
     */
    @FXML
    private Button continueButton;
   
     /**
     *A "Login" button.
     */
    @FXML
    private Button loginButton;
    
    /**
     *Text field for username.
     */
    @FXML
    private TextField usernameTextField;
    /**
     *Text field for first name.
     */
    @FXML
    private TextField firstnameTextField;
    /**
     *Text field for last name.
     */
    @FXML
    private TextField lastnameTextField;
    /**
     *Text field for mobile number.
     */
    @FXML
    private TextField mobileTextField;
    /**
     *Text field for address.
     */
    @FXML
    private TextField address1TextField;
    /**
     *Text field for address.
     */
    @FXML
    private TextField address2TextField;
    /**
     *Text field for address.
     */
    @FXML
    private TextField address3TextField;
    /**
     *Text field for city.
     */
    @FXML
    private TextField cityTextField;
    /**
     *Text field for country.
     */
    @FXML
    private TextField countryTextField;
    /**
     *Text field for postcode.
     */
    @FXML
    private TextField postcodeTextField;


     /**
     *Method for login in the system.
     */
    @FXML
    public void login() {
        ViewLoader l = new ViewLoader();
        l.loadViewController(ViewLoader.LOGIN_URL);
        Stage s = (Stage) this.continueButton.getScene().getWindow();
        s.setScene(l.getView());
    }
    
     /**
     *Method for continuing to the next scene.
     */
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

            SessionStorage.sessionData.put("loggedUser", u);

            ViewLoader l = new ViewLoader();
            l.loadViewController(ViewLoader.REGISTER2_URL);
            Stage s = (Stage) this.continueButton.getScene().getWindow();
            s.setScene(l.getView());
        } else {

        }
    }
     /**
     *Method for showing an error.
     */
    private void showError(String message){
        this.errorText.setText(message);
    }

    /**
     *Method for validating the fields.
     */
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
