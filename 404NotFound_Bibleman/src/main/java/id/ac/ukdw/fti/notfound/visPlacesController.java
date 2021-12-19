package id.ac.ukdw.fti.notfound;


import java.net.URL;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.notfound.database.Database;
import id.ac.ukdw.fti.notfound.modal.Places;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class visPlacesController implements Initializable{

    Database db = new Database();
    
    @FXML
    private AnchorPane visualisasiPlaces;

    @FXML
    private AreaChart<NumberAxis, CategoryAxis> areaChart;

    @FXML
    private CategoryAxis catAxis;

    @FXML
    private NumberAxis numAxis;

    private ObservableList<Places> places = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            places = Database.instance.visPlaces();
            XYChart.Series dataResult = new XYChart.Series();
            dataResult.setName("Places");
            areaChart.setLegendVisible(false);
            for(int i = places.size()-1; i>-0; i--){
                System.out.println(places.get(i).getDisplayTitle());
                System.out.println(places.get(i).getEventsHere().split(",").length);
                dataResult.getData().add(new BarChart.Data(places.get(i).getDisplayTitle(),places.get(i).getEventsHere().split(",").length));
            }
            areaChart.getData().add(dataResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }

    
}
