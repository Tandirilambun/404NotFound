package id.ac.ukdw.fti.notfound;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import id.ac.ukdw.fti.notfound.database.Database;
import id.ac.ukdw.fti.notfound.modal.Verses;
import id.ac.ukdw.fti.notfound.modal.VisualMethod;
import id.ac.ukdw.fti.notfound.modal.visualBar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EventController implements Initializable {

    Database db = new Database();

    @FXML
    private Text app_title;
    
    @FXML
    private AnchorPane eventPage;

    @FXML
    private TextField searchEventBox;

    @FXML
    private Button searchEvent;

    @FXML
    private ListView<String> viewEvent;

    @FXML
    private Button backButton;

    @FXML
    private Button visButton;
    
    @FXML
    private SplitPane visPane;

    @FXML
    private AnchorPane visPeople;

    @FXML
    private AnchorPane visPlace;


    //Variable goloabl untuk bar visualisasi
    List<Rectangle> rectForPeople = new ArrayList<>();
    List<Label> labelForPeople = new ArrayList<>();
    List<Rectangle> rectForPlaces = new ArrayList<>();
    List<Label> labelForPlaces = new ArrayList<>();

    //Variable Global untuk inisialisasi HashMap
    HashMap<String, Integer> peopleInMap = new HashMap<String, Integer>();
    HashMap<String, Integer> placesInMap = new HashMap<String, Integer>();

    private int peopleCountMap;
    private int placesCountMap;

    //Variable Global untuk BarVisualisasi
    private int xBar = 0;
    private final double maxWidthRect = 174;
    private final int heightRect = 26;
    //untuk Layout Y
    private int YBarPeople = 15;
    private int YBarPlaces = 15;

    //Varaible Global untuk Label Bar visualisasi
    private final int layoutXbarPeople = 45;
    private final int layoutXbarPlaces = 45;
    private int layoutYbarPeople = 19;
    private int layoutYbarPlaces = 19;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void backToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bibleman_ui.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        scene.setRoot(root);
        stage.setTitle("Tutorial RPL Main Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void visEvent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("visEvent.fxml"));
        
        Stage stage = new Stage(StageStyle.DECORATED);
        Scene scene = new Scene(root);

        scene.setRoot(root);
        stage.setTitle("Visualisasi Event");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void submit(ActionEvent event) {
        peopleCountMap = 0;
        placesCountMap = 0;

        rectForPeople.clear();
        rectForPlaces.clear();

        labelForPeople.clear();
        labelForPlaces.clear();

        peopleInMap.clear();
        placesInMap.clear();

        YBarPeople = 15;
        YBarPlaces = 15;
        layoutYbarPeople = 19;
        layoutYbarPlaces = 19;


        String cari = searchEventBox.getText().toLowerCase();
        // cari = cari.replace(" ", "-");
        System.out.println(cari);
        ArrayList<Verses> getSearch = db.searchEvent(cari);
        ObservableList<String> hasilCariEvent = FXCollections.observableArrayList();
        for(Verses isiCari : getSearch){
            hasilCariEvent.add(isiCari.getOsisRef()+"\n"+isiCari.getVerseText()+"\n");
            System.out.println(isiCari.getOsisRef() + isiCari.getVerseText());
            tambahItem(isiCari.getOsisRef());
        }
        // System.out.println(peopleInMap.size()+" aslcnoevnoiaw");
        viewEvent.setItems(hasilCariEvent);

        Map<String, Integer> sortPeopleMap = sortByValue(peopleInMap);
        Map<String, Integer> sortPlacesMap = sortByValue(placesInMap);
        
        //
        List<Map.Entry<String, Integer>> hitungPeopleMap = new LinkedList<Map.Entry<String, Integer>>(sortPeopleMap.entrySet());
        List<Map.Entry<String, Integer>> hitungPlacesMap = new LinkedList<Map.Entry<String, Integer>>(sortPlacesMap.entrySet());

        //perulangan untuk menghitung jumlah yang ada dalam peopleCount
        for (Map.Entry<String, Integer> countPeople: hitungPeopleMap){
            peopleCountMap += countPeople.getValue();
        }
        
        //perulangan untuk menghitung jumlah yang ada dalam placesCount 
        for (Map.Entry<String, Integer> countPlaces: hitungPlacesMap){
            placesCountMap += countPlaces.getValue();
        }

        //perulangan untuk membuat Bar Visualisasi

        // List<Map.Entry<String, Integer>> barPeople = new LinkedList<Map.Entry<String, Integer>>(sortPeopleMap.entrySet());
        // List<Map.Entry<String, Integer>> barPlaces = new LinkedList<Map.Entry<String, Integer>>(sortPlacesMap.entrySet());

        //perulangan untuk menghitung jumlah yang ada dalam peopleCount
        for (Map.Entry<String, Integer> countPeople: hitungPeopleMap){
            visualBar barPeople = createBarPeople(countPeople.getKey(), countPeople.getValue(), peopleCountMap);
            rectForPeople.add(barPeople.getRectangle());
            labelForPeople.add(barPeople.getLabel());
        }
                
        //perulangan untuk menghitung jumlah yang ada dalam placesCount 
        for (Map.Entry<String, Integer> countPlaces: hitungPlacesMap){
            visualBar barPlaces = createBarPlaces(countPlaces.getKey(), countPlaces.getValue(), placesCountMap);
            rectForPlaces.add(barPlaces.getRectangle());
            labelForPlaces.add(barPlaces.getLabel());
        }

        visPlace.getChildren().clear();
        visPlace.getChildren().addAll(rectForPlaces);
        visPlace.getChildren().addAll(labelForPlaces);

        visPeople.getChildren().clear();;
        visPeople.getChildren().addAll(rectForPeople);
        visPeople.getChildren().addAll(labelForPeople);


    }

    //Method untuk menambahkan item people dan places ke dalam Map
    public void tambahItem(String cari){
        VisualMethod vm = db.visualData(cari);
        //try pertama untuk menambahkan people
        try {
            System.out.println(vm.getPeopleCount());
            if(vm.getPeopleCount() > 1){
                String[] splitPeople = vm.getPeople().split(",");
                for (String j : splitPeople){
                    try {
                        
                        peopleInMap.put(j, peopleInMap.get(j)+1);
                        peopleInMap.remove(null);
                    } catch (Exception e) {
                        
                        peopleInMap.put(j, 1);
                        peopleInMap.remove(null);
                    } 
                }
            }
            else{
                try {
                    // System.out.println("aaaaaaaaaaaaa");
                    peopleInMap.put(vm.getPeople(), peopleInMap.get(vm.getPeople())+1);
                    peopleInMap.remove(null);
                } catch (Exception e) {
                    peopleInMap.put(vm.getPeople(),+1);
                    peopleInMap.remove(null);
                }
            }
        } catch (Exception e) {
            // System.out.println(vm.getPeopleCount()+ " orang");
            System.out.println(e.getMessage());
        }
        //try kedua untuk menambahkan places
        try {
            if(vm.getPlacesCount() > 1){
                String[] splitPlaces = vm.getPlaces().split(",");
                for (String j : splitPlaces){
                    try {
                        placesInMap.put(j, placesInMap.get(j)+1);
                        placesInMap.remove(null);
                    } catch (Exception e) {
                        placesInMap.put(j, 1);
                        placesInMap.remove(null);
                    } 
                }
            }
            else{
                try {
                    placesInMap.put(vm.getPlaces(), placesInMap.get(vm.getPlaces())+1);
                    placesInMap.remove(null);
                } catch (Exception e) {
                    placesInMap.put(vm.getPlaces(),+1);
                    placesInMap.remove(null);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public visualBar createBarPeople (String id, double countPeople, double countAll){
        double width = (countPeople/countAll) * maxWidthRect;
        String namaPeople = db.ambilNamaPeople(id);
        Label label = new Label(namaPeople + "=" + (int) countPeople);
        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(width);
        rectangle.setHeight(heightRect);
        rectangle.setFill(Color.RED);

        rectangle.setY(YBarPeople);
        label.setLayoutY(layoutYbarPeople);
        label.setLayoutX(layoutXbarPeople);
        YBarPeople += 35;
        layoutYbarPeople += 35;

        visualBar bar = new visualBar(rectangle, label);
        return bar;
    }

    public visualBar createBarPlaces (String id, double countPlaces, double countAll){
        double width = (countPlaces/countAll) * maxWidthRect;
        String namaPlaces = db.ambilNamaPlaces(id);
        Label label = new Label(namaPlaces + "=" + (int) countPlaces);
        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(width);
        rectangle.setHeight(heightRect);
        rectangle.setFill(Color.AQUA);

        rectangle.setY(YBarPlaces);
        label.setLayoutY(layoutYbarPlaces);
        label.setLayoutX(layoutXbarPlaces);
        YBarPlaces += 35;
        layoutYbarPlaces += 35;

        visualBar bar = new visualBar(rectangle, label);
        return bar;
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Verses> getVerses = db.getAllVerses();
        ObservableList<String> hasilVerses = FXCollections.observableArrayList();

        for(Verses isiVerses: getVerses){
            hasilVerses.add(isiVerses.getOsisRef()+"\n"+isiVerses.getVerseText()+"\n");
        }
        viewEvent.setItems(hasilVerses);
        
        
    }

    //sorting By Value on HashMap, source from Geeks for Geeks
    //https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    

}

