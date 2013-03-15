package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import be.kdg.groeph.R;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 11/03/13
 * Time: 14:20
 */
public class publicTripMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publictripmenu);
        initViews();
         Button info = (Button)findViewById(R.id.btn_infotrip);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TripInfoActivity.class);

                intent.putExtra("tripId", getIntent().getExtras().getString("tripId"));
                intent.putExtra("tripTitle", getIntent().getExtras().getString("tripTitle"));
                intent.putExtra("tripDescription", getIntent().getExtras().getString("tripDescription"));
                intent.putExtra("tripStartTime", getIntent().getExtras().getString("tripStartTime"));
                System.out.println("FB:Logging-PublicTripMenu - > " + getIntent().getExtras().getString("tripStartTime"));
                intent.putExtra("tripEndTime", getIntent().getExtras().getString("tripEndTime"));
                System.out.println("FB:Logging-PublicTripMenu - > " + getIntent().getExtras().getString("tripEndTime"));
                intent.putExtra("tripTripType", getIntent().getExtras().getString("tripTripType"));
                intent.putExtra("tripOrganiser", getIntent().getExtras().getString("tripOrganiser"));

                startActivity(intent);
                finish();
            }
        });

        Button Waypoints = (Button)findViewById(R.id.btn_waypoints);
        Waypoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WaypointActivity.class);
                startService(intent);

                startActivity(intent);
                finish();
            }
        });

        Button participants = (Button)findViewById(R.id.btn_participants);
        participants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TripParticipantsActivity.class);

                intent.putExtra("tripId", getIntent().getExtras().getString("tripId"));
                intent.putExtra("tripTitle", getIntent().getExtras().getString("tripTitle"));
                intent.putExtra("tripDescription", getIntent().getExtras().getString("tripDescription"));
                intent.putExtra("tripStartTime", getIntent().getExtras().getString("tripStartTime"));
                intent.putExtra("tripEndTime", getIntent().getExtras().getString("tripEndTime"));
                intent.putExtra("tripTripType", getIntent().getExtras().getString("tripTripType"));
                intent.putExtra("tripOrganiser", getIntent().getExtras().getString("tripOrganiser"));

                startActivity(intent);
                finish();
            }
        });


    }
    private void initViews() {

    }
}
