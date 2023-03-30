package oopGraphics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;

public class kalkulaator extends Application {
    @Override
    public void start(Stage Stage) throws Exception {

        VBox root = new VBox();
        root.setPrefSize(300, 190);

        TextField text = new TextField();
        text.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        text.setPrefHeight(15);
        text.setEditable(Boolean.FALSE);

        root.getChildren().add(text);

        Button backspace = new Button("Backspace");
        Button ce = new Button("CE");
        Button c = new Button("C");

        backspace.setAlignment(Pos.CENTER_LEFT);
        ce.setPrefWidth(60);
        c.setPrefWidth(60);
        backspace.setTextFill(Color.RED);
        ce.setTextFill(Color.RED);
        c.setTextFill(Color.RED);

        HBox CeC = new HBox(ce, c);
        CeC.setSpacing(5);

        CeC.setAlignment(Pos.CENTER_RIGHT);

        List<String> symbols = List.of("7", "8", "9", "/", "sqrt", "4", "5", "6", "*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ",", "+", "=");
        List<String> reds = List.of("/", "*", "-", "+", "=");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(6);
        gridPane.setHgap(6);
        gridPane.setPadding(new Insets(5));

        int x = 0, y = 0;

        for (String symbol : symbols) {

            Button button = new Button(symbol);
            button.setPrefWidth(60);
            button.setTextFill(reds.contains(symbol) ? Color.RED : Color.BLUE);
            gridPane.add(button, x, y);
            x++;
            if (x == 5){
                x = 0;
                y++;
            }
        }

        HBox firstRow = new HBox(5, backspace, CeC);
        HBox.setHgrow(backspace, Priority.NEVER);
        HBox.setHgrow(CeC, Priority.ALWAYS);

        firstRow.setAlignment(Pos.CENTER_RIGHT);
        firstRow.setPadding(new Insets(5, 5, 5, 5));
        firstRow.setPadding(new Insets(5));

        root.getChildren().add(firstRow);
        root.getChildren().add(gridPane);

        Scene scene = new Scene(root);
        Stage.setResizable(Boolean.FALSE);
        Stage.setScene(scene);
        Stage.setTitle("Kalkulaator");
        Stage.show();
    }
}
