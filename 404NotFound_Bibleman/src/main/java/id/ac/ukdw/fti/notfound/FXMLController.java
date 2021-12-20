package id.ac.ukdw.fti.notfound;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.ResourceBundle;


import id.ac.ukdw.fti.notfound.database.Database;
import id.ac.ukdw.fti.notfound.modal.Verses;
import id.ac.ukdw.fti.notfound.modal.tampil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLController implements Initializable{

    Database db = new Database();
    private ObservableList<Verses> verses = FXCollections.observableArrayList();
    
    @FXML
    private Text app_title;
    
    @FXML
    private TextField search_bar;

    @FXML
    private Button search_btn;

    @FXML
    private TableView<Verses> info_table;

    // @FXML
    // private TableColumn<Verses, String> ayat_show;

    // @FXML
    // private TableColumn<Verses, String> text_show;

    // @FXML
    // private TableColumn<Verses, String> event_show;

    // @FXML
    // private TableColumn<Verses, String> place_show;

    // @FXML
    // private TableColumn<Verses, String> graph_show;

    @FXML
    private TableView<?> graph_table;

    @FXML
    private ComboBox<String> book;

    @FXML
    private ComboBox<String> chapter;

    @FXML
    private ComboBox<Integer> verseNum;

    @FXML
    private ListView<String> areaTampil;
    
    @FXML
    private ListView<String> mainShow;

    @FXML
    private Button toEventPage;

    @FXML
    private Button toPlacesPage;

    @FXML
    private Text alertText;

    
    @FXML
    void eventBook(ActionEvent event) {
        String ktb = book.getSelectionModel().getSelectedItem();
        ArrayList<String> getPasal = db.getChapter(ktb);
        ObservableList<String> hasilPasal = FXCollections.observableArrayList();

        for(String isi : getPasal){
            hasilPasal.add(isi);
        }
        chapter.setItems(hasilPasal);
    }

    @FXML
    void eventChapter(ActionEvent event) {
        String chp = chapter.getSelectionModel().getSelectedItem();
        ArrayList<Integer> getAyat = db.getVerseNum(chp);
        ObservableList<Integer> hasilAyat = FXCollections.observableArrayList();

        for(Integer isi2 : getAyat){
            hasilAyat.add(isi2);
        }
        verseNum.setItems(hasilAyat);
    }

    @FXML
    void eventNum(ActionEvent event) {
        String ktb = book.getSelectionModel().getSelectedItem();
        String chp = chapter.getSelectionModel().getSelectedItem();
        Integer ayt = verseNum.getSelectionModel().getSelectedItem();
        try {
            ArrayList<tampil> getTampil = db.getAyat(ktb, chp, ayt);
            ObservableList<String> hasil = FXCollections.observableArrayList();

            for(tampil isi3 : getTampil){
                hasil.add(isi3.getOsisRef()+"\n"+ isi3.getVerseText()+"\n");
                System.out.println(isi3.getOsisRef());
            }
        areaTampil.setItems(hasil);
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void moveToEvent(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("eventTab.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.setRoot(root);
        stage.setTitle("Event");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void moveToPlaces(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("placeTab.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.setRoot(root);
        stage.setTitle("Places");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void search(ActionEvent event) {
        String cari = search_bar.getText();
        ArrayList<Verses> getSearch = db.homeSearch(cari);
        ObservableList<String> hasilCariEvent = FXCollections.observableArrayList();

        for(Verses isiCari : getSearch){
            hasilCariEvent.add(isiCari.getOsisRef()+"\n"+isiCari.getVerseText()+"\n");
        }
        if(hasilCariEvent.size() == 0 ){
            alertText.setText("Hasil tidak ditemukan!");
            alertText.setFill(Color.RED);
            mainShow.setItems(null);
        }else{
            int size = hasilCariEvent.size();
            alertText.setText("Hasil Pencarian untuk '"+cari+"' " + Integer.toString(size)+" hasil");
            alertText.setFill(Color.BLACK);
            mainShow.setItems(hasilCariEvent);
        }
        
    }

    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Verses> getVerses = db.getAllVerses();
        ObservableList<String> hasilVerses = FXCollections.observableArrayList();

        for(Verses isiVerses: getVerses){
            hasilVerses.add(isiVerses.getOsisRef()+"\n"+isiVerses.getVerseText()+"\n");
        }
        mainShow.setItems(hasilVerses);

        
        
        ArrayList<String> getKitab = db.getBook();
        ObservableList<String> hasilKitab = FXCollections.observableArrayList();

        for(String isi : getKitab){
            hasilKitab.add(isi);
        }
        book.setItems(hasilKitab);
        
    }
}

