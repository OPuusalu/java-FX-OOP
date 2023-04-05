package kodu8;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class TryToClickThis extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();

        Pane pane = new Pane();
        pane.setPrefSize(500,500);

        Button button = new Button("Click me!");
        button.setPrefSize(100,40);


        pane.getChildren().add(button);

        pane.heightProperty().addListener((obs, oldVal, newVal) -> {});
        pane.widthProperty().addListener((obs, oldVal, newVal) -> {});

        button.setOnMouseEntered(event -> {

            Random random = new Random();

            button.setLayoutX(random.nextInt(Double.valueOf(pane.getWidth() - button.getWidth()).intValue()));
            button.setLayoutY(random.nextInt(Double.valueOf(pane.getHeight() - button.getHeight()).intValue()));

        });

        Image sadGirl = new Image("https://cdn.discordapp.com/attachments/1090586748532301896/1093209679905173564/girl_sad.png");

        button.setOnMousePressed(e -> {

            System.out.println("Button pressed");

            ImageView girlView = new ImageView(sadGirl);

            girlView.setLayoutX(Math.random() * (pane.getWidth() - sadGirl.getWidth()));
            girlView.setLayoutY(-sadGirl.getHeight());

            pane.getChildren().add(girlView);

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(girlView.layoutYProperty(), -sadGirl.getHeight())),
                    new KeyFrame(Duration.seconds(3), new KeyValue(girlView.layoutYProperty(), pane.getHeight()))
            );
            timeline.setOnFinished(evt -> {
                pane.getChildren().remove(girlView);
            });
            timeline.play();
        });

        button.setLayoutX(200);
        button.setLayoutY(200);

        root.getChildren().add(pane);
        Scene scene = new Scene(root);

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            pane.setPrefWidth(newVal.doubleValue());
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            pane.setPrefHeight(newVal.doubleValue());
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Click button for money!");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
