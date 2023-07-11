package com.example.chess2;

import com.example.chess2.board.DraggableMakerGrid;
import com.example.chess2.board.GridHandler;
import com.example.chess2.pieces.BlackKing;
import com.example.chess2.pieces.Component;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChessController implements Initializable {

    private int gridSize = 50;

    @FXML
    private AnchorPane pane;

    private GridHandler backgroundGridHandler;
    private DraggableMakerGrid draggableMakerGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        draggableMakerGrid = new DraggableMakerGrid(pane.getPrefWidth(), pane.getPrefHeight(), gridSize, pane);

        backgroundGridHandler = new GridHandler(pane.getPrefWidth(), pane.getPrefHeight(), gridSize, pane);
        backgroundGridHandler.updateGrid();

        Component component = new Component(gridSize, 100, 100);
        pane.getChildren().add(component.getRectangle());

        draggableMakerGrid.makeDraggable(component);
    }
}
