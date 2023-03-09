package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static com.example.pacman.Main.*;
import static com.example.pacman.Player.speed;

public class Wall extends Rectangle {

public static ArrayList<Ghost> ghost = new ArrayList<>();
    double playerX, playerY;
    public Wall(int x, int y, Color color){
        //lager alle vegger om til rektangler, og gir dem verdi
        super(x,y,tile,tile);
        setFill(color);
    }
    public void update(){
        playerX = newPlayer.getCenterX();
        playerY = newPlayer.getCenterY();
        if (newPlayer.getBoundsInParent().intersects(getBoundsInParent())) {
            System.out.println("ok");
        }

        pane.getChildren().add(this);
    }
    /*public void checkCollision() {
        if()
    }*/
}
