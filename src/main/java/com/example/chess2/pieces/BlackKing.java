package com.example.chess2.pieces;

import com.example.chess2.board.GridHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Class for the Black King.
 * @author Timothy Makoni.
 */
public class BlackKing extends ChessPiece {

    public BlackKing(String name, AnchorPane anchorPane, int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, posiX, posiY, isBlack);

        // Event handler to get possible moves
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            int x = (int) ((mouseEvent.getSceneX()/50) % 8);
            int y = (int) ((mouseEvent.getSceneY()/50) % 8);
            ArrayList<Integer> moves = this.getPossibleMoves(x, y);
            this.highLightMoves(moves);
        });
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

    public void highLightMoves(ArrayList<Integer> moves) {
        for(Integer i: moves) {
            int x = GridHandler.getXCoord(i);
            int y = GridHandler.getYCoord(i);
            Rectangle rectangle = new Rectangle(x*50, y*50, 50,50);
            rectangle.setFill(Color.GREEN);
            anchorPane.getChildren().add(rectangle);
        }
    }
}
