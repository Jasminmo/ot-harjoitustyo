package org.ot_harjoitus.opinnot.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class KurssiSuoritusUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opinnot");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
