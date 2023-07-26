package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Pawn extends ChessPiece {
    private int startX;
    private int startY;

    public Pawn(String name, AnchorPane anchorPane, GameLogic logic,
                int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, logic, posiX, posiY, isBlack);
    }

    @Override
    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        ArrayList<Integer> moves = new ArrayList<>();
        // Program Double move
        if (this.isBlack) {
            if (this.indexY == 1) {
                moves.add(pieceMoves.doubleDown(x, y));
            }
            moves.add(pieceMoves.down(x,y));
        } else {
            if (this.indexY == 6) {
                moves.add(pieceMoves.doubleUp(x, y));
            }
            moves.add(pieceMoves.up(x,y));
        }
        return moves;
    }
}
