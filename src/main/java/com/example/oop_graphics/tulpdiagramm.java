package com.example.oop_graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class tulpdiagramm extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Pane pane = new Pane();

        List<Integer> arvud = loeArvud();

        int x = 25;

        for (Integer arv : arvud) {

            Rectangle tulp = new Rectangle(x, 150-arv, 25, arv);
            tulp.setFill(arv>50 ? Color.RED : Color.BLUE);
            Text number = new Text(String.valueOf(arv));
            number.setFill(tulp.getFill());
            number.setX(x+ 5);
            number.setY(170);
            pane.getChildren().add(number);
            pane.getChildren().add(tulp);
            x += 35;

        }

        Scene scene = new Scene(pane, 400, 250);
        stage.setTitle("Tulpdiagramm");
        stage.setScene(scene);
        stage.show();

    }

    private List<Integer> loeArvud() throws IOException {

        return Files.readAllLines(Path.of("src/arvud.txt")).stream().map(Integer::parseInt).toList();

    }

    public static void main(String[] args) {
        launch();
    }
}
