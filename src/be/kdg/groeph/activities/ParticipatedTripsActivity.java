package be.kdg.groeph.activities;

import android.app.Activity;
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
import be.kdg.groeph.model.Trip;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: glenn
 * Date: 15/03/13
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
public class ParticipatedTripsActivity extends Activity {
    private String path = "/rest/participatingTrips?tripUserEmail=";

    public List<Trip> participatingTrips;
    ListView lv_participatingTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publictrips);

        path += getIntent().getExtras().getString("tripUserEmail");
        getData(path);
        lv_participatingTrips = (ListView) findViewById(R.id.publicTripsListView);
        lv_participatingTrips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Trip selectedTrip = participatingTrips.get((int) l);
                Intent intent = new Intent(getApplicationContext(), publicTripMenuActivity.class);


                intent.putExtra("tripId", selectedTrip.getId());
                intent.putExtra("tripTitle", selectedTrip.getTitle());
                intent.putExtra("tripDescription", selectedTrip.getDescription());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());

                if (selectedTrip.getStartTime() != null) {
                    intent.putExtra("tripStartTime", sdf.format(selectedTrip.getStartTime()));

                } else {
                    intent.putExtra("tripStartTime", "noTimeSet");

                }

                if (selectedTrip.getEndTime() != null) {
                    intent.putExtra("tripEndTime", sdf.format(selectedTrip.getEndTime()));

                } else {
                    intent.putExtra("tripEndTime", "noTimeSet");
                }


                intent.putExtra("tripTripType", selectedTrip.getTripType().toString());
                intent.putExtra("tripOrganiser", selectedTrip.getTripUser().getFirstName() + " " + selectedTrip.getTripUser().getLastName());
//                intent.putExtra("tripLabel", selectedTrip.getLabels().get(0));

                startActivity(intent);
                finish();

            }
        });

        initViews();

    }

    private void initViews() {

    }

    private void getData(final String path) {
        new AsyncTask<Void, Void, List<Trip>>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }

            @Override
            protected List<Trip> doInBackground(Void... params) {
                List<Trip> trips = null;

                try {
                    trips = new NetworkController().getPublicTripsFromServer(path);
                } catch (Exception e) {
                    exception = e;
                }

                participatingTrips = trips;
                return trips;
            }

            @Override
            protected void onPostExecute(List<Trip> result) {

                //TODO: add the data to the list

                lv_participatingTrips = (ListView) findViewById(R.id.publicTripsListView);

                Trip[] lv_arr = {};
                lv_arr = participatingTrips.toArray(new Trip[0]);

                if(lv_arr.length == 0){
                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(getApplicationContext(), "No participating trips available.", Toast.LENGTH_SHORT).show();
                }else{
                    lv_participatingTrips.setAdapter(new ArrayAdapter<Trip>(ParticipatedTripsActivity.this, android.R.layout.simple_list_item_1, lv_arr));
                }

            }

        }.execute();
    }
}
