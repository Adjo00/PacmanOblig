package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.example.pacman.Main.*;

public class Ghost extends Circle implements MyShapes {
    Scene scene;
    private Retning retningspøkelse;

    public Ghost(Scene scene, double x, double y, double radius){
        super(x, y, radius);
        this.scene = scene;
        retningspøkelse = Retning.NONE;
    }
    public void update() {
        Retning tilfeldigRetning = Retning.randomDirection();
        //System.out.println(randomDirection);
        /*
        switch(tilfeldigRetning){
            case DOWN -> setCenterY(getCenterY() + speed);
            case UP -> setCenterY(getCenterY() - speed);
            case LEFT -> setCenterX(getCenterX() - speed);
            case RIGHT -> setCenterX(getCenterX() + speed);
        }
        */
        pane.getChildren().add(this);
    }
}