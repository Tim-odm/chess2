package com.example.chess2.pieces;

import com.example.chess2.board.GridHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

/**
 * Class for the Black King.
 * @author Timothy Makoni.
 */
public class BlackKing extends ChessPiece {

    public BlackKing(String name, AnchorPane anchorPane, int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, posiX, posiY, isBlack);

        this.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> GridHandler.clearBoard());
    }

    @Override
    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        ArrayList<Integer> moves = new ArrayList<>();
        moves.add(PieceMoves.up(x, y));
        moves.add(PieceMoves.down(x, y));
        moves.add(PieceMoves.left(x, y));
        moves.add(PieceMoves.right(x, y));
        return moves;
    }
}
