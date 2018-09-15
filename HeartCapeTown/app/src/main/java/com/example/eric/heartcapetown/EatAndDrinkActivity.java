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

        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Addis In Cape Ethiopian Restaurant", "Voted best African eatery in Cape Town, Addis In Cape is an authentic Ethiopian restaurant that caters for non-vegetarian and vegan clients. We provide gluten-free communal dining in a unique relaxing ambiance you, your family and friends will remember. Discover and enjoy Ethiopian dining, ending with a traditional Ethiopian coffee.", "addisincape.co.za", R.drawable.addis));
        attractions.add(new Attraction("Karibu Restaurant", "Set between the picturesque view of Table Mountain and the tranquil blue waters of the Atlantic Ocean, Karibu affords the opportunity to experience the vibrant flavours of South Africa. We invite you to encounter the ruggedness of Africa within the luxurious setting of our restaurant where a mixed fusion of African ambiance blends itself with the flavours of our heritage.", "kariburestaurant.co.za", R.drawable.karibu));

        ListView attractionsListView = (ListView) findViewById(R.id.list);

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        attractionsListView.setAdapter(adapter);
    }
}
