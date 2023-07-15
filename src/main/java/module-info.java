module com.example.chess2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chess2 to javafx.fxml;
    exports com.example.chess2;
    exports com.example.chess2.pieces;
    opens com.example.chess2.pieces to javafx.fxml;
    exports com.example.chess2.board;
    opens com.example.chess2.board to javafx.fxml;
    exports com.example.chess2.Logic;
    opens com.example.chess2.Logic to javafx.fxml;
}
