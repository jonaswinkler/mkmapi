package de.jpwinkler.mkmapi.model;

import java.util.ArrayList;
import java.util.List;

public class Evaluation {
    private int evaluationGrade;
    private int itemDescription;
    private int packaging;
    private int speed;
    private String comment;
    private List<String> complaint = new ArrayList<>();

    public int getEvaluationGrade() {
        return evaluationGrade;
    }

    public void setEvaluationGrade(int evaluationGrade) {
        this.evaluationGrade = evaluationGrade;
    }

    public int getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(int itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getPackaging() {
        return packaging;
    }

    public void setPackaging(int packaging) {
        this.packaging = packaging;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getComplaint() {
        return complaint;
    }

    public void setComplaint(List<String> complaint) {
        this.complaint = complaint;
    }
}
