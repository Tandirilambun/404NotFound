package id.ac.ukdw.fti.notfound.modal;

import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class visualBar {
    private Rectangle rectangle;
    private Label label;
    
    public visualBar(Rectangle rectangle, Label label) {
        this.rectangle = rectangle;
        this.label = label;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    public Label getLabel() {
        return label;
    }
    public void setLabel(Label label) {
        this.label = label;
    }

}
