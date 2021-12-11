package id.ac.ukdw.fti.notfound;

import java.net.URL;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.notfound.database.Database;
import id.ac.ukdw.fti.notfound.modal.Verses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController implements Initializable{
    private ObservableList<Verses> verses = FXCollections.observableArrayList();

    @FXML
    private TextField search;

    @FXML
    private Button cari;

    @FXML
    private TableView<Verses> tabelinfo;

    @FXML
    private TableColumn<Verses, String> ayatColumn;

    @FXML
    private TableColumn<Verses, String> teksColumn;

    @FXML
    private TableColumn<Verses, String> eventColumn;

    @FXML
    void Submit(ActionEvent event) {

    }
    public void initialize(URL location, ResourceBundle resources) {
        verses = Database.instance.getAllVerses();
        ayatColumn.setCellValueFactory(new PropertyValueFactory<Verses, String>("verse"));
        teksColumn.setCellValueFactory(new PropertyValueFactory<Verses, String>("verseText"));
        eventColumn.setCellValueFactory(new PropertyValueFactory<Verses, String>("eventsDescribe"));
        tabelinfo.setItems(verses);
    }

}

