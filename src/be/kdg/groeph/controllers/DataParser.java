package be.kdg.groeph.controllers;

import be.kdg.groeph.model.*;
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

    public List<Accessory> parseAccessories(String data) {
        List<Accessory> lAccessories = null;
        try{
            lAccessories = new JSONDeserializer<List<Accessory>>().deserialize(data);
            if (lAccessories == null){
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        }catch (Exception ex){
            System.out.println("FB" + ex.getMessage().toString());
        }
        System.out.println("OUTPUT" + data.toString());

        return lAccessories;
    }

    public List<Cost> parseCosts(String data) {
        List<Cost> costs = null;
        try {
            System.out.println("GuntHa -> Data: Costsparsing = " + data);
            costs = new JSONDeserializer<List<Cost>>().deserialize(data);
            if (costs == null) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB:" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return costs;

    }

    //TODO:FIX IT FELIX
    public Double parseAverageCost(String data) {
        System.out.println("GunthaBar - AverageCost - DataParser - PrePreSerializing " + data);

        double averageCost = 0.0;

        try {
            System.out.println("GunthaBar - AverageCost - DataParser - PreSerializing " + data);
            averageCost = new JSONDeserializer<Double>().deserialize(data);
            System.out.println("GunthaBar - AverageCost - DataParser - PostSerializing " + averageCost);
            if (averageCost == 0.0) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB:" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return averageCost;

    }

    public Double parseTotalCost(String data) {
        double totalCost = 0.0;
        try {
            totalCost = new JSONDeserializer<Double>().deserialize(data);
            if (totalCost == 0.0) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB:" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return totalCost;
    }

    public Double parseToReceive(String data) {
        double toReceive = 0.0;
        try {
            toReceive = new JSONDeserializer<Double>().deserialize(data);
            if (toReceive == 0.0) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        } catch (Exception ex) {
            System.out.println("FB:" + ex.getMessage().toString());
        }

        System.out.println("OUTPUT" + data.toString());

        return toReceive;
    }
}
