module com.example.imageview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.imageview to javafx.fxml;
    exports com.example.imageview;
}