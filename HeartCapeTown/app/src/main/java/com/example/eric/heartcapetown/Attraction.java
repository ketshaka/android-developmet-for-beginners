package com.example.eric.heartcapetown;

public class Attraction {


    // Name of the attraction
    private String mHeading;
    // Description of the attraction
    private String mDescription;
    // Contact details of the attraction
    private String mContacts;
    // Image resource ID for the attraction
    private int mImageResourceId;

    /**
     * Public constructor
     * @param heading is the name of the tourist attraction
     * @param description is the description of the tourist attraction
     * @param contacts is the contact details of the tourist attraction
     * @param imageResourceId is a drawable resource ID for the picture of the tourist attraction
     */
    public Attraction(String heading, String description, String contacts, int imageResourceId) {
        mHeading = heading;
        mDescription = description;
        mContacts = contacts;
        mImageResourceId = imageResourceId;
    }

    /**
     *Public getter methods for the above private methods
     */
    public String getHeading() {
        return mHeading;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getContacts() {
        return mContacts;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
