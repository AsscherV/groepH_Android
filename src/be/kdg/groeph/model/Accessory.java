package be.kdg.groeph.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Accessory implements Serializable {

    private int id;
    private String description;
    private boolean isChecked;
    private List<TripUser> tripUsers;
    private Trip trip;

    public Accessory() {
        tripUsers = new ArrayList<TripUser>() ;
    }

    public Accessory(String description, List<TripUser> tripUsers) {
        this.description=description;
        this.tripUsers=tripUsers;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TripUser> getTripUsers() {
        return tripUsers;
    }

    public void setTripUsers(List<TripUser> tripUsers) {
        this.tripUsers = tripUsers;
    }

    public void addTripUser(TripUser user){
        this.tripUsers.add(user);

    }
    public void removeTripUser(TripUser user){
            this.tripUsers.remove(user);

        }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
