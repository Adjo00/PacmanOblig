package com.example.pacman;



public enum Retning {
    UP, DOWN, LEFT, NONE, RIGHT;

    public static Retning randomDirection() {
        return values()[(int) (Math.random() * values().length)];
    }
}

