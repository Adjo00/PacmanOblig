package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.example.pacman.Main.*;
import static com.example.pacman.Player.speed;

public class DifferentWall extends Rectangle implements MyShapes {
    double playerX, playerY;
    double lastPositionY, lastPositionX;
    public DifferentWall(int x, int y, Color color) {
        super(x,y,tile, tile);
        setFill(color);
    }
    @Override
    public void update() {
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
        pane.getChildren().add(this);
    }
}
