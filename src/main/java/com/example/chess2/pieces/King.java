package com.example.chess2.pieces;

import com.example.chess2.Logic.GameLogic;
import com.example.chess2.Logic.PieceMoves;
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
        moves.add(pieceMoves.up(x, y));
        moves.add(pieceMoves.down(x, y));
        moves.add(pieceMoves.left(x, y));
        moves.add(pieceMoves.right(x, y));
        return moves;
    }
}
