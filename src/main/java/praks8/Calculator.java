package praks8;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Calculator extends Application {


    private static String operand;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage Stage) throws Exception {

        VBox root = new VBox();
        root.setPrefSize(300, 190);

        TextField text = new TextField("0");
        text.setAlignment(Pos.CENTER_RIGHT);
        text.setPrefHeight(15);
        text.setEditable(Boolean.FALSE);

        root.getChildren().add(text);

        Button backspace = new Button("Backspace");
        backspace.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (text.getText().length() == 0)
                return;
            else
                text.setText(text.getText().substring(0, text.getText().length()-1));
        });
        Button ce = new Button("CE");
        Button c = new Button("C");
        c.setOnMouseClicked(event -> {
            text.setText("");
            operand = null;
        });

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
            if (symbol.matches("^[0-9]$")){
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    if ((Objects.equals(text.getText(), "0")))
                        text.setText(symbol);
                    else
                        text.setText(text.getText() + symbol);
                });
            }
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
        Stage.setTitle("Calculator");
        Stage.show();
    }

    static class Handler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

        }
    }

}
