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
    public Player() {
        pacman = new Circle(30,30,30);
            root.setOnKeyPressed(e -> {
                root.getChildren().remove(pacman);
                switch (e.getCode()) {
                    case DOWN -> pacman.setCenterY(pacman.getCenterY() + 10);
                    case UP -> pacman.setCenterY(pacman.getCenterY() - 10);
                    case LEFT -> pacman.setCenterX(pacman.getCenterX() + 10);
                    case RIGHT -> pacman.setCenterX(pacman.getCenterX() - 10);
                }
                root.getChildren().add(pacman);
            });
    };
};


