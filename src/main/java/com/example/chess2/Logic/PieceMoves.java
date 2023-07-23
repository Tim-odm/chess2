package com.example.chess2.Logic;

import com.example.chess2.board.GridHandler;

import java.util.ArrayList;

public class PieceMoves {
    private GridHandler gridHandler;
    public PieceMoves(GridHandler gridHandler) {
        this.gridHandler = gridHandler;
    }

    private int keepBounds(int i) {
        if (i < 0) {
            return 0;
        } else return Math.min(i, 7);
    }

    public int upRightOne(int x, int y) {
        x++;
        y--;
        x = keepBounds(x);
        y = keepBounds(y);
        return gridHandler.getBoardPosition(x, y);
    }

    public int downRightOne(int x, int y) {
        x++;
        y++;
        x = keepBounds(x);
        y = keepBounds(y);
        return gridHandler.getBoardPosition(x, y);
    }

    public int upLeftOne(int x, int y) {
        x--;
        y--;
        x = keepBounds(x);
        y = keepBounds(y);
        return gridHandler.getBoardPosition(x, y);
    }

    public int downLeftOne(int x, int y) {
        x--;
        y++;
        x = keepBounds(x);
        y = keepBounds(y);
        return gridHandler.getBoardPosition(x, y);
    }

    public int up(int x, int y) {
        y--;
        y = keepBounds(y);
        return this.gridHandler.getBoardPosition(x, y);
    }

    public int down(int x, int y) {
        y++;
        y = keepBounds(y);
        return gridHandler.getBoardPosition(x, y);
    }

    public int right(int x, int y) {
        x--;
        x = keepBounds(x);
        return gridHandler.getBoardPosition(x, y);
    }

    public int left(int x, int y) {
        x++;
        x = keepBounds(x);
        return gridHandler.getBoardPosition(x, y);
    }

    public ArrayList<Integer> straights(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            boardIndexes.add(gridHandler.getBoardPosition(i, y));
        }
        for (int i = 0; i < 8; i++) {
            boardIndexes.add(gridHandler.getBoardPosition(x, i));
        }
        return boardIndexes;
    }

    public ArrayList<Integer> diagonals(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        boardIndexes.addAll(upLeft(x, y));
        boardIndexes.addAll(downLeft(x, y));
        boardIndexes.addAll(upRight(x, y));
        boardIndexes.addAll(downRight(x, y));
        return boardIndexes;
    }

    private ArrayList<Integer> upLeft(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while(x >= 0 && y >= 0) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            x--;
            y--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> downLeft(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x >= 0 && y <= 7) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            x--;
            y++;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> upRight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7 && y >= 0) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            x++;
            y--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> downRight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7 && y <= 7) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            x++;
            y++;
        }
        return boardIndexes;
    }
}
