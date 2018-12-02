package com.example.eric.heartcapetown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NatureActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.attraction_list);

        // Create a list of nature attractions
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.cray_heading), getString(R.string.cray_description), getString(R.string.cray_contact), R.drawable.crayfish));
        attractions.add(new Attraction(getString(R.string.alpaca_heading), getString(R.string.alpaca_description), getString(R.string.alpaca_contact), R.drawable.alpaca));

        // Find the {@link attractionsListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView attractionsListView = (ListView) findViewById(R.id.list);

        // Create an {@link AttractionAdapter}, whose data source is a list of {@link Attraction}s
        AttractionAdapter adapter = new AttractionAdapter(this, attractions, R.color.category_nature);

        // Make the {@link attractionsListView} use the {@link AttractionAdapter} we created above,
        // so that the {@link attractionsListView} will display list items for each {@link Word} in
        // the list.
        attractionsListView.setAdapter(adapter);
}}
