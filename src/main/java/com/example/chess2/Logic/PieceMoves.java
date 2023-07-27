package com.example.chess2.Logic;

import com.example.chess2.board.GridHandler;

import java.util.ArrayList;

public class PieceMoves {
    private final GameLogic logic;
    private final GridHandler gridHandler;
    public PieceMoves(GameLogic logic) {
        this.logic = logic;
        this.gridHandler = logic.getGridHandler();
    }

    private int keepBounds(int i) {
        if (i < 0) {
            return 0;
        } else return Math.min(i, 7);
    }

    public int pawnDown(int x, int y) {
        y++;
        if (moveOutOfBounds(x,y) || logic.pieceInPosition(x,y)) {
            return -1;
        } else {
            return gridHandler.getBoardPosition(x,y);
        }
    }

    public int pawnDownRight(int x, int y) {
        x++;
        y++;
        return pawnCaptureLogic(x,y);
    }

    public int pawnDownLeft(int x, int y) {
        x--;
        y++;
        return pawnCaptureLogic(x,y);
    }

    public int pawnUp(int x, int y) {
        y--;
        if (moveOutOfBounds(x,y) || logic.pieceInPosition(x,y)) {
            return -1;
        } else {
            return gridHandler.getBoardPosition(x,y);
        }
    }

    public int pawnUpLeft(int x, int y) {
        x--;
        y--;
        return pawnCaptureLogic(x,y);
    }

    public int pawnUpRight(int x, int y) {
        x--;
        y--;
        return pawnCaptureLogic(x,y);
    }

    public int doubleDown(int x, int y) {
        y = y + 2;
        if (logic.pieceInPosition(x,y)) return -1;
        return gridHandler.getBoardPosition(x,y);
    }

    public int doubleUp(int x, int y) {
        y = y - 2;
        if (logic.pieceInPosition(x,y)) return -1;
        return gridHandler.getBoardPosition(x,y);
    }

    private int pawnCaptureLogic(int x, int y) {
        if (moveOutOfBounds(x,y)) {
            return -1;
        } else if (logic.checkPotentialCapture(x,y)) {
            return gridHandler.getBoardPosition(x,y);
        } else {
            return -1;
        }
    }

    public int knightUpRight(int x, int y) {
        x++;
        y = y-2;
        return moveLogic(x,y);
    }

    public int knightDownRight(int x, int y) {
        x++;
        y = y+2;
        return moveLogic(x,y);
    }

    public int knightUpLeft(int x, int y) {
        x--;
        y = y-2;
        return moveLogic(x,y);
    }

    public int knightDownLeft(int x, int y) {
        x--;
        y = y+2;
        return moveLogic(x,y);
    }

    public int knightRightUp(int x, int y) {
        x = x+2;
        y--;
        return moveLogic(x,y);
    }

    public int knightRightDown(int x, int y) {
        x = x+2;
        y++;
        return moveLogic(x,y);
    }

    public int knightLeftUp(int x, int y) {
        x = x-2;
        y--;
        return moveLogic(x,y);
    }

    public int knightLeftDown(int x, int y) {
        x = x-2;
        y++;
        return moveLogic(x,y);
    }

    private int moveLogic(int x, int y) {
        if (moveOutOfBounds(x,y)) {
            return -1;
        } else if (logic.checkPotentialCapture(x,y)) {
            return gridHandler.getBoardPosition(x,y);
        } else if (logic.pieceInPosition(x,y)) {
            return -1;
        } else {
            return gridHandler.getBoardPosition(x, y);
        }
    }

    private boolean moveOutOfBounds(int x, int y) {
        return x < 0 || x > 7 || y < 0 || y > 7;
    }

    public int upRightOne(int x, int y) {
        x++;
        y--;
        return moveLogic(x,y);
    }

    public int downRightOne(int x, int y) {
        x++;
        y++;
        return moveLogic(x,y);
    }

    public int upLeftOne(int x, int y) {
        x--;
        y--;
        return moveLogic(x,y);
    }

    public int downLeftOne(int x, int y) {
        x--;
        y++;
        return moveLogic(x,y);
    }

    public int up(int x, int y) {
        y--;
        return moveLogic(x,y);
    }

    public int down(int x, int y) {
        y++;
        return moveLogic(x,y);
    }

    public int right(int x, int y) {
        x--;
        return moveLogic(x,y);
    }

    public int left(int x, int y) {
        x++;
        return moveLogic(x,y);
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
            if (logic.checkPotentialCapture(x,y)) {
                boardIndexes.add(gridHandler.getBoardPosition(x, y));
                break;
            } else if (logic.pieceInPosition(x,y)) break;
            boardIndexes.add(gridHandler.getBoardPosition(x,y));
            y--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> downStraight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (y <= 7) {
            if (logic.checkPotentialCapture(x,y)) {
                boardIndexes.add(gridHandler.getBoardPosition(x, y));
                break;
            } else if (logic.pieceInPosition(x,y)) break;
            boardIndexes.add(gridHandler.getBoardPosition(x,y));
            y++;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> leftStraight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x >= 0) {
            if (logic.checkPotentialCapture(x,y)) {
                boardIndexes.add(gridHandler.getBoardPosition(x, y));
                break;
            } else if (logic.pieceInPosition(x,y)) break;
            boardIndexes.add(gridHandler.getBoardPosition(x,y));
            x--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> rightStraight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7) {
            if (logic.checkPotentialCapture(x,y)) {
                boardIndexes.add(gridHandler.getBoardPosition(x, y));
                break;
            } else if (logic.pieceInPosition(x,y)) break;
            boardIndexes.add(gridHandler.getBoardPosition(x,y));
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
            if (logic.checkPotentialCapture(x,y)) {
                boardIndexes.add(gridHandler.getBoardPosition(x, y));
                break;
            } else if (logic.pieceInPosition(x,y)) break;
            boardIndexes.add(gridHandler.getBoardPosition(x,y));
            x--;
            y--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> downLeft(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x >= 0 && y <= 7) {
            if (logic.checkPotentialCapture(x,y)) {
                boardIndexes.add(gridHandler.getBoardPosition(x, y));
                break;
            } else if (logic.pieceInPosition(x,y)) break;
            boardIndexes.add(gridHandler.getBoardPosition(x,y));
            x--;
            y++;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> upRight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7 && y >= 0) {
            if (logic.checkPotentialCapture(x,y)) {
                boardIndexes.add(gridHandler.getBoardPosition(x, y));
                break;
            } else if (logic.pieceInPosition(x,y)) break;
            boardIndexes.add(gridHandler.getBoardPosition(x,y));
            x++;
            y--;
        }
        return boardIndexes;
    }

    private ArrayList<Integer> downRight(int x, int y) {
        ArrayList<Integer> boardIndexes = new ArrayList<>();
        while (x <= 7 && y <= 7) {
            if (logic.checkPotentialCapture(x,y)) {
                boardIndexes.add(gridHandler.getBoardPosition(x, y));
                break;
            } else if (logic.pieceInPosition(x,y)) break;
            boardIndexes.add(gridHandler.getBoardPosition(x,y));
            x++;
            y++;
        }
        return boardIndexes;
    }
}
