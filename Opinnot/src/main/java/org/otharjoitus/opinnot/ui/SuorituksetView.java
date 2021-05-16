package org.otharjoitus.opinnot.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import org.otharjoitus.opinnot.dao.FileKurssiDao;
import org.otharjoitus.opinnot.dao.FileOpiskelijaDao;
import org.otharjoitus.opinnot.dao.FileSuoritusDao;
import org.otharjoitus.opinnot.dao.KurssiDao;
import org.otharjoitus.opinnot.domain.Kurssi;
import org.otharjoitus.opinnot.domain.Opiskelija;
import org.otharjoitus.opinnot.domain.Suoritus;

import java.util.Date;

public class SuorituksetView extends VBox {

    public SuorituksetView(FileSuoritusDao suoritusDao) {
        Label label = new Label("Suoritukset");
        label.setFont(new Font("Arial", 20));

        TableView<Suoritus> table = new TableView<>();
        table.setMaxWidth(500);
        table.setEditable(false);
        ObservableList<Suoritus> data = FXCollections.observableArrayList(suoritusDao.getAll());

        TableColumn courseCode = new TableColumn("Kurssi");
        courseCode.setMinWidth(200);
        courseCode.setCellValueFactory(new PropertyValueFactory<Suoritus, String>("kurssiNimi"));

        TableColumn name = new TableColumn("Opiskelija");
        name.setMinWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<Suoritus, String>("opiskelijaNimi"));


        TableColumn date = new TableColumn("Suoritushetki");
        date.setMinWidth(50);
        date.setCellValueFactory(new PropertyValueFactory<Suoritus, Date>("suoritusHetki"));

        TableColumn grade = new TableColumn("Arvosana");
        grade.setMinWidth(50);
        grade.setCellValueFactory(new PropertyValueFactory<Suoritus, Integer>("arvosana"));

        table.getColumns().addAll(courseCode, name, date, grade);
        table.setItems(data);

        setSpacing(5);
        setPadding(new Insets(10, 0, 0, 10));
        getChildren().addAll(label, table);
    }
}