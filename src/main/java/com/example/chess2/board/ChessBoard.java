package com.example.chess2.board;

import com.example.chess2.Logic.GameLogic;
import com.example.chess2.pieces.ChessPiece;
import com.example.chess2.pieces.King;
import com.example.chess2.pieces.Pawn;
import com.example.chess2.pieces.Queen;

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

        // Add a black pawn
        Pawn bp1 = new Pawn("P", this, logic,
                200, 50, true);
        pieces.add(bp1);

        // Add the white king.
        King wk = new King("WK", this, logic,
                150, 350, false);
        pieces.add(wk);

        // Add the white queen lizzy (RIP).
        Queen wq = new Queen("WQ", this, logic,
                200, 350, false);
        pieces.add(wq);

        // Add a white pawn
        Pawn wp1 = new Pawn("P", this, logic,
                200, 300, false);
        pieces.add(wp1);

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
