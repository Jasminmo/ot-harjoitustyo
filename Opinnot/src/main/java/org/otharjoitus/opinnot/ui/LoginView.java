package org.otharjoitus.opinnot.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.otharjoitus.opinnot.domain.Opiskelija;

public class LoginView extends GridPane {
    private TextField usernameTextField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label messageLabel;
    private Opiskelija opiskelija;

    public LoginView() {
        usernameTextField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button("Kirjaudu");
        messageLabel = new Label("Kirjaudu sisään");

        add(messageLabel, 1, 0, 3, 1);
        add(new Label("käyttäjätunnus"), 0, 1, 1, 1);
        add(usernameTextField, 1, 1, 3, 1);
        add(new Label("salasana"), 0, 2, 1, 1);
        add(passwordField, 1, 2, 3, 1);
        add(loginButton, 2, 3, 1, 1);

        setPrefSize(300, 180);
        setAlignment(Pos.CENTER);
        setVgap(10);
        setHgap(10);
        setPadding(new Insets(20, 20, 20, 20));
    }

    public void login(EventHandler<ActionEvent> loginAction) {
        loginButton.setOnAction(loginAction);
    }

    public String getUsername() {
        return usernameTextField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public void showErrorMessage() {
        messageLabel.setText("Virheellinen käyttäjätunnus tai salasana!");
    }
}