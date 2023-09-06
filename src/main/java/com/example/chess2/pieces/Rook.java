package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rook extends ChessPiece {
    public Rook(String name, AnchorPane anchorPane, GameLogic logic,
                int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, logic, posiX, posiY, isBlack);
    }

    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        return new ArrayList<>(pieceMoves.straights(x, y));
    }
}
