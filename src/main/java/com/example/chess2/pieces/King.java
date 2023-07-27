package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;

import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

/**
 * Class for the Black King.
 * @author Timothy Makoni.
 */
public class King extends ChessPiece {

    public King(String name, AnchorPane anchorPane, GameLogic logic,
                int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, logic, posiX, posiY, isBlack);
    }

    @Override
    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        ArrayList<Integer> moves = new ArrayList<>();
        if (pieceMoves.up(x,y) != -1) moves.add(pieceMoves.up(x, y));
        if (pieceMoves.down(x,y) != -1) moves.add(pieceMoves.down(x, y));
        if (pieceMoves.left(x,y) != -1) moves.add(pieceMoves.left(x, y));
        if (pieceMoves.right(x,y) != -1) moves.add(pieceMoves.right(x, y));
        if (pieceMoves.upRightOne(x,y) != -1) moves.add(pieceMoves.upRightOne(x, y));
        if (pieceMoves.downRightOne(x,y) != -1) moves.add(pieceMoves.downRightOne(x, y));
        if (pieceMoves.upLeftOne(x,y) != -1) moves.add(pieceMoves.upLeftOne(x, y));
        if (pieceMoves.downLeftOne(x,y) != -1) moves.add(pieceMoves.downLeftOne(x, y));
        return moves;
    }
}
