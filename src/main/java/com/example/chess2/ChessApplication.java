package com.example.chess2;

import com.example.chess2.board.ChessBoard;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new ChessBoard());
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
