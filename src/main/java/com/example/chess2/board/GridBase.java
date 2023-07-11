package com.example.chess2.board;

import javafx.scene.layout.AnchorPane;

/**
 * This class defines the base of our 8x8 grid.
 *
 * Please Note: It was not written by me. The author is
 * @author
 */
public abstract class GridBase {
    private double planeWidth;
    private double planeHeight;
    private int tilesAcross;
    private int tilesDown;
    private int gridSize;
    private int tileAmount;
    private AnchorPane anchorPane;

    /**
     * Constructor for our grid base.
     * @param planeWidth width of the pane = 400.
     * @param planeHeight height of the pane = 400.
     * @param gridSize size of single grid (box) = 50
     * @param anchorPane the pane which our grid base is attached to.
     */
    public GridBase(double planeWidth, double planeHeight, int gridSize, AnchorPane anchorPane) {
        this.planeWidth = 400;
        this.planeHeight = 400;
        this.gridSize = gridSize;
        this.anchorPane = anchorPane;

        this.tilesAcross = (int) (planeWidth/gridSize);
        this.tileAmount = (int) ((planeWidth/gridSize) * (planeHeight/gridSize));
        this.tilesDown = tileAmount/tilesAcross;
    }

    /**
     * Get the plane width.
     * @return plane width.
     */
    public double getPlaneWidth() {
        return planeWidth;
    }

    public int getTilesAcross() {
        return tilesAcross;
    }

    public int getTilesDown() {
        return tilesDown;
    }

    public int getGridSize() {
        return gridSize;
    }

    public int getTileAmount() {
        return tileAmount;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
