package com.example.pacman;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    int vertical = 600;
    int horizontal = 600;
    BorderPane root = new BorderPane();
    Pane pane = new Pane();
    int position;
    @Override
    public void start(Stage stage) throws IOException {
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    Rectangle wall = new Rectangle(j * 50, i * 50, 50, 50);
                    wall.setFill(Color.BLACK);
                    wall.widthProperty().bind(root.widthProperty().divide(map[0].length));
                    wall.heightProperty().bind(root.heightProperty().divide(map.length));
                    root.getChildren().add(wall);
                }
                if (map[i][j] == 1) {
                    Rectangle wall = new Rectangle(j * 50, i * 50, 50, 50);
                    wall.setFill(Color.BLUE);
                    wall.widthProperty().bind(root.widthProperty().divide(map[0].length));
                    wall.heightProperty().bind(root.heightProperty().divide(map.length));
                    root.getChildren().add(wall);
                }
            }
        }



        root.setBottom(pane);
        Scene scene = new Scene(root, vertical, horizontal);
        stage.setTitle("Pacman");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}