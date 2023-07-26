package com.example.chess2.Logic;

import com.example.chess2.board.GridHandler;

import java.util.ArrayList;
import java.util.Base64;

public class PieceMoves {
    private GameLogic logic;
    private GridHandler gridHandler;
    public PieceMoves(GameLogic logic) {
        this.logic = logic;
        this.gridHandler = logic.getGridHandler();
    }

    private int keepBounds(int i) {
        if (i < 0) {
            return 0;
        } else return Math.min(i, 7);
    }

    public int doubleDown(int x, int y) {
        y = y + 2;
        return gridHandler.getBoardPosition(x,y);
    }

    public int doubleUp(int x, int y) {
        y = y - 2;
        return gridHandler.getBoardPosition(x,y);
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
        /* We used "+1"/"-1" here so that the index position the piece is
        currently in would not be taken into account. This prevents pieceInPosition
        check from terminating loops prematurely.
         */
        ArrayList<Integer> boardIndexes = upStraight(x, y-1);
        boardIndexes.addAll(downStraight(x,y+1));
        boardIndexes.addAll(leftStraight(x-1,y));
        boardIndexes.addAll(rightStraight(x+1,y));
        return boardIndexes;
    }

    private ArrayList<Integer> upStraight(int x, int y){
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (y >= 0) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            if (logic.pieceInPosition(x,y)) break;
            y--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> downStraight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (y <= 7) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            if (logic.pieceInPosition(x,y)) break;
            y++;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> leftStraight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x >= 0) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            if (logic.pieceInPosition(x,y)) break;
            x--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> rightStraight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            if (logic.pieceInPosition(x,y)) break;
            x++;
        }
        return boardIndexes;
    }

    public ArrayList<Integer> diagonals(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        boardIndexes.addAll(upLeft(x-1, y-1));
        boardIndexes.addAll(downLeft(x-1, y+1));
        boardIndexes.addAll(upRight(x+1, y-1));
        boardIndexes.addAll(downRight(x+1, y+1));
        return boardIndexes;
    }

    private ArrayList<Integer> upLeft(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while(x >= 0 && y >= 0) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            if (logic.pieceInPosition(x,y)) break;
            x--;
            y--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> downLeft(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x >= 0 && y <= 7) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            if (logic.pieceInPosition(x,y)) break;
            x--;
            y++;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> upRight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7 && y >= 0) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            if (logic.pieceInPosition(x,y)) break;
            x++;
            y--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> downRight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7 && y <= 7) {
            boardIndexes.add(gridHandler.getBoardPosition(x, y));
            if (logic.pieceInPosition(x,y)) break;
            x++;
            y++;
        }
        return boardIndexes;
    }
}
