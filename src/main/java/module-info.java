module com.example.supplychainsayali17 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychainsayali17 to javafx.fxml;
    exports com.example.supplychainsayali17;
}