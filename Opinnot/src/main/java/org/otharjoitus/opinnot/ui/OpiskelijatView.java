package org.otharjoitus.opinnot.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.otharjoitus.opinnot.dao.OpiskelijaDao;
import org.otharjoitus.opinnot.domain.Opiskelija;

public class OpiskelijatView extends VBox {
    public OpiskelijatView(OpiskelijaDao dao) {
        Label label = new Label("Opiskelijat");
        label.setFont(new Font("Arial", 20));

        TableView<Opiskelija> table = new TableView<>();
        table.setMaxWidth(500);
        table.setEditable(false);
        ObservableList<Opiskelija> data = FXCollections.observableArrayList(dao.getAll());

        TableColumn number = new TableColumn("Tunnus");
        number.setMinWidth(100);
        number.setCellValueFactory(new PropertyValueFactory<Opiskelija, String>("tunnus"));

        TableColumn name = new TableColumn("Nimi");
        name.setMinWidth(300);
        name.setCellValueFactory(new PropertyValueFactory<Opiskelija, String>("nimi"));

        TableColumn email = new TableColumn("Sähköposti");
        email.setMinWidth(50);
        email.setCellValueFactory(new PropertyValueFactory<Opiskelija, String>("sahkoposti"));

        table.getColumns().addAll(number, name, email);
        table.setItems(data);

        setSpacing(5);
        setPadding(new Insets(10, 0, 0, 10));
        getChildren().addAll(label, table);
    }

}