package com.example.pacman;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static com.example.pacman.HelloApplication.root;

public class Player {

    Circle pacman;

    //root.setOnKeyPressed()
    public Player() {

        public void bevegelse(KeyEvent keyEvent){
            if (KeyEvent.getCode() == KeyCode.W) {
                //pacman.setX(pacman.getCenterX() + 10);
                System.out.println("W");
            }
        }
    };
}


