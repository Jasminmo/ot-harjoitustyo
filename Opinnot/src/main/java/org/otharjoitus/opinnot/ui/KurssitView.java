package org.otharjoitus.opinnot.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.otharjoitus.opinnot.dao.KurssiDao;
import org.otharjoitus.opinnot.domain.Kurssi;

public class KurssitView extends VBox {
    public KurssitView(KurssiDao dao) {
        Label label = new Label("Kurssit");
        label.setFont(new Font("Arial", 20));

        TableView<Kurssi> table = new TableView<>();
        table.setMaxWidth(500);
        table.setEditable(false);
        ObservableList<Kurssi> data = FXCollections.observableArrayList(dao.getAll());

        TableColumn courseCode = new TableColumn("Koodi");
        courseCode.setMinWidth(100);
        courseCode.setCellValueFactory(
                new PropertyValueFactory<Kurssi, String>("koodi"));

        TableColumn name = new TableColumn("Nimi");
        name.setMinWidth(300);
        name.setCellValueFactory(
                new PropertyValueFactory<Kurssi, String>("nimi"));

        TableColumn credits = new TableColumn("Opintopisteet");
        credits.setMinWidth(50);
        credits.setCellValueFactory(
                new PropertyValueFactory<Kurssi, String>("opintopisteet"));

        table.getColumns().addAll(courseCode, name, credits);
        table.setItems(data);

        TextField addCourseCode = new TextField();
        addCourseCode.setPromptText("Koodi");
        addCourseCode.setMaxWidth(courseCode.getPrefWidth());

        TextField addName = new TextField();
        addName.setMaxWidth(name.getPrefWidth());
        addName.setPromptText("Nimi");

        TextField addCredits = new TextField();
        addCredits.setMaxWidth(credits.getPrefWidth());
        addCredits.setPromptText("Opintopisteet");

        Button addButton = new Button("Lisää");
        addButton.setOnAction(e -> {
            try {
                Kurssi k = new Kurssi(
                        addCourseCode.getText(),
                        addName.getText(),
                        Integer.parseInt(addCredits.getText()));
                k = dao.create(k);
                data.add(k);
                addCourseCode.clear();
                addName.clear();
                addCredits.clear();
            } catch (NumberFormatException exception) {
                showErrorMessage("Opintopisteen täytyy olla numeerinen");
            } catch (Exception exception) {
                showErrorMessage(exception.getMessage());
            }
        });

        HBox form = new HBox();

        form.getChildren().addAll(addCourseCode, addName, addCredits, addButton);
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