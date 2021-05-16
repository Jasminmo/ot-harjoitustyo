package org.otharjoitus.opinnot.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.otharjoitus.opinnot.dao.FileKurssiDao;
import org.otharjoitus.opinnot.dao.FileOpiskelijaDao;
import org.otharjoitus.opinnot.dao.FileSuoritusDao;
import org.otharjoitus.opinnot.domain.LoginService;
import org.otharjoitus.opinnot.domain.Opiskelija;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KurssiSuoritusGUI extends Application {
    private FileKurssiDao kurssiDao;
    private FileOpiskelijaDao opiskelijaDao;
    private FileSuoritusDao suoritusDao;

    private LoginView loginPane;
    private LoginService loginService;
    private Scene mainScene;

    private boolean isAdmin;
    private Opiskelija opiskelija;

    @Override
    public void init() throws Exception {
        setupDAOs();
        loginService = new LoginService(opiskelijaDao);
    }

    private void setupDAOs() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));

        String opiskelijatTiedosto = properties.getProperty("opiskelijatTiedosto");
        String kurssitTiedosto = properties.getProperty("kurssitTiedosto");
        String suorituksetTiedosto = properties.getProperty("suorituksetTiedosto");

        kurssiDao = new FileKurssiDao(kurssitTiedosto);
        opiskelijaDao = new FileOpiskelijaDao(opiskelijatTiedosto);
        suoritusDao = new FileSuoritusDao(suorituksetTiedosto, kurssiDao, opiskelijaDao);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opintosuoritukset app");
        login(stage);
        //stage.setScene(mainScene);
        stage.show();
    }

    private void login(Stage stage) {
        loginPane = new LoginView();
        loginPane.login(event -> {
            String username = loginPane.getUsername();
            if (!username.equals("admin")) {
                Opiskelija opiskelija = loginService.studentLogin(username, loginPane.getPassword());
                if (opiskelija == null) {
                    loginPane.showErrorMessage();
                } else {
                    this.opiskelija = opiskelija;
                    Scene opiskelijanSuorituksetScene =
                            new Scene(new OpiskelijanSuorituksetView(opiskelija, kurssiDao, suoritusDao));
                    stage.setScene(opiskelijanSuorituksetScene);
                }
            } else {
                HBox hbox = new HBox();
                Button kurssitButton = new Button("Kurssit");
                Button opiskelijatButton = new Button("Opiskelijat");
                Button suorituksetButton = new Button("Suoritukset");

                kurssitButton.setOnAction(e -> stage.setScene(new Scene(new KurssitView(kurssiDao))));
                opiskelijatButton.setOnAction(e -> stage.setScene(new Scene(new OpiskelijatView(opiskelijaDao))));
                suorituksetButton.setOnAction(e -> stage.setScene(new Scene(new SuorituksetView(suoritusDao))));

                hbox.setPadding(new Insets(10, 0, 0, 10));
                hbox.getChildren().addAll(kurssitButton, opiskelijatButton, suorituksetButton);
                Scene adminScene = new Scene(hbox);
                stage.setScene(adminScene);
            }
        });
        stage.setScene(new Scene(loginPane));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
