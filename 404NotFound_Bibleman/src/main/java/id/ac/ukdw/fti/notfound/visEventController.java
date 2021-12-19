package id.ac.ukdw.fti.notfound;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.notfound.database.Database;
import id.ac.ukdw.fti.notfound.modal.Event;
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

public class visEventController implements Initializable{

    Database db = new Database();
    private ObservableList<Event> events = FXCollections.observableArrayList();

    @FXML
    private AnchorPane visualisasiEvent;
    
    @FXML
    private AreaChart<NumberAxis, CategoryAxis> areaChart;

    @FXML
    private CategoryAxis catAxis;

    @FXML
    private NumberAxis numAxis;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            
            events = Database.instance.visEvent();
            ArrayList<String> listPlace = new ArrayList<String>();
            XYChart.Series dataResult = new XYChart.Series();
            dataResult.setName("Event");
            areaChart.setLegendVisible(false);
            for(int i = events.size()-1; i>-0; i--){
                System.out.println(events.get(i).getPlaces());
                System.out.println(events.get(i).getPlaces().split(",").length);
                dataResult.getData().add(new XYChart.Data(events.get(i).getTitle(),events.get(i).getPlaces().split(",").length));
                
            }
            // System.out.println(listPlace);
            areaChart.getData().add(dataResult);
            // System.out.println(events.size()); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
}
