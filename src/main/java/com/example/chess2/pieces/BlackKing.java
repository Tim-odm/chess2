package com.example.chess2.pieces;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Class for the Black King.
 * @author Timothy Makoni.
 */
public class BlackKing extends ChessPiece {
    private Rectangle rectangle;
    private Label label;
    private int recX;
    private int recY;
    private int labelX;
    private int labelY;

    public BlackKing(int startX, int startY) {
        this.setLayoutX(startX);
        this.setLayoutY(startY);
        this.setWidth(50);
        this.setHeight(50);
        rectangle = new Rectangle(startX, startY, 50, 50);
        rectangle.setFill(Color.BLACK);
        Text text = new Text("BK");
        text.setFill(Color.WHITE);
        text.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
        this.getChildren().addAll(rectangle, text);
    }
}
