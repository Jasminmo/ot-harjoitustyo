package org.otharjoitus.opinnot.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.otharjoitus.opinnot.dao.FileKurssiDao;
import org.otharjoitus.opinnot.dao.FileSuoritusDao;
import org.otharjoitus.opinnot.domain.Kurssi;
import org.otharjoitus.opinnot.domain.Opiskelija;
import org.otharjoitus.opinnot.domain.Suoritus;

import java.util.Date;

public class OpiskelijanSuorituksetView extends VBox {
    private final Opiskelija opiskelija;

    public OpiskelijanSuorituksetView(Opiskelija opiskelija, FileKurssiDao kurssiDao, FileSuoritusDao suoritusDao) {
        this.opiskelija = opiskelija;

        Label label = new Label("Suoritukset");
        label.setFont(new Font("Arial", 20));

        TableView<Suoritus> table = new TableView<>();
        table.setMaxWidth(500);
        table.setEditable(false);
        ObservableList<Suoritus> data = FXCollections.observableArrayList(suoritusDao.getOpiskelijanSuoritukset(opiskelija.getTunnus()));

        TableColumn courseCode = new TableColumn("Kurssi");
        courseCode.setMinWidth(200);
        courseCode.setCellValueFactory(new PropertyValueFactory<Suoritus, String>("kurssiNimi"));

        TableColumn date = new TableColumn("Suoritushetki");
        date.setMinWidth(50);
        date.setCellValueFactory(new PropertyValueFactory<Suoritus, Date>("suoritusHetki"));

        TableColumn grade = new TableColumn("Arvosana");
        grade.setMinWidth(50);
        grade.setCellValueFactory(new PropertyValueFactory<Suoritus, Integer>("arvosana"));

        TableColumn credits = new TableColumn("Opintopisteet");
        credits.setMinWidth(50);
        credits.setCellValueFactory(new PropertyValueFactory<Suoritus, Integer>("opintopisteet"));

        table.getColumns().addAll(courseCode, date, credits, grade);
        table.setItems(data);

        TextField addCourseCode = new TextField();
        addCourseCode.setPromptText("Koodi");
        addCourseCode.setMaxWidth(courseCode.getPrefWidth());

        TextField addGrade = new TextField();
        addGrade.setMaxWidth(credits.getPrefWidth());
        addGrade.setPromptText("Arvosana");

        Button addButton = new Button("Lisää");
        addButton.setOnAction(e -> {
            try {
                Kurssi kurssi = kurssiDao.findByKoodi(addCourseCode.getText());
                Suoritus s = new Suoritus(
                        kurssi,
                        opiskelija,
                        Integer.parseInt(addGrade.getText()));
                s = suoritusDao.create(s);
                data.add(s);
                addCourseCode.clear();
                addGrade.clear();
            } catch (NumberFormatException exception) {
                showErrorMessage("Arvosanan täytyy olla numeerinen");
            } catch (Exception exception) {
                showErrorMessage(exception.getMessage());
            }
        });

        HBox form = new HBox();

        form.getChildren().addAll(addCourseCode, addGrade, addButton);
        form.setSpacing(3);

        setSpacing(5);
        setPadding(new Insets(10, 0, 0, 10));
        getChildren().addAll(label, table, form);
    }

    private void showErrorMessage(String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(message);
        a.show();
    }
}