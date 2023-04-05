package kodu8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class askQuestion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        String question ="Yes or no?";
        String[] answers = {"Yes", "No"};

        Label label = new Label(question);
        ToggleGroup toggleGroup = new ToggleGroup();
        VBox answerBox = new VBox(10);
        for (String answer : answers) {
            RadioButton radioButton = new RadioButton(answer);
            radioButton.setToggleGroup(toggleGroup);
            answerBox.getChildren().add(radioButton);
        }
        Button button = new Button("Submit");
        Label label1 = new Label();

        button.setOnAction(e -> {
            RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (radioButton != null && radioButton.getText().equals("14")) {
                label1.setText("You are correct.");
            } else {
                label1.setText("Sorry, the correct answer is 14.");
            }
        });

        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(label, answerBox, button, label1);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Important question!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
