package com.example.pacman;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static com.example.pacman.Main.*;

public class Coins extends Circle implements MyShapes {
    //Det er 292 coins i mappet
    public Coins(int x, int y, Color color){
        super(x,y,tile/4);
        setFill(color);
    }
    public void update() {
        if (newPlayer.getBoundsInParent().intersects(getBoundsInParent())){
            System.out.println("Score " + scoreCount);
        }
        //fjern fra arraylist
        //legg til i score
        //lag collision med coins
        pane.getChildren().add(this);
    }
}
