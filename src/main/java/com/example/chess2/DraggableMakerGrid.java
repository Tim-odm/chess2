package com.example.chess2;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class DraggableMakerGrid extends GridBase{

    private double mouseAnchorX;
    private double mouseAnchorY;

    public DraggableMakerGrid(double planeWidth, double planeHeight, int gridSize, AnchorPane anchorPane) {
        super(planeWidth, planeHeight, gridSize, anchorPane);
    }

    public void makeDraggable(Node node){
        node.setOnMouseReleased(mouseEvent -> {
            mouseAnchorX = mouseEvent.getSceneX();
            mouseAnchorY = mouseEvent.getSceneY();

            int x = (int) ((mouseAnchorX/getGridSize()) % getTilesAcross()) * getGridSize();
            int y = (int) ((mouseAnchorY/getGridSize()) % getTilesDown()) * getGridSize();

            node.setLayoutX(x);
            node.setLayoutY(y);
        });
    }

    public void makeDraggable(Component component){
        Node node = component.getRectangle();
        node.setOnMouseDragged(mouseEvent -> {
            mouseAnchorX = mouseEvent.getSceneX();
            mouseAnchorY = mouseEvent.getSceneY();
            System.out.println("Anchor X:" + mouseAnchorX);
            System.out.println("Anchor Y:" + mouseAnchorY);

            int x = (int) ((mouseAnchorX/getGridSize()) % getTilesAcross()) * getGridSize();
            int y = (int) ((mouseAnchorY/getGridSize()) % getTilesDown()) * getGridSize();

            System.out.println("X:" + x);
            System.out.println("Y:" + y);

            node.setLayoutX(x - component.getStartPositionX());
            node.setLayoutY(y - component.getStartPositionY());
            // System.out.println(x - component.getStartPositionX());
            // System.out.println(y - component.getStartPositionY());
        });
    }
}
