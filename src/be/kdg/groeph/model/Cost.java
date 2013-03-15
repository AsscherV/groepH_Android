package be.kdg.groeph.model;



/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 28/02/13
 * Time: 15:03
 */


public class Cost {


    private int id;
    String text;
    Double costValue;
    TripUser tripUser;
    Trip trip;

    public Cost() {
    }

    public Cost(String text, Double costValue, TripUser tripUser, Trip trip) {
        this.text = text;
        this.costValue = costValue;
        this.tripUser = tripUser;
        this.trip = trip;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getCostValue() {
        return costValue;
    }

    public void setCostValue(Double costValue) {
        this.costValue = costValue;
    }

    public TripUser getTripUser() {
        return tripUser;
    }

    public void setTripUser(TripUser tripUser) {
        this.tripUser = tripUser;
    }
}
