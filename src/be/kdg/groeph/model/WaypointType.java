package be.kdg.groeph.model;


import java.util.ArrayList;
import java.util.List;

public class WaypointType {

    private int id;

    private String type;

    private List<Waypoint> waypoints = new ArrayList<Waypoint>();

    public WaypointType() {
    }

    public WaypointType(String type) {
        this.type=type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }
}
