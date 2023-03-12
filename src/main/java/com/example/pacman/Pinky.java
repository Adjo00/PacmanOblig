package com.example.pacman;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static com.example.pacman.Main.*;

public class Pinky extends Ghost{
    public Pinky(Scene scene, double x , double y, double radius, Color color) {
        super(scene, x, y, radius);
        setFill(color);
    }
}
