module notfound{
    requires javafx.controls;
    requires javafx.fxml;

    opens id.ac.ukdw.fti.notfound to javafx.fxml;
    exports id.ac.ukdw.fti.notfound;
}
