package com.example.chess2.board;

import com.example.chess2.ChessApplication;
import com.example.chess2.pieces.ChessPiece;
import com.example.chess2.pieces.King;
import com.example.chess2.pieces.Queen;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class ChessBoard extends AnchorPane {
    /**
     * Grid size variable storing the size of one square on the board.
     */
    private final int GRIDSIZE = 50;

    /**
     *
     */
    private static ArrayList<ChessPiece> pieces;

    public ChessBoard() {

        // Initialise DraggableMakerGrid that defines the logic for the grid.
        DraggableMakerGrid draggableMakerGrid = new DraggableMakerGrid(400, 400,
                GRIDSIZE, this);

        // Initialise the grid handler.
        GridHandler backgroundGridHandler = new GridHandler(400, 400,
                GRIDSIZE, this);
        // Draw the grid.
        backgroundGridHandler.updateGrid();

        pieces = new ArrayList<>();
        // Add the black king.
        King bk = new King("BK", this, 150, 0, true);
        pieces.add(bk);

        // Add the black queen.
        Queen bq = new Queen("BQ", this, 200, 0, true);
        pieces.add(bq);

        // Add the white king.
        King wk = new King("WK", this, 150, 350, false);
        pieces.add(wk);

        Queen wq = new Queen("WQ", this, 200, 350, false);
        pieces.add(wq);

        this.getChildren().addAll(pieces);

        draggableMakerGrid.makeDraggable(pieces);

        // Add an event handler for the board that clears it whenever it is clicked.
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, clearBoard());
    }

    /**
     * This method clears the board and unselects any selected pieces.
     * @return As above.
     */
    private EventHandler<MouseEvent> clearBoard() {
        return mouseEvent -> {
            GridHandler.clearBoard();
            for (ChessPiece piece: pieces) {
                if (piece.getIsSelected()) {
                    System.out.println(piece.getText().getText() + " was selected");
                    piece.setIsSelected(false);
                }
            }
        };
    }

    public static void unselectAll() {
        GridHandler.clearBoard();
        for (ChessPiece piece: pieces) {
            piece.setIsSelected(false);
        }
    }
}
