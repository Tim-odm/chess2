package com.example.chess2.Logic;

import com.example.chess2.board.GridHandler;
import com.example.chess2.pieces.ChessPiece;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

/**
 * This class handles interactions between game elements, namely the pieces and
 * the board.
 */
public class GameLogic {
    private final int GRID_SIZE = 50;
    private AnchorPane chessBoard;
    private boolean isPieceInPlay;
    private boolean blackInPlay;
    private final GridHandler gridHandler;
    private final PieceMoves pieceMoves;
    private ChessPiece pieceInPlay;
    private ArrayList<Integer> possibleMoves;
    private ArrayList<ChessPiece> pieces;

    public GameLogic(GridHandler gridHandler, AnchorPane chessBoard) {
        this.chessBoard = chessBoard;
        this.gridHandler = gridHandler;
        this.pieceMoves = new PieceMoves(this);
        this.isPieceInPlay = false;
        this.possibleMoves = new ArrayList<>();
        this.pieces = new ArrayList<>();
        this.blackInPlay = false;
    }

    public void setPieces(ArrayList<ChessPiece> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<ChessPiece> getPieces() {
        return this.pieces;
    }

    public PieceMoves getPieceMoves() {
        return this.pieceMoves;
    }
    public GridHandler getGridHandler() {
        return this.gridHandler;
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
                // Check for a potential capture
                if (checkPotentialCapture(x, y)) {
                    ChessPiece capturedPiece = getByIndex(x, y);
                    chessBoard.getChildren().remove(capturedPiece);
                    pieces.remove(capturedPiece);
                }
                pieceInPlay.setLayoutX(x * GRID_SIZE);
                pieceInPlay.setLayoutY(y * GRID_SIZE);
                pieceInPlay.updateCurrentPosition(x, y);
                this.switchPlay();
            }
            this.gridHandler.clearBoard();
            this.isPieceInPlay = false;
            this.pieceInPlay = null;
        } else {
            gridHandler.clearBoard();
        }
    }

    private boolean checkPotentialMove(int x, int y) {
        return possibleMoves.contains(gridHandler.getBoardPosition(x, y));
    }

    private boolean checkPotentialCapture(int x, int y) {
        // Loop through all the pieces on the board.checking if any piece is on
        // position x,y.
        for (ChessPiece piece: pieces) {
            if (this.pieceInPlay.getIsBlack() != piece.getIsBlack()) {
                if (piece.getIndexX() == x && piece.getIndexY() == y) {
                    return true;
                }
            }
        }
        return false;
    }

    private ChessPiece getByIndex(int x, int y) {
        for (ChessPiece piece: pieces) {
            if (piece.getIndexX() == x && piece.getIndexY() == y) {
                return piece;
            }
        }
        return null;
    }

    public void initialise() {
        for (ChessPiece piece: this.pieces) {
            if (!piece.getIsBlack()) {
                piece.setIsInPlay(true);
            }
        }
    }

    public void switchPlay() {
        // this.blackInPlay = !this.blackInPlay;
        for (ChessPiece piece: pieces) {
            piece.setIsInPlay(!piece.getIsInPlay());
        }
    }

    public boolean pieceInPosition(int x, int y) {
        for (ChessPiece piece: pieces) {
            if (piece.getIndexX() == x) {
                if (piece.getIndexY() == y) {
                    return true;
                }
            }
        }
        return false;
    }
 }
