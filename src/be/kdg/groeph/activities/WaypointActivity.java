package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import be.kdg.groeph.R;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.Accessory;
import be.kdg.groeph.model.Waypoint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 13/03/13
 * Time: 12:35
 */
public class WaypointActivity extends Activity {
    final Context context = this;
    String path = "/rest/getWaypointsByTripId?tripId=";

    public List<Waypoint> waypoints;
    ListView lv_waypoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        path += getIntent().getExtras().getString("tripId");

        setContentView(R.layout.waypointlist);

        initView();

    }


    private void initView() {
        lv_waypoints = (ListView) findViewById(R.id.listview_waypoints);
        lv_waypoints.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Waypoint selectedWaypoint = waypoints.get((int) l);
                Intent intent = new Intent(context,WaypointInfoActivity.class);

                intent.putExtra("waypointId", selectedWaypoint.getId() + "");
                intent.putExtra("waypointDescription", selectedWaypoint.getDescription()+"");
                intent.putExtra("waypointLabel", selectedWaypoint.getLabel()+"");
                intent.putExtra("waypointLong", selectedWaypoint.getLongitude()+"");
                intent.putExtra("waypointLat", selectedWaypoint.getLattitude()+"");

                startActivity(intent);
                //finish();
            }
        });
        List<Waypoint> waypoints;
        waypoints = getWaypointsData();

        //TODO: removed until google maps api is fixed
        //createMarkers(waypoints);

    }

    /*
    private void createMarkers(List<Waypoint> waypoints) {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapView);

        GoogleMap googleMap = mapFragment.getMap();

        for (Waypoint waypoint : waypoints) {
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(waypoint.getLattitude(), waypoint.getLongitude()))
                    .title(waypoint.getLabel())
                    .snippet(waypoint.getDescription())
            );
        }

    }
       */

    public List<Waypoint> getWaypointsData() {

        new AsyncTask<Void, Void, List<Waypoint>>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }

            @Override
            protected List<Waypoint> doInBackground(Void... params) {
                List<Waypoint> waypoints = null;

                try {
                    waypoints = new NetworkController().getWaypointsFromServer(path);
                    System.out.println("GuntHa result doInbackground" + waypoints);
                } catch (Exception e) {
                    exception = e;
                }

                return waypoints;
            }

            @Override
            protected void onPostExecute(List<Waypoint> result) {
                System.out.println("GuntHa result postExec" + result);
                waypoints = result;
                lv_waypoints = (ListView) findViewById(R.id.listview_waypoints);

                Waypoint[] lv_arr = {};
                lv_arr = waypoints.toArray(new Waypoint[0]);
                if(lv_arr.length == 0){
                    Intent intent = new Intent(context, publicTripMenuActivity.class);
                    intent.putExtra("tripUserId", getIntent().getExtras().getString("tripUserId") + "");
                    intent.putExtra("tripId", getIntent().getExtras().getString("tripId") + "");
                    intent.putExtra("tripTitle", getIntent().getExtras().getString("tripTitle"));
                    intent.putExtra("tripDescription", getIntent().getExtras().getString("tripDescription"));
                    intent.putExtra("tripStartTime", getIntent().getExtras().getString("tripStartTime"));
                    intent.putExtra("tripEndTime", getIntent().getExtras().getString("tripEndTime"));
                    intent.putExtra("tripTripType", getIntent().getExtras().getString("tripTripType"));
                    intent.putExtra("tripOrganiser", getIntent().getExtras().getString("tripOrganiser"));
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "No waypoints for this trip.", Toast.LENGTH_SHORT).show();
                }  else{
                    lv_waypoints.setAdapter(new ArrayAdapter<Waypoint>(WaypointActivity.this, android.R.layout.simple_list_item_1, lv_arr));

                }
            }

        }.execute();

        return null;
    }


}
