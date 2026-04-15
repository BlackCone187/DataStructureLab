package com.example.labwork1;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StudentPane {
    private BorderPane root;
    private GridPane pane;
    private Label idLb, nameLb, avgLb;
    private TextField idTf, nameTf, avgTf;
    private Button add, remove;

    public StudentPane() {

    }

    public BorderPane getRoot() {
        return root;
    }
}
