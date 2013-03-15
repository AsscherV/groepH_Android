package be.kdg.groeph.controllers;

import be.kdg.groeph.model.Trip;
import be.kdg.groeph.model.TripUser;
import be.kdg.groeph.model.Waypoint;
import com.google.gson.JsonSyntaxException;
import flexjson.JSONDeserializer;

import java.util.List;

/**
 * @author Jo Somers - jo@webcomrades.be
 * @version 1.0
 * @company WebComrades
 * @year 2013
 */

public class DataParser {

    public DataParser() {

    }

    public TripUser parseData(String data) {

/*
Gson gson = new GsonBuilder().create();
Type rootType = new TypeToken<TripUser>(){}.getType();

TripUser object = gson.fromJson(data, rootType);
if(object == Null) {
throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
}
return object;
*/

        TripUser Tuser = null;
        try {
            System.out.println("test");
            Tuser = new JSONDeserializer<TripUser>().deserialize(data);
            if (Tuser == null) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return Tuser;

/*
ObjectMapper mapper = new ObjectMapper();
TripUser Tuser = Null;
try {
Tuser = mapper.readValue(data, TripUser.class);
} catch (IOException e) {
e.printStackTrace(); //To change body of catch statement use File | Settings | File Templates.
}

return Tuser;
*/
/*
TripUser Tuser = gson.fromJson(data, TripUser.class);
System.out.println("OUTPUT"+Tuser.toString());
*/

    }

    public List<Trip> parsePublicTrips(String data) {
        List<Trip> trips = null;
        try {
            System.out.println("test");
            trips = new JSONDeserializer<List<Trip>>().deserialize(data);
            if (trips == null) {
               throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return trips;

    }

    public List<Waypoint> parseWaypoints(String data) {
        List<Waypoint> waypoints = null;
        try {
            System.out.println("GuntHa -> Data = " + data);
            waypoints = new JSONDeserializer<List<Waypoint>>().deserialize(data);
            if (waypoints == null) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB:" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return waypoints;

    }

    public Waypoint parseWaypoint(String data) {
        Waypoint waypoint = null;
        try {
            System.out.println("test");
            waypoint = new JSONDeserializer<Waypoint>().deserialize(data);
            if (waypoint == null) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return waypoint;

    }

    public List<TripUser> parseTripUsers(String data) {
        List<TripUser> tUsers = null;
        try {
            System.out.println("test");
            tUsers = new JSONDeserializer<List<TripUser>>().deserialize(data);
            if (tUsers == null) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return tUsers;

    }
}
