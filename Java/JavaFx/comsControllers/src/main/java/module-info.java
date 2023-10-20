module com.example.comscontrollers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.comscontrollers to javafx.fxml;
    exports com.example.comscontrollers;
}