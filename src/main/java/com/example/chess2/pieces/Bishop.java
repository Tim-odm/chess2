package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Bishop extends ChessPiece {

    public Bishop (String name, AnchorPane anchorPane, GameLogic logic,
                   int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, logic, posiX, posiY, isBlack);
    }

    @Override
    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        return new ArrayList<>(pieceMoves.diagonals(x,y));
    }
}
