package com.example.oop_graphics;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class someDevice extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        pane.setMinSize(1000, 500);

        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(900, 100);

        Text text = new Text("Enter your password, please");
        Button button = new Button("Enter");
        PasswordField passwordField = new PasswordField();

        borderPane.setTop(text);
        borderPane.setCenter(passwordField);

        HBox bottomContainer = new HBox(button);
        borderPane.setBottom(bottomContainer);

        pane.getChildren().add(borderPane);
        borderPane.setLayoutX(50);
        borderPane.setLayoutY(100);

        BorderPane secondScreen = new BorderPane();
        secondScreen.setMinSize(900, 300);

        Text text2 = new Text("lol get your password stolen");
        text2.setLayoutX(-300);
        text2.setLayoutY(100);

        Path path = new Path();
        path.getElements().add(new MoveTo(-200, 100));
        path.getElements().add(new CubicCurveTo(500, 100, 250, 0, 1400, 100));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(8000));
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setPath(path);
        pathTransition.setNode(text2);

        secondScreen.getChildren().add(text2);
        secondScreen.setLayoutX(100);
        secondScreen.setLayoutY(300);

        pane.getChildren().add(secondScreen);

        bottomContainer.setSpacing(20);

        button.setOnAction(e -> {
            bottomContainer.getChildren().removeIf(node -> node instanceof Text && ((Text) node).getText().equals("You need to enter a password"));
            if (!passwordField.getText().isEmpty()) {
                pathTransition.play();
            } else {
                bottomContainer.getChildren().add(new Text("You need to enter a password"));
            }
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Albanian Virus");
        primaryStage.setAlwaysOnTop(Boolean.TRUE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
