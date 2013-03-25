package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import be.kdg.groeph.R;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.Cost;

import java.util.List;

/**
 * To change this template use File | Settings | File Templates.
 */
public class MyCostsActivity extends Activity {
    private String path = "/rest/getCostsByTripAndTripUser?tripId=";
    private List<Cost> costsByTrip;
    ListView lv_costs;
    String tripId;
    String tripUserId;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costmycosts);

        tripId = getIntent().getExtras().getString("tripId")+"";
        tripUserId = getIntent().getExtras().getString("tripUserId")+"";
        lv_costs = (ListView) findViewById(R.id.lstvw_costmycosts);
        getAllData();

    }

    private List<Cost> getAllData() {
        new AsyncTask<Void,Void,List<Cost>>(){

            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }
            @Override
            protected List<Cost> doInBackground(Void... params) {
                try {
                    System.out.println("costs tripId: " + tripId);
                    costsByTrip = new NetworkController().getCostsFromServer(path + tripId+"&tripUserId="+tripUserId);
                    System.out.println("GuntHasWorld result doInbackground" + costsByTrip);
                } catch (Exception e) {

                }

                return costsByTrip;
            }

            @Override
            protected void onPostExecute(List<Cost> result) {
                System.out.println("GuntHa result postExec: Costs: " + result);
                System.out.println("result: "+ result);
                costsByTrip = result;


                Cost[] lv_arr = {};


                lv_arr = costsByTrip.toArray(new Cost[0]);
                System.out.println("GuntHasWorld" + lv_arr);
                lv_costs.setAdapter(new ArrayAdapter<Cost>(MyCostsActivity.this, android.R.layout.simple_list_item_1, lv_arr));
            }
        }.execute();
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
