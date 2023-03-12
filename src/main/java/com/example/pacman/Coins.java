package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.example.pacman.Main.pane;
import static com.example.pacman.Main.tile;

public class Coins extends Circle implements MyShapes {

    public Coins(int x, int y, Color color){
        super(x,y,tile/4);
        setFill(color);
    }

    public void update(){

        //lag collision med coins
        pane.getChildren().add(this);
    }
}
