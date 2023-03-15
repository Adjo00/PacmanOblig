package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static com.example.pacman.Main.ghost;
import static com.example.pacman.Main.walls;

public class Inky extends Ghost{
    double ghostLastPositionY, ghostLastPositionX;
    Retning retningspøkelse;
    /**
     * Dette er konstruktørmetoden for Inky, som er en subklasse av Ghost
     * @param scene scenen som Inky skal være i
     * @param x x posisjonen til Inky
     * @param y y posisjonen til Inky
     * @param radius radiusen til Inky
     * @param color fargen til Inky
     */
    public Inky(Scene scene, double x , double y, double radius, Color color) {
        super(scene, x, y, radius);
        setFill(color);
        ghost.add(this);
    }

    @Override
    public void update() {
            for (Wall w : walls) {
                if (!this.getBoundsInParent().intersects(w.getBoundsInParent())) {
                    ghostLastPositionY = this.getCenterY();
                    ghostLastPositionX = this.getCenterX();
                    //System.out.println("treffer inni");
                }
                if (this.getBoundsInParent().intersects(w.getBoundsInParent())) {

                    Retning tilfeldig = Retning.randomDirection();
                    this.retningspøkelse = tilfeldig;
                    System.out.println("treffer vegg");

                    this.setCenterY(ghostLastPositionY);
                    this.setCenterX(ghostLastPositionX);


                }
            }

    }
}

