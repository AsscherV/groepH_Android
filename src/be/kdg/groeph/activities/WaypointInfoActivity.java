package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import be.kdg.groeph.R;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.Waypoint;
import com.qualcomm.QCARSamples.CloudRecognition.CloudReco;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 14/03/13
 * Time: 21:43
 */
public class WaypointInfoActivity extends Activity {
    final Context context = this;
    Intent intent;
    String waypointId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waypointinfo);



        TextView waypointtitle = (TextView)findViewById(R.id.txt_WaypointTitle);
        TextView waypointDescription = (TextView)findViewById(R.id.txt_WaypointDescription);
        TextView waypointLongitude = (TextView)findViewById(R.id.txt_WaypointLongitude);
        TextView waypointLattitude = (TextView)findViewById(R.id.txt_WaypointLattitude);

        waypointId = getIntent().getExtras().getString("waypointId")+"";
        waypointtitle.setText(getIntent().getExtras().getString("waypointLabel")+"");
        waypointDescription.setText(getIntent().getExtras().getString("waypointDescription")+"");
        waypointLongitude.setText(getIntent().getExtras().getString("waypointLong")+"");
        waypointLattitude.setText(getIntent().getExtras().getString("waypointLat")+"");

        initViews();
    }

    private void initViews() {




        Button button = (Button)findViewById(R.id.btn_waypointVuforia);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask<Void, Void, Waypoint>() {

                    private Exception exception = null;

                    @Override
                    protected void onPreExecute() {

                        super.onPreExecute();
                    }

                    @Override
                    protected Waypoint doInBackground(Void... params) {
                        Waypoint waypoint = null;

                        try {
                            System.out.println("wayID: " + waypointId);
                            waypoint = new NetworkController().getWaypointFromServer("/rest/getWaypointsByWaypointId?id="+waypointId);

                        } catch (Exception e) {
                            exception = e;
                        }

                        return waypoint;
                    }

                    @Override
                    protected void onPostExecute(Waypoint result) {

                        //TODO: GUNTHABAR change the Activity
                        Intent i = new Intent(context, CloudReco.class);

                        i.putExtra("waypointTitle",result.getLabel());
                        i.putExtra("waypointDescription",result.getDescription());



                        startActivity(i);
                        //finish();

                    }


                }.execute();            }
        });



    }
}