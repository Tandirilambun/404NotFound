module notfound{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;

    opens id.ac.ukdw.fti.notfound to javafx.fxml;
    exports id.ac.ukdw.fti.notfound;
    exports id.ac.ukdw.fti.notfound.database;
    exports id.ac.ukdw.fti.notfound.modal;
}
