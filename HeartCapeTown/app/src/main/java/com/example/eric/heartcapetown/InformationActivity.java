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
        attractions.add(new Attraction("Cape Town International Airport", "Ground Floor, Arrivals", "airport@capetown.travel", R.drawable.airport));
        attractions.add(new Attraction("City Centre", "Cape Town Tourism, Pinnacle Building, corner of Burg and Castle streets, Cape Town", "info@capetown.travel", R.drawable.city_centre));

        ListView attractionsListView = (ListView) findViewById(R.id.list);

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        attractionsListView.setAdapter(adapter);
    }

}
