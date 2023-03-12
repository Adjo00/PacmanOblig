package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static com.example.pacman.Main.pane;
import static com.example.pacman.Main.tile;

public class Ghost extends Circle implements Figurer {
    Scene scene;
    private Retning retningspøkelse;
    double speed = 1.5;

    public Ghost(Scene scene){
        super(660,540,tile/3);
        setFill(Color.GREEN);
        this.scene = scene;
        retningspøkelse = Retning.NONE;
    }
    public void update() {
        Retning tilfeldigRetning = Retning.randomDirection();
        //System.out.println(randomDirection);
        switch(tilfeldigRetning){
            case DOWN -> setCenterY(getCenterY() + speed);
            case UP -> setCenterY(getCenterY() - speed);
            case LEFT -> setCenterX(getCenterX() - speed);
            case RIGHT -> setCenterX(getCenterX() + speed);
        }
        pane.getChildren().add(this);
    }

}


/*
        scene.setOnKeyPressed(e -> { //forsatt usikker på scene.
            //dette skjer før man kan gjøre noe... derfor timeline
            //Sier hvilke knapp som går hvilke retning
            switch (e.getCode()) {
                case S -> retningspøkelse = Retning.DOWN;
                case W -> retningspøkelse = Retning.UP;
                caDse A -> retningspøkelse = Retning.LEFT;
                case D -> retningspøkelse = Retning.RIGHT;
            }
        });

 */