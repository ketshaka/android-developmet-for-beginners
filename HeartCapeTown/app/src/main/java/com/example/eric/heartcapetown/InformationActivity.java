package com.example.eric.heartcapetown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.attraction_list);

        // Create list of visitor information centres
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.cpt_int_heading), getString(R.string.cpt_int_description), getString(R.string.cpt_int_contact), R.drawable.airport));
        attractions.add(new Attraction(getString(R.string.city_centre_heading), getString(R.string.city_centre_description), getString(R.string.city_centre_contact), R.drawable.city_centre));

        // Find the attractionsListView object in the view hierarchy of the activity, there should
        // be a ListView with the view ID list, which is declared in word_list.xml
        ListView attractionsListView = (ListView) findViewById(R.id.list);

        // Create an AttractionAdapter, whose data source is a list of Attractions
        AttractionAdapter adapter = new AttractionAdapter(this, attractions, R.color.category_information);

        // Make the attractionsListView use the AttractionAdapter created above
        attractionsListView.setAdapter(adapter);
    }

}
