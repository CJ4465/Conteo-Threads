module com.mycompany.conteo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.conteo1 to javafx.fxml;
    exports com.mycompany.conteo1;
}
