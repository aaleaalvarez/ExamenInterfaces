module org.example.examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens org.example.examen to javafx.fxml;
    exports org.example.examen;
}