module com.example.part5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.part5 to javafx.fxml;
    exports com.example.part5;
}
