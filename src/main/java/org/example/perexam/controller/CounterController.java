package org.example.perexam.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.perexam.models.Counter;

public class CounterController {
    private Counter counter = new Counter();
    @FXML
    private Label countLabel;
    @FXML
    private Button incrementButton;
    @FXML
    private Button resetButton;

    @FXML
    public void initialize(){
        incrementButton.setOnAction(a ->{
            counter.increment();
            updateLabel();
        } );
        resetButton.setOnAction(a ->{
            counter.reset();
            updateLabel();
        } );
    }
    private void updateLabel(){
        countLabel.setText(String.valueOf(counter.getCount()));
    }
}
