module com.example.csssetyling {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.csssetyling to javafx.fxml;
    exports com.example.csssetyling;
}