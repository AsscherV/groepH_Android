package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import be.kdg.groeph.R;

/**
 * Created with IntelliJ IDEA.
 * User: glenn
 * Date: 14/03/13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public class ProfileActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);


        TextView txt_email = (TextView) findViewById(R.id.txt_email);
        txt_email.setText(getIntent().getExtras().getString("tripUserEmail"));

        TextView txt_firstName = (TextView) findViewById(R.id.txt_firstName);
        txt_firstName.setText(getIntent().getExtras().getString("tripUserFirstName"));

        TextView txt_name = (TextView) findViewById(R.id.txt_name);
        txt_name.setText(getIntent().getExtras().getString("tripUserName"));

        TextView txt_dateOfBirth = (TextView) findViewById(R.id.txt_dateOfBirth);
        txt_dateOfBirth.setText(getIntent().getExtras().getString("tripUserDateOfBirth"));

        TextView txt_phoneNumber = (TextView) findViewById(R.id.txt_phoneNumber);
        txt_phoneNumber.setText(getIntent().getExtras().getString("tripUserPhonenumber"));

        TextView txt_gender = (TextView) findViewById(R.id.txt_gender);
        txt_gender.setText("" + getIntent().getExtras().getChar("tripUserGender"));

        TextView txt_street = (TextView) findViewById(R.id.txt_street);
        txt_street.setText(getIntent().getExtras().getString("tripUserStreet"));

        TextView txt_number = (TextView) findViewById(R.id.txt_number);
        txt_number.setText(getIntent().getExtras().getString("tripUserStreetNumber"));

        TextView txt_zip = (TextView) findViewById(R.id.txt_zipCode);
        txt_zip.setText(getIntent().getExtras().getString("tripUserZip"));

        TextView txt_city = (TextView) findViewById(R.id.txt_city);
        txt_city.setText(getIntent().getExtras().getString("tripUserCity"));


        initViews();

    }

    private void initViews() {

    }


}
