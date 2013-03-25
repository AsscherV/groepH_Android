package be.kdg.groeph.activities;

import android.app.Activity;
import android.os.Bundle;
import be.kdg.groeph.R;
import be.kdg.groeph.model.Cost;

import java.util.ArrayList;

/**
 * To change this template use File | Settings | File Templates.
 */
public class CostStatisticsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costs);


        getAllData();

    }

    private ArrayList<Cost> getAllData() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }


}
