package be.kdg.groeph.controllers;

import be.kdg.groeph.Globals;
import be.kdg.groeph.model.*;
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
        return dataParser.parseWaypoints(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            @Override
            public String handleResponse(InputStream input) throws IOException {
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


    public List<Accessory> getTripAccessoriesFromServer(String path) throws IOException{
        return dataParser.parseAccessories(dataFetcher.getFromServer(new DataFetcher.ResponseHandler(){
            @Override
        public String handleResponse(InputStream input) throws IOException {
                return IOUtils.toString(input);
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }

    public List<Cost> getCostsFromServer(String path) throws IOException {

        System.out.println("GuntHasWorld -ntwcntrol " + path);
        return dataParser.parseCosts(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            @Override
            public String handleResponse(InputStream input) throws IOException {

                return IOUtils.toString(input);
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }

    public Double getToReceiveFromServer(String path) throws IOException {

        return dataParser.parseToReceive(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            String response;
            @Override
            public String handleResponse(InputStream input) throws IOException {
                response = IOUtils.toString(input);
                return response;
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }

    public Double getAverageCostsFromServer(String path) throws IOException {
        return dataParser.parseAverageCost(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            String response;
            @Override
            public String handleResponse(InputStream input) throws IOException {

                try {
                    response = IOUtils.toString(input);
                    System.out.println("GunthaBar - AverageCost - NetwerkController " + response);


                    return response;
                } finally {
                    System.out.println("GunthaBar - AverageCost - NetwerkController - finally " + response);

                }
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }


    public Double getTotalCostsFromServer(String path) throws IOException {
        return dataParser.parseTotalCost(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
            String response;
            @Override
            public String handleResponse(InputStream input) throws IOException {
                response = IOUtils.toString(input);
                return response;
            }
        }, path, Globals.connectTimeout, Globals.readTimeout));
    }
}
