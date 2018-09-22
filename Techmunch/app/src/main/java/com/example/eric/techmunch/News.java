package com.example.eric.techmunch;

/**
 * A {@link News} object containing information related to a single news article
 */

public class News {

    // Tag of the story
    private String mTag;

    // Headline of the story
    private String mHeadline;

    // Writer of the story
    // private String mWriter;

    // Date of the story
    private String mDate;

    /**
     * Constructs a new {@link News} object.
     *
     * @param tag is the category the story falls under
     * @param headline is the headline of the news article
     * // @param writer is the name of the author of the news article
     * @param date is the date the story was published
     */
    public News(String tag, String headline, String date) {
        mTag = tag;
        mHeadline = headline;
        // mWriter = writer;
        mDate = date;
    }

    /**
     * Public getter methods so that other classes can access this information
     */

    // Returns the tag of the story
    public String getTag() {
        return mTag;
    }

    // Returns the headline of the story
    public String getHeadline() {
        return mHeadline;
    }

    // Returns the writer of the story
    // public String getWriter() {
    //    return mWriter;
    //}

    // Returns the date of the story

    public String getDate() {
        return mDate;
    }
}
