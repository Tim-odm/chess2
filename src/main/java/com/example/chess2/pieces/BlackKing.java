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

    public BlackKing(String name, int posiX, int posiY, boolean isBlack) {
        super(name, posiX, posiY, isBlack);
    }
}
