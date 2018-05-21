package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name_Register_field;

    @FXML
    private TextField surname_Register_field;

    @FXML
    private TextField login_Register_field;

    @FXML
    private PasswordField password_Register_field;

    @FXML
    private Button RegisterSignUpButton;

    @FXML
    void initialize() {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        RegisterSignUpButton.setOnAction(event -> {
            dataBaseHandler.signUpUser(name_Register_field.getText(), surname_Register_field.getText(),
                    login_Register_field.getText(), password_Register_field.getText());
        });

    }

//    private void signUpNewUser() {
//        DataBaseHandler dbHandler = new DataBaseHandler();
//        String firstName = name_Register_field.getText();
//        String lastName = surname_Register_field.getText();
//        String login = login_Register_field.getText();
//        String password = password_Register_field.getText();
//
//        User user = new User(firstName, lastName, login, password);
//
//        dbHandler.signUpUser(user);
//
//    }
}
