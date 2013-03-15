package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import be.kdg.groeph.R;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 8/03/13
 * Time: 13:13
 */
public class MenuActivity extends Activity {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button requestLogoutButton = (Button) findViewById(R.id.btn_Logout);
        requestLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: invalidate the sesison
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button publicTripsButton = (Button) findViewById(R.id.btn_Trips);
        publicTripsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: invalidate the sesison
                Intent i = new Intent(getApplicationContext(),PublicTripsActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button organizedTripsButton = (Button) findViewById(R.id.btn_MyTrips);
        organizedTripsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: invalidate the sesison
                Intent i = new Intent(getApplicationContext(),OrganizedTripsActivity.class);
                i.putExtra("tripUserEmail",getIntent().getExtras().getString("tripUserEmail"));
                startActivity(i);
                finish();
            }
        });

        Button profileButton = (Button) findViewById(R.id.btn_Profile);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: invalidate the sesison
                Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
                i.putExtra("tripUserEmail",getIntent().getExtras().getString("tripUserEmail"));
                i.putExtra("tripUserFirstName",getIntent().getExtras().getString("tripUserFirstName"));
                i.putExtra("tripUserName",getIntent().getExtras().getString("tripUserName"));
                i.putExtra("tripUserDateOfBirth",getIntent().getExtras().getString("tripUserDateOfBirth"));
                i.putExtra("tripUserPhonenumber",getIntent().getExtras().getString("tripUserPhonenumber"));
                i.putExtra("tripUserGender",getIntent().getExtras().getChar("tripUserGender"));
                i.putExtra("tripUserStreet",getIntent().getExtras().getString("tripUserStreet"));
                i.putExtra("tripUserStreetNumber",getIntent().getExtras().getString("tripUserStreetNumber"));
                i.putExtra("tripUserZip",getIntent().getExtras().getString("tripUserZip"));
                i.putExtra("tripUserCity",getIntent().getExtras().getString("tripUserCity"));
                startActivity(i);
                finish();
            }
        });

        Button participatingTripsButton = (Button) findViewById(R.id.btn_participatingTrips);
        participatingTripsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),ParticipatedTripsActivity.class);
                i.putExtra("tripUserEmail",getIntent().getExtras().getString("tripUserEmail"));
                startActivity(i);
                finish();
            }
        });

        initViews();
    }

    private void initViews() {

    }


}