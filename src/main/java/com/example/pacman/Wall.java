package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import static com.example.pacman.Main.*;
import static com.example.pacman.Player.speed;

public class Wall extends Rectangle implements MyShapes {

    double playerX, playerY;
    double lastPositionY, lastPositionX;
    double ghostLastPositionY, ghostLastPositionX;

    /**
     * Dette er konstruktørmetoden for wall, som er en subklasse av Rectangle
     * Wall er da alle vegger i map
     * @param x x posisjonen til wall
     * @param y y posisjonen til wall
     * @param color fargen til wall
     */
    public Wall(int x, int y, Color color){
        //lager alle vegger om til rektangler, og gir dem verdi
        super(x,y,tile,tile);
        setFill(color);
    }

    /**
     * Wall har en update metode som bruker i run() gameloopen i main.
     * Denne metoden sjekker om pacman treffer en vegg, og hvis han gjør det, så flytter den seg tilbake til siste posisjon.
     * Denne metoden sjekker også om pacman treffer en ghost, og hvis han gjør det, så flytter den ghosten tilbake til siste posisjon.
     * Dette gjør den ved å bruke en random retning, og flytte ghosten deretter.
     */
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


