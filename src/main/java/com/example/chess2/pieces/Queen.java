package com.example.chess2.pieces;

import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Queen extends ChessPiece{
    public Queen(String name, AnchorPane anchorPane, int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, posiX, posiY, isBlack);
    }

    @Override
    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        ArrayList<Integer> moves = PieceMoves.straights(x, y);
        moves.addAll(PieceMoves.diagonals(x, y));
        return moves;
    }
}
