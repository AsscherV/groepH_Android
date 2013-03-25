package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import be.kdg.groeph.R;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.Cost;

import java.util.List;


public class CostActivity extends Activity {
    private String path = "/rest/getCostsByTrip?tripId=";
    private List<Cost> costsByTrip;
    double averageCost;
    double totalCost;
    double toReceive;
    final Context context = this;

    ListView lv_costs;
    String tripId;
    String tripUserId;

    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costs);
        tripId = getIntent().getExtras().getString("tripId") + "";
        tripUserId = getIntent().getExtras().getString("tripUserId" + "");
        initView();
    }

    private void initView() {
        lv_costs = (ListView) findViewById(R.id.listview_costs);
        costsByTrip = getCostsData();


        Button btnMyCosts = (Button) findViewById(R.id.btn_costs_mycosts);
        btnMyCosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MyCostsActivity.class);
                i.putExtra("tripId", tripId);
                i.putExtra("tripUserId", tripUserId);
                startActivity(i);
            }
        });

    }


    /*
    Zou normaal moeten werken
    //TODO: test this
     */
    private Double getAverageCost(final String tripId) {
        new AsyncTask<Void, Void, Double>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }

            @Override
            protected Double doInBackground(Void... params) {
                try {

                    averageCost = new NetworkController().getAverageCostsFromServer("/rest/getAverageCostForATrip?tripId=" + tripId);
                    System.out.println("GunthaBar - AverageCost " + averageCost);

                } catch (Exception e) {
                    exception = e;
                }

                return averageCost;
            }

            @Override
            protected void onPostExecute(Double result) {
                TextView txtAverage = (TextView) findViewById(R.id.txt_costs_average);
                txtAverage.setText(result+"");
            }


        }.execute();

        return null;
    }


    /*
    Dit zou normaal wel moetenn werken
    //TODO: TEST THIS
     */
    private Double getTotalCosts(final String tripId, String tripUserId) {
        new AsyncTask<Void, Void, Double>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Double doInBackground(Void... params) {
                try {
                    totalCost = new NetworkController().getTotalCostsFromServer("/rest/getTotalCostForATrip?tripId=" + tripId);
                } catch (Exception e) {
                    exception = e;
                }

                return averageCost;
            }

            @Override
            protected void onPostExecute(Double result) {
                TextView txtTotal = (TextView) findViewById(R.id.txt_costs_total);
                txtTotal.setText(result+"");

                totalCost = result;
            }


        }.execute();
        return null;
    }


    /*
    Deze zou normaal af moeten zijn
       //TODO: TEST THIS

     */
    private Double getCosttoReceive(final String tripId, final String tripUserId) {
        new AsyncTask<Void, Void, Double>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Double doInBackground(Void... params) {
                try {
                    toReceive = new NetworkController().getToReceiveFromServer("/rest/getCostForAUserByTripAndUser?tripId=" + tripId + "&tripUserId=" + tripUserId);
                } catch (Exception e) {
                    exception = e;
                }

                return toReceive;
            }

            @Override
            protected void onPostExecute(Double result) {
                TextView txtToReceive = (TextView) findViewById(R.id.txt_costs_PaymentsToReceive);
                txtToReceive.setText(result+"");


                toReceive = result;
            }

        }.execute();
        return null;
    }


    /*
    Zou normaal moeten werken
    //TODO: test this
     */
    private List<Cost> getCostsData() {

        new AsyncTask<Void, Void, List<Cost>>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }

            @Override
            protected List<Cost> doInBackground(Void... params) {
                try {
                    System.out.println("costs tripId: " + tripId);

                    costsByTrip = new NetworkController().getCostsFromServer(path + tripId);
                    System.out.println("GuntHa result doInbackground" + costsByTrip);
                } catch (Exception e) {
                    exception = e;
                }

                return costsByTrip;
            }

            @Override
            protected void onPostExecute(List<Cost> result) {
                System.out.println("GuntHa result postExec: Costs: " + result);
                System.out.println("result: " + result);
                costsByTrip = result;
                lv_costs = (ListView) findViewById(R.id.listview_costs);

                Cost[] lv_arr = {};
                lv_arr = costsByTrip.toArray(new Cost[0]);
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
                    Toast.makeText(getApplicationContext(), "No costs for this trip.", Toast.LENGTH_SHORT).show();
                } else{
                    lv_costs.setAdapter(new ArrayAdapter<Cost>(CostActivity.this, android.R.layout.simple_list_item_1, lv_arr));
                }
            }


        }.execute();

        return null;
    }


}