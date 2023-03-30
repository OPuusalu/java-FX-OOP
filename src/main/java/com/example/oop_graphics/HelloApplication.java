package com.example.oop_graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();

        Canvas background = new Canvas(300,200);

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(0,0,800,200);
        gc.setFill(Color.BLACK);
        gc.fillRect(0,200,800,200);
        gc.setFill(Color.WHITE);
        gc.fillRect(0,400,800,200);

        Button button = new Button("I like beans"); // luuakse nupp

        BoxBlur boxBlur = new BoxBlur();

        boxBlur.setHeight(5);
        boxBlur.setWidth(5);

        BoxBlur noBlur = new BoxBlur();

        noBlur.setHeight(0);
        noBlur.setWidth(0);

        button.setEffect(boxBlur);

        button.setLayoutX(background.getWidth()/2); // nupu paigutamine x-koordinaadi mõttes

        button.setLayoutY(background.getHeight()/2); // nupu paigutamine y-koordinaadi mõttes

        button.setOnAction(e -> {
            button.setEffect(noBlur);
        });

        //root.getChildren().add(canvas);
        root.getChildren().add(background);
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