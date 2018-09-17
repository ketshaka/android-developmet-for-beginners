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
        attractions.add(new Attraction("40/40 Club Cape Town", "In the heart of the CBD, 40/40 Club Cape Town gives you the ultimate nightlife sensory experience. Mixing luxurious and sensuous décor, cutting-edge sound and high-end service, this is the perfect venue for your evening out, private party or any other celebration. Open Thursday, Friday and Saturday.", "4040clubcapetown.co.za", R.drawable.forty_forty));
        attractions.add(new Attraction("Coco", "The focus at Coco is high-end bottle service, excellent customer attention, beautiful clientele and incredible music all set in a sexy and glam environment. Musically, get ready for the finest commercial hiphop, house, dance and everything in between every Friday and Saturday nights.", "cococpt.co.za", R.drawable.coco));

        // Find the {@link attractionsListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView attractionsListView = (ListView) findViewById(R.id.list);

        // Create an {@link AttractionAdapter}, whose data source is a list of {@link Attraction}s
        AttractionAdapter adapter = new AttractionAdapter(this, attractions, R.color.category_nightlife);

        // Make the {@link attractionsListView} use the {@link AttractionAdapter} we created above,
        // so that the {@link attractionsListView} will display list items for each {@link Word} in
        // the list.
        attractionsListView.setAdapter(adapter);
}}
