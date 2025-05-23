module com.poligran.bugtracker {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.poligran.bugtracker.vista to javafx.fxml;
    exports com.poligran.bugtracker.vista;
}
