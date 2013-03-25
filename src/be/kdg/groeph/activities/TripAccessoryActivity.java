package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import be.kdg.groeph.R;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.Accessory;
import be.kdg.groeph.model.TripUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: glenn
 * Date: 22/03/13
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class TripAccessoryActivity extends Activity {
    final Context context = this;

    private String path = "/rest/getAccessoriesByTrip?tripId=";

    public List<Accessory> accessories;
    ListView lv_accessories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publictrips);

        path += getIntent().getExtras().getString("tripId");
        getData(path);
        lv_accessories = (ListView) findViewById(R.id.publicTripsListView);
        /*
        lv_participatingUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Trip selectedTrip = publicTrips.get((int) l);
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
        */

        initViews();

    }

    private void initViews() {

    }

    private void getData(final String path) {
        new AsyncTask<Void, Void, List<Accessory>>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }

            @Override
            protected List<Accessory> doInBackground(Void... params) {
                List<Accessory> laccessories = null;

                try {
                    laccessories = new NetworkController().getTripAccessoriesFromServer(path);
                } catch (Exception e) {
                    exception = e;
                }

                accessories = laccessories;
                return laccessories;
            }

            @Override
            protected void onPostExecute(List<Accessory> result) {

                //TODO: add the data to the list

                lv_accessories = (ListView) findViewById(R.id.publicTripsListView);

                Accessory[] lv_arr = {};
                lv_arr = accessories.toArray(new Accessory[0]);

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
                    //finish();
                    Toast.makeText(getApplicationContext(), "No accessories for this trip.", Toast.LENGTH_SHORT).show();
                }else{
                    lv_accessories.setAdapter(new ArrayAdapter<Accessory>(TripAccessoryActivity.this, android.R.layout.simple_list_item_1, lv_arr));
                }
            }

        }.execute();

    }
}
