package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.example.pacman.HelloApplication.pane;
import static com.example.pacman.HelloApplication.tile;

public class Wall extends Rectangle {
    public Wall(int x, int y, Color color){
        super(x,y,tile,tile);
        setFill(color);
    }
    public void update(){
        pane.getChildren().add(this);
    }
}
