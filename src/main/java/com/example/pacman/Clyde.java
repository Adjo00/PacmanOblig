package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Clyde extends Ghost{
    public Clyde(Scene scene, double x , double y, double radius, Color color) {
        super(scene, x, y, radius);
        setFill(color);
    }
}
