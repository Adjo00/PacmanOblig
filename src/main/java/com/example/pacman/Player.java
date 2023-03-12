package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static com.example.pacman.Main.*;

public class Player extends Circle implements Figurer{
    Scene scene;
    private Retning retning;
    public static Player newPlayer;
    public static double speed = 1.5;
    public Player(Scene scene) {
        super(50,50,tile/3); //error fordi float eller no?
        setFill(Color.YELLOW);
        this.scene = scene; //sier scene er d samma
        retning = Retning.NONE; // default, hvis ikke løper den vekk...
        scene.setOnKeyPressed(e -> { //forsatt usikker på scene.
            //dette skjer før man kan gjøre noe... derfor timeline
            //Sier hvilke knapp som går hvilke retning
            switch (e.getCode()) {
                case S -> retning = Retning.DOWN;
                case W -> retning = Retning.UP;
                case A -> retning = Retning.LEFT;
                case D -> retning = Retning.RIGHT;
            }
        });
    }

    public void update(){
        //lager en switch for å gi speed til figuren
        //kan brukes for ghost for å la dem gå en vei
        switch(retning){
          case DOWN -> setCenterY(getCenterY() + speed);
          case UP -> setCenterY(getCenterY() - speed);
          case LEFT -> setCenterX(getCenterX() - speed);
          case RIGHT -> setCenterX(getCenterX() + speed);
        }
        pane.getChildren().add(this);
    }
    public Retning getDirection() {
        return newPlayer.retning;
    }
    public static double lastPositionY() {
        return newPlayer.getCenterY();
    }
    public static double lastPositionX() {
        return newPlayer.getCenterX();
    }
}


