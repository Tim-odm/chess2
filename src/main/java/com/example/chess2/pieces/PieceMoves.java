package com.example.chess2.pieces;

import com.example.chess2.board.GridHandler;

import java.util.ArrayList;

public class PieceMoves {

    private static int keepBounds(int i) {
        if (i < 0) {
            return 0;
        } else return Math.min(i, 7);
    }
    public static int up(int x, int y) {
        y--;
        y = keepBounds(y);
        return GridHandler.getBoardPosition(x, y);
    }

    public static int down(int x, int y) {
        y++;
        y = keepBounds(y);
        return GridHandler.getBoardPosition(x, y);
    }

    public static int right(int x, int y) {
        x--;
        x = keepBounds(x);
        return GridHandler.getBoardPosition(x, y);
    }

    public static int left(int x, int y) {
        x++;
        x = keepBounds(x);
        return GridHandler.getBoardPosition(x, y);
    }

    public static ArrayList<Integer> straights(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            boardIndexes.add(GridHandler.getBoardPosition(i, y));
        }
        for (int i = 0; i < 8; i++) {
            boardIndexes.add(GridHandler.getBoardPosition(x, i));
        }
        return boardIndexes;
    }

    public static ArrayList<Integer> diagonals(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        boardIndexes.addAll(upLeft(x, y));
        boardIndexes.addAll(downLeft(x, y));
        boardIndexes.addAll(upRight(x, y));
        boardIndexes.addAll(downRight(x, y));
        return boardIndexes;
    }

    private static ArrayList<Integer> upLeft(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while(x >= 0 && y >= 0) {
            boardIndexes.add(GridHandler.getBoardPosition(x, y));
            x--;
            y--;
        }
        return boardIndexes;
    }

    private static ArrayList<Integer> downLeft(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x >= 0 && y <= 7) {
            boardIndexes.add(GridHandler.getBoardPosition(x, y));
            x--;
            y++;
        }
        return boardIndexes;
    }

    private static ArrayList<Integer> upRight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7 && y >= 0) {
            boardIndexes.add(GridHandler.getBoardPosition(x, y));
            x++;
            y--;
        }
        return boardIndexes;
    }

    private static ArrayList<Integer> downRight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7 && y <= 7) {
            boardIndexes.add(GridHandler.getBoardPosition(x, y));
            x++;
            y++;
        }
        return boardIndexes;
    }
}
