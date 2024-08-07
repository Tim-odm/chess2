package com.example.chess2.board;

import com.example.chess2.Logic.GameLogic;
import com.example.chess2.pieces.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

/**
 * This class is the node on which the game takes place. It is also responsible for
 * handling game logic.
 */
public class ChessBoard extends AnchorPane {
    /**
     * Grid size variable storing the size of one square on the board.
     */
    private final int GRID_SIZE = 50;

    /**
     * An ArrayList of pieces.
     */
    private ArrayList<ChessPiece> pieces;

    private GameLogic logic;

    public ChessBoard() {
        // Initialise the grid handler. Draw our grid here.
        GridHandler backgroundGridHandler = new GridHandler(400, 400,
                GRID_SIZE, this);

        // Initialise DraggableMakerGrid that sets the behaviours of objects on the grid.
        DraggableMakerGrid draggableMakerGrid = new DraggableMakerGrid(400, 400,
                GRID_SIZE, this);

        // Draw the grid.
        backgroundGridHandler.updateGrid();
        // backgroundGridHandler.makePlayable();

        // Initialise the GameLogic object
        this.logic = new GameLogic(backgroundGridHandler, this);

        pieces = new ArrayList<>();
        // Add the black king.
        King bk = new King("BK", this, logic,
                150, 0, true);
        pieces.add(bk);

        // Add the black queen.
        Queen bq = new Queen("BQ", this, logic,
                200, 0, true);
        pieces.add(bq);

        // Add a black knight;
        Knight bknight1 = new Knight("BKn", this, logic,
                300, 0, true);
        pieces.add(bknight1);

        // Add a black knight;
        Knight bknight2 = new Knight("BKn", this, logic,
                50, 0, true);
        pieces.add(bknight2);

        // Add a black bishop
        Bishop blackBishop1 = new Bishop("BB", this, logic,
                100, 0, true);
        pieces.add(blackBishop1);

        // Add a black bishop
        Bishop blackBishop2 = new Bishop("BB", this, logic,
                250, 0, true);
        pieces.add(blackBishop2);

        // Add the rooks
        Rook blackRook1 = new Rook("BR", this, logic,
                0,0, true);
        pieces.add(blackRook1);

        Rook blackRook2 = new Rook("BR", this, logic,
                350,0, true);
        pieces.add(blackRook2);

        // Add all black pawns
        for (int i = 0; i < 8; i++) {
            Pawn bp = new Pawn("P", this, logic,
                    i*50, 50, true);
            bp.setIsPawn(true);
            pieces.add(bp);
        }

        // Add the white king.
        King wk = new King("WK", this, logic,
                150, 350, false);
        pieces.add(wk);

        // Add the white queen lizzy (RIP).
        Queen wq = new Queen("WQ", this, logic,
                200, 350, false);
        pieces.add(wq);

        // Add a white knight;
        Knight wknight1 = new Knight("WKn", this, logic,
                300, 350, false);
        pieces.add(wknight1);

        Knight whiteKnight2 = new Knight("WKn", this, logic,
                50, 350, false);
        pieces.add(whiteKnight2);

        // Add a white bishop
        Bishop whiteBishop1 = new Bishop("WB", this, logic,
                100, 350, false);
        pieces.add(whiteBishop1);

        Bishop whiteBishop2 = new Bishop("WB", this, logic,
                250, 350, false);
        pieces.add(whiteBishop2);

        // Add the white rooks
        Rook whiteRook1 = new Rook("WR", this, logic,
                0,350, false);
        pieces.add(whiteRook1);

        Rook whiteRook2 = new Rook("WR", this, logic,
                350,350, false);
        pieces.add(whiteRook2);

        // Add all white pawns
        for (int i = 0; i < 8; i++) {
            Pawn p = new Pawn("P", this, logic,
                    i*50, 300, false);
            p.setIsPawn(true);
            pieces.add(p);
        }

        logic.setPieces(pieces);
        logic.initialise();
        this.getChildren().addAll(pieces);

        draggableMakerGrid.makeDraggable(pieces);

        // Add an event handler for the board that clears it whenever it is clicked.
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onMouseClicked);
    }

    private void onMouseClicked(MouseEvent event) {
        this.logic.boardClickedEvent(event);
    }
}
