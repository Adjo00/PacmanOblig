package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.shape.Circle;

import static com.example.pacman.Main.*;
import static com.example.pacman.Player.speed;

public class Ghost extends Circle implements MyShapes {
    Scene scene;
    public static Retning retningspøkelse;
    double speed1 = 1.5;

    public Ghost(Scene scene, double x, double y, double radius) {
        super(x, y, radius);
        this.scene = scene;
        retningspøkelse = Retning.UP;

    }

    public void update() {

        switch (retningspøkelse) {
            case DOWN -> setCenterY(getCenterY() - speed1);
            case UP -> setCenterY(getCenterY() + speed1);
            case LEFT -> setCenterX(getCenterX() + speed1);
            case RIGHT -> setCenterX(getCenterX() - speed1);
        }


        /*
        for (Wall w : walls) {
            if (!getBoundsInParent().intersects(w.getBoundsInParent())) {
                ghostLastPositionY = this.getCenterY();
                ghostLastPositionX = this.getCenterX();
                System.out.println("treffer ikke vegg");
            }
            if (getBoundsInParent().intersects(w.getBoundsInParent())) {
                ghostX = getCenterX();
                ghostY = getCenterY();
                System.out.println("treffer vegg");

                switch (Retning.randomDirection()) {
                    case DOWN -> setCenterY(ghostY - speed);
                    case UP -> setCenterY(ghostY + speed);
                    case LEFT -> setCenterX(ghostX + speed);
                    case RIGHT -> setCenterX(ghostX - speed);
                }

                this.setCenterY(ghostLastPositionY);
                this.setCenterX(ghostLastPositionX);
                //System.out.println("ok");
            }
        }

         */


    pane.getChildren().add(this);
    }
}