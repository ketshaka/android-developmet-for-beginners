package com.example.eric.heartcapetown;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    // Resource ID for the background colour for the list of attractions
    private int mColorResourceId;

    /**
     * Create a new AttractionAdapter object.
     * @param context is the current context (activity) that the adapter is being created.
     * @param attractions is the list of Attraction to be displayed.
     */
    public AttractionAdapter(Context context, List<Attraction> attractions, int colorResourceId) {
        super(context, 0, attractions);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if existing view is being reused, otherwise inflate a new view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_list_item, parent, false);
        }

        // Get the Attraction object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the TextView in the attraction_list_item.xml layout with the ID: heading
        TextView headingView = (TextView) listItemView.findViewById(R.id.heading);
        // Get the heading from the currentAttraction object and set this text on the heading
        // TextView
        headingView.setText(currentAttraction.getHeading());

        // Find the TextView in the attraction_list_item.xml layout with the ID: description
        TextView descriptionView = (TextView) listItemView.findViewById(R.id.description);
        // Get the description from the currentAttraction object and set this text on the
        // description TextView.
        descriptionView.setText(currentAttraction.getDescription());

        // Find the TextView in the attraction_list_item.xml layout with the ID: contacts
        TextView contactsView = (TextView) listItemView.findViewById(R.id.contacts);
        // Get the contacts from the currentAttraction object and set this text on the contacts
        // TextView
        contactsView.setText(currentAttraction.getContacts());

        // Find the ImageView in the attraction_list_item.xml layout with the ID: picture
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.picture);
        // Get the image resource ID from the currentAttraction object and display provided image
        // based on the resource ID
        imageView.setImageResource(currentAttraction.getImageResourceId());

        // Set the theme colour for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the colour that the resource ID maps to
        int colour = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background colour of the text container View
        textContainer.setBackgroundColor(colour);

        // Return the whole list item layout
        return listItemView;
    }
}
