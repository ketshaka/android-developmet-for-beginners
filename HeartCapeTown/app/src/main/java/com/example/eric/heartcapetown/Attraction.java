package com.example.eric.heartcapetown;

public class Attraction {
    // Name of the attraction
    private String mHeading;
    // Description of the attraction
    private String mDescription;
    // Contact details of the attraction
    private String mContacts;
    // Drawable image resource ID for the picture of the attraction
    private int mImageResourceId;

    public Attraction(String heading, String description, String contacts, int imageResourceId) {
        mHeading = heading;
        mDescription = description;
        mContacts = contacts;
        mImageResourceId = imageResourceId;
    }

    // Getter methods
    public String getHeading() { return mHeading; }
    public String getDescription() { return mDescription; }
    public String getContacts(){ return mContacts; }
    public int getImageResourceId() { return mImageResourceId; }
}
