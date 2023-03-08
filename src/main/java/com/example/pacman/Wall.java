package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

import static com.example.pacman.HelloApplication.pane;
import static com.example.pacman.HelloApplication.tile;

public class Wall extends Rectangle {

public static ArrayList<Ghost> ghost = new ArrayList<>();
    public Wall(int x, int y, Color color){
        //lager alle vegger om til rektangler, og gir dem verdi
        super(x,y,tile,tile);
        setFill(color);
    }
    public void update(){

        /*for(Ghost g : ghost) {
            if (player.getBoundsInParent().intersects(getBoundsInParent())) {

            }
        }*/
        pane.getChildren().add(this);
    }
    /*public void checkCollision() {
        if()
    }*/
}
