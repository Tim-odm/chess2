package com.example.chess2;

import javafx.scene.layout.AnchorPane;

public abstract class GridBase {
    private double planeWidth;
    private double planeHeight;
    private int tilesAcross;
    private int tilesDown;
    private int gridSize;
    private int tileAmount;
    private AnchorPane anchorPane;

    public GridBase(double planeWidth, double planeHeight, int gridSize, AnchorPane stackPane) {
        this.planeWidth = 400;
        this.planeHeight = 400;
        this.gridSize = gridSize;
        this.anchorPane = stackPane;

        this.tilesAcross = (int) (planeWidth/gridSize);
        this.tileAmount = (int) ((planeWidth/gridSize) * (planeHeight/gridSize));
        this.tilesDown = tileAmount/tilesAcross;
    }

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

    public AnchorPane getStackPane() {
        return anchorPane;
    }
}
