package com.example.chess2.pieces;

import com.example.chess2.board.GridHandler;
import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public abstract class ChessPiece extends StackPane {
    /**
     *
     */
    protected AnchorPane anchorPane;
    /**
     * Size of the pane.
     */
    private final int PANE_SIZE = 50;
    /**
     * Rectangle object to represent the piece.
     */
    private Rectangle rectangle;

    /**
     * Text to identify the piece.
     */
    private Text text;
    /**
     * X position of the piece on the grid.
     */
    private int posiX;

    /**
     * Y position of the piece on the grid.
     */
    private int posiY;

    /**
     * Boolean to define if the piece is black or white.
     */
    private boolean isBlack;

    /**
     *
     */
    private boolean isSelected;

    ChessPiece(String name, AnchorPane anchorPane, int posiX, int posiY, boolean isBlack) {
        this.setWidth(PANE_SIZE);
        this.setHeight(PANE_SIZE);
        this.setLayoutX(posiX);
        this.setLayoutY(posiY);
        rectangle = new Rectangle(0,0, PANE_SIZE, PANE_SIZE);
        text = new Text(name);
        if (isBlack) {
            rectangle.setFill(Color.BLACK);
            text.setFill(Color.WHITE);
        } else {
            rectangle.setFill(Color.WHITE);
            text.setFill(Color.BLACK);
        }
        this.getChildren().addAll(rectangle, text);

        // Event handler for when a piece is clicked on showing possible moves.
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, clickOnEvent());

        // Event handler for when the mouse exits a piece clearing the board.
        // this.addEventHandler(MouseEvent.MOUSE_EXITED, mouseExitedEvent());
    }

    /**
     * This method handles events for when a piece is clicked on.
     * @return mouseEvent (in lambda form)
     */
    private EventHandler<MouseEvent> clickOnEvent() {
        return mouseEvent -> {
            // Set selected to true
            isSelected = true;

            // Get the possible moves
            int x = (int) ((mouseEvent.getSceneX()/50) % 8);
            int y = (int) ((mouseEvent.getSceneY()/50) % 8);
            ArrayList<Integer> moves = getPossibleMoves(x, y);
            GridHandler.highlightMoves(moves);
            mouseEvent.consume();
        };
    }

    private EventHandler<MouseEvent> mouseExitedEvent() {
        return mouseEvent -> {
            GridHandler.clearBoard();
            mouseEvent.consume();
        };
    }

    public abstract ArrayList<Integer> getPossibleMoves(int x, int y);
}
