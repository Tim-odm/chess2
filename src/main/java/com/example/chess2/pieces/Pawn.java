package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Pawn extends ChessPiece {

    public Pawn(String name, AnchorPane anchorPane, GameLogic logic,
                int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, logic, posiX, posiY, isBlack);
    }

    @Override
    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        ArrayList<Integer> moves = new ArrayList<>();
        if (this.isBlack) {
            if (pieceMoves.pawnDown(x,y) != -1) {
                moves.add(pieceMoves.pawnDown(x,y));
                if (this.indexY == 1 && pieceMoves.doubleDown(x,y) != -1)
                    moves.add(pieceMoves.doubleDown(x, y));
            }
            if (pieceMoves.pawnDownRight(x,y) != -1) moves.add(pieceMoves.pawnDownRight(x,y));
            if (pieceMoves.pawnDownLeft(x,y) != -1) moves.add(pieceMoves.pawnDownLeft(x,y));
        } else {
            if (pieceMoves.pawnUp(x,y) != -1) {
                moves.add(pieceMoves.pawnUp(x,y));
                if (this.indexY == 6 && pieceMoves.doubleUp(x,y) != -1)
                    moves.add(pieceMoves.doubleUp(x, y));
            }
            if (pieceMoves.pawnUpLeft(x,y) != -1) moves.add(pieceMoves.pawnUpRight(x,y));
            if (pieceMoves.pawnUpLeft(x,y) != -1) moves.add(pieceMoves.pawnUpLeft(x,y));
        }
        return moves;
    }
}
