package com.example.eric.heartcapetown;

public class Attraction {

    private String mHeading;
    private String mDescription;
    private String mContacts;

    public Attraction(String heading, String description, String contacts) {
        mHeading = heading;
        mDescription = description;
        mContacts = contacts;
    }

    public String getHeading() {
        return mHeading;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getContacts() {
        return mContacts;
    }
}
