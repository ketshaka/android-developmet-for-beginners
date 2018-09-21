package com.example.eric.techmunch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * A {@link NewsAdapter} creates a a list item layout for each news story in the data source (a list
 * of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView to be displayed to the
 * user.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    /**
     * Constructs a new {@link NewsAdapter}
     *
     * @param context of the app
     * @param news is the list of news stories, which are the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays the news at a given position in the list of stories
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID tag
        TextView tagView = (TextView) listItemView.findViewById(R.id.tag);
        // Display the tag of the current news in that TextView
        tagView.setText(currentNews.getTag());

        // Find the TextView with view ID headline
        TextView headlineView = (TextView) listItemView.findViewById(R.id.headline);
        // Display the headline of the current news in that TextView
        headlineView.setText(currentNews.getHeadline());

        // Find the TextView with view ID writer
        TextView writerView = (TextView) listItemView.findViewById(R.id.writer);
        // Display the writer of the current news in that TextView
        writerView.setText(currentNews.getWriter());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date of the current news in that TextView
        dateView.setText(currentNews.getDate());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
