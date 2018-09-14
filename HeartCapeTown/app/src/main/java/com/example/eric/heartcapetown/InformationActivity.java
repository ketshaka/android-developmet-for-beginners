package com.example.eric.heartcapetown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.word_list);

        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Picture1", "Cool place", "www.coolplace.com"));
        attractions.add(new Attraction("Picture2", "Okay place", "0254685"));

        ListView attractionsListView = (ListView) findViewById(R.id.list);

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        attractionsListView.setAdapter(adapter);
    }

}
