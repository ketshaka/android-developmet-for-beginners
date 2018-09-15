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

        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("40/40 Club Cape Town", "In the heart of the CBD, 40/40 Club Cape Town gives you the ultimate nightlife sensory experience. Mixing luxurious and sensuous décor, cutting-edge sound and high-end service, this is the perfect venue for your evening out, private party or any other celebration. Open Thursday, Friday and Saturday.", "4040clubcapetown.co.za", R.drawable.forty_forty));
        attractions.add(new Attraction("Coco", "The focus at Coco is high-end bottle service, excellent customer attention, beautiful clientele and incredible music all set in a sexy and glam environment. Musically, get ready for the finest commercial hiphop, house, dance and everything in between every Friday and Saturday nights.", "cococpt.co.za", R.drawable.coco));

        ListView attractionsListView = (ListView) findViewById(R.id.list);

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        attractionsListView.setAdapter(adapter);
}}
