module com.uniquindio.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uniquindio.parcial2 to javafx.fxml;
    exports com.uniquindio.parcial2;
    exports com.uniquindio.parcial2.controllerView;
    opens com.uniquindio.parcial2.controllerView to javafx.fxml;
}