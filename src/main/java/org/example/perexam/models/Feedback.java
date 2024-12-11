package org.example.perexam.models;

public class Feedback {
    private String customerName;
    private String feedbackText;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    @Override
    public String toString() {
        return "Customer FeedBack: "+ "\n"+
                "Name: " + customerName+ "\n"+
                "FeedBack: " + feedbackText;
    }

}
