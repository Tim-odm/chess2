package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;
import com.example.chess2.Logic.PieceMoves;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Queen extends ChessPiece{
    public Queen(String name, AnchorPane anchorPane, GameLogic logic,
                 int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, logic, posiX, posiY, isBlack);
    }

    @Override
    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        ArrayList<Integer> moves = pieceMoves.straights(x, y);
        moves.addAll(pieceMoves.diagonals(x, y));
        return moves;
    }
}
