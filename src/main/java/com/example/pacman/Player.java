package com.example.pacman;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static com.example.pacman.HelloApplication.pane;
import static com.example.pacman.HelloApplication.tile;

public class Player extends Circle implements Figurer{
    Scene scene;
    private Retning retning;
    public static double speed = 1.5;
    public Player(Scene scene) {
        super(30,30,tile/3); //error fordi float eller no?
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

        //if(getBoundsInLocal().intersects(getBoundsInParent()) )
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


}


