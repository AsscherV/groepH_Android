package be.kdg.groeph.model;


import android.graphics.Bitmap;
import be.kdg.groeph.model.Null.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Waypoint implements Nullable, Serializable {

    private int id;
    private String label;
    private String description;
    private double lattitude;
    private double longitude;
    private WaypointType waypointType;
    private Trip trip;
    private String targetId;
    private Bitmap thumb;
    private String waypointUrl;
    private int correctAnswer;
    private List<Answer> answers;


    public Waypoint(){

    }

    public Waypoint(String label, WaypointType waypointType, double lattitude, double longitude, String question,  String answer1, String answer2, String answer3, String answer4, int correctAnswer) {
        this.label=label;
        this.waypointType=waypointType;
        this.lattitude=lattitude;
        this.longitude=longitude;
        this.description=question;
        this.correctAnswer=correctAnswer;
        answers= new ArrayList<Answer>();
        this.answers.add(new Answer(answer1));
        this.answers.add(new Answer(answer2));
        this.answers.add(new Answer(answer3));
        this.answers.add(new Answer(answer4));
    }

    public WaypointType getWaypointType() {
        return waypointType;
    }

    public void setWaypointType(WaypointType waypointType) {
        this.waypointType = waypointType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }


    @Override
    public boolean isNull() {
        return false;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Bitmap getThumb() {
        return thumb;
    }

    public void setThumb(Bitmap thumb) {
        this.thumb = thumb;
    }

    public String getWaypointUrl() {
        return waypointUrl;
    }

    public void setWaypointUrl(String waypointUrl) {
        this.waypointUrl = waypointUrl;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void recycle()
    {
        // Cleans the Thumb bitmap variable
        thumb.recycle();
        thumb = null;
    }

    @Override
    public String toString() {
        return "Title: " + label + " Description: " + description;
    }
}
