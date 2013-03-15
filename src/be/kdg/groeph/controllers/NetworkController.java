package be.kdg.groeph.controllers;

import be.kdg.groeph.Globals;
import be.kdg.groeph.model.Trip;
import be.kdg.groeph.model.TripUser;
import be.kdg.groeph.model.Waypoint;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class NetworkController {
	
	private DataFetcher dataFetcher;
	private DataParser dataParser;

	public NetworkController() {
		this.dataParser = new DataParser();
		this.dataFetcher = new DataFetcher();
	}
	
	public TripUser getDataFromServer(String path) throws IOException {
		return dataParser.parseData(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
			@Override
			public String handleResponse(InputStream input) throws IOException {
				return IOUtils.toString(input);
			}
		}, path, Globals.connectTimeout, Globals.readTimeout));
	}
    public List<Trip> getPublicTripsFromServer(String path) throws IOException {
        return dataParser.parsePublicTrips(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            @Override
            public String handleResponse(InputStream input) throws IOException {
                return IOUtils.toString(input);
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }
    public List<Waypoint> getWaypointsFromServer(String path) throws IOException {

        System.out.println("GuntHa " + path);
        return dataParser.parseWaypoints(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            @Override
            public String handleResponse(InputStream input) throws IOException {
                System.out.println("GuntHa " + input);
                return IOUtils.toString(input);
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }

    public Waypoint getWaypointFromServer(String path) throws IOException {
        return dataParser.parseWaypoint(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            @Override
            public String handleResponse(InputStream input) throws IOException {
                return IOUtils.toString(input);
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }

    public List<TripUser> getTripUsersFromServer(String path) throws IOException {
        return dataParser.parseTripUsers(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            @Override
            public String handleResponse(InputStream input) throws IOException {
                return IOUtils.toString(input);
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }

	
}
