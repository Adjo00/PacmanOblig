package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

import static com.example.pacman.HelloApplication.*;

public class Wall extends Rectangle {

public static ArrayList<Ghost> ghost = new ArrayList<>();
    public Wall(int x, int y, Color color){
        //lager alle vegger om til rektangler, og gir dem verdi
        super(x,y,tile,tile);
        setFill(color);
    }
    public void update(){

        if (newPlayer.getBoundsInParent().intersects(getBoundsInParent())) {
            System.out.println("ok");
        }

        pane.getChildren().add(this);
    }
    /*public void checkCollision() {
        if()
    }*/
}
