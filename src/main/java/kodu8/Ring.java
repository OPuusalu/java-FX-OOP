package kodu8;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ring extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {


        Circle ring1 = new Circle(100, 100, 100, Color.RED);
        // setOnMouseEntered määrab sündmuse käsitleja
        // käsitleja defineeritakse anonüümse klassiga
        ring1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                // siin saab kasutada ka ümbritsevas skoobis olevaid muutujaid, nt ring1
                System.out.println("Mouse on circle");
            }
        }); // loogeline sulg lõpetab klassi ja tavaline sulg meetodi väljakutse
        ring1.setOnMouseExited(event -> {
            System.out.println("Mouse exited circle");
        });
        /*
        ring1.setOnMousePressed(event -> {
            System.out.println("Circle has been clicked");
        })
         */

        ring1.addEventHandler(MouseEvent.DRAG_DETECTED, new Handler());

        ring1.addEventHandler(MouseEvent.MOUSE_CLICKED, new Handler2(ring1));

        Pane pane = new Pane(ring1);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    static class Handler2 implements EventHandler<MouseEvent> {
        private final Circle circle;

        public Handler2(Circle circle) {
            this.circle = circle;
        }

        public void handle(MouseEvent me) {
            circle.setFill(Color.GREEN);
        }
    }

    static class Handler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("Drag detected");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
