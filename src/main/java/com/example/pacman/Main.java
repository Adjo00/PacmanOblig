package com.example.pacman;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    //public static
    Scene scene;
    public static Pane pane = new Pane();
    public static int row = 28;
    public static Player newPlayer;
    Ghost spøkelse;
    Retning retning;
    Map kart = new Map();
    public static int vertical = 980;
    public static int horizontal = 980;
    //finner ut at hvor stort et tile er
    public static int tile = horizontal/row;
    Text highscore;
    public static int scoreCount = 0;
//Arraylist fordi d er flere en ett objedkt
    public static ArrayList<Wall> walls = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(pane, horizontal, vertical);
        kart.map();  // BARE EN GANG.
        newPlayer = new Player(scene);
        spøkelse = new Ghost(scene);
        run();
        stage.setTitle("Pacman");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    public synchronized void run(){
        //fps basically
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(0.01), e ->{
        //Se på timeline... alt som skal kjøres / oppdateres settes her
        //For å oppdatere hvilke wall d blir laget.
        pane.getChildren().clear(); //for å renskeskjermen. hvis ikke blir d mange objekter stacket på hverandre. kommer til å lagge.
        Rectangle skjerm = new Rectangle(0,0,horizontal,vertical); // lager et rektangel som dekker skjermen (hindre hvite merker)
        skjerm.setFill(Color.BLACK);
        pane.getChildren().add(skjerm);
        for(Wall w : walls){ //Laster inn veggene. går gjennom arraylisten. (Class - > navn -> arraylisten)
            w.update();
        }
        highscore = new Text("HIGHSCORE:");
        highscore.setX(50);
        highscore.setY(25);
        highscore.setFill(Color.WHITE);
        pane.getChildren().add(highscore);
        spøkelse.update();
        newPlayer.update(); // oppdaterer bevegelsen til figuren

    }));
        //Hvor mange ganger den skal runne. når den stopper, stopper greia å funke.
        time.setCycleCount(Animation.INDEFINITE);
        //Sier når den skal starte
        time.playFromStart();
    }



    public static void main(String[] args) {
        launch();
    }
}