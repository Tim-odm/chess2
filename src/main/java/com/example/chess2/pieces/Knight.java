package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Knight extends ChessPiece {
    public Knight(String name, AnchorPane anchorPane, GameLogic logic,
                  int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, logic, posiX, posiY, isBlack);
    }

    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        ArrayList<Integer> moves = new ArrayList<>();
        if (pieceMoves.knightUpRight(x,y) != -1) moves.add(pieceMoves.knightUpRight(x,y));
        if (pieceMoves.knightDownRight(x,y) != -1) moves.add(pieceMoves.knightDownRight(x,y));
        if (pieceMoves.knightUpLeft(x,y) != -1) moves.add(pieceMoves.knightUpLeft(x,y));
        if (pieceMoves.knightDownLeft(x,y) != -1) moves.add(pieceMoves.knightDownLeft(x,y));
        if (pieceMoves.knightLeftDown(x,y) != -1) moves.add(pieceMoves.knightLeftDown(x,y));
        if (pieceMoves.knightLeftUp(x,y) != -1) moves.add(pieceMoves.knightLeftUp(x,y));
        if (pieceMoves.knightRightDown(x,y) != -1) moves.add(pieceMoves.knightRightDown(x,y));
        if (pieceMoves.knightRightUp(x,y) != -1) moves.add(pieceMoves.knightRightUp(x,y));
        return moves;
    }
}
