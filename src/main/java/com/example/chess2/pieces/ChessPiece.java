package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;
import com.example.chess2.Logic.PieceMoves;

import javafx.event.EventHandler;
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
     * X position of the piece on the grid in terms of pixels.
     */
    private int posiX; // use get layout

    /**
     * Y position of the piece on the grid in terms of pixels.
     */
    private int posiY; // use get layout

    /**
     *
     */
    private int indexX;

    private int indexY;

    /**
     * Boolean to define if the piece is black or white.
     */
    private boolean isBlack;

    /**
     * Boolean value to define if a piece is currently being selected.
     */
    private boolean isSelected;
    private boolean isInPlay;

    private GameLogic logic;
    protected PieceMoves pieceMoves;

    private ArrayList<Integer> moves;

    ChessPiece(String name, AnchorPane anchorPane, GameLogic logic,
               int posiX, int posiY, boolean isBlack) {
        // Setting the basics
        this.anchorPane = anchorPane;
        this.setWidth(PANE_SIZE);
        this.setHeight(PANE_SIZE);
        this.setLayoutX(posiX);
        this.setLayoutY(posiY);
        this.isBlack = isBlack;
        this.isSelected = false;
        this.indexX = ((posiX/50) % 8);
        this.indexY = ((posiY/50) % 8);
        this.logic = logic;
        this.pieceMoves = logic.getPieceMoves();
        this.isInPlay = false;

        // Initialisations
        rectangle = new Rectangle(0,0, PANE_SIZE, PANE_SIZE);
        text = new Text(name);
        moves = new ArrayList<>();

        // set black or white
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

    public boolean getIsBlack() {
        return this.isBlack;
    }

    public void setIsInPlay (boolean isInPlay) {
        this.isInPlay = isInPlay;
    }

    public boolean getIsInPlay() {
        return this.isInPlay;
    }

    public int getIndexX() {
        return this.indexX;
    }

    public int getIndexY() {
        return this.indexY;
    }

    public Text getText() {
        return this.text;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public ArrayList<Integer> getMoves() {
        return this.moves;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    /**
     * This method handles events for when a piece is clicked on.
     * @return mouseEvent (in lambda form)
     */
    private EventHandler<MouseEvent> clickOnEvent() {
        return mouseEvent -> {
            if (this.isInPlay) {
                int x = (int) ((mouseEvent.getSceneX() / 50) % 8);
                int y = (int) ((mouseEvent.getSceneY() / 50) % 8);
                logic.selectPiece(this, x, y);
                mouseEvent.consume();
           }
        };
    }

    /**
     * This method updates the current position of the piece every time it is
     * moved.
     * @param x The X index position of the piece.
     * @param y The Y index position of the piece.
     */
    public void updateCurrentPosition(int x, int y) {
        this.indexX = x;
        this.indexY = y;
        System.out.println("Current position: " + this.indexX + "," + this.indexY);
    }

    public abstract ArrayList<Integer> getPossibleMoves(int x, int y);
}
