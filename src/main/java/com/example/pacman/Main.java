package com.example.pacman;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    //public static
    public static Scene scene;
    public static Pane pane = new Pane();
    public static int row = 28;
    public static Player newPlayer;
    public static Ghost blinky, pinky, inky, clyde, spøkelse;
    public static Retning retning;
    Map kart = new Map();
    public static int vertical = 1010;
    public static int horizontal = 980;
    //finner ut at hvor stort et tile er
    public static int tile = horizontal/row;
    Text highscore, lives;
    public static double speed = 1.5;
    public static int scoreCount = 0;
    public static int playerHealth = 3;
//Arraylist fordi d er flere en ett objedkt
    public static ArrayList<Wall> walls = new ArrayList<>();
    public static ArrayList<Coins> coins = new ArrayList<>();
    public static ArrayList<Ghost> ghost = new ArrayList<>();
    public static ArrayList<DifferentWall> differentWalls = new ArrayList<>();
    public static ArrayList<Powerup> powerPellets = new ArrayList<>();

    /**
     * Starter programmet, setter opp scene og new'er objekter som skal brukes.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(pane, horizontal, vertical);
        kart.map();  // BARE EN GANG.
        newPlayer = new Player(scene);
        blinky = new Blinky(scene, 430,540,tile/3,Color.RED);
        pinky = new Pinky(scene, 480,540,tile/3,Color.PINK);
        inky = new Inky(scene, 530,540,tile/3,Color.CYAN);
        clyde = new Clyde(scene, 580,540,tile/3,Color.ORANGE);
        //spøkelse = new Ghost(scene, 660,540,tile/3,Color.GREEN);
        run();
        stage.setTitle("Pacman");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Inneholder en TimeLine som kjører en gameloop, den oppdaterer alt av bevegelse og endringer
     */
    public void run(){
        //fps basically
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(0.014), e ->{
        //Se på timeline... alt som skal kjøres / oppdateres settes her
        //For å oppdatere hvilke wall d blir laget.
        pane.getChildren().clear(); //for å renskeskjermen. hvis ikke blir d mange objekter stacket på hverandre. kommer til å lagge.
        Rectangle skjerm = new Rectangle(0,0,horizontal,vertical); // lager et rektangel som dekker skjermen (hindre hvite merker)
        skjerm.setFill(Color.BLACK);
        pane.getChildren().add(skjerm);
        for(Wall w : walls){ //Laster inn veggene. går gjennom arraylisten. (Class - > navn -> arraylisten)
            w.update();
        }
        for (DifferentWall df : differentWalls){
            df.update();
        }
        for (Ghost g : ghost){
            g.update();
            //System.out.println(ghost);
        }
        Coins.coinRemove();
        Powerup.powerPelletRemove();
        highscore = new Text("HIGHSCORE: " + scoreCount);
        highscore.setX(50);
        highscore.setY(25);

        highscore.setFill(Color.WHITE);
        pane.getChildren().add(highscore);

        lives = new Text("Lives: " + playerHealth);
        lives.setX(150);
        lives.setY(25);
        lives.setFill(Color.WHITE);
        pane.getChildren().add(lives);
        //spøkelse.update();
        newPlayer.update(); // oppdaterer bevegelsen til figuren

    }));
        //Hvor mange ganger den skal runne. når den stopper, stopper greia å funke.
        time.setCycleCount(Animation.INDEFINITE);
        //Sier når den skal starte
        time.playFromStart();
    }

    /**
     * launch() metoden starter javaFX applikasjonen
     */
    public static void main(String[] args) {
        launch();
    }
}