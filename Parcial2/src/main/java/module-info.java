module com.uniquindio.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uniquindio.parcial2 to javafx.fxml;
    exports com.uniquindio.parcial2;
}