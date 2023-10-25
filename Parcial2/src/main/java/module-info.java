module com.uniquindio.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens com.uniquindio.parcial2 to javafx.fxml;
    exports com.uniquindio.parcial2;
    exports com.uniquindio.parcial2.controllerView;
    opens com.uniquindio.parcial2.controllerView to javafx.fxml;
    exports com.uniquindio.parcial2.model;


}