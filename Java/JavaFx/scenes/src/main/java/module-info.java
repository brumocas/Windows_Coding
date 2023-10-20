module com.example.scenes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.scenes to javafx.fxml;
    exports com.example.scenes;
}