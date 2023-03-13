package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.example.pacman.Main.*;
import static com.example.pacman.Player.speed;

public class DifferentWall extends Rectangle implements MyShapes {
    public DifferentWall(int x, int y, Color color) {
        super(x,y,tile, tile);
        setFill(color);
    }
    @Override
    public void update() {
        pane.getChildren().add(this);
    }
}
