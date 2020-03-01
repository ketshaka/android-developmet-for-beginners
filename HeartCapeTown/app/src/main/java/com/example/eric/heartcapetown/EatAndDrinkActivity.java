package com.example.eric.heartcapetown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class EatAndDrinkActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.attraction_list);

        // Create list of eat and drink attractions
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.addis_heading), getString(R.string.addis_description), getString(R.string.addis_contact), R.drawable.addis));
        attractions.add(new Attraction(getString(R.string.karibu_heading), getString(R.string.karibu_description), getString(R.string.karibu_contact), R.drawable.karibu));

        // Find the attractionsListView object in the view hierarchy of the activity, there should
        // be a ListView with the view ID called list, which is declared in word_list.xml
        ListView attractionsListView = (ListView) findViewById(R.id.list);

        // Create an AttractionAdapter, whose data source is a list of Attractions
        AttractionAdapter adapter = new AttractionAdapter(this, attractions, R.color.category_eat_and_drink);

        // Make the attractionsListView use the AttractionAdapter above
        attractionsListView.setAdapter(adapter);
    }
}
