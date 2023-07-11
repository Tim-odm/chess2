package com.example.chess2.board;

import com.example.chess2.pieces.BlackKing;
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
        BlackKing bk = new BlackKing(200, 200);
        this.getChildren().add(bk);
        draggableMakerGrid.makeDraggable(bk);
    }
}
