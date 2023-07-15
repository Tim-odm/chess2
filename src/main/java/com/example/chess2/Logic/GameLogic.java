package com.example.chess2.Logic;

import com.example.chess2.board.GridHandler;
import com.example.chess2.pieces.ChessPiece;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * This class handles interactions between game elements, namely the pieces and
 * the board.
 */
public class GameLogic {
    private final int GRID_SIZE = 50;
    private boolean isPieceInPlay;
    private final GridHandler gridHandler;
    private final PieceMoves pieceMoves;
    private ChessPiece pieceInPlay;
    private ArrayList<Integer> possibleMoves;

    public GameLogic(GridHandler gridHandler, PieceMoves pieceMoves) {
        this.gridHandler = gridHandler;
        this.pieceMoves = pieceMoves;
        this.isPieceInPlay = false;
        possibleMoves = new ArrayList<>();
    }

    public PieceMoves getPieceMoves() {
        return this.pieceMoves;
    }


    public void selectPiece(ChessPiece piece, int x, int y) {
        gridHandler.clearBoard();
        // Set the selected to piece to true
        // piece.setIsSelected(true);
        this.isPieceInPlay = true;
        this.pieceInPlay = piece;

        // get the possible moves of the piece.
        possibleMoves =
                new ArrayList<>(piece.getPossibleMoves(x, y));

        // Highlight the piece's possible moves.
        gridHandler.highlightMoves(possibleMoves);
    }

    public void boardClickedEvent(MouseEvent event) {
        if (isPieceInPlay) {
            int x = (int) ((event.getSceneX() / GRID_SIZE));
            int y = (int) ((event.getSceneY() / GRID_SIZE));
            if (checkPotentialMove(x, y)) {
                // Move the piece in play
                pieceInPlay.setLayoutX(x * GRID_SIZE);
                pieceInPlay.setLayoutY(y * GRID_SIZE);
                pieceInPlay.updateCurrentPosition(x, y);
                gridHandler.clearBoard();
            } else {
                this.isPieceInPlay = false;
                this.pieceInPlay = null;
                gridHandler.clearBoard();
            }
        } else {
            gridHandler.clearBoard();
        }
    }

    private boolean checkPotentialMove(int x, int y) {
        return possibleMoves.contains(gridHandler.getBoardPosition(x, y));
    }
}
