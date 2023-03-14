package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import static com.example.pacman.Main.*;
import static com.example.pacman.Player.speed;

public class Wall extends Rectangle implements MyShapes {

    double playerX, playerY;
    double lastPositionY, lastPositionX;
    double ghostX, ghostY;
    double ghostLastPositionY, ghostLastPositionX;

    public Wall(int x, int y, Color color){
        //lager alle vegger om til rektangler, og gir dem verdi
        super(x,y,tile,tile);
        setFill(color);
    }
    public void update(){
        if (!newPlayer.getBoundsInParent().intersects(getBoundsInParent())) {
            lastPositionY = Player.lastPositionY();
            lastPositionX = Player.lastPositionX();
        }
        if (newPlayer.getBoundsInParent().intersects(getBoundsInParent())) {
            playerX = newPlayer.getCenterX();
            playerY = newPlayer.getCenterY();
            switch(newPlayer.getDirection()){
                case DOWN -> newPlayer.setCenterY(playerY - speed);
                case UP -> newPlayer.setCenterY(playerY + speed);
                case LEFT -> newPlayer.setCenterX(playerX + speed);
                case RIGHT -> newPlayer.setCenterX(playerX - speed);
            }
            newPlayer.setCenterY(lastPositionY);
            newPlayer.setCenterX(lastPositionX);
            //System.out.println("ok");
        }

        for (Ghost g : ghost) {
            if (!this.getBoundsInParent().intersects(g.getBoundsInParent())) {
                ghostLastPositionY = g.getCenterY();
                ghostLastPositionX = g.getCenterX();
                System.out.println("treffer inni");
            }
            if (this.getBoundsInParent().intersects(g.getBoundsInParent())) {
                Retning tilfeldig = Retning.randomDirection();
                Ghost.retningspøkelse = tilfeldig;
                System.out.println("treffer vegg");
                g.setCenterY(ghostLastPositionY);
                g.setCenterX(ghostLastPositionX);
            }
        }
        pane.getChildren().add(this);
    }
}


