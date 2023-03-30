package com.example.oop_graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class kalkulaator extends Application {
    @Override
    public void start(Stage Stage) throws Exception {

        Region region = new Region();
        region.setMinSize(600, 400);



        Scene scene = new Scene(region);
        Stage.setResizable(Boolean.FALSE);
        Stage.setScene(scene);
        Stage.setTitle("Kalkulaator");
        Stage.show();


    }
}
