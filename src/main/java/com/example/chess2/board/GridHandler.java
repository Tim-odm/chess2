package com.example.chess2.board;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class inherits from GridBase and basically "draws the grid".
 * @author
 */
public class GridHandler extends GridBase {

    Color bgWhite = Color.WHITE;
    Color bgGrey = Color.color(0.82, 0.82, 0.82);

    /**
     * Constructor for the GridHandler class.
     * @param planeWidth The width of the plane = 400px.
     * @param planeHeight The height of the plane = 400px.
     * @param gridSize The size of one grid (box) = 50px.
     * @param anchorPane The pane on which our grid (chessboard) is drawn.
     */
    public GridHandler(double planeWidth, double planeHeight, int gridSize, AnchorPane anchorPane) {
        super(planeWidth, planeHeight, gridSize, anchorPane);
    }

    /**
     * This method draws the grid (chessboard);
     */
    public void updateGrid() {
        for(int i = 0; i < getTileAmount(); i++){
            // This logic calculated the box number along the X and Y planes.
            int x = (i % getTilesAcross());
            int y = (i / getTilesAcross());

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

            // Attach both the rectangle and label to the **MAIN** pane at the
            // correct X and Y coors
            getAnchorPane().getChildren().add(rectangle);
            getAnchorPane().getChildren().add(label);
        }
    }
}
