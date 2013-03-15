package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import be.kdg.groeph.R;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.TripUser;

import java.text.DateFormat;
import java.util.Date;


public class LoginActivity extends Activity {

    private final String path = "/rest/login?Username="; // url path: value for 1EUR in USD.


    private ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button requestButton = (Button) findViewById(R.id.Button_doRequest);
        requestButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText pw = (EditText) findViewById(R.id.PasswordText);
                EditText us = (EditText) findViewById(R.id.UserNameText);

                getData(path + us.getText().toString() + "&Password=" + pw.getText().toString());
            }
        });

        initViews();
    }

    private void initViews() {

        progressbar = (ProgressBar) findViewById(R.id.ProgressBar);


        progressbar.setVisibility(View.GONE);
    }

    private void getData(final String path) {
        new AsyncTask<Void, Void, TripUser>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {

                progressbar.setVisibility(View.VISIBLE);
                super.onPreExecute();
            }

            @Override
            protected TripUser doInBackground(Void... params) {
                TripUser tripUser = null;

                try {
                    tripUser = new NetworkController().getDataFromServer(path);
                } catch (Exception e) {
                    exception = e;
                }

                return tripUser;
            }

            @Override
            protected void onPostExecute(TripUser result) {
                if (exception == null && result != null) {

                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                    i.putExtra("tripUserEmail",result.getEmail());
                    i.putExtra("tripUserFirstName",result.getFirstName());
                    i.putExtra("tripUserName",result.getLastName());
                    Date date = result.getDateOfBirth();
                    String formattedDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date).toString();
                    i.putExtra("tripUserDateOfBirth",formattedDate);
                    i.putExtra("tripUserPhonenumber",result.getPhoneNumber());
                    i.putExtra("tripUserGender",result.getGender());
                    i.putExtra("tripUserStreet",result.getAddress().getStreet());
                    i.putExtra("tripUserStreetNumber",result.getAddress().getStreetNumber());
                    i.putExtra("tripUserZip",result.getAddress().getZipcode());
                    i.putExtra("tripUserCity",result.getAddress().getCity());

                    startActivity(i);
                    finish();
                    //TODO: Add the cookie to a session I guess


                } else if (result == null) {
                    Toast.makeText(getApplicationContext(), "Wrong credentials", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Oops. Something went wrong!", Toast.LENGTH_SHORT).show();

                }
                progressbar.setVisibility(View.GONE);


            }

        }.execute();
    }

}
