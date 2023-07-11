package com.example.chess2.board;

import com.example.chess2.pieces.BlackKing;
import com.example.chess2.pieces.BlackQueen;
import com.example.chess2.pieces.WhiteKing;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ChessBoard extends AnchorPane {
    private final int GRIDSIZE = 50;

    public ChessBoard() {

        // Initialise DraggableMakerGrid that defines the logic for the grid.
        DraggableMakerGrid draggableMakerGrid = new DraggableMakerGrid(400, 400,
                GRIDSIZE, this);

        // Initialise the grid handler.
        GridHandler backgroundGridHandler = new GridHandler(400, 400,
                GRIDSIZE, this);
        // Draw the grid.
        backgroundGridHandler.updateGrid();

        // Add the black king.
        BlackKing bk = new BlackKing("BK", 100, 0, true);
        this.getChildren().add(bk);
        draggableMakerGrid.makeDraggable(bk);

        // Add the black queen.
        BlackQueen bq = new BlackQueen("BQ", 150, 0, true);
        this.getChildren().add(bq);
        draggableMakerGrid.makeDraggable(bq);

        // Add the white king.
        WhiteKing wk = new WhiteKing("WK", 150, 350, false);
        this.getChildren().add(wk);
        draggableMakerGrid.makeDraggable(wk);
    }
}
