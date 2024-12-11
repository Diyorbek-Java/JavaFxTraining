package org.example.perexam.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.perexam.models.Feedback;

public class FeedBackController {
    @FXML
    private TextField nameField;

    @FXML
    private TextArea feedbackArea;

    @FXML
    private Button submitbutton;

    @FXML
    private TextArea outputArea;

    @FXML
    public void initialize(){
        submitbutton.setOnAction(a ->{
           submitFeedback();
        } );

    }
    private void submitFeedback(){
        Feedback feedback = new Feedback();
        feedback.setCustomerName(nameField.getText());
        feedback.setFeedbackText(feedbackArea.getText());

        outputArea.setText(feedback.toString());
    }


}
