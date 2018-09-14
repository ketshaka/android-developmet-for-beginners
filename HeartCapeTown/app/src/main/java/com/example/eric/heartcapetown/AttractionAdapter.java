package com.example.eric.heartcapetown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Context context, List<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        TextView headingView = (TextView) listItemView.findViewById(R.id.heading);
        headingView.setText(currentAttraction.getHeading());

        TextView descriptionView = (TextView) listItemView.findViewById(R.id.description);
        descriptionView.setText(currentAttraction.getDescription());

        TextView contactsView = (TextView) listItemView.findViewById(R.id.contacts);
        contactsView.setText(currentAttraction.getContacts());

        return listItemView;

    }
}
