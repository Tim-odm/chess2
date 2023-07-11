package com.example.chess2.pieces;

import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class BlackQueen extends ChessPiece{
    public BlackQueen(String name, AnchorPane anchorPane, int posiX, int posiY, boolean isBlack) {
        super(name, anchorPane, posiX, posiY, isBlack);
    }

    @Override
    public ArrayList<Integer> getPossibleMoves(int x, int y) {
        return null;
    }

    @Override
    public void highLightMoves(ArrayList<Integer> moves) {

    }
}
