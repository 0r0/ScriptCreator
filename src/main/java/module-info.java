module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi.ooxml;
    requires poi;

    opens org.example to javafx.fxml;
    exports org.example;
}