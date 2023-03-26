module com.example.quality_software_rendu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.testng;
    requires junit;
    requires org.junit.jupiter.api;

    exports fr;
    exports Controller;
    opens Controller to javafx.fxml;
    opens fr to javafx.fxml;
}