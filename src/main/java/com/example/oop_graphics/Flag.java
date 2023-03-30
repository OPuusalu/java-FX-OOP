package com.example.oop_graphics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Flag extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(0,0,800,200);
        gc.setFill(Color.BLACK);
        gc.fillRect(0,200,800,200);
        gc.setFill(Color.WHITE);
        gc.fillRect(0,400,800,200);


        Button button = new Button();

        button.setText("Now I see what's written here, nothing useful after all...");

        BoxBlur boxBlur = new BoxBlur();
        boxBlur.setHeight(6);
        boxBlur.setWidth(6);
        BoxBlur noBlur = new BoxBlur();
        noBlur.setHeight(0);
        noBlur.setWidth(0);
        button.setEffect(boxBlur);
        button.setLayoutX(200);
        button.setLayoutY(canvas.getHeight()/2);

        button.setOnAction(e -> {
            button.setEffect(noBlur);
        });


        root.getChildren().add(canvas);
        root.getChildren().add(button);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Flag");  // lava tiitelribale pannakse tekst

        primaryStage.setScene(scene);  // lavale lisatakse stseen

        primaryStage.show();  // lava tehakse nähtavaks
    }

    public static void main(String[] args) {
        launch();
    }
}
