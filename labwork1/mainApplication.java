package com.example.labwork1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class mainApplication extends Application {
    @Override
    public void start(Stage stage) {



        Scene scene = new Scene(new BorderPane(), 320, 240);
        stage.setTitle("Student Management");
        stage.setScene(scene);
        stage.show();
    }
}