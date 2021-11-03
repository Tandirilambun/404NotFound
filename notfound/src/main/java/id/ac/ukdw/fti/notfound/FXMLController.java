package id.ac.ukdw.fti.notfound;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FXMLController {

    private String textDisplay;

    @FXML
    private TextField textfield;

    @FXML
    private Button submitButton;

    @FXML
    private Text text;

    @FXML
    void submit(ActionEvent event) {
        textDisplay = textfield.getText().trim();
        text.setText(textDisplay);
    }

}
