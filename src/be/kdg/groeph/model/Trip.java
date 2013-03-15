package be.kdg.groeph.model;

import be.kdg.groeph.model.Null.NullTrip;
import be.kdg.groeph.model.Null.Nullable;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Trip implements Nullable, Serializable {

    private int id;
    private String title;
    private String description;
    private Date startTime;
    private Date endTime;
    private boolean isPublic;
    private boolean isVisible;
    private boolean isStarted;
    private String label;
    private TripType tripType;
    private TripUser tripUser;
    private List<TripUser> tripUsers = new ArrayList<TripUser>();
    private List<TripUser> confirmedTripUsers = new ArrayList<TripUser>();
    private List<Cost> costs = new ArrayList<Cost>();
    private List<Waypoint> waypoints = new ArrayList<Waypoint>();
    private List<Accessory> accessories = new ArrayList<Accessory>();

    public Trip() {
    }

    public Trip(String title, String description, Date startTime, Date endTime, String label, TripType tripType, boolean isPublic) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.label = label;
        this.tripType = tripType;
        this.isPublic = isPublic;
    }

    public Trip(String title, String description, Date startTime, Date endTime, String label, TripType tripType, boolean isPublic, boolean visible) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.label = label;
        this.tripType = tripType;
        this.isPublic = isPublic;
        this.isVisible = visible;
    }

    public Trip(String title, String description, Date startTime, Date endTime, TripType tripType, boolean isPublic,boolean visible) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripType = tripType;
        this.isPublic = isPublic;
        this.isVisible = visible;
    }
    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }
    
    /*public void addLabel(Label label) {
        label.setTrip(this);
        labels.add(label);
    }   */

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public static Trip INVALID_TRIP() {
        return new NullTrip();
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public TripUser getTripUser() {
        return tripUser;
    }

    public void setTripUser(TripUser tripUser) {
        this.tripUser = tripUser;
    }

    public void addTripUser(TripUser tripUser) {
        tripUsers.add(tripUser);
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public void addWaypoint(Waypoint waypoint) {
        waypoints.add(waypoint);
        waypoint.setTrip(this);
    }
    public void deleteWaypoint(Waypoint waypoint){
        waypoint.setTrip(null);
        waypoints.remove(waypoint);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }



    public List<TripUser> getConfirmedTripUsers() {

        return confirmedTripUsers;
    }

    public void setConfirmedTripUsers(List<TripUser> confirmedTripUsers) {
        this.confirmedTripUsers = confirmedTripUsers;
    }

    public void addConfirmedUser(TripUser user) {
        //System.out.println("size confirmedTripUsers before: " + confirmedTripUsers.size());
        confirmedTripUsers.add(user);
        //System.out.println("size confirmedTripUsers after: " + confirmedTripUsers.size());
        //System.out.println("size tripUsers before: " + tripUsers.size());
        tripUsers.remove(user);
        //System.out.println("size tripUsers after: " + tripUsers.size());
    }
    public void addAccessory(Accessory accessory) {
        accessory.setTrip(this);
        this.accessories.add(accessory);
    }


    public void deleteAccessory(Accessory accessory) {
        accessory.setTrip(null);
        accessories.remove(accessory);

    }
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        if (endTime == null && startTime == null) {
            return "title: " + title;
        } else {
            return "title: " + title + " starttime: " + sdf.format(startTime) + " endtime: " + sdf.format(endTime);
        }
// return "title: " + title + " starttime: " + sdf.format(startTime) +" endtime: "+ sdf.format(endTime);
    }
}
