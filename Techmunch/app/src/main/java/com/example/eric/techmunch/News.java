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

    // Link to the story
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param tag is the category the story falls under
     * @param headline is the headline of the news article
     * // @param writer is the name of the author of the news article
     * @param date is the date the story was published
     * @param url is the link to the story on the website
     */
    public News(String tag, String headline, String date, String url) {
        mTag = tag;
        mHeadline = headline;
        // mWriter = writer;
        mDate = date;
        mUrl = url;
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

    // Returns the link to the story

    public String getUrl() {
        return mUrl;
    }
}
