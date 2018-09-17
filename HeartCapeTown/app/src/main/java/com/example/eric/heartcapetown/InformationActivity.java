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
        attractions.add(new Attraction("Cape Town International Airport", "Cape Town International Airport is the primary airport serving the city of Cape Town, and is the second-busiest airport in South Africa and third-busiest in Africa. Located approximately 20 kilometres from the city centre, the airport was opened in 1954 to replace Cape Town's previous airport, Wingfield Aerodrome.", "airport@capetown.travel", R.drawable.airport));
        attractions.add(new Attraction("City Centre", "Aptly referred to as the City Bowl, the heart of the city is held in an enclosed basin formed between the Atlantic Ocean and the face of Table Mountain, flanked on one side by Lion’s Head and Signal Hill, and on the other by Devil’s Peak. From the busy sea port, through the business centre, and up into the more residential slopes, the city reveals its rich history and contemporary metropolitan character. Cape Town City Centre is made up of the Foreshore, CBD, Bo-Kaap, Gardens, Higgovale, Tamboerskloof, Oranjezicht, Vredehoek and Devil’s Peak.", "info@capetown.travel", R.drawable.city_centre));

        // Find the {@link attractionsListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView attractionsListView = (ListView) findViewById(R.id.list);

        // Create an {@link AttractionAdapter}, whose data source is a list of {@link Attraction}s
        AttractionAdapter adapter = new AttractionAdapter(this, attractions, R.color.category_information);

        // Make the {@link attractionsListView} use the {@link AttractionAdapter} we created above,
        // so that the {@link attractionsListView} will display list items for each {@link Word} in
        // the list.
        attractionsListView.setAdapter(adapter);
    }

}
