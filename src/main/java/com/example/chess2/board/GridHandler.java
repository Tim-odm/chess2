package com.example.chess2.board;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class inherits from GridBase and basically "draws the grid".
 * @author
 */
public class GridHandler extends GridBase {

    private final static Color bgWhite = Color.WHITE;
    private final static Color bgGrey = Color.color(0.82, 0.82, 0.82);
    private final static int[][] boardPositions = new int[8][8];
    private static ArrayList<Rectangle> rectangles;

    private static boolean[] squares;

    /**
     * Constructor for the GridHandler class.
     * @param planeWidth The width of the plane = 400px.
     * @param planeHeight The height of the plane = 400px.
     * @param gridSize The size of one grid (box) = 50px.
     * @param anchorPane The pane on which our grid (chessboard) is drawn.
     */
    public GridHandler(double planeWidth, double planeHeight, int gridSize, AnchorPane anchorPane) {
        super(planeWidth, planeHeight, gridSize, anchorPane);
        rectangles = new ArrayList<>();
        squares = new boolean[64];
    }

    /**
     * This method draws the grid (chessboard);
     */
    public void updateGrid() {
        for(int i = 0; i < getTileAmount(); i++){
            // This logic calculated the box number along the X and Y planes.
            int x = (i % getTilesAcross());
            int y = (i / getTilesAcross());

            boardPositions[x][y] = i;

            Rectangle rectangle = new Rectangle(x * getGridSize(),y * getGridSize(),getGridSize(),getGridSize());
            Label label = new Label(Integer.toString(i));
            label.setLayoutX(x * 50);
            label.setLayoutY(y * 50);

            // Logic to define is a square is grey or white.
            if((x + y) % 2 == 0){
                rectangle.setFill(bgWhite);
            } else {
                rectangle.setFill(bgGrey);
            }

            // Add the rectangle to the array
            rectangles.add(rectangle);

            // Attach both the rectangle and label to the **MAIN** pane at the
            // correct X and Y coors
            getAnchorPane().getChildren().add(rectangle);
            getAnchorPane().getChildren().add(label);
        }
        // Check if the 2D array is storing positions correctly.
        System.out.println(Arrays.deepToString(boardPositions));
    }

    /**
     * Given a pixel on the screen this method should return the index of the
     * board position.
     * @param x Pixel position in the X axis.
     * @param y Pixel position in the Y axis.
     * @return Board position index.
     */
    public static int getBoardPosition(double x, double y) {
        int a = (int) ((x/getGridSize()) % getTilesAcross());
        int b = (int) ((y/getGridSize()) % getTilesDown());
        return boardPositions[a][b];
    }

    /**
     * This method adds an event handler to each rectangle such that if that
     * rectangle is playable then the selected piece can be moved to it.
     */
    public void makePlayable() {
       for (Rectangle r: rectangles) {
           r.setOnMouseClicked(mouseEvent -> {
               double mouseAnchorX = mouseEvent.getSceneX();
               double mouseAnchorY = mouseEvent.getSceneY();

               int x = (int) ((mouseAnchorX / getGridSize()) % getTilesAcross());
               int y = (int) ((mouseAnchorY / getGridSize()) % getTilesDown());
               ChessBoard.potentialMove(x, y);
           });
       }
    }

    /**
     * Given board coordinates this method should return the index of the
     * board position.
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @return Board position index.
     */
    public static int getBoardPosition(int x, int y) {
        return boardPositions[x][y];
    }

    /**
     * This method highlights squares where a piece could potentially move.
     * @param potentialMoves An ArrayList containing the index positions of the
     *                       potential moves a piece can make.
     */
    public static void highlightMoves(ArrayList<Integer> potentialMoves) {
        clearSquaresInPlay();
        for (Integer i: potentialMoves) {
            rectangles.get(i).setFill(Color.LIGHTGREEN);
            setSquareInPlay(i);
        }
    }

    public static void setSquareInPlay(int i) {
        squares[i] = true;
    }

    public static void clearSquaresInPlay() {
        Arrays.fill(squares, false);
    }

    public static boolean[] getSquaresInPlay() {
        return squares;
    }

    /**
     * This method resets the color of all squares on the board.
     */
    public static void clearBoard() {
        for (int i = 0; i < getTileAmount(); i++) {
            int x = (i % getTilesAcross());
            int y = (i / getTilesAcross());

            if((x + y) % 2 == 0){
                rectangles.get(i).setFill(bgWhite);
            } else {
                rectangles.get(i).setFill(bgGrey);
            }
        }
    }

    // when highlighted rectangle is clicked.

    public static int getXCoord(int boardPosition) {
        return boardPosition % 8;
    }

    public static int getYCoord(int boardPosition) {
        return boardPosition / 8;
    }
 }

