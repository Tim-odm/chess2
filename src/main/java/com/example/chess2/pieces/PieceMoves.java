package com.example.chess2.pieces;

import com.example.chess2.board.GridHandler;

public class PieceMoves {
    public static int up(int x, int y) {
        return GridHandler.getBoardPosition(x, y-1);
    }

    public static int down(int x, int y) {
        return GridHandler.getBoardPosition(x, y+1);
    }

    public static int right(int x, int y) {
        return GridHandler.getBoardPosition(x-1, y);
    }

    public static int left(int x, int y) {
        return GridHandler.getBoardPosition(x+1, y);
    }
}
