package com.example.chess2.board;

import com.example.chess2.pieces.Component;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * This class is the implementation of the abstract class GridBase.
 * <p>
 * The author of this class is
 * @author
 */
public class DraggableMakerGrid extends GridBase {

    private double mouseAnchorX;
    private double mouseAnchorY;

    /**
     * Constructor for a grid with draggable components.
     * @param planeWidth Width of the plane = 400.
     * @param planeHeight Height of the plane = 400.
     * @param gridSize Size of a single grid (box) = 50.
     * @param anchorPane The anchorPane which of DraggableMakerGrid object
     *                   is attached to.
     */
    public DraggableMakerGrid(double planeWidth, double planeHeight, int gridSize, AnchorPane anchorPane) {
        super(planeWidth, planeHeight, gridSize, anchorPane);
    }

    /**
     * This method makes an object draggable.
     * *Maye be deprecated.
     * @param node The node to make draggable.
     */
    public void makeDraggable(Node node){
        node.setOnMouseReleased(mouseEvent -> {
            // Get coords of mouse event when the mouse is released
            mouseAnchorX = mouseEvent.getSceneX();
            mouseAnchorY = mouseEvent.getSceneY();

            int x = (int) ((mouseAnchorX/getGridSize()) % getTilesAcross()) * getGridSize();
            int y = (int) ((mouseAnchorY/getGridSize()) % getTilesDown()) * getGridSize();

            node.setLayoutX(x);
            node.setLayoutY(y);
        });
    }

    /**
     * Method used to make component draggable.
     * @param component The component to make draggable.
     */
    public void makeDraggable(Component component){
        // Turn the component into a node.
        Node node = component.getRectangle();

        node.setOnMouseDragged(mouseEvent -> {
            // Get X and Y coords of the mouse event.
            mouseAnchorX = mouseEvent.getSceneX();
            mouseAnchorY = mouseEvent.getSceneY();
            System.out.println("Anchor X:" + mouseAnchorX);
            System.out.println("Anchor Y:" + mouseAnchorY);

            // This logic calculates the X and Y position of the grid we are
            // currently in.
            int x = (int) ((mouseAnchorX/getGridSize()) % getTilesAcross()) * getGridSize();
            int y = (int) ((mouseAnchorY/getGridSize()) % getTilesDown()) * getGridSize();

            System.out.println("X:" + x);
            System.out.println("Y:" + y);

            // Snap the component to correct grid.
            node.setLayoutX(x);
            node.setLayoutY(y);
            System.out.println(x - component.getStartPositionX());
            System.out.println(y - component.getStartPositionY());
        });
    }

    /**
     * Method to make a stackPane draggable.
     */
    public void makeDraggable(StackPane stackPane) {
        Node node = stackPane;

        node.setOnMouseDragged(mouseEvent -> {
            // Get X and Y coords of the mouse event.
            mouseAnchorX = mouseEvent.getSceneX();
            mouseAnchorY = mouseEvent.getSceneY();
            System.out.println("Anchor X:" + mouseAnchorX);
            System.out.println("Anchor Y:" + mouseAnchorY);

            // This logic calculates the X and Y position of the grid we are
            // currently in.
            int x = (int) ((mouseAnchorX / getGridSize()) % getTilesAcross()) * getGridSize();
            int y = (int) ((mouseAnchorY / getGridSize()) % getTilesDown()) * getGridSize();

            System.out.println("X:" + x);
            System.out.println("Y:" + y);

            // Snap the component to correct grid.
            node.setLayoutX(x);
            node.setLayoutY(y);

        });


    }
}
