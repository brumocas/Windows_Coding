module com.guitest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.guitest to javafx.fxml;
    exports com.guitest;
}