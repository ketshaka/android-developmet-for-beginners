package com.example.eric.heartcapetown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NightlifeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.attraction_list);

        // Create a list of nightlife activities
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.forty_heading), getString(R.string.forty_description), getString(R.string.forty_contact), R.drawable.forty_forty));
        attractions.add(new Attraction(getString(R.string.coco_heading), getString(R.string.coco_description), getString(R.string.coco_contact), R.drawable.coco));

        // Find the attractionsListView object in the view hierarchy of the activity, there should
        // be a ListView with the view ID called list, which is declared in word_list.xml
        ListView attractionsListView = (ListView) findViewById(R.id.list);

        // Create an AttractionAdapter, whose data source is a list of Attractions
        AttractionAdapter adapter = new AttractionAdapter(this, attractions, R.color.category_nightlife);

        // Make the attractionsListView use the AttractionAdapter created above
        attractionsListView.setAdapter(adapter);
}}
