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

        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Crayfish Trail", "Experience South Africa’s beautiful West Coast! Join us on The Crayfish Trail, a multi-day trail that follows the rugged coastline between the Berg and Olifants Rivers. We offer a unique blend of community life,culture, history, food, wine and wildlife. All trails include meals, accommodation, transport and guides.", "info@crayfishtrail.co.za", R.drawable.crayfish));
        attractions.add(new Attraction("Alpaca Loom Coffee Shop and Weaving Studio", "Visit South Africa’s biggest alpaca herd! Watch our weavers at work, interact with alpacas in the petting zoo and enjoy views of Table Mountain. Delicious coffee and cake, exquisite scarves, shawls, blankets and knitwear made locally from local alpaca fiber. Open daily 10am – 6pm. Tours held Friday to Sunday at 3pm.", "alpacas.co.za", R.drawable.alpaca));

        ListView attractionsListView = (ListView) findViewById(R.id.list);

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        attractionsListView.setAdapter(adapter);
}}
