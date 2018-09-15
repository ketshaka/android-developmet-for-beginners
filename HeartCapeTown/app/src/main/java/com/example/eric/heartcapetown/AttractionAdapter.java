package com.example.eric.heartcapetown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    /**
     * Create a new {@link AttractionAdapter} object
     *
     * @param context is the current context (activity) that the adapter is being created
     * @param attractions is the list of {@link Attraction} to be displayed
     */
    public AttractionAdapter(Context context, List<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if existing view is being reused, otherwise inflate a new view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_list_item, parent, false);
        }

        // Get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the TextView in the attraction_list_item.xml layout with the ID heading
        TextView headingView = (TextView) listItemView.findViewById(R.id.heading);
        // Get the heading from the currentAttraction object and set this text on the heading
        // TextView
        headingView.setText(currentAttraction.getHeading());

        // Find the TextView in the attraction_list_item.xml layout with the ID description
        TextView descriptionView = (TextView) listItemView.findViewById(R.id.description);
        // Get the description from the currentAttraction object and set this text on the
        // description TextView
        descriptionView.setText(currentAttraction.getDescription());

        // Find the TextView in the attraction_list_item.xml layout with the ID contacts
        TextView contactsView = (TextView) listItemView.findViewById(R.id.contacts);
        // Get the contacts from the currentAttraction object and set this text on the contacts
        // TextView
        contactsView.setText(currentAttraction.getContacts());

        // Find the ImageView in the attraction_list_item.xml layout with the ID picture
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.picture);
        // Get the image resource ID from the currentAttraction object and display provided image
        // based on the resource ID
        imageView.setImageResource(currentAttraction.getImageResourceId());

        return listItemView;

    }
}
