package org.otharjoitus.opinnot.ui;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.otharjoitus.opinnot.dao.FileKurssiDao;
import org.otharjoitus.opinnot.dao.FileOpiskelijaDao;
import org.otharjoitus.opinnot.dao.FileSuoritusDao;

import java.io.FileInputStream;
import java.util.Properties;

public class KurssiSuoritusGUI extends Application {

    private FileKurssiDao kurssiDao;
    private FileOpiskelijaDao opiskelijaDao;
    private FileSuoritusDao suoritusDao;


    private Scene kurssiScene;
    // private Scene uusiOpiskelijaScene;
    // private Scene loginScene;

    @Override
    public void init() throws Exception {
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
        stage.setTitle("Opinnot");

        // main scene
        BorderPane asettelu = new BorderPane();
        Node center = null;
        asettelu.setCenter(center);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
