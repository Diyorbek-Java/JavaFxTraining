module org.example.perexam {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;

    opens org.example.perexam to javafx.fxml;
    exports org.example.perexam;

    opens org.example.perexam.controller to javafx.fxml;
    exports org.example.perexam.controller;
    opens org.example.perexam.models to javafx.base;
}