package be.kdg.groeph.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import be.kdg.groeph.R;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 12/03/13
 * Time: 13:28
 */
public class TripInfoActivity extends Activity {
    String trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tripinfo);
        //TODO: add ze alllemaal apart toe aan de intent
        // haal deze dan allemaal apart uit de intent en add deze aan de velden
        TextView txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText(getIntent().getExtras().getString("tripTitle"));

        TextView txt_description = (TextView) findViewById(R.id.txt_description);
        txt_description.setText(getIntent().getExtras().getString("tripDescription"));

        TextView startime = (TextView) findViewById(R.id.txt_Starttime);
        startime.setText(getIntent().getExtras().getString("tripStartTime"));
        System.out.println("FB:Logging - > " + getIntent().getExtras().getString("tripStartTime"));

        TextView endtime = (TextView) findViewById(R.id.txt_Endtime);
        endtime.setText(getIntent().getExtras().getString("tripEndTime"));
        System.out.println("FB:Logging - > " + getIntent().getExtras().getString("tripEndTime"));


        TextView txt_triptype = (TextView) findViewById(R.id.txt_type);
        txt_triptype.setText(getIntent().getExtras().getString("tripTripType"));

        System.out.println("FB:Logging - > " + getIntent().getExtras().getString("tripTripType"));
        //TODO: fix the label by the new model also in PublictripsMenuActivity
        TextView txtLabel = (TextView) findViewById(R.id.txt_Label);
        txtLabel.setText("No Label this is a todo");

        TextView txt_Organiser = (TextView) findViewById(R.id.txt_Organiser);
        txt_Organiser.setText(getIntent().getExtras().getString("tripOrganiser"));


        initViews();

    }

    private void initViews() {

    }

}
