package be.kdg.groeph.model;



import java.io.Serializable;


public class Answer implements Serializable {

    private int id;

    private String answer;

    private Waypoint waypoint;

    public Answer() {
    }

    public Answer(String answer) {

        this.answer = answer;
    }

    public Answer(String answer, Waypoint waypoint) {
        this.answer=answer;
        this.waypoint=waypoint;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Waypoint getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(Waypoint waypoint) {
        this.waypoint = waypoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer1 = (Answer) o;

        if (!answer.equals(answer1.answer)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return answer.hashCode();
    }
}
