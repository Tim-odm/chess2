module com.example.chess2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chess2 to javafx.fxml;
    exports com.example.chess2;
}
