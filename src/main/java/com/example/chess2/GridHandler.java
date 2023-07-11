package com.example.chess2;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GridHandler extends GridBase {

    Color bgWhite = Color.WHITE;
    Color bgGrey = Color.color(0.82, 0.82, 0.82);

    public GridHandler(double planeWidth, double planeHeight, int gridSize, AnchorPane stackPane) {
        super(planeWidth, planeHeight, gridSize, stackPane);
    }

    public void updateGrid() {
        for(int i = 0; i < getTileAmount(); i++){
            int x = (i % getTilesAcross());
            int y = (i / getTilesAcross());

            Rectangle rectangle = new Rectangle(x * getGridSize(),y * getGridSize(),getGridSize(),getGridSize());
            Label label = new Label(Integer.toString(i));
            label.setLayoutX(x * 50);
            label.setLayoutY(y * 50);

            if((x + y) % 2 == 0){
                rectangle.setFill(bgWhite);
            } else {
                rectangle.setFill(bgGrey);
            }
            getStackPane().getChildren().add(rectangle);
            getStackPane().getChildren().add(label);
        }
    }
}

