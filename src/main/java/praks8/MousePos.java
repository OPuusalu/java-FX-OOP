package praks8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MousePos extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();


        pane.setPrefSize(400, 300);

        Text label = new Text();
        pane.getChildren().add(label);

        pane.setOnMouseDragged(e -> {
            label.setVisible(true);
            label.setText("(" + e.getX() + ", " + e.getY() + ")");
            label.setLayoutX(e.getX());
            label.setLayoutY(e.getY());
        });

        pane.setOnMouseDragReleased(e -> label.setVisible(false));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mouse pos when mouse is clicked");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
