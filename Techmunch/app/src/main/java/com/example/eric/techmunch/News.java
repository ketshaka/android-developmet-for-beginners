package com.example.eric.techmunch;

/**
 * News object containing metadata about an article.
 */

public class News {
    // Tag of the story
    private String mTag;
    // Headline of the story
    private String mHeadline;
    // Date of the story
    private String mDate;
    // URL of the story
    private String mUrl;

    public News(String tag, String headline, String date, String url) {
        mTag = tag;
        mHeadline = headline;
        mDate = date;
        mUrl = url;
    }

    // Getter methods
    public String getTag() { return mTag; }
    public String getHeadline() { return mHeadline; }
    public String getDate() { return mDate; }
    public String getUrl() { return mUrl; }
}
