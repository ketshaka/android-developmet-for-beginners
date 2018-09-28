package com.example.eric.techmunch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<News> news = QueryUtils.extractNews();

        // Create fake list of news
        // ArrayList<News> news = new ArrayList<>();
        // news.add(new News("Consumer", "New Kalahari Echo device leaked", "Kris Ball", "October 20, 2019"));
        // news.add(new News("Fintech", "Debit cards used on Oldegg.com conpromised", "Jack Leadbitter", "October 20, 2019"));
        // news.add(new News("Consumer", "Tenpounds Video is going private in the UK", "Julius Moretti, Julia Hu", "October 20, 2019"));
        // news.add(new News("Consumer", "MeTube Gaminng is shutting down", "Patrick Fernandez", "October 19, 2019"));
        // news.add(new News("Transport","Postfriends is now a unicorn", "Alan Labinsky", "October 19, 2019"));
        // news.add(new News("Social", "Way is shutting down", "Bjorn Tussel", "October 19, 2019"));

        // Find a reference to the {@link ListView} in the layout
        ListView newsListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes the list of news as input
        final NewsAdapter adapter = new NewsAdapter(this, news);

        // Set the adapter on the {@link ListView}
        newsListView.setAdapter(adapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                News currentNews = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri newsUri = Uri.parse(currentNews.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}
